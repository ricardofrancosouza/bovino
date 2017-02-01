package com.gerenciador.bovino.domain;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the raca database table.
 * 
 */
@Entity
@NamedQuery(name="Raca.findAll", query="SELECT r FROM Raca r")
public class Raca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_raca")
	private Integer idRaca;

	@Column(name="ds_abrev")
	private String dsAbrev;

	@Column(name="nm_raca")
	private String nmRaca;

	private String obs;

	//bi-directional many-to-one association to Bovino
	@OneToMany(mappedBy="raca")
	private List<Bovino> bovinos;

	public Raca() {
	}

	public Integer getIdRaca() {
		return this.idRaca;
	}

	public void setIdRaca(Integer idRaca) {
		this.idRaca = idRaca;
	}

	public String getDsAbrev() {
		return this.dsAbrev;
	}

	public void setDsAbrev(String dsAbrev) {
		this.dsAbrev = dsAbrev;
	}

	public String getNmRaca() {
		return this.nmRaca;
	}

	public void setNmRaca(String nmRaca) {
		this.nmRaca = nmRaca;
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
		bovino.setRaca(this);

		return bovino;
	}

	public Bovino removeBovino(Bovino bovino) {
		getBovinos().remove(bovino);
		bovino.setRaca(null);

		return bovino;
	}

}