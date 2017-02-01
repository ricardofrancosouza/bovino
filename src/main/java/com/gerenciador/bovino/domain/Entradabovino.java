package com.gerenciador.bovino.domain;
import java.io.Serializable;
import java.math.BigDecimal;
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



/**
 * The persistent class for the entradabovino database table.
 * 
 */
@Entity
@NamedQuery(name="Entradabovino.findAll", query="SELECT e FROM Entradabovino e")
public class Entradabovino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_entradabov")
	private Integer idEntradabov;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_entrada")
	private Date dtEntrada;

	@Column(name="kg_morto_medido_individual")
	private double kgMortoMedidoIndividual;

	@Column(name="qtd_bovino")
	private int qtdBovino;

	@Column(name="qtd_kg_medio_individual")
	private double qtdKgMedioIndividual;

	@Column(name="vlr_arroba")
	private BigDecimal vlrArroba;

	@Column(name="vlr_total")
	private BigDecimal vlrTotal;

	@Column(name="vlr_unitario")
	private BigDecimal vlrUnitario;

	//bi-directional many-to-one association to Notafiscal
	@ManyToOne
	@JoinColumn(name="id_notafiscal")
	private Notafiscal notafiscal;

	//bi-directional many-to-one association to Lote
	@ManyToOne
	@JoinColumn(name="id_lote")
	private Lote lote;

	public Entradabovino() {
	}

	public Integer getIdEntradabov() {
		return this.idEntradabov;
	}

	public void setIdEntradabov(Integer idEntradabov) {
		this.idEntradabov = idEntradabov;
	}

	public Date getDtEntrada() {
		return this.dtEntrada;
	}

	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public double getKgMortoMedidoIndividual() {
		return this.kgMortoMedidoIndividual;
	}

	public void setKgMortoMedidoIndividual(double kgMortoMedidoIndividual) {
		this.kgMortoMedidoIndividual = kgMortoMedidoIndividual;
	}

	public int getQtdBovino() {
		return this.qtdBovino;
	}

	public void setQtdBovino(int qtdBovino) {
		this.qtdBovino = qtdBovino;
	}

	public double getQtdKgMedioIndividual() {
		return this.qtdKgMedioIndividual;
	}

	public void setQtdKgMedioIndividual(double qtdKgMedioIndividual) {
		this.qtdKgMedioIndividual = qtdKgMedioIndividual;
	}

	public BigDecimal getVlrArroba() {
		return this.vlrArroba;
	}

	public void setVlrArroba(BigDecimal vlrArroba) {
		this.vlrArroba = vlrArroba;
	}

	public BigDecimal getVlrTotal() {
		return this.vlrTotal;
	}

	public void setVlrTotal(BigDecimal vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

	public BigDecimal getVlrUnitario() {
		return this.vlrUnitario;
	}

	public void setVlrUnitario(BigDecimal vlrUnitario) {
		this.vlrUnitario = vlrUnitario;
	}

	public Notafiscal getNotafiscal() {
		return this.notafiscal;
	}

	public void setNotafiscal(Notafiscal notafiscal) {
		this.notafiscal = notafiscal;
	}

	public Lote getLote() {
		return this.lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

}