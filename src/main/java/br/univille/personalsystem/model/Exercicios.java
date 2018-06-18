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
public class Exercicios {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(length=10000)
	private String Treino;
	private int Duracao;
	private int Repeticao;
	private int Carga;
	private int Intervalo;
	private int Ordem;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH})
	private TipoExercicios tipoExercicios = new TipoExercicios();
	
	@ManyToMany(cascade= {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="equipamentos_id")
	List<Equipamentos> listaEquipamentos = new ArrayList<Equipamentos>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTreino() {
		return Treino;
	}
	public void setTreino(String treino) {
		Treino = treino;
	}
	public int getDuracao() {
		return Duracao;
	}
	public void setDuracao(int duracao) {
		Duracao = duracao;
	}
	public int getRepeticao() {
		return Repeticao;
	}
	public void setRepeticao(int repeticao) {
		Repeticao = repeticao;
	}
	public int getCarga() {
		return Carga;
	}
	public void setCarga(int carga) {
		Carga = carga;
	}
	public int getIntervalo() {
		return Intervalo;
	}
	public void setIntervalo(int intervalo) {
		Intervalo = intervalo;
	}
	public int getOrdem() {
		return Ordem;
	}
	public void setOrdem(int ordem) {
		Ordem = ordem;
	}
	
}
