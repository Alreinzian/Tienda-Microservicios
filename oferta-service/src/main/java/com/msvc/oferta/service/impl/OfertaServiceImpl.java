package com.msvc.oferta.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.msvc.oferta.entities.Oferta;

import com.msvc.oferta.exceptions.ResourceNotFoundException;
import com.msvc.oferta.repository.OfertaRepository;
import com.msvc.oferta.service.OfertaService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OfertaServiceImpl implements OfertaService {

	
	//private Logger logger = LoggerFactory.getLogger(OfertaService.class);
	
	//@Autowired
	//private RestTemplate restTemplate;
	
	
    @Autowired
    private OfertaRepository ofertaRepository;

    @Override
    public Oferta saveOferta(Oferta oferta) {
        String randomOfertaId = UUID.randomUUID().toString();
        oferta.setOfertaId(randomOfertaId);
        return ofertaRepository.save(oferta);
    }

    @Override
    public List<Oferta> getAllOfertas() {
        return ofertaRepository.findAll();
    }

	@Override
	public Oferta getOferta(String ofertaId) {
		// TODO Auto-generated method stub
		return ofertaRepository.findById(ofertaId).orElseThrow(()-> new ResourceNotFoundException("Oferta no encontrada con el Id : " +ofertaId));
	}

}
