package com.balkiss.produits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.balkiss.produits.entities.Marque;
import com.balkiss.produits.repos.MarqueRepository;

@Service
public class MarqueServiceImpl implements MarqueService {
	@Autowired
	MarqueRepository marqueRepository;
	@Override
	public Marque saveMarque(Marque m) {
		return marqueRepository.save(m);
	}

	@Override
	public Marque updateMarque(Marque m) {
		return marqueRepository.save(m);
	}

	@Override
	public void deleteMarque(Marque m) {
		// TODO Auto-generated method stub
		marqueRepository.delete(m);
	}

	@Override
	public void deleteMarqueById(Long id) {
		// TODO Auto-generated method stub
		marqueRepository.deleteById(id);
	}

	@Override
	public Marque getMarque(Long id) {
		// TODO Auto-generated method stub
		return marqueRepository.findById(id).get();
	}

	@Override
	public List<Marque> getAllMarques() {
		// TODO Auto-generated method stub
		return marqueRepository.findAll();
	}

	@Override
	public Page<Marque> getAllMarquesParPage(int page, int size) {
		// TODO Auto-generated method stub
		return marqueRepository.findAll(PageRequest.of(page, size));
	}

}
