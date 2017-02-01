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
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the statusbovinos database table.
 * 
 */
@Entity
@Table(name="statusbovinos")
@NamedQuery(name="Statusbovino.findAll", query="SELECT s FROM Statusbovino s")
public class Statusbovino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_status")
	private Integer idStatus;

	@Column(name="flg_doador")
	private boolean flgDoador;

	@Column(name="flg_fertilidade")
	private boolean flgFertilidade;

	@Column(name="flg_mamando")
	private boolean flgMamando;

	@Column(name="flg_vazia")
	private boolean flgVazia;
	@OneToMany(mappedBy="statusbovino")
	private List<Bovino> bovinos;



	public Statusbovino() {
	}

	public Integer getIdStatus() {
		return this.idStatus;
	}

	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}

	public boolean getFlgDoador() {
		return this.flgDoador;
	}

	public void setFlgDoador(boolean flgDoador) {
		this.flgDoador = flgDoador;
	}

	public boolean getFlgFertilidade() {
		return this.flgFertilidade;
	}

	public void setFlgFertilidade(boolean flgFertilidade) {
		this.flgFertilidade = flgFertilidade;
	}

	public boolean getFlgMamando() {
		return this.flgMamando;
	}

	public void setFlgMamando(boolean flgMamando) {
		this.flgMamando = flgMamando;
	}

	public boolean getFlgVazia() {
		return this.flgVazia;
	}

	public void setFlgVazia(boolean flgVazia) {
		this.flgVazia = flgVazia;
	}

	public List<Bovino> getBovinos() {
		return this.bovinos;
	}

	public void setBovinos(List<Bovino> bovinos) {
		this.bovinos = bovinos;
	}

	public Bovino addBovino(Bovino bovino) {
		getBovinos().add(bovino);
		bovino.setStatusbovino(this);

		return bovino;
	}

	public Bovino removeBovino(Bovino bovino) {
		getBovinos().remove(bovino);
		bovino.setStatusbovino(null);

		return bovino;
	}



}