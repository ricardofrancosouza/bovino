package com.gerenciador.bovino.representation;
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gerenciador.bovino.domain.Entradasemem;
import com.gerenciador.bovino.domain.Monta;
import com.gerenciador.bovino.domain.Semem;

public class SememRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Integer identifier;

	
	
	@JsonInclude(Include.NON_NULL)
	private String obs;	

	@JsonInclude(Include.NON_NULL)
	private List<MontaRepresentation> montas;
	
	@JsonInclude(Include.NON_NULL)
	private List<EntradaSememRepresentation> entradasSemens;
	

	
	public SememRepresentation() {
	}

	public SememRepresentation(Semem semem) {
		this.identifier = semem.getIdSemem();
		this.obs        = semem.getObs();
		if(semem.getEntradasemems() != null)
		{
			List<Entradasemem> entradasSemem = semem.getEntradasemems();
			List<EntradaSememRepresentation> entredadasememRepresentation = new ArrayList<>();
			for(Entradasemem entradasemem: entradasSemem)
			{
				 entredadasememRepresentation.add(new EntradaSememRepresentation(entradasemem));
			}
			this.setEntradasSemens(entradasSemens);
		}
		
		
		if(semem.getMontas() != null)
		{
			List<Monta> montas = semem.getMontas();
			List<MontaRepresentation> montaRepresentation = new ArrayList<>();
			for(Monta monta: montas)
			{
				montaRepresentation.add(new MontaRepresentation(monta));
				
			}
			this.setMontas(montaRepresentation);
		}		
		
	}

	public static Semem build(SememRepresentation representation) {

		Semem semem = new Semem();
		
		semem.setIdSemem(representation.getIdentifier());
		
		if( representation.getEntradasSemens() != null)
        {
			List<EntradaSememRepresentation> entradasSemensRepresantation = representation.getEntradasSemens();
			List<Entradasemem> entradasSemens = new ArrayList<>();
			for(EntradaSememRepresentation entradaSemem : entradasSemensRepresantation )
	       {
				entradasSemens.add(EntradaSememRepresentation.build(entradaSemem));
			  
	       }
			semem.setEntradasemems(entradasSemens);
        }		
		
		

		return semem;
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public List<MontaRepresentation> getMontas() {
		return montas;
	}

	public void setMontas(List<MontaRepresentation> montas) {
		this.montas = montas;
	}

	public List<EntradaSememRepresentation> getEntradasSemens() {
		return entradasSemens;
	}

	public void setEntradasSemens(List<EntradaSememRepresentation> entradasSemens) {
		this.entradasSemens = entradasSemens;
	}




}
