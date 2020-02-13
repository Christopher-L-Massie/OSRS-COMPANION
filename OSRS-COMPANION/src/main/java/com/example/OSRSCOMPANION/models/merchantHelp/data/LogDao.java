package com.example.OSRSCOMPANION.models.merchantHelp.data;

import com.example.OSRSCOMPANION.models.merchantHelp.profitLog.log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDao extends CrudRepository<log, Integer> {
}
