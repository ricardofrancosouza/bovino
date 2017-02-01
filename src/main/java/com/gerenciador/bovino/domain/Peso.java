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

import org.hibernate.annotations.ManyToAny;


@Entity
@NamedQuery(name="Peso.findAll", query="SELECT p FROM Peso p")
public class Peso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_peso")
	private Integer idPeso;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_pesagem")
	private Date dtPesagem;

	@Column(name="qtd_quilos")
	private double qtdQuilos;

	//bi-directional many-to-one association to Bovino
	@ManyToOne
	private Bovino bovino;

	public Peso() {
	}

	public Integer getIdPeso() {
		return this.idPeso;
	}

	public void setIdPeso(Integer idPeso) {
		this.idPeso = idPeso;
	}

	public Date getDtPesagem() {
		return this.dtPesagem;
	}

	public void setDtPesagem(Date dtPesagem) {
		this.dtPesagem = dtPesagem;
	}

	public double getQtdQuilos() {
		return this.qtdQuilos;
	}

	public void setQtdQuilos(double qtdQuilos) {
		this.qtdQuilos = qtdQuilos;
	}


	public Bovino getBovinos() {
		return bovino;
	}

	public void setBovinos(Bovino bovinos) {
		this.bovino = bovinos;
	}





}