package com.gerenciador.bovino.representation;
import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gerenciador.bovino.domain.Entradasemem;


public class EntradaSememRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Integer identifier;

	@JsonInclude(Include.NON_NULL)
	private Date dtEntrada;
	
	@JsonInclude(Include.NON_NULL)
	private double qtdsemem;	

	@JsonInclude(Include.NON_NULL)
	private SememRepresentation semem;
	
	@JsonInclude(Include.NON_NULL)
	private NotaFiscalRepresentation notafiscal;
	
	@JsonInclude(Include.NON_NULL)
	private double vlrsemem;
	
	
	
	public EntradaSememRepresentation() {
	}

	public EntradaSememRepresentation(Entradasemem entradaSemem) {
		this.identifier = entradaSemem.getIdEntrada();
		this.dtEntrada  = entradaSemem.getDtEntrada();
		this.qtdsemem   = entradaSemem.getQtdSemem();
	    this.vlrsemem   = entradaSemem.getVlrSemem();
//	    if(entradaSemem.getNotafiscal()!= null)
//	    {
//	    	Notafiscal notafiscal = entradaSemem.getNotafiscal();
//	    	NotaFiscalRepresentation notafiscalRepresentation = new NotaFiscalRepresentation(notafiscal);
//	    	this.setNotafiscal(notafiscalRepresentation);
//	    }
//		if(entradaSemem.getSemem() != null)
//		{
//			Semem semem = entradaSemem.getSemem();
//			SememRepresentation sememRepresentation = new SememRepresentation(semem);
//			this.setSemem(sememRepresentation);
//		}
		
	}

	public static Entradasemem build(EntradaSememRepresentation representation) {

		Entradasemem entradaSemem = new Entradasemem();
		
		entradaSemem.setIdEntrada(representation.getIdentifier());
        entradaSemem.setDtEntrada(representation.getDtEntrada());
        entradaSemem.setQtdSemem(representation.getQtdsemem());
        
//        if(representation.getNotafiscal() != null)
//        {
//        	NotaFiscalRepresentation notafiscaralRepresentation = representation.getNotafiscal();
//        	Notafiscal notafiscal = NotaFiscalRepresentation.build(notafiscaralRepresentation);
//        	entradaSemem.setNotafiscal(notafiscal);
//        }
//        if(representation.getSemem()!=null)
//        {
//        	SememRepresentation semerepresentation = representation.getSemem();
//        	Semem semem = SememRepresentation.build(semerepresentation);
//        	entradaSemem.setSemem(semem);
//        	
//        }
        
		return entradaSemem;
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public Date getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public double getQtdsemem() {
		return qtdsemem;
	}

	public void setQtdsemem(double qtdsemem) {
		this.qtdsemem = qtdsemem;
	}

	public SememRepresentation getSemem() {
		return semem;
	}

	public void setSemem(SememRepresentation semem) {
		this.semem = semem;
	}

	public NotaFiscalRepresentation getNotafiscal() {
		return notafiscal;
	}

	public void setNotafiscal(NotaFiscalRepresentation notafiscal) {
		this.notafiscal = notafiscal;
	}

	public double getVlrsemem() {
		return vlrsemem;
	}

	public void setVlrsemem(double vlrsemem) {
		this.vlrsemem = vlrsemem;
	}

	


}
