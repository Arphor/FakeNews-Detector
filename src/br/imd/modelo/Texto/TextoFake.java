package br.imd.modelo.Texto;

import java.net.URL;
import java.util.ArrayList;

public class TextoFake extends Texto {

	private int id;
	private URL url;
	private String data;
	
	@Override
	public void Process(){
		ArrayList<String> temp;
		String ajeitar = this.getOriginalText().replaceAll("[^A-Za-z0-9\s]", "");
		ajeitar = this.SmallWords(ajeitar);
		temp = this.Separate(ajeitar);
		temp = this.cutWords(temp, 3);
		temp = this.noRepeat(temp);
		temp = this.textOrder(temp);
		this.setProcessText(temp);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public URL getUrl() {
		return url;
	}
	public void setUrl(URL url) {
		this.url = url;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
