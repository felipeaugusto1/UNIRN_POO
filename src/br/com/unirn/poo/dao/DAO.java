package br.com.unirn.poo.dao;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import br.com.unirn.poo.singleton.ListasSingleton;

/**
 * Classe para manipular arquivos que aramazenarão os dados gerado no sistema.
 *
 * @author allan
 *
 */
public class DAO <T>{
	
	private static final String  localArquivo = "base_de_objetos/";
	private static final String extensao = ".txt";

	public void salvar (Collection<T> lista, Class<T> classe) throws IOException{
		FileOutputStream file = new FileOutputStream(localArquivo + classe.getName() + extensao);
		ObjectOutputStream stream = new ObjectOutputStream(file);
		stream.writeObject(lista);		
		stream.flush();
		stream.close();
	}
	
	public void recuperar(Collection<T> lista, Class<T> classe) throws IOException, ClassNotFoundException{
		FileInputStream file = new FileInputStream(localArquivo + classe.getName() + extensao);
		ObjectInputStream stream = new ObjectInputStream(file);
		ArrayList<T> objetos = (ArrayList<T>) stream.readObject();		
		for (T objeto : objetos){
			lista.add(objeto);
		}
		stream.close();
	}
}