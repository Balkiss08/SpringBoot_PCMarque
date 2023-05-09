package com.balkiss.produits.entities;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pc {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idPc;
private String processeurPc;
@NotNull
@Size (min = 4,max = 15)
private String nomPc;
private int memoirePc;
private int diqueDurPc;
@Min(value = 10)
@Max(value = 10000)
private double prixPc;
@ManyToOne
private Marque marque;
public Pc(String processeurPc, int memoirePc, int diqueDurPc, double prixPc, String nomPc) {
	super();
	this.nomPc=nomPc;
	this.processeurPc = processeurPc;
	this.memoirePc = memoirePc;
	this.diqueDurPc = diqueDurPc;
	this.prixPc = prixPc;
}
public Marque getMarque() {
	return marque;
}
public void setMarque(Marque marque) {
	this.marque = marque;
}
public Pc() {
	super();
	}
public Long getIdPc() {
	return idPc;
}

public String getProcesseurPc() {
	return processeurPc;
}
public void setProcesseurPc(String processeurPc) {
	this.processeurPc = processeurPc;
}
public int getMemoirePc() {
	return memoirePc;
}
public void setMemoirePc(int memoirePc) {
	this.memoirePc = memoirePc;
}
public int getDiqueDurPc() {
	return diqueDurPc;
}
public void setDiqueDurPc(int diqueDurPc) {
	this.diqueDurPc = diqueDurPc;
}
public double getPrixPc() {
	return prixPc;
}
public void setPrixPc(double prixPc) {
	this.prixPc = prixPc;
}

public String getNomPc() {
	return nomPc;
}
public void setNomPc(String nomPc) {
	this.nomPc = nomPc;
}
@Override
public String toString() {
	return "Pc [idPc=" + idPc + ", processeurPc=" + processeurPc + ", nomPc=" + nomPc + ", memoirePc=" + memoirePc
			+ ", diqueDurPc=" + diqueDurPc + ", prixPc=" + prixPc + ", marque=" + marque + "]";
}


	
}
