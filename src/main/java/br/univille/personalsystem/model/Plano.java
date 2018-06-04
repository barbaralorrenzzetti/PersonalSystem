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
	private long id;
	@Column(length=10000)
	private String NomePlano;
	private float PrecoPlano;
	private String MetodoCobranca;
	
	@ManyToMany(cascade= {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="matricula_id")
	List<Matricula> listaMatricula = new ArrayList<Matricula>();
    
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomePlano() {
		return NomePlano;
	}
	public void setNomePlano(String nomePlano) {
		NomePlano = nomePlano;
	}
	public float getPrecoPlano() {
		return PrecoPlano;
	}
	public void setPrecoPlano(float precoPlano) {
		PrecoPlano = precoPlano;
	}
	public String getMetodoCobranca() {
		return MetodoCobranca;
	}
	public void setMetodoCobranca(String metodoCobranca) {
		MetodoCobranca = metodoCobranca;
	}
	

}
