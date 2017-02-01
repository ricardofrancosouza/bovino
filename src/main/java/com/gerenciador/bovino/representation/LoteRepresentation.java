package com.gerenciador.bovino.representation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gerenciador.bovino.domain.Bovino;
import com.gerenciador.bovino.domain.Lote;;

public class LoteRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Integer identifier;

	@JsonInclude(Include.NON_NULL)
	private Date dtCriacaoLote;
	
	@JsonInclude(Include.NON_NULL)
	private boolean flgAtivo;	

	@JsonInclude(Include.NON_NULL)
	private String nmLote;
	
	@JsonInclude(Include.NON_NULL)
	private float qtdBovinos;
	
	@JsonInclude(Include.NON_NULL)
	private List<BovinoRepresentation> bovinos;
	
	@JsonInclude(Include.NON_NULL)
	private String obs;


	
	public LoteRepresentation() {
	}

	public LoteRepresentation(Lote lote) {
		this.identifier = lote.getIdLote();
        this.nmLote        = lote.getNmLote();
        this.obs           = lote.getObs();
		if(lote.getBovinos()!= null)
		{
			List<Bovino> bovinos = lote.getBovinos();
			List<BovinoRepresentation> bovinosRepresentation = new ArrayList<>();
			for(Bovino bovino : bovinos)
			{
				bovinosRepresentation.add(new BovinoRepresentation(bovino));
			}
			this.setBovinos(bovinosRepresentation);
		}
		
		
	}

	public static Lote build(LoteRepresentation representation) {

		Lote lote = new Lote();
		lote.setNmLote(representation.nmLote);
		lote.setObs(representation.obs);
		if(representation.getBovinos()!=null)
        {
        	List<BovinoRepresentation> bovinosRepresentation = representation.getBovinos();
        	List<Bovino> bovinos = new ArrayList<>();
            for (BovinoRepresentation bovinoRepresentation : bovinosRepresentation)
            {
            	bovinos.add(BovinoRepresentation.build(bovinoRepresentation));
            }
           lote.setBovinos(bovinos);
        }
		return lote;
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public Date getDtCriacaoLote() {
		return dtCriacaoLote;
	}

	public void setDtCriacaoLote(Date dtCriacaoLote) {
		this.dtCriacaoLote = dtCriacaoLote;
	}

	public boolean isFlgAtivo() {
		return flgAtivo;
	}

	public void setFlgAtivo(boolean flgAtivo) {
		this.flgAtivo = flgAtivo;
	}

	public String getNmLote() {
		return nmLote;
	}

	public void setNmLote(String nmLote) {
		this.nmLote = nmLote;
	}

	public float getQtdBovinos() {
		return qtdBovinos;
	}

	public void setQtdBovinos(float qtdBovinos) {
		this.qtdBovinos = qtdBovinos;
	}

	public List<BovinoRepresentation> getBovinos() {
		return bovinos;
	}

	public void setBovinos(List<BovinoRepresentation> bovinos) {
		this.bovinos = bovinos;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}




}
