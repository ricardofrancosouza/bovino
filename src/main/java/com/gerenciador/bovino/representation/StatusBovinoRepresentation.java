package com.gerenciador.bovino.representation;
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gerenciador.bovino.domain.Bovino;
import com.gerenciador.bovino.domain.Raca;
import com.gerenciador.bovino.domain.Statusbovino;;

public class StatusBovinoRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Integer identifier;

	@JsonInclude(Include.NON_NULL)
	private boolean flgDoador;
	
	@JsonInclude(Include.NON_NULL)
	private boolean flgFertilidade;	

	@JsonInclude(Include.NON_NULL)
	private boolean flgMamando;
	
	@JsonInclude(Include.NON_NULL)
	private boolean flgVazia;
	
	@JsonInclude(Include.NON_NULL)
	private List<BovinoRepresentation> Bovino;
	
	

		public StatusBovinoRepresentation() {
	}

	public StatusBovinoRepresentation(Statusbovino status) {
		this.identifier = status.getIdStatus();
		this.flgDoador = status.getFlgDoador();
		this.flgFertilidade = status.getFlgFertilidade();
		this.flgMamando = status.getFlgMamando();
		this.flgVazia = status.getFlgVazia();
		
//		if(status.getBovinos() != null)
//		{
//			List<Bovino> bovinos = status.getBovinos();
//			List<BovinoRepresentation> bovinoRepresentation= new ArrayList<>();
//			for(Bovino bovino : bovinos )
//			{
//				bovinoRepresentation.add(new BovinoRepresentation(bovino));
//				
//			}
//			this.setBovino(bovinoRepresentation);
//			
//		}

		
	}
	
	

	public static Statusbovino build(StatusBovinoRepresentation representation) {

		Statusbovino status = new Statusbovino();
		
		status.setIdStatus(representation.getIdentifier());
		status.setFlgFertilidade(representation.getFlgFertilidade());
		status.setFlgMamando(representation.getFlgMamando());
        status.setFlgVazia(representation.getFlgVazia());
        
//        if(representation.getBovino() != null)
//        {
//        	List<BovinoRepresentation> bovinosRepresentation = representation.getBovino();
//        	List<Bovino> bovinos = new ArrayList<>();
//        	for(BovinoRepresentation bovinoRepre : bovinosRepresentation)
//        	{
//        		bovinos.add(BovinoRepresentation.build(bovinoRepre));
//        	}
//        	status.setBovinos(bovinos);
//        }

		return status;
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public boolean isFlgDoador() {
		return flgDoador;
	}

	public void setFlgDoador(boolean flgDoador) {
		this.flgDoador = flgDoador;
	}

	public boolean getFlgFertilidade() {
		return flgFertilidade;
	}

	public void setFlgFertilidade(boolean flgFertilidade) {
		this.flgFertilidade = flgFertilidade;
	}

	public boolean getFlgMamando() {
		return flgMamando;
	}

	public void setFlgMamando(boolean flgMamando) {
		this.flgMamando = flgMamando;
	}

	public boolean getFlgVazia() {
		return flgVazia;
	}

	public void setFlgVazia(boolean flgVazia) {
		this.flgVazia = flgVazia;
	}

	public List<BovinoRepresentation> getBovino() {
		return Bovino;
	}

	public void setBovino(List<BovinoRepresentation> bovino) {
		Bovino = bovino;
	}





}
