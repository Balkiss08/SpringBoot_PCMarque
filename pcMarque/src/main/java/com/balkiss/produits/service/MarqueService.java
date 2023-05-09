package com.balkiss.produits.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.balkiss.produits.entities.Marque;

public interface MarqueService {
	Marque saveMarque(Marque m);
	Marque updateMarque(Marque m);
	void deleteMarque(Marque m);
	 void deleteMarqueById(Long id);
	 Marque getMarque(Long id);
	List<Marque> getAllMarques();
	Page<Marque> getAllMarquesParPage(int page, int size);
}
