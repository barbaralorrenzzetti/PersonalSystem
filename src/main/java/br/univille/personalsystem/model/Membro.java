package br.univille.personalsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Membro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private float membroDireito;
	private float membroEsquerdo;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getMembroDireito() {
		return membroDireito;
	}
	public void setMembroDireito(float membroDireito) {
		this.membroDireito = membroDireito;
	}
	public float getMembroEsquerdo() {
		return membroEsquerdo;
	}
	public void setMembroEsquerdo(float membroEsquerdo) {
		this.membroEsquerdo = membroEsquerdo;
	}
	
	
}
