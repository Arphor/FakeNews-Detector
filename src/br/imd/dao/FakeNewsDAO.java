package br.imd.dao;

import java.util.ArrayList;

import br.imd.modelo.Texto.TextoFake;

public class FakeNewsDAO {
	private ArrayList<TextoFake> textos;
	private static FakeNewsDAO fDAO;
	
	
	public ArrayList<TextoFake> getTextos() {
		return textos;
	}

	public void setTextos(ArrayList<TextoFake> textos) {
		this.textos = textos;
	}
	
	private FakeNewsDAO() {
		textos = new ArrayList<TextoFake>();
	}
	
	public static FakeNewsDAO getInstace() {
		if(fDAO == null) {
			fDAO = new FakeNewsDAO();
		}
		return fDAO;
	}
	public void adicionarTexto(TextoFake texto) {
		this.textos.add(texto);
	}
	public TextoFake pegarTexto(int num) {
		
		return this.textos.get(num);
	}
	
	public ArrayList<TextoFake> bancoFake(){
		return textos;
	}
}
