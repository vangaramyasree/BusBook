package com.busbook.BusBook.service;

import java.util.List;

import com.busbook.BusBook.model.Booking;

public interface BookingService {
    List<Booking> getAllBookings();
    Booking getBookingById(Long id);
    Booking bookBus(Booking booking);
    void cancelBooking(Long id);
}