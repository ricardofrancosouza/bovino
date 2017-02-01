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
 * The persistent class for the monta database table.
 * 
 */
@Entity
@NamedQuery(name="Monta.findAll", query="SELECT m FROM Monta m")
public class Monta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_monta")
	private Integer idMonta;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_monta")
	private Date dtMonta;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_prev_parto")
	private Date dtPrevParto;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_prev_resultado")
	private Date dtPrevResultado;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_resultado")
	private Date dtResultado;

	@Column(name="status_monta")
	private Boolean statusMonta;

	//bi-directional many-to-one association to Bovino
	@ManyToOne
	@JoinColumn(name="id_matriz")
	private Bovino bovino;

	//bi-directional many-to-one association to Semem
	@ManyToOne
	@JoinColumn(name="id_semem")
	private Semem semem;

	//bi-directional many-to-one association to Nascimento
	@OneToMany(mappedBy="monta")
	private List<Nascimento> nascimentos;

	public Monta() {
	}

	public Integer getIdMonta() {
		return this.idMonta;
	}

	public void setIdMonta(Integer idMonta) {
		this.idMonta = idMonta;
	}

	public Date getDtMonta() {
		return this.dtMonta;
	}

	public void setDtMonta(Date dtMonta) {
		this.dtMonta = dtMonta;
	}

	public Date getDtPrevParto() {
		return this.dtPrevParto;
	}

	public void setDtPrevParto(Date dtPrevParto) {
		this.dtPrevParto = dtPrevParto;
	}

	public Date getDtPrevResultado() {
		return this.dtPrevResultado;
	}

	public void setDtPrevResultado(Date dtPrevResultado) {
		this.dtPrevResultado = dtPrevResultado;
	}

	public Date getDtResultado() {
		return this.dtResultado;
	}

	public void setDtResultado(Date dtResultado) {
		this.dtResultado = dtResultado;
	}

	public Boolean getStatusMonta() {
		return this.statusMonta;
	}

	public void setStatusMonta(Boolean statusMonta) {
		this.statusMonta = statusMonta;
	}

	public Bovino getBovino() {
		return this.bovino;
	}

	public void setBovino(Bovino bovino) {
		this.bovino = bovino;
	}

	public Semem getSemem() {
		return this.semem;
	}

	public void setSemem(Semem semem) {
		this.semem = semem;
	}

	public List<Nascimento> getNascimentos() {
		return this.nascimentos;
	}

	public void setNascimentos(List<Nascimento> nascimentos) {
		this.nascimentos = nascimentos;
	}

	public Nascimento addNascimento(Nascimento nascimento) {
		getNascimentos().add(nascimento);
		nascimento.setMonta(this);

		return nascimento;
	}

	public Nascimento removeNascimento(Nascimento nascimento) {
		getNascimentos().remove(nascimento);
		nascimento.setMonta(null);

		return nascimento;
	}

}