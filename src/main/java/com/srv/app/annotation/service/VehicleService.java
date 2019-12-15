package com.srv.app.annotation.service;

import com.srv.app.annotation.model.Vehicle;

import java.util.List;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 15-Dec-19
 */
public interface VehicleService {

     Vehicle saveVehicle(Vehicle vehicle);

     Integer updateVehicle(Vehicle vehicle);

     Vehicle getOneVehicle(Integer vehicleId);

     List<Vehicle> getAllvehicles();

     Integer deletevehicle(Integer vehicleId);

     Boolean checkvehicle(Integer vehicleId);

     List<Vehicle> getvehiclesByEmail(String name);
}
