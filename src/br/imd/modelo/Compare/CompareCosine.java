package br.imd.modelo.Compare;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.imd.dao.FakeNewsDAO;

public class CompareCosine implements Comparison {
	
	private static class Values {

        private int val1;
        private int val2;

        @SuppressWarnings("unused")
		public int getVal1() {
			return val1;
		}
        @SuppressWarnings("unused")
		public void setVal1(int val1) {
			this.val1 = val1;
		}
        @SuppressWarnings("unused")
		public int getVal2() {
			return val2;
		}
        @SuppressWarnings("unused")
		public void setVal2(int val2) {
			this.val2 = val2;
		}

		private Values(int v1, int v2) {
            this.val1 = v1;
            this.val2 = v2;
        }

        public void updateValues(int v1, int v2) {
            this.val1 = v1;
            this.val2 = v2;
        }
    }
	
	private double Threshold = 85;
	
	public double getThreshold() {
		return Threshold;
	}
	public void setThreshold(double threshold) {
		Threshold = threshold;
	}
	
	@Override
	public double Algorithm(ArrayList<String> sa, ArrayList<String> sb) {
		
		Map<String, Values> wFreq = new HashMap<>();
		List<String> dWords = new ArrayList<>();
		
		for (String t : sa) {
			if (!t.isEmpty()) {
				if(wFreq.containsKey(t)) {
					Values vals1 = wFreq.get(t);
					int freq1 = vals1.val1 + 1;
					int freq2 = vals1.val2;
					vals1.updateValues(freq1, freq2);
					wFreq.put(t, vals1);
				} else {
					Values vals1 = new Values(1, 0);
					wFreq.put(t, vals1);
					dWords.add(t);
				}
			}
		}
		
		
		for (String t : sb) {
			if (!t.isEmpty()) {
				if(wFreq.containsKey(t)) {
					Values vals1 = wFreq.get(t);
					int freq1 = vals1.val1;
					int freq2 = vals1.val2 + 1;
					vals1.updateValues(freq1, freq2);
					wFreq.put(t, vals1);
				} else {
					Values vals1 = new Values(0, 1);
					wFreq.put(t, vals1);
					dWords.add(t);
				}
			}
		}
		
		double Dot = (double) 0;
		double V1 = (double) 0;
		double V2 = (double) 0;
		
		for(int i = 0; i < dWords.size(); i++) {
			Values vals = wFreq.get(dWords.get(i));
			double f1 = vals.val1;
			double f2 = vals.val2;
			
			Dot = Dot + f1 * f2;
			V1 = V1 + f1 * f1;
			V2 = V2 + f2 * f2;
			
		}
		
		double end = Dot / ((Math.sqrt(V1)) * (Math.sqrt(V2)));
		end = end*100;
		
		return end;
	}
	@Override
	public boolean Compare(ArrayList<String> str) {
		
		FakeNewsDAO fakeNews = FakeNewsDAO.getInstace();
		for(int i = 0; i<fakeNews.getTextos().size(); i++) {
			if(this.Algorithm(str, fakeNews.pegarTexto(i).getProcessText()) >= this.getThreshold()) {
				return true;
			}
		}
		
		return false;
	}
	
}
