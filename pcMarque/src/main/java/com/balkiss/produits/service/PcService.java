package com.balkiss.produits.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.balkiss.produits.entities.Marque;
import com.balkiss.produits.entities.Pc;

public interface PcService {
	Pc savePc(Pc p);
	Pc updatePc(Pc p);
	void deletePc(Pc p);
	 void deletePcById(Long id);
	 Pc getPc(Long id);
	List<Pc> getAllPcs();
	Page<Pc> getAllPcsParPage(int page, int size);
	List<Pc> findByNomPc(String nom);
	//List<Pc> findByNomProduitContains(String nom);
	List<Pc> findByNomPrix (String nom, Double prix);
	List<Pc> findByMarque (Marque marque);
	List<Pc> findByMarqueIdMarque(Long id);
	List<Pc> findByOrderByNomPcAsc();
	List<Pc> trierPcsNomsPrix();

}
