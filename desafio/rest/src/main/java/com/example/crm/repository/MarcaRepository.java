package com.example.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crm.model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long>{

}
