package com.ncs.airside.repository;

import com.ncs.airside.model.database.CompanyInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyInformationRepo extends JpaRepository<CompanyInformation, Integer> {
}
