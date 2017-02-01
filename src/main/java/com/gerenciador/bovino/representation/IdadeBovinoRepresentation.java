package com.gerenciador.bovino.representation;
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gerenciador.bovino.domain.Bovino;
import com.gerenciador.bovino.domain.Idadebovino;

public class IdadeBovinoRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Integer identifier;

	@JsonInclude(Include.NON_NULL)
	private boolean flgBezerras012;
	
	@JsonInclude(Include.NON_NULL)
	private boolean flgBezerros012;	

	@JsonInclude(Include.NON_NULL)
	private boolean flgNovilhas1324;
	
	@JsonInclude(Include.NON_NULL)
	private boolean flgNovilhas2536;
	
	@JsonInclude(Include.NON_NULL)
	private boolean flgNovilhasAcima36;
	
	@JsonInclude(Include.NON_NULL)
	private boolean flgNovilhos1324;
	
	@JsonInclude(Include.NON_NULL)
	private boolean flgNovilhos2536;
	
	@JsonInclude(Include.NON_NULL)
	private boolean flgNovilhosAcima36;
	
	@JsonInclude(Include.NON_NULL)
	private List<BovinoRepresentation> Bovinos;
		
	public IdadeBovinoRepresentation() {
	}

	public IdadeBovinoRepresentation(Idadebovino idadeBovino) {
		this.identifier = idadeBovino.getIdIdade();
		this.flgBezerras012 = idadeBovino.getFlgBezerras012();
		this.flgBezerros012 = idadeBovino.getFlgBezerros012();
		this.flgNovilhas1324 = idadeBovino.getFlgNovilhas1324();
		this.flgNovilhas2536 = idadeBovino.getFlgNovilhas2536();
		this.flgNovilhasAcima36        = idadeBovino.getFlgNovilhasAcima36();
		this.flgNovilhos1324 = idadeBovino.getFlgNovilhos1324();
		this.flgNovilhos2536 = idadeBovino.getFlgNovilhos2536();
		this.flgNovilhosAcima36           = idadeBovino.getFlgNovilhasAcima36();
		if(idadeBovino.getBovinos()!= null)
		{
			List<Bovino> bovinos = idadeBovino.getBovinos();
			List<BovinoRepresentation> bovinosRepresentation = new ArrayList<>();
			for(Bovino bovino : bovinos)
			{
				bovinosRepresentation.add(new BovinoRepresentation(bovino));
			}
			this.setBovinos(bovinosRepresentation);
		}
		
		
	}

	public static Idadebovino build(IdadeBovinoRepresentation representation) {

		Idadebovino idadeBovino = new Idadebovino();
		
		idadeBovino.setIdIdade(representation.getIdentifier());
		idadeBovino.setFlgBezerras012(representation.flgBezerras012);
		idadeBovino.setFlgBezerros012(representation.flgBezerros012);
        idadeBovino.setFlgNovilhas1324(representation.flgNovilhas1324);
        idadeBovino.setFlgNovilhas2536(representation.flgNovilhas2536);
        idadeBovino.setFlgNovilhasAcima36(representation.flgNovilhasAcima36);
        idadeBovino.setFlgNovilhos1324(representation.flgNovilhos1324);
        idadeBovino.setFlgNovilhos2536(representation.flgNovilhos2536);
        idadeBovino.setFlgNovilhosAcima36(representation.flgNovilhosAcima36);
        /*if(representation.getBovinos()!=null)
        {
        	List<BovinoRepresentation> bovinosRepresentation = representation.getBovinos();
        	List<Bovino> bovinos = new ArrayList<>();
            for (BovinoRepresentation bovinoRepresentation : bovinosRepresentation)
            {
            	bovinos.add(BovinoRepresentation.build(bovinoRepresentation));
            }
            idadeBovino.setBovinos(bovinos);
        }*/
		return idadeBovino;
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public boolean isFlgBezerras012() {
		return flgBezerras012;
	}

	public void setFlgBezerras012(boolean flgBezerras012) {
		this.flgBezerras012 = flgBezerras012;
	}

	public boolean isFlgBezerros012() {
		return flgBezerros012;
	}

	public void setFlgBezerros012(boolean flgBezerros012) {
		this.flgBezerros012 = flgBezerros012;
	}

	public boolean isFlgNovilhas1324() {
		return flgNovilhas1324;
	}

	public void setFlgNovilhas1324(boolean flgNovilhas1324) {
		this.flgNovilhas1324 = flgNovilhas1324;
	}

	public boolean isFlgNovilhas2536() {
		return flgNovilhas2536;
	}

	public void setFlgNovilhas2536(boolean flgNovilhas2536) {
		this.flgNovilhas2536 = flgNovilhas2536;
	}

	public boolean isFlgNovilhasAcima36() {
		return flgNovilhasAcima36;
	}

	public void setFlgNovilhasAcima36(boolean flgNovilhasAcima36) {
		this.flgNovilhasAcima36 = flgNovilhasAcima36;
	}

	public boolean isFlgNovilhos1324() {
		return flgNovilhos1324;
	}

	public void setFlgNovilhos1324(boolean flgNovilhos1324) {
		this.flgNovilhos1324 = flgNovilhos1324;
	}

	public boolean isFlgNovilhos2536() {
		return flgNovilhos2536;
	}

	public void setFlgNovilhos2536(boolean flgNovilhos2536) {
		this.flgNovilhos2536 = flgNovilhos2536;
	}

	public boolean isFlgNovilhosAcima36() {
		return flgNovilhosAcima36;
	}

	public void setFlgNovilhosAcima36(boolean flgNovilhosAcima36) {
		this.flgNovilhosAcima36 = flgNovilhosAcima36;
	}

	public List<BovinoRepresentation> getBovinos() {
		return Bovinos;
	}

	public void setBovinos(List<BovinoRepresentation> bovinos) {
		Bovinos = bovinos;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	

}
