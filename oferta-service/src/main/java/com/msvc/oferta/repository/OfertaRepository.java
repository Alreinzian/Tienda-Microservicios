package com.msvc.oferta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msvc.oferta.entities.Oferta;

public interface OfertaRepository extends JpaRepository<Oferta,String> {
}
