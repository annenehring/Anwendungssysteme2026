package de.mcc.client;

import de.mcc.HelloServiceGrpc;
import de.mcc.Helloworld;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AsyncHelloWorldClient {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) throws Exception{
        // We are trying to connect to a server running on localhost port 9090
        String target = "localhost:9090";

        // Open a channel to the target server
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create()).build();

        // Create a blocking stub to communicate with the target server. There is also the option to create an async stub
        HelloServiceGrpc.HelloServiceStub stub = HelloServiceGrpc.newStub(channel);

        while (true) {
            System.out.println("Input name:");
            String name = s.nextLine();

            if (name.equals("")) {
                System.out.println("Exiting...");
                break;
            }

            Helloworld.HelloRequest request = Helloworld.HelloRequest.newBuilder().setName(name).build();

            StreamObserver<Helloworld.HelloResponse> responseObserver = new StreamObserver<Helloworld.HelloResponse>() {
                @Override
                public void onNext(Helloworld.HelloResponse helloResponse) {
                    System.out.println("Client received response to request: " + request + ".\n Response: " + helloResponse);
                }

                @Override
                public void onError(Throwable throwable) {
                    System.err.println("Error in responseObserver");
                    throwable.printStackTrace();
                }

                @Override
                public void onCompleted() {
                    System.out.println("Request: " + request + " is completed");
                }
            };
            stub.greeter(request, responseObserver);
        }

        channel.shutdown();
        channel.awaitTermination(30, TimeUnit.SECONDS);
    }
}
