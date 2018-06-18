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
import javax.persistence.ManyToOne;

@Entity
public class Equipamentos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(length=10000)
	private String Nome;
	private int Repeticao;
	private String Exercicios;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH})
	private Exercicios exercicios = new Exercicios();
	
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getRepeticao() {
		return Repeticao;
	}
	public void setRepeticao(int repeticao) {
		Repeticao = repeticao;
	}
	public String getExercicios() {
		return Exercicios;
	}
	public void setExercicios(String exercicios) {
		Exercicios = exercicios;
	}
	
}
