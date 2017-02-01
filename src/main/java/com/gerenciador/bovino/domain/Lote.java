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


/**
 * The persistent class for the lote database table.
 * 
 */
@Entity
@NamedQuery(name="Lote.findAll", query="SELECT l FROM Lote l")
public class Lote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_lote")
	private Integer idLote;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_criacao")
	private Date dtCriacao;

	@Column(name="flg_ativo")
	private byte flgAtivo;

	@Column(name="nm_lote")
	private String nmLote;

	private String obs;

	//bi-directional many-to-one association to Bovino
	@OneToMany(mappedBy="lote")
	private List<Bovino> bovinos;

	//bi-directional many-to-one association to Entradabovino
	@OneToMany(mappedBy="lote")
	private List<Entradabovino> entradabovinos;

	//bi-directional many-to-one association to Progsaida
	@OneToMany(mappedBy="lote")
	private List<Progsaida> progsaidas;

	public Lote() {
	}

	public Integer getIdLote() {
		return this.idLote;
	}

	public void setIdLote(Integer idLote) {
		this.idLote = idLote;
	}

	public Date getDtCriacao() {
		return this.dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public byte getFlgAtivo() {
		return this.flgAtivo;
	}

	public void setFlgAtivo(byte flgAtivo) {
		this.flgAtivo = flgAtivo;
	}

	public String getNmLote() {
		return this.nmLote;
	}

	public void setNmLote(String nmLote) {
		this.nmLote = nmLote;
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
		bovino.setLote(this);

		return bovino;
	}

	public Bovino removeBovino(Bovino bovino) {
		getBovinos().remove(bovino);
		bovino.setLote(null);

		return bovino;
	}

	public List<Entradabovino> getEntradabovinos() {
		return this.entradabovinos;
	}

	public void setEntradabovinos(List<Entradabovino> entradabovinos) {
		this.entradabovinos = entradabovinos;
	}

	public Entradabovino addEntradabovino(Entradabovino entradabovino) {
		getEntradabovinos().add(entradabovino);
		entradabovino.setLote(this);

		return entradabovino;
	}

	public Entradabovino removeEntradabovino(Entradabovino entradabovino) {
		getEntradabovinos().remove(entradabovino);
		entradabovino.setLote(null);

		return entradabovino;
	}

	public List<Progsaida> getProgsaidas() {
		return this.progsaidas;
	}

	public void setProgsaidas(List<Progsaida> progsaidas) {
		this.progsaidas = progsaidas;
	}

	public Progsaida addProgsaida(Progsaida progsaida) {
		getProgsaidas().add(progsaida);
		progsaida.setLote(this);

		return progsaida;
	}

	public Progsaida removeProgsaida(Progsaida progsaida) {
		getProgsaidas().remove(progsaida);
		progsaida.setLote(null);

		return progsaida;
	}

}