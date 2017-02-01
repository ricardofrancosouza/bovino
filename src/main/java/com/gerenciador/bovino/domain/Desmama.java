package com.gerenciador.bovino.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQuery(name="Desmama.findAll", query="SELECT d FROM Desmama d")
public class Desmama implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_desmama")
	private Integer idDesmama;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_desmama")
	private Date dtDesmama;

	private String idade;

	private String obs;


	@OneToMany(mappedBy="desmama")
	private List<Bovino> bovinos;

	public Desmama() {
	}

	public Integer getIdDesmama() {
		return this.idDesmama;
	}

	public void setIdDesmama(Integer idDesmama) {
		this.idDesmama = idDesmama;
	}

	public Date getDtDesmama() {
		return this.dtDesmama;
	}

	public void setDtDesmama(Date dtDesmama) {
		this.dtDesmama = dtDesmama;
	}

	public String getIdade() {
		return this.idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public List<Bovino> getBovinos() {
		return this.bovinos;
	}

	public void setBovinos(List<Bovino> bovinos) {
		this.bovinos = bovinos;
	}

	public Bovino addBovino(Bovino bovino) {
		getBovinos().add(bovino);
		bovino.setDesmama(this);

		return bovino;
	}

	public Bovino removeBovino(Bovino bovino) {
		getBovinos().remove(bovino);
		bovino.setDesmama(null);

		return bovino;
	}

}