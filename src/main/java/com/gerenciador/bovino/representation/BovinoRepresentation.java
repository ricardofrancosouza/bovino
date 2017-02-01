package com.gerenciador.bovino.representation;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gerenciador.bovino.domain.Bovino;
import com.gerenciador.bovino.domain.Desmama;
import com.gerenciador.bovino.domain.Lote;
import com.gerenciador.bovino.domain.Monta;
import com.gerenciador.bovino.domain.Peso;
import com.gerenciador.bovino.domain.Raca;
import com.gerenciador.bovino.domain.Semem;
import com.gerenciador.bovino.domain.Statusbovino;
import com.gerenciador.bovino.service.StatusBovinoService;;

public class BovinoRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Integer identifier;

	@JsonInclude(Include.NON_NULL)
	private String apelido;
	
	@JsonInclude(Include.NON_NULL)
	private String sexo;	

	@JsonInclude(Include.NON_NULL)
	private String codbarras;
	
	@JsonInclude(Include.NON_NULL)
	private String corpelagem;
	
	@JsonInclude(Include.NON_NULL)
	private String nrChipeletronico;
	
	@JsonInclude(Include.NON_NULL)
	private String nrManejosisbov;
	
	@JsonInclude(Include.NON_NULL)
	private Date dtDesmama;
	
	@JsonInclude(Include.NON_NULL)
	private Date dtEntrada;
	
	@JsonInclude(Include.NON_NULL)
	private Date dtInicioMatriz;
	
	
	@JsonInclude(Include.NON_NULL)
	private Date dtNascimento;
	
	@JsonInclude(Include.NON_NULL)
	private BigDecimal vlrCusto;
    
	@JsonInclude(Include.NON_NULL)
	private LoteRepresentation lote;
	
	@JsonInclude(Include.NON_NULL)
	private List<MontaRepresentation> montas;
	
	@JsonInclude(Include.NON_NULL)
	private List<SememRepresentation> semens;
	//@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	private DesmamaRepresentation desmama;
	
	@JsonInclude(Include.NON_NULL)
	private StatusBovinoRepresentation statusbovino;
	
	@JsonInclude(Include.NON_NULL)
	private List<PesoRepresentation> pesos;
	
	
	@JsonInclude(Include.NON_NULL)
	private RacaRepresentation raca;
	
	
	
	
	
	public BovinoRepresentation() {
	}

	public BovinoRepresentation(Bovino bovino) {
		this.identifier   = bovino.getId_bovino();
		this.codbarras    = bovino.getCodBarras();
		this.apelido      = bovino.getApelido();
		this.corpelagem   = bovino.getCorPelagem();
		this.dtEntrada    = bovino.getDtEntrada();
		this.dtNascimento = bovino.getDtNascimento();
		if(bovino.getStatusbovino() != null)
		{
			Statusbovino status = bovino.getStatusbovino();
			StatusBovinoRepresentation statusRepresantetion = new StatusBovinoRepresentation(status);
			this.setStatusbovino(statusRepresantetion);
		}
		if(bovino.getRaca() != null)
		{
			Raca raca = bovino.getRaca();
			RacaRepresentation racaRepresantetion = new RacaRepresentation(raca);
			this.setRaca(racaRepresantetion);
		}
		
		/*if(bovino.getMontas()!= null)
		{
			List<Monta> montas = bovino.getMontas();
			List<MontaRepresentation> montasRepresentation = new ArrayList<>();
			for(Monta monta : montas)
			{
				montasRepresentation.add(new MontaRepresentation(monta));
				
			}
			this.setMontas(montasRepresentation);
		}
        if(bovino.getSemems() != null)
        {
        	List<Semem> semens = bovino.getSemems();
        	List<SememRepresentation> semensRepresentation = new ArrayList<>();
        	for(Semem semem : semens)
        	{
        		semensRepresentation.add(new SememRepresentation(semem));
        	}
        	this.setSemens(semensRepresentation);
        }*/
        
        if(bovino.getDesmama()!= null)
		{
			Desmama desmama = bovino.getDesmama();
			DesmamaRepresentation desmamaRepresentation = new DesmamaRepresentation(desmama);
			this.setDesmamas(desmamaRepresentation);
		}
        
        
        if(bovino.getPesos()!= null)
		{
			List<Peso> pesos = bovino.getPesos();
			List<PesoRepresentation> pesosRepresentation = new ArrayList<>();
			for(Peso peso : pesos)
			{
				pesosRepresentation.add(new PesoRepresentation(peso));
				
			}
			this.setPesos(pesosRepresentation);
		}
		this.nrChipeletronico = bovino.getNrChipEletronico();
		this.nrManejosisbov = bovino.getNrManejosisbov();
		this.sexo           = bovino.getSexo();
		this.vlrCusto       = bovino.getVlCusto();
		
		
	}

	public static Bovino build(BovinoRepresentation representation) {

		Bovino bovino = new Bovino();
		
		
		bovino.setId_bovino(representation.getIdentifier());
		bovino.setCodBarras(representation.codbarras);
		bovino.setCorPelagem(representation.corpelagem);
        bovino.setDtEntrada(representation.dtEntrada);
        bovino.setDtNascimento(representation.dtNascimento);
        
        bovino.setNrChipEletronico(representation.nrChipeletronico);
        bovino.setNrManejosisbov(representation.nrManejosisbov);
        bovino.setSexo(representation.sexo);
        bovino.setVlCusto(representation.vlrCusto);
        
        if(representation.getLote() != null)
        {
        	LoteRepresentation loteRepresentation = representation.getLote();
        	Lote lote = LoteRepresentation.build(loteRepresentation);
        	bovino.setLote(lote);
        }
        if(representation.getStatusbovino() != null)
        {
        	StatusBovinoRepresentation statusRepresentation = representation.getStatusbovino();
        	Statusbovino status = StatusBovinoRepresentation.build(statusRepresentation);
        	bovino.setStatusbovino(status);
        }
        
        
        if(representation.getDesmamas() != null)
        {
        	DesmamaRepresentation desmamaRepresentation = representation.getDesmamas();
        	Desmama desmama = DesmamaRepresentation.build(desmamaRepresentation);
        	bovino.setDesmama(desmama);
        }
        if(representation.getPesos()!= null)
      		{
      			List<PesoRepresentation> pesos = representation.getPesos();
      			List<Peso> pesos1 = new ArrayList<>();
      			for(PesoRepresentation peso : pesos)
      			{
      				pesos1.add( PesoRepresentation.build(peso));
      				
      			}
      			bovino.setPesos(pesos1);
      		}
        
        
        if(representation.getMontas() != null)
        {
        	List<MontaRepresentation> montasRepresentation = representation.getMontas();
        	List<Monta> montas = new ArrayList<>();
        	for(MontaRepresentation montaRepresentation  : montasRepresentation)
        	{
        		montas.add(MontaRepresentation.build(montaRepresentation));
        	}
        	
        	bovino.setMontas(montas);
        }
        
        if(representation.getSemens() != null)
        {
        	List<SememRepresentation> semensRepresentation = representation.getSemens();
        	List<Semem> semens = new ArrayList<>();
        	for(SememRepresentation sememRepresentation  : semensRepresentation)
        	{
        		semens.add(SememRepresentation.build(sememRepresentation));
        	}
        	
        	bovino.setSemems(semens);
        }
        
        
		return bovino;
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return apelido;
	}

	public void setName(String name) {
		this.apelido = name;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCodbarras() {
		return codbarras;
	}

	public void setCodbarras(String codbarras) {
		this.codbarras = codbarras;
	}

	public String getCorpelagem() {
		return corpelagem;
	}

	public void setCorpelagem(String corpelagem) {
		this.corpelagem = corpelagem;
	}

	public String getNrChipeletronico() {
		return nrChipeletronico;
	}

	public void setNrChipeletronico(String nrChipeletronico) {
		this.nrChipeletronico = nrChipeletronico;
	}

	public String getNrManejosisbov() {
		return nrManejosisbov;
	}

	public void setNrManejosisbov(String nrManejosisbov) {
		this.nrManejosisbov = nrManejosisbov;
	}

	public Date getDtDesmama() {
		return dtDesmama;
	}

	public void setDtDesmama(Date dtDesmama) {
		this.dtDesmama = dtDesmama;
	}

	public Date getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public Date getDtInicioMatriz() {
		return dtInicioMatriz;
	}

	public void setDtInicioMatriz(Date dtInicioMatriz) {
		this.dtInicioMatriz = dtInicioMatriz;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}



	public String getNome() {
		return apelido;
	}

	public void setNome(String nome) {
		this.apelido = nome;
	}

	public LoteRepresentation getLote() {
		return lote;
	}

	public void setLote(LoteRepresentation lote) {
		this.lote = lote;
	}

	public List<MontaRepresentation> getMontas() {
		return montas;
	}

	public void setMontas(List<MontaRepresentation> montas) {
		this.montas = montas;
	}

	public List<SememRepresentation> getSemens() {
		return semens;
	}

	public void setSemens(List<SememRepresentation> semens) {
		this.semens = semens;
	}

	public BigDecimal getVlrCusto() {
		return vlrCusto;
	}

	public void setVlrCusto(BigDecimal vlrCusto) {
		this.vlrCusto = vlrCusto;
	}

	public DesmamaRepresentation getDesmamas() {
		return desmama;
	}

	public void setDesmamas(DesmamaRepresentation desmamas) {
		this.desmama = desmamas;
	}

	public StatusBovinoRepresentation getStatusbovino() {
		return statusbovino;
	}

	public void setStatusbovino(StatusBovinoRepresentation statusbovino) {
		this.statusbovino = statusbovino;
	}

	public List<PesoRepresentation> getPesos() {
		return pesos;
	}

	public void setPesos(List<PesoRepresentation> pesos) {
		this.pesos = pesos;
	}

	public RacaRepresentation getRaca() {
		return raca;
	}

	public void setRaca(RacaRepresentation raca) {
		this.raca = raca;
	}


    

}
