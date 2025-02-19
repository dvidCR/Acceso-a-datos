package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Page<Cliente> findAll(Pageable pageable);
}