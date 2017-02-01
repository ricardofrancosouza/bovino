package com.gerenciador.bovino.representation;
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gerenciador.bovino.domain.Bovino;
import com.gerenciador.bovino.domain.Raca;;

public class RacaRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Integer identifier;

	@JsonInclude(Include.NON_NULL)
	private String nomeRaca;
	
	@JsonInclude(Include.NON_NULL)
	private String dsAbrev;	

	@JsonInclude(Include.NON_NULL)
	private String obs;
	
	@JsonInclude(Include.NON_NULL)
	private List<BovinoRepresentation> Bovinos;
	public RacaRepresentation() {
	}

	public RacaRepresentation(Raca raca) {
		this.identifier = raca.getIdRaca();
		this.dsAbrev = raca.getDsAbrev();
		this.nomeRaca = raca.getNmRaca();
		this.obs = raca.getObs();	
		/*if (raca.getBovinos() != null)
		{
			List<Bovino> bovinos = raca.getBovinos();
			List<BovinoRepresentation> bovinosrepresentation = new ArrayList<>();
			for(Bovino bovino : bovinos)
			{
				bovinosrepresentation.add(new BovinoRepresentation(bovino));
			}
			this.setBovinos(bovinosrepresentation);;
		}*/
		
	}

	public static Raca build(RacaRepresentation representation) {

		Raca raca = new Raca();
		
		raca.setIdRaca(representation.getIdentifier());
		raca.setDsAbrev(representation.getDsAbrev());
		raca.setNmRaca(representation.getNomeRaca());
        raca.setObs(representation.getObs());
        
      /*  if(representation.getBovinos()!= null)
        {
        	List<BovinoRepresentation> bovinosRepresentation = representation.getBovinos();
        	List<Bovino> bovinos = new ArrayList<>();
        	for(BovinoRepresentation bovinoRepresentation : bovinosRepresentation)
        	{
        		bovinos.add(BovinoRepresentation.build(bovinoRepresentation));
        	}
        	raca.setBovinos(bovinos);
        }*/
        return raca;
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public String getNomeRaca() {
		return nomeRaca;
	}

	public void setNomeRaca(String nomeRaca) {
		this.nomeRaca = nomeRaca;
	}

	public String getDsAbrev() {
		return dsAbrev;
	}

	public void setDsAbrev(String dsAbrev) {
		this.dsAbrev = dsAbrev;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public List<BovinoRepresentation> getBovinos() {
		return Bovinos;
	}

	public void setBovinos(List<BovinoRepresentation> bovinos) {
		Bovinos = bovinos;
	}

}
