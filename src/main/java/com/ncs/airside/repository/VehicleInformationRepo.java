package com.ncs.airside.repository;

import com.ncs.airside.model.database.VehicleInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleInformationRepo extends JpaRepository<VehicleInformation , Integer> {
}
