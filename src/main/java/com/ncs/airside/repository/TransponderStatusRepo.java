package com.ncs.airside.repository;

import com.ncs.airside.model.database.Transponder;
import com.ncs.airside.model.database.TransponderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransponderStatusRepo extends JpaRepository<TransponderStatus, Integer> {
}
