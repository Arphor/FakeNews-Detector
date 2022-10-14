package br.imd.modelo.Compare;
import java.util.ArrayList;

public interface Comparison {

	double Algorithm(ArrayList<String> sa, ArrayList<String> sb);
	
	boolean Compare(ArrayList<String> str);
}
