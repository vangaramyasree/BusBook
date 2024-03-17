package com.busbook.BusBook.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.busbook.BusBook.model.Bus;
import com.busbook.BusBook.service.BusService;


@Controller
@RequestMapping("/buses")
public class BusController {
	 private static final Logger logger = LogManager.getLogger(BusController.class);
	@Autowired
    private BusService busService;

	@GetMapping
public String getAllBuses(Model model) {
		model.addAttribute("buses", busService.getAllBuses());
		return "index";
	}
	@GetMapping("/new")
    public String newBusForm(Model model) {
        model.addAttribute("bus", new Bus());
        return "new-bus";
    }
	@PostMapping("/save")
    public String saveBus(@ModelAttribute("bus") Bus bus) {
        busService.saveBus(bus);
        return "redirect:/buses";
    }
	 @GetMapping("/edit/{id}")
	    public String editBusForm(@PathVariable Long id, Model model) {
	        Bus bus = busService.getBusById(id);
	        model.addAttribute("bus", bus);
	        return "edit-bus";
	    }
	 @PostMapping("/update")
	 public String updateBus(@ModelAttribute("bus") Bus editedBus) {
	     // Retrieve the existing bus from the database
	     Bus existingBus = busService.getBusById(editedBus.getId());
	     
	     if (existingBus == null) {
	         return "redirect:/buses";
	     }

	  
	     existingBus.setName(editedBus.getName());
	     existingBus.setCapacity(editedBus.getCapacity());
	     
	    
	     busService.saveBus(existingBus);

	     
	     return "redirect:/buses";
	 }

	    @GetMapping("/delete/{id}")
	    public String deleteBus(@PathVariable Long id) {
	        busService.deleteBus(id);
	        return "redirect:/buses";
	    }
	

}
