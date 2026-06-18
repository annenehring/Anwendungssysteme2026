package de.mcc.client;

import de.mcc.HelloServiceGrpc;
import de.mcc.Helloworld;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
TODO: Implementieren Sie einen lokal laufenden GRPC-Server und GRPC-Clients. Der Client soll einen beliebigen
 Namen (String) an den Server senden können, und der Server antwortet mit einer Begrüßung, die den
 Namen enthält.
 */
public class SyncHelloWorldClient {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        String target = "localhost:9090";
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create()).build();

        HelloServiceGrpc.HelloServiceBlockingStub blockingStub = HelloServiceGrpc.newBlockingStub(channel);

        while(true){

        System.out.println("Input name: ");
        String name = s.nextLine();

        if (name.equals("")){
            System.out.println("exiting....");
            break;
        }

            Helloworld.HelloRequest req = Helloworld.HelloRequest.newBuilder().setName(name).build();
            Helloworld.HelloResponse resp = blockingStub.greeter(req);

            System.out.println("Response vom Server: " + resp);
        }

        channel.shutdown();
        channel.awaitTermination(30,TimeUnit.SECONDS);

    }
}
