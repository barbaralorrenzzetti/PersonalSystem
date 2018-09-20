package br.univille.personalsystem.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Avaliacao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(length=10000)
	private float peso;
	private float estatura;
	private float torax;
	private float quadril;
	private float ombro;
	private float abdomen;
	private float cintura;
	@ManyToOne
	private Membro braco = new Membro();
	@ManyToOne
	private Membro anteBraco = new Membro();
	@ManyToOne
	private Membro coxas = new Membro();
	@ManyToOne
	private Membro panturrilha = new Membro();
	private float triceps;
	private float escapular;
	private float axilar;
	private float peitoral;
	private float abdomnal;
	private float supraIliaca;
	private float coxa;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH})
	private Matricula matricula = new Matricula();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getEstatura() {
		return estatura;
	}

	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	public float getTorax() {
		return torax;
	}

	public void setTorax(float torax) {
		this.torax = torax;
	}

	public float getQuadril() {
		return quadril;
	}

	public void setQuadril(float quadril) {
		this.quadril = quadril;
	}

	public float getOmbro() {
		return ombro;
	}

	public void setOmbro(float ombro) {
		this.ombro = ombro;
	}

	public float getAbdomen() {
		return abdomen;
	}

	public void setAbdomen(float abdomen) {
		this.abdomen = abdomen;
	}

	public float getCintura() {
		return cintura;
	}

	public void setCintura(float cintura) {
		this.cintura = cintura;
	}

	public Membro getBraco() {
		return braco;
	}

	public void setBraco(Membro braco) {
		this.braco = braco;
	}

	public Membro getAnteBraco() {
		return anteBraco;
	}

	public void setAnteBraco(Membro anteBraco) {
		this.anteBraco = anteBraco;
	}

	public Membro getCoxas() {
		return coxas;
	}

	public void setCoxas(Membro coxas) {
		this.coxas = coxas;
	}

	public Membro getPanturrilha() {
		return panturrilha;
	}

	public void setPanturrilha(Membro panturrilha) {
		this.panturrilha = panturrilha;
	}

	public float getTriceps() {
		return triceps;
	}

	public void setTriceps(float triceps) {
		this.triceps = triceps;
	}

	public float getEscapular() {
		return escapular;
	}

	public void setEscapular(float escapular) {
		this.escapular = escapular;
	}

	public float getAxilar() {
		return axilar;
	}

	public void setAxilar(float axilar) {
		this.axilar = axilar;
	}

	public float getPeitoral() {
		return peitoral;
	}

	public void setPeitoral(float peitoral) {
		this.peitoral = peitoral;
	}

	public float getAbdomnal() {
		return abdomnal;
	}

	public void setAbdomnal(float abdomnal) {
		this.abdomnal = abdomnal;
	}

	public float getSupraIliaca() {
		return supraIliaca;
	}

	public void setSupraIliaca(float supraIliaca) {
		this.supraIliaca = supraIliaca;
	}

	public float getCoxa() {
		return coxa;
	}

	public void setCoxa(float coxa) {
		this.coxa = coxa;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	



}
