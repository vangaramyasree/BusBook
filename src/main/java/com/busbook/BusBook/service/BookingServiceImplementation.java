package com.busbook.BusBook.service;




import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.busbook.BusBook.model.Booking;

@Service
public class BookingServiceImplementation implements BookingService {
    private List<Booking> bookings = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    public List<Booking> getAllBookings() {
        return bookings;
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookings.stream().filter(booking -> booking.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Booking bookBus(Booking booking) {
        booking.setId(idCounter++);
        bookings.add(booking);
        return booking;
    }

    @Override
    public void cancelBooking(Long id) {
        bookings.removeIf(booking -> booking.getId().equals(id));
    }
}
