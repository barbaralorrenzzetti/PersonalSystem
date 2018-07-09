package br.univille.personalsystem.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;


@Entity
public class Plano {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	@Column(length=10000)
	private String nomePlano;
	private float precoPlano;
	private String metodoCobranca;
	

    
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		this.Id = id;
	}
	public String getNomePlano() {
		return nomePlano;
	}
	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}
	public float getPrecoPlano() {
		return precoPlano;
	}
	public void setPrecoPlano(float precoPlano) {
		this.precoPlano = precoPlano;
	}
	public String getMetodoCobranca() {
		return metodoCobranca;
	}
	public void setMetodoCobranca(String metodoCobranca) {
		this.metodoCobranca = metodoCobranca;
	}
	

}
