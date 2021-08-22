package com.lamppit.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lamppit.desafio.model.Projeto;
import com.lamppit.desafio.repository.ProjetoRepository;


@Service
public class ProjetoService {
	
	@Autowired // automaticamente instanciada pelo Spring boot
	private ProjetoRepository repo;
	
	public Projeto find(Integer id) {
		Optional<Projeto> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Projeto insert(Projeto obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Projeto update(Projeto obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public List<Projeto> findAll() {
		return repo.findAll();
		
	}
}

















