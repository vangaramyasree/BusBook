package com.busbook.BusBook.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.busbook.BusBook.model.Bus;

@Service
public class BusServiceImplementation implements BusService {
    private List<Bus> buses = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    public List<Bus> getAllBuses() {
        return buses;
    }

    @Override
    public Bus getBusById(Long id) {
        return buses.stream().filter(bus -> bus.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Bus saveBus(Bus bus) {
        if (bus.getId() == null) {
            bus.setId(idCounter++);
        } else {
            deleteBus(bus.getId());
        }
        buses.add(bus);
        return bus;
    }
    @GetMapping("/edit/{id}")
    public String editBusForm(@PathVariable Long id, Model model) {
        Bus bus = busService.getBusById(id);
        model.addAttribute("bus", bus);
        return "edit-bus";
    }

    @PostMapping("/update")
    public String updateBus(@ModelAttribute("bus") Bus bus) {
        busService.saveBus(bus); // Save the edited bus details
        return "redirect:/buses";
    }


    @Override
    public void deleteBus(Long id) {
        buses.removeIf(bus -> bus.getId().equals(id));
    }
}