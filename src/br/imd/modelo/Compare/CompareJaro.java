package br.imd.modelo.Compare;
import java.util.ArrayList;

import br.imd.dao.FakeNewsDAO;

public class CompareJaro implements Comparison {

	private double Threshold = 85.00;
	
	public double getThreshold() {
		return Threshold;
	}
	public void setThreshold(double d) {
		Threshold = d;
	}
	
	@Override
	public double Algorithm(ArrayList<String> sa, ArrayList<String> sb) {
		if(sa.equals(sb)) {
			return 100.00;
		}
		
		int lenA = sa.size();
		int lenB = sb.size();
		int Max_dist = (int) (Math.floor(Math.max(lenA, lenB) / 2) - 1);
		int matchs = 0;

		int hash_sA[] = new int[sa.size()];
		int hash_sB[] = new int[sb.size()];
		
		for(int i = 0; i < lenA; i++) {
			for(int j = Math.max(0, i - Max_dist); j < Math.min(lenB, i + Max_dist + 1); j++) {
				
				if(sa.get(i).equals(sb.get(j)) && hash_sB[j] == 0) {
					hash_sB[j] = 1;
					hash_sA[i] = 1;
					matchs++;
					break;
				}
			}
		}
		
		if(matchs == 0) {
			return 0.0;
		}
		
		int transpo = 0;
		int point = 0;
		
		for(int in = 0; in < lenA; in++) {
			if(hash_sA[in] == 1) {
				while(hash_sB[point] == 0) {
					point++;
				}
				
				if(sa.get(in) != sb.get(point++)) {
					transpo++;
				}
			}
			transpo = transpo/2;
		}
		
		
		double jaro = ((((double) matchs) / ((double) lenA)) + (((double) matchs) / ((double) lenB)) + ((((double) matchs) - ((double) transpo)) / ((double) matchs)))/3.0; 
		jaro = jaro *100;
		return jaro;
	}
	@Override
	public boolean Compare(ArrayList<String> str) {
		// TODO Auto-generated method stub
		FakeNewsDAO fakeNews = FakeNewsDAO.getInstace();
		for(int i = 0; i<fakeNews.getTextos().size(); i++) {
			if(this.Algorithm(str, fakeNews.pegarTexto(i).getProcessText()) >= this.getThreshold()) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
}
