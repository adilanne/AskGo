package br.laab.askgo.entities;

import java.util.Observable;
import java.util.Observer;

public abstract class ObservadorEnquete implements Observer{
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
		Enquete enquete = (Enquete)arg0;
		String status = String.valueOf(arg1);
		switch (status) {
		case "com voto":
			this.enqueteComVoto(enquete);
			break;
		case "voto removido":
			this.enqueteComVotoRemovido(enquete);
			break;
		default:
			break;
		}
		
	}

	public void enqueteComVotoRemovido(Enquete enquete) {
		System.out.println("Um voto foi removido da enquete");
		
	}

	public void enqueteComVoto(Enquete enquete) {
		System.out.println("Um voto adicionado à enquete");
		
	}

}
