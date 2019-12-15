package com.srv.app.annotation.service.impl;

import com.srv.app.annotation.model.Vehicle;
import com.srv.app.annotation.repo.VehicleRepository;
import com.srv.app.annotation.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 15-Dec-19
 */

@Service
public class VechicleImpl implements VehicleService {

    @Autowired
    private VehicleRepository repo;

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return repo.save(vehicle);
    }

    @Override
    public Integer updateVehicle(Vehicle vehicle) {
        return saveVehicle(vehicle).getVehicleId();
    }

    @Override
    public Vehicle getOneVehicle(Integer vehicleId) {
        Optional<Vehicle> op = repo.findById(vehicleId);
        return op.orElse(null);
    }

    @Override
    public List<Vehicle> getAllvehicles() {
        return repo.findAll();
    }

    @Override
    public Integer deletevehicle(Integer vehicleId) {
        repo.deleteById(vehicleId);
        return vehicleId;
    }

    @Override
    public Boolean checkvehicle(Integer vehicleId) {
        return null;
    }

    @Override
    public List<Vehicle> getvehiclesByEmail(String name) {
        return repo.findByVehicleBrandName(name);
    }
}
