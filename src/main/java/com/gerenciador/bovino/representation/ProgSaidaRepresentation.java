package com.gerenciador.bovino.representation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gerenciador.bovino.domain.Progsaida;
import com.gerenciador.bovino.domain.Saidabovino;;

public class ProgSaidaRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Integer identifier;

	@JsonInclude(Include.NON_NULL)
	private Date dtSaida;
	
	@JsonInclude(Include.NON_NULL)
	private double qtdPreparo;	

	@JsonInclude(Include.NON_NULL)
	private List<SaidaBovinoRepresentation> saidaBovinos;
	public ProgSaidaRepresentation() {
	}

	public ProgSaidaRepresentation(Progsaida progSaida) {
		this.identifier = progSaida.getIdProgsaida();
		this.dtSaida = progSaida.getDtSaida();
		this.qtdPreparo = progSaida.getQtdPreparo();
		if (progSaida.getSaidabovinos() != null)
		{
			List<Saidabovino> progSaidas = progSaida.getSaidabovinos();
			List<SaidaBovinoRepresentation> saidaBovinosRepresentation = new ArrayList<>();
			for(Saidabovino progSada : progSaidas)
			{
				saidaBovinosRepresentation.add(new SaidaBovinoRepresentation(progSada));
			}
			this.setSaidaBovinos(saidaBovinosRepresentation);
		}
		
	}

	public static Progsaida build(ProgSaidaRepresentation representation) {

		Progsaida progSaida = new Progsaida();
		
		progSaida.setIdProgsaida(representation.getIdentifier());
		progSaida.setDtSaida(representation.dtSaida);
		progSaida.setQtdPreparo(representation.qtdPreparo);
        if(representation.getSaidaBovinos() != null)
        {
        	List<SaidaBovinoRepresentation> saidasBovinosRepresentation = representation.getSaidaBovinos();
        	List<Saidabovino> saidabovino = new ArrayList<>();
        	for(SaidaBovinoRepresentation saidaBovinoRepresentation  : saidasBovinosRepresentation)
        	{
        		saidabovino.add(SaidaBovinoRepresentation.build(saidaBovinoRepresentation));
        	}
        	
        	progSaida.setSaidabovinos(saidabovino);
        }
		return progSaida;
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public Date getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}

	public double getQtdPreparo() {
		return qtdPreparo;
	}

	public void setQtdPreparo(double qtdPreparo) {
		this.qtdPreparo = qtdPreparo;
	}

	public List<SaidaBovinoRepresentation> getSaidaBovinos() {
		return saidaBovinos;
	}

	public void setSaidaBovinos(List<SaidaBovinoRepresentation> saidaBovinos) {
		this.saidaBovinos = saidaBovinos;
	}


}
