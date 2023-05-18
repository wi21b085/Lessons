package org.example.service;

import org.example.dto.StationData;

import java.util.List;

public class Database {

    public List<StationData> getAllStationData() {
        // Just a simulated query
        // would connect to real database, make query and return data
        return List.of(
                new StationData(1, 32142),
                new StationData(1, 1253),
                new StationData(1, 34214),
                new StationData(2, 213433),
                new StationData(2, 21314),
                new StationData(2, 3423),
                new StationData(3, 21341),
                new StationData(4, 21324)
        );
    }
}
