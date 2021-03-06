package br.com.unirn.poo.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.unirn.poo.excecoes.CPFInvalidoException;
import br.com.unirn.poo.modelo.TipoUsuario;
import br.com.unirn.poo.modelo.Usuario;
import br.com.unirn.poo.processadores.ProcessadorUsuario;
import br.com.unirn.poo.singleton.ListasSingleton;
import br.com.unirn.poo.util.SistemaAcademicoUtils;
import br.com.unirn.poo.util.ValidadorCPF;

/**
 * 
 * @author felipe
 *
 */
public class MenuUsuario extends MenuGeneric<Usuario> {

	private String nome;
	private String cpf;
	private String telefone;
	private String login;
	private String senha;
	private TipoUsuario tipoUsuario;

	public MenuUsuario() {
		super();
		processador = new ProcessadorUsuario();

		montarMenu();
	}

	@Override
	public void montarMenu() {
		System.out.println("-------------------");
		System.out.println("Cadastro de Usuario");
		System.out.println("-------------------");

		System.out.println("Informe o nome do usuario: ");
		nome = scanner.nextLine();

		System.out.println("Informe o CPF do usuario (sem caracteres especiais): ");
		cpf = scanner.nextLine();
		
		while (!ValidadorCPF.isCPF(cpf)) {
			System.out.println("CPF Inválido. Informe novamente:");
			cpf = scanner.nextLine();
		}

		System.out.println("Informe o telefone do usuario: ");
		telefone = scanner.nextLine();

		System.out.println("Informe o login do usuario: ");
		login = scanner.nextLine();

		System.out.println("Informe a senha do usuario: ");
		senha = scanner.nextLine();

		montarMenuTipoUsuario();

		Usuario usuario = new Usuario(nome, cpf, telefone, login, senha, tipoUsuario);
		
		try {
			if (processador.validate(usuario)) {
				processador.cadastrar(usuario, ListasSingleton.getInstance().getListaUsuario());
				
				System.out.println("Usuário cadastrado com sucesso!");

				super.solicitarProximaAcao();
			}
			else {
				System.out.println("Informe todos os dados do usuário.");
				scanner = new Scanner(System.in);
				montarMenu();
			}
		} catch (Exception e) {
			if (e instanceof CPFInvalidoException) {
				System.out.println(e.getMessage());
				scanner = new Scanner(System.in);
				montarMenu();
			}
		}
		
	}

	@Override
	public void opcaoInvalida() {
		System.out.println("\n Opção inválida. Tente novamente. \n");
		SistemaAcademicoUtils.esperarSegundos();
		scanner = new Scanner(System.in);
		montarMenuTipoUsuario();
	}

	private void montarMenuTipoUsuario() {
		int tipoUsuarioInformado = 0;

		System.out.println("Tipo do Usuario: ");
		System.out.println("1 - Administrador");
		System.out.println("2 - Coordenador");
		System.out.println("3 - Secretário");

		try {
			tipoUsuarioInformado = scanner.nextInt();
		} catch (InputMismatchException e) {
			opcaoInvalida();
		}

		switch (tipoUsuarioInformado) {
		case 1:
			tipoUsuario = TipoUsuario.ADMINISTRADOR;
			break;
		case 2:
			tipoUsuario = TipoUsuario.COORDENADOR;
			break;
		case 3:
			tipoUsuario = TipoUsuario.SECRETARIO;
			break;
		default:
			opcaoInvalida();
			break;
		}
	}

}
