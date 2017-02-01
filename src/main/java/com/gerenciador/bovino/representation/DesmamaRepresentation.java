package com.gerenciador.bovino.representation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gerenciador.bovino.domain.Bovino;
import com.gerenciador.bovino.domain.Desmama;


public class DesmamaRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Integer identifier;

	//@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	private List<BovinoRepresentation> bovinos;
	
	@JsonInclude(Include.NON_NULL)
	private Date dtDesmama;	

	@JsonInclude(Include.NON_NULL)
	private String idade;
	
	@JsonInclude(Include.NON_NULL)
	private String obs;
		
	public DesmamaRepresentation() {
	}

	public DesmamaRepresentation(Desmama desmama) {
		this.identifier = desmama.getIdDesmama();
		this.dtDesmama = desmama.getDtDesmama();
		this.idade = desmama.getIdade();
		this.obs = desmama.getObs();
		/*if(desmama.getBovinos() != null)
		{
			List<Bovino> bovinos = desmama.getBovinos();
			List<BovinoRepresentation> bovinosRepresentation = new ArrayList<>();
			for(Bovino bovino : bovinos)
			{
				bovinosRepresentation.add(new BovinoRepresentation(bovino));
			}
			this.setBovinos(bovinosRepresentation);
		}*/
		
	}

	public static Desmama build(DesmamaRepresentation representation) {

		Desmama desmama = new Desmama();
		
		
		desmama.setIdDesmama(representation.getIdentifier());
		desmama.setDtDesmama(representation.dtDesmama);
		desmama.setIdade(representation.idade);
        desmama.setObs(representation.obs);
       /*if(representation.getBovinos() != null)
        {
        	List<BovinoRepresentation> bovinosRepresentation = representation.getBovinos();
        	List<Bovino> bovinos = new ArrayList<>();
        	for(BovinoRepresentation bovinoRepresentation : bovinosRepresentation)
        	{
        		bovinos.add(BovinoRepresentation.build(bovinoRepresentation));
        	}
        	desmama.setBovinos(bovinos);
        }*/
		return desmama;
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public List<BovinoRepresentation> getBovinos() {
		return bovinos;
	}

	public void setBovinos(List<BovinoRepresentation> bovinos) {
		this.bovinos = bovinos;
	}

	public Date getDtDesmama() {
		return dtDesmama;
	}

	public void setDtDesmama(Date dtDesmama) {
		this.dtDesmama = dtDesmama;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	


}
