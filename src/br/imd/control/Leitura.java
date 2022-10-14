package br.imd.control;


import java.io.BufferedReader;

import br.imd.dao.FakeNewsDAO;
import br.imd.modelo.Texto.TextoFake;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;

public class Leitura {
	
	
	private void Formatar(String line, TextoFake textoAdicionar) throws MalformedURLException, ParseException {
		String[] textoFrag = line.split(",");
		String conteudo = "";
		for(int num=0; num < textoFrag.length; num++) {
			if(num==0) {
				textoAdicionar.setId(Integer.parseInt(textoFrag[num]));
			}
			else if(num==textoFrag.length - 2) {
				URL url = new URL(textoFrag[num]);
				textoAdicionar.setUrl(url);
			}
			else if(num==(textoFrag.length)-1) {
				String[] dataPub = textoFrag[num].split("\s");
				textoAdicionar.setData(dataPub[0]);
			}
			else {
				conteudo = conteudo + textoFrag[num];
			}
		}
		textoAdicionar.setOriginalText(conteudo);
	}
	
	@SuppressWarnings("static-access")
	public void Organizar(String name) {
		FakeNewsDAO fakeNews; 
		fakeNews = FakeNewsDAO.getInstace();
		BufferedReader arquivo = null;
		try {
			InputStream arq = getClass().getClassLoader().getResourceAsStream(name);
			arquivo = new BufferedReader(new InputStreamReader(arq));
			arquivo.readLine();
			String line;
            while ((line = arquivo.readLine()) != null) {
            	TextoFake textoAdicionar = new TextoFake();
            	try{
            		this.Formatar(line, textoAdicionar);
            		textoAdicionar.Process();
            		fakeNews.getInstace().adicionarTexto(textoAdicionar);
            		
            	}catch(ParseException e) {
            		e.printStackTrace();
            	}
            }
		}catch(IOException e){
			System.out.println(e.getMessage());
		}

	}
}
