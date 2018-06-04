package br.univille.personalsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Entity
public class Matricula {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Length(min=2, max=1000, message="O tamanho do nome deve ser entre {min} e {max}")
	private Date InicioContrato;
	private Date TerminoContrato;
	private String TipoPlano;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getInicioContrato() {
		return InicioContrato;
	}
	public void setInicioContrato(Date inicioContrato) {
		InicioContrato = inicioContrato;
	}
	public Date getTerminoContrato() {
		return TerminoContrato;
	}
	public void setTerminoContrato(Date terminoContrato) {
		TerminoContrato = terminoContrato;
	}
	public String getTipoPlano() {
		return TipoPlano;
	}
	public void setTipoPlano(String tipoPlano) {
		TipoPlano = tipoPlano;
	}
	
	

}