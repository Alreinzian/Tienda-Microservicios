package com.msvc.oferta.oferta.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msvc.oferta.oferta.entities.Oferta;
import com.msvc.oferta.oferta.exceptions.ResourceNotFoundException;
import com.msvc.oferta.oferta.repository.OfertaRepository;
import com.msvc.oferta.oferta.service.OfertaService;

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
