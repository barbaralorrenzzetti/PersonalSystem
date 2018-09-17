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
import javax.persistence.OneToMany;

@Entity
public class Exercicios {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(length=10000)
	private int duracao;
	private int repeticao;
	private int carga;
	private int intervalo;
	private int ordem;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH})
	private TipoExercicios tipoExercicios = new TipoExercicios();
	
	@OneToMany(cascade={CascadeType.MERGE,CascadeType.REFRESH},orphanRemoval=true)
    @JoinColumn(name="equipamentos_id")
	List<Equipamentos> listaEquipamentos = new ArrayList<Equipamentos>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getRepeticao() {
		return repeticao;
	}

	public void setRepeticao(int repeticao) {
		this.repeticao = repeticao;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	public int getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public TipoExercicios getTipoExercicios() {
		return tipoExercicios;
	}

	public void setTipoExercicios(TipoExercicios tipoExercicios) {
		this.tipoExercicios = tipoExercicios;
	}

	public List<Equipamentos> getListaEquipamentos() {
		return listaEquipamentos;
	}

	public void setListaEquipamentos(List<Equipamentos> listaEquipamentos) {
		this.listaEquipamentos = listaEquipamentos;
	}
	

}
