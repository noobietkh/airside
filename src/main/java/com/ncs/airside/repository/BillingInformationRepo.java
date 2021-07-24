package com.ncs.airside.repository;

import com.ncs.airside.model.database.BillingInformation;
import com.ncs.airside.model.database.CustomerInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingInformationRepo extends JpaRepository<BillingInformation, Integer> {
}
