package org.example;

import org.example.dto.StationData;
import org.example.service.Database;
import org.example.service.Queue;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StationDataCollectorTest {

    @Test
    public void shouldReturnCumulatedCustomerKwh() {
        // Arrange
        Queue queue = mock(Queue.class);
        Database database = mock(Database.class);
        when(database.getAllStationData()).thenReturn(
                List.of(
                        new StationData(1, 1),
                        new StationData(1, 1),
                        new StationData(1, 1)
                )
        );
        StationDataCollector stationDataCollector
                = new StationDataCollector(database, queue);

        // Act
        int total = stationDataCollector.getTotalKwhForCustomer(1);

        // Assert
        assertEquals(3, total);
    }

    @Test
    public void shouldReturnZeroForMissingCustomer() {
        // Arrange
        Queue queue = mock(Queue.class);
        Database database = mock(Database.class);
        when(database.getAllStationData()).thenReturn(
                List.of(
                        new StationData(1, 1),
                        new StationData(1, 1),
                        new StationData(1, 1)
                )
        );
        StationDataCollector stationDataCollector
                = new StationDataCollector(database, queue);

        // Act
        int total = stationDataCollector.getTotalKwhForCustomer(2);

        // Assert
        assertEquals(0, total);
    }
    @Test
    public void shouldReturnCumulatedCustomerKwhFromQueueTask() {
        // Arrange
        Queue queue = mock(Queue.class);
        when(queue.getCustomerTask()).thenReturn(1);
        Database database = mock(Database.class);
        when(database.getAllStationData()).thenReturn(
                List.of(
                        new StationData(1, 1),
                        new StationData(1, 1),
                        new StationData(1, 1)
                )
        );
        StationDataCollector stationDataCollector
                = new StationDataCollector(database, queue);

        // Act
        int total = stationDataCollector.processQueueAndReturnCustomerTotal();

        // Assert
        assertEquals(3, total);
    }

    @Test
    public void shouldReturnZeroForMissingCustomerFromQueueTask() {
        // Arrange
        Queue queue = mock(Queue.class);
        when(queue.getCustomerTask()).thenReturn(2);
        Database database = mock(Database.class);
        when(database.getAllStationData()).thenReturn(
                List.of(
                        new StationData(1, 1),
                        new StationData(1, 1),
                        new StationData(1, 1)
                )
        );
        StationDataCollector stationDataCollector
                = new StationDataCollector(database, queue);

        // Act
        int total = stationDataCollector.processQueueAndReturnCustomerTotal();

        // Assert
        assertEquals(0, total);
    }

    @Test
    @Tag("Integration")
    public void shouldReturnCumulatedCustomerKwhFromDatabase() {
        // Arrange
        Queue queue = new Queue();
        Database database = new Database();
        StationDataCollector stationDataCollector
                = new StationDataCollector(database, queue);

        // Act
        int total = stationDataCollector.getTotalKwhForCustomer(1);

        // Assert
        assertEquals(67609, total);
    }

}