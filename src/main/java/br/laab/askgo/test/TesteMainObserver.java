package br.laab.askgo.test;

import java.util.Scanner;

import br.laab.askgo.entities.Enquete;
import br.laab.askgo.entities.Usuario;

public class TesteMainObserver {
	public static void main(String[] args) {
		
		Usuario usuario1 = new Usuario();
		Usuario usuario2 = new Usuario();
		
		Enquete enquete1 = new Enquete();
		Enquete enquete2 = new Enquete();
		
		usuario1.setNome("Maria");
		usuario1.setEmail("maria@maria.com");

		usuario2.setNome("Joao");
		usuario2.setEmail("joao@joao.com");
		
		enquete1.setTitulo("ENQUETE 1");
		enquete2.setTitulo("ENQUETE 2");
		
		enquete1.addObserver(usuario1);
		enquete2.addObserver(usuario2);
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		String cmd = "";
		
		while (!cmd.equalsIgnoreCase("0")) {
			System.out.println("-----------------------");
			System.out.println("1- Add voto na enquete 1");
			System.out.println("2- Add voto na enquete 2");
			System.out.println("3- Remover voto da enquete 1");
			System.out.println("4- Remover voto da enquete 2");
			System.out.println("0- Sair");
			System.out.println("-----------------------");
			System.out.println("");
			System.out.print("Digite o comando: ");
			cmd = scanner.nextLine();				
			
			switch (cmd) {
			case "1":
				enquete1.votar();
				break;
			case "2":
				enquete2.votar();
				break;
			case "3":
				enquete1.removerVoto();
				break;
			case "4":
				enquete2.removerVoto();
			default:
				break;
			}
		}
	}

}
