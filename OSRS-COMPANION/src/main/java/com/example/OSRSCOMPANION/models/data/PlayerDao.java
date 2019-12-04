package com.example.OSRSCOMPANION.models.data;

import com.example.OSRSCOMPANION.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PlayerDao extends CrudRepository<Player, Integer> {





}
