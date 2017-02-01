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
 * The persistent class for the notafiscal database table.
 * 
 */
@Entity
@NamedQuery(name="Notafiscal.findAll", query="SELECT n FROM Notafiscal n")
public class Notafiscal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_notafiscal")
	private Integer idNotafiscal;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_emissao")
	private Date dtEmissao;

	@Column(name="flg_compra")
	private boolean flgCompra;

	@Column(name="flg_servico")
	private boolean flgServico;

	@Column(name="flg_venda")
	private boolean flgVenda;

	@Column(name="nr_fiscal")
	private String nrFiscal;

	@Column(name="serie_nota")
	private String serieNota;

	//bi-directional many-to-one association to Entradabovino
	@OneToMany(mappedBy="notafiscal")
	private List<Entradabovino> entradabovinos;

	//bi-directional many-to-one association to Entradasemem
	@OneToMany(mappedBy="notafiscal")
	private List<Entradasemem> entradasemems;

	//bi-directional many-to-one association to Saidabovino
	@OneToMany(mappedBy="notafiscal")
	private List<Saidabovino> saidabovinos;

	public Notafiscal() {
	}

	public Integer getIdNotafiscal() {
		return this.idNotafiscal;
	}

	public void setIdNotafiscal(Integer idNotafiscal) {
		this.idNotafiscal = idNotafiscal;
	}

	public Date getDtEmissao() {
		return this.dtEmissao;
	}

	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	

	public boolean getFlgCompra() {
		return flgCompra;
	}

	public void setFlgCompra(boolean flgCompra) {
		this.flgCompra = flgCompra;
	}

	public boolean getFlgServico() {
		return flgServico;
	}

	public void setFlgServico(boolean flgServico) {
		this.flgServico = flgServico;
	}

	public boolean getFlgVenda() {
		return flgVenda;
	}

	public void setFlgVenda(boolean flgVenda) {
		this.flgVenda = flgVenda;
	}

	public String getNrFiscal() {
		return this.nrFiscal;
	}

	public void setNrFiscal(String nrFiscal) {
		this.nrFiscal = nrFiscal;
	}

	public String getSerieNota() {
		return this.serieNota;
	}

	public void setSerieNota(String serieNota) {
		this.serieNota = serieNota;
	}

	public List<Entradabovino> getEntradabovinos() {
		return this.entradabovinos;
	}

	public void setEntradabovinos(List<Entradabovino> entradabovinos) {
		this.entradabovinos = entradabovinos;
	}

	public Entradabovino addEntradabovino(Entradabovino entradabovino) {
		getEntradabovinos().add(entradabovino);
		entradabovino.setNotafiscal(this);

		return entradabovino;
	}

	public Entradabovino removeEntradabovino(Entradabovino entradabovino) {
		getEntradabovinos().remove(entradabovino);
		entradabovino.setNotafiscal(null);

		return entradabovino;
	}

	public List<Entradasemem> getEntradasemems() {
		return this.entradasemems;
	}

	public void setEntradasemems(List<Entradasemem> entradasemems) {
		this.entradasemems = entradasemems;
	}

	public Entradasemem addEntradasemem(Entradasemem entradasemem) {
		getEntradasemems().add(entradasemem);
		entradasemem.setNotafiscal(this);

		return entradasemem;
	}

	public Entradasemem removeEntradasemem(Entradasemem entradasemem) {
		getEntradasemems().remove(entradasemem);
		entradasemem.setNotafiscal(null);

		return entradasemem;
	}

	public List<Saidabovino> getSaidabovinos() {
		return this.saidabovinos;
	}

	public void setSaidabovinos(List<Saidabovino> saidabovinos) {
		this.saidabovinos = saidabovinos;
	}

	public Saidabovino addSaidabovino(Saidabovino saidabovino) {
		getSaidabovinos().add(saidabovino);
		saidabovino.setNotafiscal(this);

		return saidabovino;
	}

	public Saidabovino removeSaidabovino(Saidabovino saidabovino) {
		getSaidabovinos().remove(saidabovino);
		saidabovino.setNotafiscal(null);

		return saidabovino;
	}

}