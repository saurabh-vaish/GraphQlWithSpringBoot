package com.srv.app.annotation.repo;

import com.srv.app.annotation.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 15-Dec-19
 */
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

    List<Vehicle> findByVehicleBrandName(String name);
}
