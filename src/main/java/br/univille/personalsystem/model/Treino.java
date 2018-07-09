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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Treino {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	@Column(length=10000)
	private String Nome;
	private String Observacao;
	private String Objetivo;
	@Temporal(value=TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date Inicio;
	private Date Fim;

	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH}, optional=true)
	private Matricula matricula = new Matricula();


	@ManyToMany(cascade= {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="exercicios_id")
	List<Exercicios> listaExercicios = new ArrayList<Exercicios>();


	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		this.Id = id;
	}

	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getObservacao() {
		return Observacao;
	}
	public void setObservacao(String observacao) {
		Observacao = observacao;
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

	public List<Exercicios> getListaExercicios() {
		return listaExercicios;
	}

	public void setListaExercicios(List<Exercicios> ListaExercicios) {
		this.listaExercicios = ListaExercicios;
	}

}
