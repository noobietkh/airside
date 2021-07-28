package com.ncs.airside.repository;

import com.ncs.airside.model.database.CustomerInformation;
import com.ncs.airside.model.database.Transponder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerInformationRepo extends JpaRepository<CustomerInformation, Integer> {
    Optional<CustomerInformation> findByCustomerID(int customerID);
}
