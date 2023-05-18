package org.example;


import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.concurrent.TimeoutException;

public class Main {
    private final static String QUEUE_NAME = "kitchen";

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(30003);

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "' " + LocalTime.now());

            try {
                Thread.sleep(5000);
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println(" [x] Finished '" + message + "' " + LocalTime.now());
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
    }
}
/*
alternative:

public class Main {
    private final static String QUEUE_NAME = "kitchen";

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(30003);

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        channel.basicConsume(QUEUE_NAME, true, this::handle, consumerTag -> {});
    }

    private void handle(String consumerTag, Delivery delivery){

            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "' " + LocalTime.now());

            try {
                Thread.sleep(5000);
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println(" [x] Finished '" + message + "' " + LocalTime.now());
    }

}
*/