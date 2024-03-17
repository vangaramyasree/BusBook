package com.busbook.BusBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.busbook.BusBook.model.Booking;
import com.busbook.BusBook.service.BookingService;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/new")
    public String newBookingForm(@RequestParam("busId") Long busId, Model model) {
        Booking booking = new Booking();
        booking.setBusId(busId);
        model.addAttribute("booking", booking);
        return "new-booking";
    }

    @PostMapping("/save")
    public String saveBooking(@ModelAttribute("booking") Booking booking) {
        bookingService.bookBus(booking);
        return "redirect:/buses";
    }

    @GetMapping("/delete/{id}")
    public String cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
        return "redirect:/buses";
    }
}
