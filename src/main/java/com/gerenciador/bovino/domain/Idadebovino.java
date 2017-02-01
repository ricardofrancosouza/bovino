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


/**
 * The persistent class for the idadebovino database table.
 * 
 */
@Entity
@NamedQuery(name="Idadebovino.findAll", query="SELECT i FROM Idadebovino i")
public class Idadebovino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_idade")
	private Integer idIdade;

	@Column(name="flg_bezerras_0_12")
	private boolean flgBezerras012;

	@Column(name="flg_bezerros_0_12")
	private boolean flgBezerros012;

	@Column(name="flg_novilhas_13_24")
	private boolean flgNovilhas1324;

	@Column(name="flg_novilhas_25_36")
	private boolean flgNovilhas2536;

	@Column(name="flg_novilhas_acima_36")
	private boolean flgNovilhasAcima36;

	@Column(name="flg_novilhos_13_24")
	private boolean flgNovilhos1324;

	@Column(name="flg_novilhos_25_36")
	private boolean flgNovilhos2536;

	@Column(name="flg_novilhos_acima_36")
	private boolean flgNovilhosAcima36;

	//bi-directional many-to-one association to Bovino
	@OneToMany(mappedBy="idadebovino")
	private List<Bovino> bovinos;

	public Idadebovino() {
	}

	public Integer getIdIdade() {
		return this.idIdade;
	}

	public void setIdIdade(Integer idIdade) {
		this.idIdade = idIdade;
	}

	public boolean getFlgBezerras012() {
		return this.flgBezerras012;
	}

	public void setFlgBezerras012(boolean flgBezerras012) {
		this.flgBezerras012 = flgBezerras012;
	}

	public boolean getFlgBezerros012() {
		return this.flgBezerros012;
	}

	public void setFlgBezerros012(boolean flgBezerros012) {
		this.flgBezerros012 = flgBezerros012;
	}

	public boolean getFlgNovilhas1324() {
		return this.flgNovilhas1324;
	}

	public void setFlgNovilhas1324(boolean flgNovilhas1324) {
		this.flgNovilhas1324 = flgNovilhas1324;
	}

	public boolean getFlgNovilhas2536() {
		return this.flgNovilhas2536;
	}

	public void setFlgNovilhas2536(boolean flgNovilhas2536) {
		this.flgNovilhas2536 = flgNovilhas2536;
	}

	public boolean getFlgNovilhasAcima36() {
		return this.flgNovilhasAcima36;
	}

	public void setFlgNovilhasAcima36(boolean flgNovilhasAcima36) {
		this.flgNovilhasAcima36 = flgNovilhasAcima36;
	}

	public boolean getFlgNovilhos1324() {
		return this.flgNovilhos1324;
	}

	public void setFlgNovilhos1324(boolean flgNovilhos1324) {
		this.flgNovilhos1324 = flgNovilhos1324;
	}

	public boolean getFlgNovilhos2536() {
		return this.flgNovilhos2536;
	}

	public void setFlgNovilhos2536(boolean flgNovilhos2536) {
		this.flgNovilhos2536 = flgNovilhos2536;
	}

	public boolean getFlgNovilhosAcima36() {
		return this.flgNovilhosAcima36;
	}

	public void setFlgNovilhosAcima36(boolean flgNovilhosAcima36) {
		this.flgNovilhosAcima36 = flgNovilhosAcima36;
	}

	public List<Bovino> getBovinos() {
		return this.bovinos;
	}

	public void setBovinos(List<Bovino> bovinos) {
		this.bovinos = bovinos;
	}

	public Bovino addBovino(Bovino bovino) {
		getBovinos().add(bovino);
		bovino.setIdadebovino(this);

		return bovino;
	}

	public Bovino removeBovino(Bovino bovino) {
		getBovinos().remove(bovino);
		bovino.setIdadebovino(null);

		return bovino;
	}

}