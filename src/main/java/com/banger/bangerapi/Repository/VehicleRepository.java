package com.banger.bangerapi.Repository;

import com.banger.bangerapi.Models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository  extends JpaRepository<Vehicle,Integer> {
    @Query("select vehicle from Vehicle vehicle where  vehicle.status='available'")
    List<Vehicle> availableVehicle();
    @Query("select vehicle from Vehicle vehicle where  vehicle.status='unavailable'")
    List<Vehicle> unAvailableVehicle();
}
