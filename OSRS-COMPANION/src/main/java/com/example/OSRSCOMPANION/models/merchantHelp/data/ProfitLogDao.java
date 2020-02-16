package com.example.OSRSCOMPANION.models.merchantHelp.data;

import com.example.OSRSCOMPANION.models.merchantHelp.profitLog.profitLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfitLogDao extends CrudRepository<profitLog, Integer> {
}
