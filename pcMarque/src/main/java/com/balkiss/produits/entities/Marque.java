package com.balkiss.produits.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data

@AllArgsConstructor

@Entity
public class Marque{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMarque;
	private String nomMarque;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateCreation;
	
	private String paysOrigine;
	
	@JsonIgnore
	@OneToMany(mappedBy = "marque")
	private List<Pc> pcs;
	public Marque(String nomMarque, Date dateCreation, String paysOrigine) {
		super();
		this.nomMarque = nomMarque;
		this.dateCreation = dateCreation;
		this.paysOrigine = paysOrigine;
	}
	public List<Pc> getPcs() {
		return pcs;
	}
	public void setPcs(List<Pc> pcs) {
		this.pcs = pcs;
	}
	public Marque() {
		super();
		}
	
	public Long getIdMarque() {
		return idMarque;
	}
	
	public String getNomMarque() {
		return nomMarque;
	}
	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getPaysOrigine() {
		return paysOrigine;
	}
	public void setPaysOrigine(String paysOrigine) {
		this.paysOrigine = paysOrigine;
	}
	@Override
	public String toString() {
		return "Marque [nomMarque=" + nomMarque + ", dateCreation=" + dateCreation
				+ ", paysOrigine=" + paysOrigine + "]";
	}

	
}