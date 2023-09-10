package com.example.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crm.model.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long>{
	
}
