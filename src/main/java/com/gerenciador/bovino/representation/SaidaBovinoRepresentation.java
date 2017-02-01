package com.gerenciador.bovino.representation;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gerenciador.bovino.domain.Saidabovino;;

public class SaidaBovinoRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Integer identifier;

	@JsonInclude(Include.NON_NULL)
	private Date dtSaida;
	
	@JsonInclude(Include.NON_NULL)
	private boolean flgFrigorifico;	

	@JsonInclude(Include.NON_NULL)
	private boolean flgTerceiros;
	
	@JsonInclude(Include.NON_NULL)
	private String obs;
	
	@JsonInclude(Include.NON_NULL)
	private Integer qtdanimais;
	
	@JsonInclude(Include.NON_NULL)
	private double qtdKgmortomedioindv;
	
	@JsonInclude(Include.NON_NULL)
	private double qtdKgVivomedidoIndiv;
	
	@JsonInclude(Include.NON_NULL)
	private BigDecimal vlrArroba;
	
	@JsonInclude(Include.NON_NULL)
	private BigDecimal vlrTotal;
		
	public SaidaBovinoRepresentation() {
	}

	public SaidaBovinoRepresentation(Saidabovino saidabovino) {
		this.identifier = saidabovino.getIdSaida();
		this.dtSaida = saidabovino.getDtSaida();
		this.flgFrigorifico = saidabovino.getFlgFrigorifico();
		this.flgTerceiros = saidabovino.getFlgTerceiros();
		this.qtdanimais = saidabovino.getQtdAnimais();
		this.obs        = saidabovino.getObs();
		this.qtdKgmortomedioindv = saidabovino.getQtdKgMortoMedioIndiv();
		this.qtdKgVivomedidoIndiv = saidabovino.getQtdKgVivoMedidoIndiv();
		this.vlrArroba           = saidabovino.getVlrArroba();
		this.vlrTotal       = saidabovino.getVlrTotal();
		
		
	}

	public static Saidabovino build(SaidaBovinoRepresentation representation) {

		Saidabovino saidaBovino = new Saidabovino();
		
		saidaBovino.setIdSaida(representation.getIdentifier());
		saidaBovino.setDtSaida(representation.dtSaida);
		saidaBovino.setFlgFrigorifico(representation.getFlgFrigorifico());
        saidaBovino.setFlgTerceiros(representation.getFlgTerceiros());
        saidaBovino.setQtdAnimais(representation.getQtdanimais());
        saidaBovino.setObs(representation.getObs());
        saidaBovino.setQtdKgMortoMedioIndiv(representation.getQtdKgmortomedioindv());
        saidaBovino.setQtdKgVivoMedidoIndiv(representation.getQtdKgVivomedidoIndiv());
        saidaBovino.setVlrArroba(representation.getVlrArroba());
        saidaBovino.setVlrTotal(representation.getVlrTotal());
		return saidaBovino;
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public Date getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}

	public boolean getFlgFrigorifico() {
		return flgFrigorifico;
	}

	public void setFlgFrigorifico(boolean flgFrigorifico) {
		this.flgFrigorifico = flgFrigorifico;
	}

	public boolean getFlgTerceiros() {
		return flgTerceiros;
	}

	public void setFlgTerceiros(boolean flgTerceiros) {
		this.flgTerceiros = flgTerceiros;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Integer getQtdanimais() {
		return qtdanimais;
	}

	public void setQtdanimais(Integer qtdanimais) {
		this.qtdanimais = qtdanimais;
	}

	public double getQtdKgmortomedioindv() {
		return qtdKgmortomedioindv;
	}

	public void setQtdKgmortomedioindv(double qtdKgmortomedioindv) {
		this.qtdKgmortomedioindv = qtdKgmortomedioindv;
	}

	public double getQtdKgVivomedidoIndiv() {
		return qtdKgVivomedidoIndiv;
	}

	public void setQtdKgVivomedidoIndiv(double qtdKgVivomedidoIndiv) {
		this.qtdKgVivomedidoIndiv = qtdKgVivomedidoIndiv;
	}

	public BigDecimal getVlrArroba() {
		return vlrArroba;
	}

	public void setVlrArroba(BigDecimal vlrArroba) {
		this.vlrArroba = vlrArroba;
	}

	public BigDecimal getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(BigDecimal vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

}
