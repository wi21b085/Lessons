package org.example;

import org.example.service.Database;
import org.example.service.Queue;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Queue queue = new Queue();

        StationDataCollector stationDataCollector
                = new StationDataCollector(database, queue);

        System.out.println(stationDataCollector.getTotalKwhForCustomer(1));

        stationDataCollector.processQueueAndReturnCustomerTotal();
    }
}