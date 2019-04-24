package com.infotel.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CLI") // heritage SINGLETABLE //
public class Client extends Personne{
	
	

	@Override
	public String toString() {
		return "Client [numeroAdherent=" + numeroAdherent + ", toString()=" + super.toString() + "]";
	}

	public int getNumeroAdherent() {
		return numeroAdherent;
	}

	public void setNumeroAdherent(int numeroAdherent) {
		this.numeroAdherent = numeroAdherent;
	}

	private int numeroAdherent;
	

}
