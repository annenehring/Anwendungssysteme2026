package de.mcc.server;

import de.mcc.HelloServiceGrpc;
import de.mcc.Helloworld;
import io.grpc.*;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class HelloWorldServer {

    public static void main(String[] args) throws Exception{
        // INFO: InsecureServerCredentials beduetet: wir brauchen keine Verschlüsselung, kein Zertifikat -> localhost ist sicher
        Server server = Grpc.newServerBuilderForPort(9090, InsecureServerCredentials.create()).addService(new HelloWorldServerImpl()).build();

        server.start();

        //INFO: sagt also bevor du dich beendest, führe das noch aus:
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    server.shutdown().awaitTermination(30, TimeUnit.SECONDS); // nehme keine Requestst mehr an -> maximal 30 sekunden Zeit
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Server is shut down");
            }
        });

        server.awaitTermination();//müssen server explizit stoppen
    }

    public static class HelloWorldServerImpl extends HelloServiceGrpc.HelloServiceImplBase {



    }
}
