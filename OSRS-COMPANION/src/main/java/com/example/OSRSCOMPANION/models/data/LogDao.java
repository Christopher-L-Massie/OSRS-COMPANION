package com.example.OSRSCOMPANION.models.data;

import com.example.OSRSCOMPANION.models.merchantHelp.log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDao extends CrudRepository<log, Integer> {
}
