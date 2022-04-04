package com.gamegol.ranking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gamegol.ranking.model.Time;

public interface Times extends JpaRepository<Time, Long>{

}
