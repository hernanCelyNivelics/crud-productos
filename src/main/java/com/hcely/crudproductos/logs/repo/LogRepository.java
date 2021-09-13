package com.hcely.crudproductos.logs.repo;

import com.hcely.crudproductos.logs.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log,Integer> {
}
