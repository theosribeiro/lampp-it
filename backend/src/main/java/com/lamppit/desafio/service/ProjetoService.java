package com.lamppit.desafio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lamppit.desafio.model.Projeto;
import com.lamppit.desafio.repository.ProjetoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProjetoService {
	
	@Autowired // automaticamente instanciada pelo Spring boot
	private ProjetoRepository repo;
	
	public Projeto find(Integer id) throws ObjectNotFoundException {
		Optional<Projeto> obj = repo.findById(id);
		
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+id + ",Tipo: "+ Projeto.class.getName());
		}
		return obj.orElse(null);
	}
	
	public Projeto insert(Projeto obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Projeto update(Projeto obj) throws ObjectNotFoundException {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) throws ObjectNotFoundException {
		find(id);
		repo.deleteById(id);
	}
}

















