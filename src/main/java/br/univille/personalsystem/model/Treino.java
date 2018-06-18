package br.univille.personalsystem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Treino {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(length=10000)
	private String Nome;
	private String Observação;
	private String Objetivo;
	private Date Inicio;
	private Date Fim;

	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH})
	private Matricula matricula = new Matricula();

	@ManyToMany(cascade= {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="exercicios_id")
	List<Exercicios> listaExercicios = new ArrayList<Exercicios>();



	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getObservação() {
		return Observação;
	}
	public void setObservação(String observação) {
		Observação = observação;
	}
	public String getObjetivo() {
		return Objetivo;
	}
	public void setObjetivo(String objetivo) {
		Objetivo = objetivo;
	}
	public Date getInicio() {
		return Inicio;
	}
	public void setInicio(Date inicio) {
		Inicio = inicio;
	}
	public Date getFim() {
		return Fim;
	}
	public void setFim(Date fim) {
		Fim = fim;
	}


}
