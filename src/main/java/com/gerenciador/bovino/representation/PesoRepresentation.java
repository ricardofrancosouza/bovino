package com.gerenciador.bovino.representation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gerenciador.bovino.domain.Bovino;
import com.gerenciador.bovino.domain.Peso;;

public class PesoRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Integer identifier;

	@JsonInclude(Include.NON_NULL)
	private Date dtPesagem;
	
	@JsonInclude(Include.NON_NULL)
	private double qtdQuilos;	

	@JsonIgnore
	private BovinoRepresentation bovino;
	
	public PesoRepresentation() {
	}

	public PesoRepresentation(Peso peso) {
		this.identifier = peso.getIdPeso();
		this.dtPesagem = peso.getDtPesagem();
		this.qtdQuilos = peso.getQtdQuilos();
	 /*   if(peso.getBovinos()!= null)
        {
        	Bovino bovino = peso.getBovinos();
	    	
	    	BovinoRepresentation bovinosRepresentation = new BovinoRepresentation(bovino);
	    	this.setBovinos(bovinosRepresentation);
        }*/
		
	}

	public static Peso build(PesoRepresentation representation) {

		Peso peso = new Peso();
		
		peso.setIdPeso(representation.getIdentifier());
		peso.setDtPesagem(representation.dtPesagem);
		peso.setQtdQuilos(representation.qtdQuilos);
	    if(representation.getBovinos()!= null)
        {
        	BovinoRepresentation bovinosRepresentation = representation.getBovinos();
        	peso.setBovinos(BovinoRepresentation.build(bovinosRepresentation));
        }
    
		return peso;
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public Date getDtPesagem() {
		return dtPesagem;
	}

	public void setDtPesagem(Date dtPesagem) {
		this.dtPesagem = dtPesagem;
	}

	public double getQtdQuilos() {
		return qtdQuilos;
	}

	public void setQtdQuilos(double qtdQuilos) {
		this.qtdQuilos = qtdQuilos;
	}

	public BovinoRepresentation getBovinos() {
		return bovino;
	}

	public void setBovinos(BovinoRepresentation bovinos) {
		this.bovino = bovinos;
	}

}
