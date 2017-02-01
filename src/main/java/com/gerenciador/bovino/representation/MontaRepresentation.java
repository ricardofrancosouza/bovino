package com.gerenciador.bovino.representation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gerenciador.bovino.domain.Monta;
import com.gerenciador.bovino.domain.Nascimento;

public class MontaRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Integer identifier;

	
	@JsonInclude(Include.NON_NULL)
	private Date dataprevisaoparto;	

	@JsonInclude(Include.NON_NULL)
	private Date dataprevisaoresultado;
	@JsonInclude(Include.NON_NULL)
	private Date datamonta;
	
	@JsonInclude(Include.NON_NULL)
	private Boolean statusmonta;
	
	@JsonInclude(Include.NON_NULL)
	private Date dataresultado;
	
	@JsonInclude(Include.NON_NULL)
	private List<NascimentoRepresentation> nascimentos;
	
	public MontaRepresentation() {
	}

	public MontaRepresentation(Monta monta) {
		this.identifier 			= monta.getIdMonta();
		this.dataprevisaoparto 		= monta.getDtPrevParto();
		this.datamonta              = monta.getDtMonta();
		this.dataprevisaoresultado  = monta.getDtPrevParto();
		this.statusmonta            = monta.getStatusMonta();
		this.dataresultado          = monta.getDtResultado();
		if(monta.getNascimentos() != null)
		{
			List<Nascimento> nascimentos = monta.getNascimentos();
			List<NascimentoRepresentation> nascimentosRepresentation = new ArrayList<>();
			for (Nascimento nascimento : nascimentos)
			{
				nascimentosRepresentation.add(new NascimentoRepresentation(nascimento));
			}
			
			this.setNascimentos(nascimentosRepresentation);
			
		}
		
		
	}

	public static Monta build(MontaRepresentation representation) {

		Monta monta = new Monta();
		
		monta.setIdMonta(representation.getIdentifier());
		monta.setDtPrevParto(representation.dataprevisaoparto);
		monta.setDtMonta(representation.datamonta);
		monta.setDtPrevResultado(representation.dataprevisaoresultado);
		monta.setDtResultado(representation.dataresultado);
		return monta;
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public Date getDataprevisaoparto() {
		return dataprevisaoparto;
	}

	public void setDataprevisaoparto(Date dataprevisaoparto) {
		this.dataprevisaoparto = dataprevisaoparto;
	}

	public Date getDataprevisaoresultado() {
		return dataprevisaoresultado;
	}

	public void setDataprevisaoresultado(Date dataprevisaoresultado) {
		this.dataprevisaoresultado = dataprevisaoresultado;
	}

	public Date getDatamonta() {
		return datamonta;
	}

	public void setDatamonta(Date datamonta) {
		this.datamonta = datamonta;
	}

	public Boolean getStatusmonta() {
		return statusmonta;
	}

	public void setStatusmonta(Boolean statusmonta) {
		this.statusmonta = statusmonta;
	}

	public Date getDataresultado() {
		return dataresultado;
	}

	public void setDataresultado(Date dataresultado) {
		this.dataresultado = dataresultado;
	}

	public List<NascimentoRepresentation> getNascimentos() {
		return nascimentos;
	}

	public void setNascimentos(List<NascimentoRepresentation> nascimentos) {
		this.nascimentos = nascimentos;
	}

	

}
