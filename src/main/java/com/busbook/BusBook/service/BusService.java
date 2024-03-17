package com.busbook.BusBook.service;

import java.util.List;

import com.busbook.BusBook.model.Bus;

public interface BusService {
    List<Bus> getAllBuses();
    Bus getBusById(Long id);
    Bus saveBus(Bus bus);
    void deleteBus(Long id);
}