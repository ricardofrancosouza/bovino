package com.gerenciador.bovino.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the progsaida database table.
 * 
 */
@Entity
@NamedQuery(name="Progsaida.findAll", query="SELECT p FROM Progsaida p")
public class Progsaida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_progsaida")
	private Integer idProgsaida;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_saida")
	private Date dtSaida;

	@Column(name="peso_saida")
	private double pesoSaida;

	@Column(name="qtd_preparo")
	private double qtdPreparo;

	//bi-directional many-to-one association to Lote
	@ManyToOne
	@JoinColumn(name="id_lote")
	private Lote lote;

	//bi-directional many-to-one association to Saidabovino
	@OneToMany(mappedBy="progsaida")
	private List<Saidabovino> saidabovinos;

	public Progsaida() {
	}

	public Integer getIdProgsaida() {
		return this.idProgsaida;
	}

	public void setIdProgsaida(Integer idProgsaida) {
		this.idProgsaida = idProgsaida;
	}

	public Date getDtSaida() {
		return this.dtSaida;
	}

	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}

	public double getPesoSaida() {
		return this.pesoSaida;
	}

	public void setPesoSaida(double pesoSaida) {
		this.pesoSaida = pesoSaida;
	}

	public double getQtdPreparo() {
		return this.qtdPreparo;
	}

	public void setQtdPreparo(double qtdPreparo) {
		this.qtdPreparo = qtdPreparo;
	}

	public Lote getLote() {
		return this.lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public List<Saidabovino> getSaidabovinos() {
		return this.saidabovinos;
	}

	public void setSaidabovinos(List<Saidabovino> saidabovinos) {
		this.saidabovinos = saidabovinos;
	}

	public Saidabovino addSaidabovino(Saidabovino saidabovino) {
		getSaidabovinos().add(saidabovino);
		saidabovino.setProgsaida(this);

		return saidabovino;
	}

	public Saidabovino removeSaidabovino(Saidabovino saidabovino) {
		getSaidabovinos().remove(saidabovino);
		saidabovino.setProgsaida(null);

		return saidabovino;
	}

}