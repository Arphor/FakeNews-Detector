package br.imd.modelo.Texto;

import java.text.Normalizer;
import java.util.ArrayList;

public class TextoComparar extends Texto {
	
	@Override
	public void Process()  throws Exception{
		String texto = this.getOriginalText().replaceAll("[^A-Za-z0-9\s]", "");
		System.out.println(texto);
		ArrayList<String> temp;
		texto = Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		System.out.println(texto);
		if(texto.equals("")){
			throw new Exception("Texto inválido, Tente Novamente!");
		}
		this.setOriginalText(texto);
		texto = this.SmallWords(texto);
		temp = this.Separate(texto);
		temp = this.cutWords(temp, 3);
		temp = this.noRepeat(temp);
		temp = this.textOrder(temp);
		this.setProcessText(temp);
	}

}
