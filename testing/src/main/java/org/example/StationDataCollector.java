package org.example;

import org.example.dto.StationData;
import org.example.service.Database;
import org.example.service.Queue;

import java.util.List;
import java.util.stream.Collectors;

public class StationDataCollector {

    private final Database database;
    private final Queue queue;

    public StationDataCollector(Database database, Queue queue) {
        this.database = database;
        this.queue = queue;
    }

    public int processQueueAndReturnCustomerTotal() {
        System.out.println("Processing Queue...");
        System.out.println("Task found!");
        int customerId = queue.getCustomerTask();

        System.out.println("Customer: " + customerId);
        int total = getTotalKwhForCustomer(customerId);
        System.out.println("Total Kwh: " + total);

        return total;
    }

    public int getTotalKwhForCustomer(int id) {
        List<StationData> stationData = database.getAllStationData();

        return stationData.stream()
                .filter(data -> data.getCustomerId() == id)
                .mapToInt(StationData::getKwh)
                .sum();
    }
}
