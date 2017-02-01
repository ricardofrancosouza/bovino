package com.gerenciador.bovino.representation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gerenciador.bovino.domain.Entradabovino;
import com.gerenciador.bovino.domain.Entradasemem;
import com.gerenciador.bovino.domain.Notafiscal;
import com.gerenciador.bovino.domain.Saidabovino;;

public class NotaFiscalRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Integer identifier;

	@JsonInclude(Include.NON_NULL)
	private Date dtemeissao;
	
	@JsonInclude(Include.NON_NULL)
	private List<EntradaBovinoRepresentation> entradasbovinos;	

	@JsonInclude(Include.NON_NULL)
	private List<EntradaSememRepresentation> entradassemens;
	
	@JsonInclude(Include.NON_NULL)
	private boolean flgCompra;
	
	@JsonInclude(Include.NON_NULL)
	private boolean flgservico;
	
	@JsonInclude(Include.NON_NULL)
	private boolean flgvenda;
	
	@JsonInclude(Include.NON_NULL)
	private List<SaidaBovinoRepresentation> saidabovinos;
	
	@JsonInclude(Include.NON_NULL)
	private String serienota;

	
	
	@JsonInclude(Include.NON_NULL)
	private String nrfiscal;
	
	

	public NotaFiscalRepresentation(Notafiscal notafiscal) {
		this.identifier = notafiscal.getIdNotafiscal();
		this.dtemeissao = notafiscal.getDtEmissao();
		this.flgCompra  = notafiscal.getFlgCompra();
		this.flgservico  = notafiscal.getFlgServico();
		this.flgvenda    = notafiscal.getFlgVenda();
		this.nrfiscal    = notafiscal.getNrFiscal();
		this.serienota   = notafiscal.getSerieNota();
		if (notafiscal.getEntradabovinos() != null)
		{
			List<Entradabovino> entradasbovinos = notafiscal.getEntradabovinos();
			List<EntradaBovinoRepresentation> entradabovinosrepresentation = new ArrayList<>();
			for(Entradabovino entradabovino : entradasbovinos)
			{
				entradabovinosrepresentation.add(new EntradaBovinoRepresentation(entradabovino));
			}
			this.setEntradasbovinos(entradabovinosrepresentation);
		}
		
		if (notafiscal.getEntradasemems() != null)
		{
			List<Entradasemem> entradassemens = notafiscal.getEntradasemems();
			List<EntradaSememRepresentation> entradasSemensrepresentation = new ArrayList<>();
			for(Entradasemem entradasemem : entradassemens)
			{
				entradasSemensrepresentation.add(new EntradaSememRepresentation(entradasemem));
			}
			this.setEntradassemens(entradasSemensrepresentation);
		}
		
		/*if (notafiscal.getSaidabovinos() != null)
		{
			List<Saidabovino> saidabovinos = notafiscal.getSaidabovinos();
			List<SaidaBovinoRepresentation> saidabovinosrepresentation = new ArrayList<>();
			for(Saidabovino saidabovino : saidabovinos)
			{
				saidabovinosrepresentation.add(new SaidaBovinoRepresentation(saidabovino));
			}
			this.setSaidabovinos(saidabovinosrepresentation);
		}*/
		
		
		
	}

	public static Notafiscal build(NotaFiscalRepresentation representation) {

		Notafiscal notafiscal = new Notafiscal();
		
		notafiscal.setIdNotafiscal(representation.getIdentifier());
		notafiscal.setDtEmissao(representation.dtemeissao);
		notafiscal.setFlgCompra(representation.flgCompra);
        notafiscal.setFlgServico(representation.flgservico);
        notafiscal.setFlgVenda(representation.flgvenda);
        notafiscal.setNrFiscal(representation.nrfiscal);
        notafiscal.setSerieNota(representation.serienota);
        if(representation.getEntradasbovinos() != null)
        {
        	List<EntradaBovinoRepresentation> entradabovinosRepresentation = representation.getEntradasbovinos();
        	List<Entradabovino> entradabovino = new ArrayList<>();
        	for(EntradaBovinoRepresentation entradabovinoRepresentation  : entradabovinosRepresentation)
        	{
        		entradabovino.add(EntradaBovinoRepresentation.build(entradabovinoRepresentation));
        	}
        	
        	notafiscal.setEntradabovinos(entradabovino);
        }
        if(representation.getEntradassemens() != null)
        {
        	List<EntradaSememRepresentation> entradasemensRepresentation = representation.getEntradassemens();
        	List<Entradasemem> entradasemens = new ArrayList<>();
        	for(EntradaSememRepresentation entradasememRepresentation  : entradasemensRepresentation)
        	{
        		entradasemens.add(EntradaSememRepresentation.build(entradasememRepresentation));
        	}
        	
        	notafiscal.setEntradasemems(entradasemens);
        }
        /*if(representation.getSaidabovinos() != null)
        {
        	List<SaidaBovinoRepresentation> saidaBovinosRepresentation = representation.getSaidabovinos();
        	List<Saidabovino> saidasbovino = new ArrayList<>();
        	for(SaidaBovinoRepresentation saidaBovinoRepresentation  : saidaBovinosRepresentation)
        	{
        		saidasbovino.add(SaidaBovinoRepresentation.build(saidaBovinoRepresentation));
        	}
        	
        	notafiscal.setSaidabovinos(saidasbovino);
        }*/
        
        
        
		return notafiscal;
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public Date getDtemeissao() {
		return dtemeissao;
	}

	public void setDtemeissao(Date dtemeissao) {
		this.dtemeissao = dtemeissao;
	}

	public List<EntradaBovinoRepresentation> getEntradasbovinos() {
		return entradasbovinos;
	}

	public void setEntradasbovinos(List<EntradaBovinoRepresentation> entradasbovinos) {
		this.entradasbovinos = entradasbovinos;
	}

	public List<EntradaSememRepresentation> getEntradassemens() {
		return entradassemens;
	}

	public void setEntradassemens(List<EntradaSememRepresentation> entradassemens) {
		this.entradassemens = entradassemens;
	}

	public boolean isFlgCompra() {
		return flgCompra;
	}

	public void setFlgCompra(boolean flgCompra) {
		this.flgCompra = flgCompra;
	}

	public boolean isFlgservico() {
		return flgservico;
	}

	public void setFlgservico(boolean flgservico) {
		this.flgservico = flgservico;
	}

	public boolean isFlgvenda() {
		return flgvenda;
	}

	public void setFlgvenda(boolean flgvenda) {
		this.flgvenda = flgvenda;
	}

	public List<SaidaBovinoRepresentation> getSaidabovinos() {
		return saidabovinos;
	}

	public void setSaidabovinos(List<SaidaBovinoRepresentation> saidabovinos) {
		this.saidabovinos = saidabovinos;
	}

	public String getSerienota() {
		return serienota;
	}

	public void setSerienota(String serienota) {
		this.serienota = serienota;
	}


	public String getNrfiscal() {
		return nrfiscal;
	}

	public void setNrfiscal(String nrfiscal) {
		this.nrfiscal = nrfiscal;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}



}
