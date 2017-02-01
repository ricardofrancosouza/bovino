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



@Entity
@NamedQuery(name="Saidabovino.findAll", query="SELECT s FROM Saidabovino s")
public class Saidabovino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_saida")
	private Integer idSaida;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_saida")
	private Date dtSaida;

	@Column(name="flg_frigorifico")
	private boolean flgFrigorifico;

	@Column(name="flg_terceiros")
	private boolean flgTerceiros;

	private String obs;

	@Column(name="qtd_animais")
	private int qtdAnimais;

	@Column(name="qtd_kg_morto_medio_indiv")
	private double qtdKgMortoMedioIndiv;

	@Column(name="qtd_kg_vivo_medido_indiv")
	private double qtdKgVivoMedidoIndiv;

	@Column(name="vlr_arroba")
	private BigDecimal vlrArroba;

	@Column(name="vlr_total")
	private BigDecimal vlrTotal;

	//bi-directional many-to-one association to Progsaida
	@ManyToOne
	@JoinColumn(name="id_progsaida")
	private Progsaida progsaida;

	//bi-directional many-to-one association to Notafiscal
	@ManyToOne
	@JoinColumn(name="id_notafiscal")
	private Notafiscal notafiscal;

	public Saidabovino() {
	}

	public Integer getIdSaida() {
		return this.idSaida;
	}



	public Date getDtSaida() {
		return this.dtSaida;
	}

	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}
	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public int getQtdAnimais() {
		return this.qtdAnimais;
	}

	public void setQtdAnimais(int qtdAnimais) {
		this.qtdAnimais = qtdAnimais;
	}
	public void setQtdKgMortoMedioIndiv(float qtdKgMortoMedioIndiv) {
		this.qtdKgMortoMedioIndiv = qtdKgMortoMedioIndiv;
	}

	public void setQtdKgVivoMedidoIndiv(float qtdKgVivoMedidoIndiv) {
		this.qtdKgVivoMedidoIndiv = qtdKgVivoMedidoIndiv;
	}
	public Progsaida getProgsaida() {
		return this.progsaida;
	}

	public void setProgsaida(Progsaida progsaida) {
		this.progsaida = progsaida;
	}

	public Notafiscal getNotafiscal() {
		return this.notafiscal;
	}

	public void setNotafiscal(Notafiscal notafiscal) {
		this.notafiscal = notafiscal;
	}

	public boolean getFlgFrigorifico() {
		return flgFrigorifico;
	}

	public void setFlgFrigorifico(boolean flgFrigorifico) {
		this.flgFrigorifico = flgFrigorifico;
	}

	public boolean getFlgTerceiros() {
		return flgTerceiros;
	}

	public void setFlgTerceiros(boolean flgTerceiros) {
		this.flgTerceiros = flgTerceiros;
	}

	public double getQtdKgMortoMedioIndiv() {
		return qtdKgMortoMedioIndiv;
	}

	public void setQtdKgMortoMedioIndiv(double qtdKgMortoMedioIndiv) {
		this.qtdKgMortoMedioIndiv = qtdKgMortoMedioIndiv;
	}

	public double getQtdKgVivoMedidoIndiv() {
		return qtdKgVivoMedidoIndiv;
	}

	public void setQtdKgVivoMedidoIndiv(double qtdKgVivoMedidoIndiv) {
		this.qtdKgVivoMedidoIndiv = qtdKgVivoMedidoIndiv;
	}

	public BigDecimal getVlrArroba() {
		return vlrArroba;
	}

	public void setVlrArroba(BigDecimal vlrArroba) {
		this.vlrArroba = vlrArroba;
	}

	public BigDecimal getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(BigDecimal vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

	public void setIdSaida(Integer idSaida) {
		this.idSaida = idSaida;
	}
	

}