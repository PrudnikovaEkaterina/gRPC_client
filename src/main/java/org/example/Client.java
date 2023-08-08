package org.example;
import org.example.grpc.GreatingService;
import org.example.grpc.GreetingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class Client {
    public static void main(String[] args) {
        ManagedChannel channel= ManagedChannelBuilder.forTarget("localhost:8080").
                usePlaintext().build();
        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);
        GreatingService.HelloRequest request = GreatingService.HelloRequest.newBuilder()
                .setName("Kate").build();
        GreatingService.HelloResponse response = stub.greeting(request);
        System.out.println(response);
        channel.shutdownNow();
}}
