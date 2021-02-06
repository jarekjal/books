package com.jarekjal.books.controller;

import com.jarekjal.books.entity.Bike;
import com.jarekjal.books.entity.Car;
import com.jarekjal.books.entity.Vehicle;
import com.jarekjal.books.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/vehicles")
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicle> readAll() {
        return vehicleRepository.findAll();
    }


    @RequestMapping(path = "/cars", method = RequestMethod.POST)
    public Vehicle create(@RequestBody Car car) {
        return vehicleRepository.save(car);
    }

    @RequestMapping(path = "/bikes", method = RequestMethod.POST)
    public Vehicle create(@RequestBody Bike bike) {
        return vehicleRepository.save(bike);
    }
}
