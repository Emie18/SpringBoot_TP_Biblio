package com.example.api_livre.dao;

import com.example.api_livre.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre, Long> {
}
