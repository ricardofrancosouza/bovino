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
 * The persistent class for the nascimento database table.
 * 
 */
@Entity
@NamedQuery(name="Nascimento.findAll", query="SELECT n FROM Nascimento n")
public class Nascimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_nascimento")
	private Integer idNascimento;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_parto")
	private Date dtParto;

	@Column(name="flg_vivo")
	private boolean flgVivo;

	private String sexo;

	//bi-directional many-to-one association to Bovino
	@OneToMany(mappedBy="nascimento")
	private List<Bovino> bovinos;

	//bi-directional many-to-one association to Monta
	@ManyToOne
	@JoinColumn(name="id_monta")
	private Monta monta;

	public Nascimento() {
	}

	public Integer getIdNascimento() {
		return this.idNascimento;
	}

	public void setIdNascimento(Integer idNascimento) {
		this.idNascimento = idNascimento;
	}

	public Date getDtParto() {
		return this.dtParto;
	}

	public void setDtParto(Date dtParto) {
		this.dtParto = dtParto;
	}

	public boolean getFlgVivo() {
		return this.flgVivo;
	}

	public void setFlgVivo(boolean flgVivo) {
		this.flgVivo = flgVivo;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public List<Bovino> getBovinos() {
		return this.bovinos;
	}

	public void setBovinos(List<Bovino> bovinos) {
		this.bovinos = bovinos;
	}

	public Bovino addBovino(Bovino bovino) {
		getBovinos().add(bovino);
		bovino.setNascimento(this);

		return bovino;
	}

	public Bovino removeBovino(Bovino bovino) {
		getBovinos().remove(bovino);
		bovino.setNascimento(null);

		return bovino;
	}

	public Monta getMonta() {
		return this.monta;
	}

	public void setMonta(Monta monta) {
		this.monta = monta;
	}

}