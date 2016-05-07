package br.com.unirn.poo.menu;

import java.util.Scanner;

public class Menu {

	private static int opcao;

	public static void montarMenuOpcoes() {
		System.out.println("\n ---------------------------------- \n");
		System.out.println("1 - Cadastrar Usuário");
		System.out.println("2 - Cadastrar Professor");
		System.out.println("3 - Cadastrar Aluno");
		System.out.println("4 - Cadastrar Disciplina");
		System.out.println("5 - Cadastrar Turma");
		System.out.println("6 - Cadastrar Horário");
		System.out.println("7 - Cadastrar Sala");
		System.out.println("8 - Cadastrar Laboratório");
		System.out.println("9 - Cadastrar Aplicativo");
		System.out.println("10 - Cadastrar Projetor");
		System.out.println("11 - Realizar Reserva");
		System.out.println("12 - Sair");

		System.out.println("Selecione uma opção: ");
		listenerUsuario();
	}

	private static void listenerUsuario() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Informe uma opção: ");
		opcao = scanner.nextInt();

		switch (opcao) {
		case 1:
			new MenuUsuario();
			scanner.close();
			break;
			
		case 12:
			System.exit(0);
		default:
			break;
		}
	}
}
