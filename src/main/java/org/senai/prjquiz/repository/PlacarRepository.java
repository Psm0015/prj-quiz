package org.senai.prjquiz.repository;

import org.senai.prjquiz.entity.placar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacarRepository extends JpaRepository<placar, Integer>{
    
}
