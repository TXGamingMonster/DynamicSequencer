import java.util.HashMap;
import java.util.Scanner;

public class Sequencer {
	
	public String sequence;
	public HashMap<String, String> palindromes = new HashMap<String, String>();
	
	public Sequencer(String x) {
		sequence = x;
		System.out.println(x);
		System.out.println("Sequence: "+longPalSeq(x));
	}
	//return the passed in sequence.
	public String getSeq() {
		return sequence;
	}
	
	public String longPalSeq(String s){
		String temp = s;
		//base cases
		//check if the value has already been found for this sequence
		if(palindromes.containsKey(temp)){
			return palindromes.get(temp);
		}
		//return the character if string length is one.
		if(temp.length() == 1){
			palindromes.put(temp, s);
			return temp;
		}
		//return the two characters if length is two and they match
		if(temp.length() == 2 && temp.charAt(0) == temp.charAt(1)){
			palindromes.put(temp, s);
			return temp;
		}
		if(temp.length() == 2){
			return ""+temp.charAt(0);
		}
		// do the first and last chars match? return recursive value of inside chars
		if(temp.charAt(0) == temp.charAt(temp.length()-1)){
			String first = "" + temp.charAt(0);
			//System.out.println(temp.substring(1, temp.length()-1));
			String middle = longPalSeq(temp.substring(1, temp.length()-1));
			char last = temp.charAt(temp.length()-1);
			palindromes.put(temp, (first + middle + last));
			return (first + middle + last);
		}
		//if they dont match, return the longer of i+1 to j, and i to j-1.
		if(temp.charAt(0) != temp.charAt(temp.length()-1)){
			String first = "" + temp.charAt(0);
			///get the possible midsections
			String middle1 = longPalSeq(temp.substring(1, temp.length()));
			String middle2 = longPalSeq(temp.substring(0, temp.length()-1));
			String middle = "";
			//figure out which midsection is longer.
			if(middle1.length() > middle2.length()){
				middle = middle1;
			}
			else{
				middle = middle2;
			}
			char last = temp.charAt(temp.length()-1);
			palindromes.put(temp, middle);
			return (middle);
		}
		//return null if the above didn't return anything;
		return null;
	}
	//main to run the algorithm
	public static void main(String[] args) {
		
		//Results in CTAAAATC
		long start = System.currentTimeMillis();
		System.out.print("String: ");
		Sequencer s = new Sequencer("ACGTGTCAAAATCG");
		System.out.println("Runtime: "+(System.currentTimeMillis()-start));
		
		//Results in AGTTCCTTGA
		System.out.print("String: ");
		start = System.currentTimeMillis();
		s = new Sequencer("AGTTTCCTTGAAGCTA");
		System.out.println(System.currentTimeMillis()-start);
		
		//Result is the same as input, used for runtime testing
		System.out.print("String: ");
		start = System.currentTimeMillis();
		s = new Sequencer("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		System.out.println(System.currentTimeMillis()-start);
		
		//Results in ATCCTTGAACATCAATCCTAACTCAATCCTAACTCAATCCTAACTCAATCCTAACTCAATCCTAACTCAATCCTAACTACAAGTTCCTA
		System.out.print("String: ");
		start = System.currentTimeMillis();
		s = new Sequencer("AGGGGTCAAAACTGGTTCGTAGCTAGCTAGCTACAAAGTTCCTAAGCTACAAAGTTCCTAAGCTACAAAGTTCCTAAGCTACAAAGTTCCTAAGCTACAAAGTTCCTAAGCTACAAAGTTCCTAAGCTACAAAGTTCCTA");
		System.out.println(System.currentTimeMillis()-start);
		
		//Results in A
		System.out.print("String: ");
		start = System.currentTimeMillis();
		s = new Sequencer("ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789/*()_+!@#$%^&`~;:?><");
		System.out.println(System.currentTimeMillis()-start);
		
		//Results in AGTCAATCTAACTGA
		start = System.currentTimeMillis();
		System.out.print("String: ");
		s = new Sequencer("AGTCGAATCGTAACCTAGGGAACCCCTT");
		System.out.println("Runtime: "+(System.currentTimeMillis()-start));
	}
}
