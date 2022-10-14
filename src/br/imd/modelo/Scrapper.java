package br.imd.modelo;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.ArrayList;
import java.util.Random;

public class Scrapper{
	
	private static String url = "https://g1.globo.com";
	
	private Document connect() throws Exception {
		Document document = null;
		
		try {
			document = Jsoup.connect(url).get(); 
		} catch(Exception e) {
			throw new Exception(e);
		}
		
		return document;
	}

	public String scrap() throws Exception {
		
		Document document = null;
		
		try {
			document = this.connect(); 
		} catch(Exception e) {
			throw new Exception(e);
		}

		 
		ArrayList<Element> collection = document.getElementsByClass("bastian-feed-item");

		Random r = new Random();
		int low = 0;
		int high = collection.size();
		int result = r.nextInt(high-low) + low;
		
		
		String elementText = collection.get(result).text();
		System.out.println(elementText);
	
			
		return elementText;
	}				 		 		 
	
}
