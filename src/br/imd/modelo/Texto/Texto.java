package br.imd.modelo.Texto;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Texto  {

	String originalText;
	ArrayList<String> processText;
	
	
	
	public String getOriginalText() {
		return originalText;
	}

	public void setOriginalText(String originalText) {
		this.originalText = originalText;
	}

	public ArrayList<String> getProcessText() {
		return processText;
	}

	public void setProcessText(ArrayList<String> processText) {
		this.processText = processText;
	}

	public abstract void Process() throws Exception;
	
	public ArrayList<String> Separate(String str){
		ArrayList<String> temp = new ArrayList<String>();
		
		String[] splitS = str.trim().split("\\s+");
		
		for(int i = 0; i < splitS.length; i++) {
			temp.add(splitS[i]);
		}

		
		return temp;
	}
	
	public ArrayList<String> cutWords(ArrayList<String> arrayS, int i){
		ArrayList<String> smallWords = new ArrayList<String>();
		
		for(String s : arrayS) {
			if(s.length() <= i) {
				smallWords.add(s);
			}
		}
		
		arrayS.removeAll(smallWords);
		
		return arrayS;
	}
	
	public String SmallWords(String texto){
		return texto.toLowerCase();
	}
	
	public ArrayList<String> noRepeat(ArrayList<String> arrayS){
		ArrayList<String> uniqueWords = new ArrayList<String>();
		
		for(String s : arrayS) {
			if(!uniqueWords.contains(s)) {
				uniqueWords.add(s);
			}
		}
		
		return uniqueWords;
	}
	
	public ArrayList<String> textOrder(ArrayList<String> arrayS){
		Collections.sort(arrayS);
		
		return arrayS;
	}
	
}