package br.com.unirn.poo.main;

import java.util.Scanner;

import br.com.unirn.poo.menu.Menu;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		Menu.montarMenuOpcoes();

		
		System.out.println("Informe uma opção: ");
		int opcao = scanner.nextInt();
		
		System.out.println("Opcao escolhida: " +opcao);
		
	}
	
	

}