package com.gerenciador.bovino.representation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gerenciador.bovino.domain.Bovino;
import com.gerenciador.bovino.domain.Nascimento;;

public class NascimentoRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Integer identifier;

	@JsonInclude(Include.NON_NULL)
	private Date dtParto;
	
	@JsonInclude(Include.NON_NULL)
	private boolean flgVivo;	

	@JsonInclude(Include.NON_NULL)
	private String sexo;
	
	@JsonInclude(Include.NON_NULL)
	private List<BovinoRepresentation> bovinos;
	
		
	public NascimentoRepresentation() {
	}

	public NascimentoRepresentation(Nascimento nascimento) {
		this.identifier = nascimento.getIdNascimento();
		this.dtParto = nascimento.getDtParto();
		this.flgVivo = nascimento.getFlgVivo();
		this.sexo = nascimento.getSexo();
		if(nascimento.getBovinos() != null)
		{
			List<Bovino> bovinos = nascimento.getBovinos();
			List<BovinoRepresentation> bovinosRepresentation = new ArrayList<>();
			for(Bovino bovino : bovinos)
			{
				 bovinosRepresentation.add(new BovinoRepresentation(bovino));
			}
			this.setBovinos(bovinosRepresentation);
		}
		
	}

	public static Nascimento build(NascimentoRepresentation representation) {

		Nascimento nascimento = new Nascimento();
		
		nascimento.setIdNascimento(representation.getIdentifier());
		nascimento.setDtParto(representation.dtParto);
		nascimento.setFlgVivo(representation.flgVivo);
        nascimento.setSexo(representation.sexo);
        if(representation.getBovinos()!= null)
        {
        	List<BovinoRepresentation> bovinosRepresentation = representation.getBovinos();
        	List<Bovino> bovinos = new ArrayList<>();
        	for(BovinoRepresentation bovinoRepresentation : bovinosRepresentation)
        	{
        		bovinos.add(BovinoRepresentation.build(bovinoRepresentation));
        	}
        	nascimento.setBovinos(bovinos);
        }
        return nascimento;
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public Date getDtParto() {
		return dtParto;
	}

	public void setDtParto(Date dtParto) {
		this.dtParto = dtParto;
	}

	public boolean isFlgVivo() {
		return flgVivo;
	}

	public void setFlgVivo(boolean flgVivo) {
		this.flgVivo = flgVivo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public List<BovinoRepresentation> getBovinos() {
		return bovinos;
	}

	public void setBovinos(List<BovinoRepresentation> bovinos) {
		this.bovinos = bovinos;
	}

}
