package de.mcc.client;

import de.mcc.HelloServiceGrpc;
import de.mcc.Helloworld;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SyncHelloWorldClient {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        String target = "localhost:9090";
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create()).build();

        HelloServiceGrpc.HelloServiceBlockingStub blockingStub = HelloServiceGrpc.newBlockingStub(channel);


    }
}
