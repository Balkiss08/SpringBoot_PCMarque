package com.balkiss.produits.repos;



import org.springframework.data.jpa.repository.JpaRepository;


import com.balkiss.produits.entities.Produit;
public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
}