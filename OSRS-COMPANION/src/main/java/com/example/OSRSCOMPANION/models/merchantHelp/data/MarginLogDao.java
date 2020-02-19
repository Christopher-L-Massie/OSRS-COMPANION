package com.example.OSRSCOMPANION.models.merchantHelp.data;

import com.example.OSRSCOMPANION.models.merchantHelp.itemMarginLog.marginLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarginLogDao extends CrudRepository<marginLog, Integer> {
}
