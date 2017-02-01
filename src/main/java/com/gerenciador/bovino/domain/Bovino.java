package com.gerenciador.bovino.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@NamedQuery(name="Bovino.findAll", query="SELECT b FROM Bovino b")
public class Bovino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_bovino")
	private Integer idBovino;

	@Column(name="apelido")
	private String apelido;

	@Column(name="cod_barras")
	private String codBarras;

	@Column(name="cor_pelagem")
	private String corPelagem;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_desmama")
	private Date dtDesmama;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_entrada")
	private Date dtEntrada;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_inicio")
	private Date dtInicio;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Date dtNascimento;

	@Column(name="flg_ativo")
    private boolean flgAtivo;
	@Column(name="nr_chip_eletronico")
	private String nrChipEletronico;

	@Column(name="nr_manejosisbov")
	private String nrManejosisbov;

	private String sexo;

	@Column(name="vl_custo")
	private BigDecimal vlCusto;

	//bi-directional many-to-one association to Idadebovino
	@ManyToOne
	@JoinColumn(name="id_idade")
	private Idadebovino idadebovino;

	//bi-directional many-to-one association to Nascimento
	@ManyToOne
	@JoinColumn(name="id_nascimento")
	private Nascimento nascimento;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_status")
	private Statusbovino statusbovino;

	//bi-directional many-to-one association to Desmama
	@ManyToOne
	@JoinColumn(name="id_desmama")
	private Desmama desmama;

	//bi-directional many-to-one association to Peso
	@OneToMany(mappedBy="bovino")
	//@JoinColumn(name="id_bovino")
	private List<Peso> pesos;

	//bi-directional many-to-one association to Lote
	@ManyToOne
	@JoinColumn(name="id_lote")
	private Lote lote;

	//bi-directional many-to-one association to Raca
	@ManyToOne
	@JoinColumn(name="id_raca")
	private Raca raca;

	//bi-directional many-to-one association to Monta
	@OneToMany(mappedBy="bovino")
	private List<Monta> montas;

	//bi-directional many-to-one association to Semem
	@OneToMany(mappedBy="bovino")
	private List<Semem> semems;

	public Bovino() {
	}


	public Integer getId_bovino() {
		return idBovino;
	}


	public void setId_bovino(Integer idBovino) {
		this.idBovino = idBovino;
	}


	public String getApelido() {
		return this.apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getCodBarras() {
		return this.codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public String getCorPelagem() {
		return this.corPelagem;
	}

	public void setCorPelagem(String corPelagem) {
		this.corPelagem = corPelagem;
	}

	public Date getDtDesmama() {
		return this.dtDesmama;
	}

	public void setDtDesmama(Date dtDesmama) {
		this.dtDesmama = dtDesmama;
	}

	public Date getDtEntrada() {
		return this.dtEntrada;
	}

	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public Date getDtInicio() {
		return this.dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtNascimento() {
		return this.dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public boolean getFlgAtivo() {
		return this.flgAtivo;
	}

	public void setFlgAtivo(boolean flgAtivo) {
		this.flgAtivo = flgAtivo;
	}

	public String getNrChipEletronico() {
		return this.nrChipEletronico;
	}

	public void setNrChipEletronico(String nrChipEletronico) {
		this.nrChipEletronico = nrChipEletronico;
	}

	public String getNrManejosisbov() {
		return this.nrManejosisbov;
	}

	public void setNrManejosisbov(String nrManejosisbov) {
		this.nrManejosisbov = nrManejosisbov;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public BigDecimal getVlCusto() {
		return this.vlCusto;
	}

	public void setVlCusto(BigDecimal vlCusto) {
		this.vlCusto = vlCusto;
	}

	public Idadebovino getIdadebovino() {
		return this.idadebovino;
	}

	public void setIdadebovino(Idadebovino idadebovino) {
		this.idadebovino = idadebovino;
	}

	public Nascimento getNascimento() {
		return this.nascimento;
	}

	public void setNascimento(Nascimento nascimento) {
		this.nascimento = nascimento;
	}

	public Statusbovino getStatusbovino() {
		return this.statusbovino;
	}

	public void setStatusbovino(Statusbovino statusbovino) {
		this.statusbovino = statusbovino;
	}

	public Desmama getDesmama() {
		return this.desmama;
	}

	public void setDesmama(Desmama desmama) {
		this.desmama = desmama;
	}





	public List<Peso> getPesos() {
		return pesos;
	}


	public void setPesos(List<Peso> pesos) {
		this.pesos = pesos;
	}


	public Lote getLote() {
		return this.lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public Raca getRaca() {
		return this.raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public List<Monta> getMontas() {
		return this.montas;
	}

	public void setMontas(List<Monta> montas) {
		this.montas = montas;
	}

	public Monta addMonta(Monta monta) {
		getMontas().add(monta);
		monta.setBovino(this);

		return monta;
	}

	public Monta removeMonta(Monta monta) {
		getMontas().remove(monta);
		monta.setBovino(null);

		return monta;
	}

	public List<Semem> getSemems() {
		return this.semems;
	}

	public void setSemems(List<Semem> semems) {
		this.semems = semems;
	}

	public Semem addSemem(Semem semem) {
		getSemems().add(semem);
		semem.setBovino(this);

		return semem;
	}

	public Semem removeSemem(Semem semem) {
		getSemems().remove(semem);
		semem.setBovino(null);

		return semem;
	}
	

}