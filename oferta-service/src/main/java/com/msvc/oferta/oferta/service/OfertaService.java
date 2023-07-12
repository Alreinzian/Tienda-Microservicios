package com.msvc.oferta.oferta.service;

import java.util.List;

import com.msvc.oferta.oferta.entities.Oferta;

public interface OfertaService {

    Oferta saveOferta(Oferta oferta);

    List<Oferta> getAllOfertas();

    Oferta getOferta(String ofertaId);
}
