package com.gerenciador.bovino.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name="Entradasemem.findAll", query="SELECT e FROM Entradasemem e")
public class Entradasemem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_entrada")
	private Integer idEntrada;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_entrada")
	private Date dtEntrada;

	@Column(name="qtd_semem")
	private double qtdSemem;

	@Column(name="vlr_semem")
	private float vlrSemem;

	//bi-directional many-to-one association to Semem
	@ManyToOne
	@JoinColumn(name="id_semem")
	private Semem semem;

	//bi-directional many-to-one association to Notafiscal
	@ManyToOne
	@JoinColumn(name="id_notafiscal")
	private Notafiscal notafiscal;

	public Entradasemem() {
	}

	public Integer getIdEntrada() {
		return this.idEntrada;
	}

	public void setIdEntrada(Integer idEntrada) {
		this.idEntrada = idEntrada;
	}

	public Date getDtEntrada() {
		return this.dtEntrada;
	}

	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public double getQtdSemem() {
		return this.qtdSemem;
	}

	public void setQtdSemem(double qtdSemem) {
		this.qtdSemem = qtdSemem;
	}

	public float getVlrSemem() {
		return this.vlrSemem;
	}

	public void setVlrSemem(float vlrSemem) {
		this.vlrSemem = vlrSemem;
	}

	public Semem getSemem() {
		return this.semem;
	}

	public void setSemem(Semem semem) {
		this.semem = semem;
	}

	public Notafiscal getNotafiscal() {
		return this.notafiscal;
	}

	public void setNotafiscal(Notafiscal notafiscal) {
		this.notafiscal = notafiscal;
	}

}