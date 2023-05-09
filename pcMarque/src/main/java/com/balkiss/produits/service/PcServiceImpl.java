package com.balkiss.produits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.balkiss.produits.entities.Marque;
import com.balkiss.produits.entities.Pc;
import com.balkiss.produits.repos.PcRepository;

@Service
public class PcServiceImpl implements PcService {
	@Autowired
	PcRepository pcRepository;
	@Override
	public Pc savePc(Pc p) {
		return pcRepository.save(p);
	}

	@Override
	public Pc updatePc (Pc p) {
		return pcRepository.save(p);
	}

	@Override
	public void deletePc(Pc p) {
		// TODO Auto-generated method stub
		pcRepository.delete(p);
	}

	@Override
	public void deletePcById(Long id) {
		// TODO Auto-generated method stub
		pcRepository.deleteById(id);
	}

	@Override
	public Pc getPc(Long id) {
		// TODO Auto-generated method stub
		return pcRepository.findById(id).get();
	}

	@Override
	public List<Pc> getAllPcs() {
		// TODO Auto-generated method stub
		return pcRepository.findAll();
	}

	@Override
	public Page<Pc> getAllPcsParPage(int page, int size) {
		// TODO Auto-generated method stub
		return pcRepository.findAll(PageRequest.of(page, size));
	}
	
	@Override
	public List<Pc> findByNomPc(String nom) {
	return pcRepository.findByNomPc(nom);
	}
	
	@Override
	public List<Pc> findByNomPrix(String nom, Double prix) {
		return pcRepository.findByNomPrix(nom, prix);
	}
	@Override
	public List<Pc> findByMarque(Marque marque) {
	return pcRepository.findByCategorie(marque);
	}
	@Override
	public List<Pc> findByMarqueIdMarque(Long id) {
	return pcRepository.findByMarqueIdMarque(id);
	}
	@Override
	public List<Pc> findByOrderByNomPcAsc() {
	return pcRepository.findByOrderByNomPcAsc();
	}
	@Override
	public List<Pc> trierPcsNomsPrix() {
	return pcRepository.trierPcsNomsPrix();
	}

	
	}
