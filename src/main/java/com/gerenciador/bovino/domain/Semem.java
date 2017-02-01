package com.gerenciador.bovino.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the semem database table.
 * 
 */
@Entity
@NamedQuery(name="Semem.findAll", query="SELECT s FROM Semem s")
public class Semem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_semem")
	private Integer idSemem;

	private String obs;

	//bi-directional many-to-one association to Entradasemem
	@OneToMany(mappedBy="semem")
	private List<Entradasemem> entradasemems;

	//bi-directional many-to-one association to Monta
	@OneToMany(mappedBy="semem")
	private List<Monta> montas;

	//bi-directional many-to-one association to Bovino
	@ManyToOne
	@JoinColumn(name="id_reprodutor")
	private Bovino bovino;

	public Semem() {
	}

	public Integer getIdSemem() {
		return this.idSemem;
	}

	public void setIdSemem(Integer idSemem) {
		this.idSemem = idSemem;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public List<Entradasemem> getEntradasemems() {
		return this.entradasemems;
	}

	public void setEntradasemems(List<Entradasemem> entradasemems) {
		this.entradasemems = entradasemems;
	}

	public Entradasemem addEntradasemem(Entradasemem entradasemem) {
		getEntradasemems().add(entradasemem);
		entradasemem.setSemem(this);

		return entradasemem;
	}

	public Entradasemem removeEntradasemem(Entradasemem entradasemem) {
		getEntradasemems().remove(entradasemem);
		entradasemem.setSemem(null);

		return entradasemem;
	}

	public List<Monta> getMontas() {
		return this.montas;
	}

	public void setMontas(List<Monta> montas) {
		this.montas = montas;
	}

	public Monta addMonta(Monta monta) {
		getMontas().add(monta);
		monta.setSemem(this);

		return monta;
	}

	public Monta removeMonta(Monta monta) {
		getMontas().remove(monta);
		monta.setSemem(null);

		return monta;
	}

	public Bovino getBovino() {
		return this.bovino;
	}

	public void setBovino(Bovino bovino) {
		this.bovino = bovino;
	}

}