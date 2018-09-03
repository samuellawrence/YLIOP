package com.arvato.jesy.lifematters.repositories;

import com.arvato.jesy.lifematters.entities.Personnel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {

}