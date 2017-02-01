package com.gerenciador.bovino.representation;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gerenciador.bovino.domain.Entradabovino;

public class EntradaBovinoRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Integer identifier;

	@JsonInclude(Include.NON_NULL)
	private Date dtEntrada;
	
	@JsonInclude(Include.NON_NULL)
	private double kgmortomedidoindividual;	

	@JsonInclude(Include.NON_NULL)
	private Integer qtdBovino;
	
	@JsonInclude(Include.NON_NULL)
	private double qtdKgMedioindividual;
	
	@JsonInclude(Include.NON_NULL)
	private BigDecimal vlrArroba;
	
	@JsonInclude(Include.NON_NULL)
	private BigDecimal vlrTotal;
	
	@JsonInclude(Include.NON_NULL)
	private BigDecimal vlrUnitario;
		
	public EntradaBovinoRepresentation() {
	}

	public EntradaBovinoRepresentation(Entradabovino entradaBovino) {
		this.identifier = entradaBovino.getIdEntradabov();
		this.dtEntrada = entradaBovino.getDtEntrada();
		this.kgmortomedidoindividual = entradaBovino.getKgMortoMedidoIndividual();
		this.qtdBovino = entradaBovino.getQtdBovino();
		this.qtdKgMedioindividual = entradaBovino.getQtdKgMedioIndividual();
		this.vlrArroba        = entradaBovino.getVlrArroba();
		this.vlrTotal = entradaBovino.getVlrTotal();
		this.vlrUnitario = entradaBovino.getVlrUnitario();		
		
	}

	public static Entradabovino build(EntradaBovinoRepresentation representation) {

		Entradabovino entradaBovino = new Entradabovino();
		
		entradaBovino.setIdEntradabov(representation.getIdentifier());
		entradaBovino.setDtEntrada(representation.dtEntrada);
		entradaBovino.setKgMortoMedidoIndividual(representation.kgmortomedidoindividual);
        entradaBovino.setQtdBovino(representation.qtdBovino);
        entradaBovino.setQtdKgMedioIndividual(representation.qtdKgMedioindividual);
        entradaBovino.setVlrArroba(representation.vlrArroba);
        entradaBovino.setVlrTotal(representation.vlrTotal);
        entradaBovino.setVlrUnitario(representation.vlrUnitario);
        return entradaBovino;
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public double getKgmortomedidoindividual() {
		return kgmortomedidoindividual;
	}

	public void setKgmortomedidoindividual(double kgmortomedidoindividual) {
		this.kgmortomedidoindividual = kgmortomedidoindividual;
	}

	public Integer getQtdBovino() {
		return qtdBovino;
	}

	public void setQtdBovino(Integer qtdBovino) {
		this.qtdBovino = qtdBovino;
	}

	public double getQtdKgMedioindividual() {
		return qtdKgMedioindividual;
	}

	public void setQtdKgMedioindividual(double qtdKgMedioindividual) {
		this.qtdKgMedioindividual = qtdKgMedioindividual;
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

	public BigDecimal getVlrUnitario() {
		return vlrUnitario;
	}

	public void setVlrUnitario(BigDecimal vlrUnitario) {
		this.vlrUnitario = vlrUnitario;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

}
