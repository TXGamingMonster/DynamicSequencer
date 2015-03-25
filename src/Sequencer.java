import java.util.HashMap;
import java.util.Scanner;

public class Sequencer {
	
	public String sequence;
	public HashMap<String, String> palindromes = new HashMap<String, String>();
	
	public Sequencer(String x) {
		sequence = x;
		//System.out.println("Sequence: "+x);
		//System.out.println("Subsequence: "+function1(x));
		System.out.println(longPalSeq(x));
	}
	
	public String getSeq() {
		return sequence;
	}
	
	public String function1(String x) {
		for(int i=0;i<x.length();i++)
		{
			for(int j=1;j<=x.length()-i;j++)
			{
				String s = x.substring(i,i+j);
				if(s.length() > 1 && s.charAt(0)==s.charAt(s.length()-1))
					System.out.println(s);
			}
		}
		return x;
	}
	
	public String longPalSeq(String s){
		String temp = s;
		//base cases
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
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//System.out.print("Enter sequence: ");
		long start = System.currentTimeMillis();
		Sequencer s = new Sequencer("ACGTGTCAAAATCGAGTC");
		System.out.println(System.currentTimeMillis()-start);
		//Sequencer s = new Sequencer(sc.nextLine());
		//System.out.println(s.getSeq());
		//System.out.println(s.longPalSeq(s.getSeq()));
		start = System.currentTimeMillis();
		s = new Sequencer("RACECAR");
		System.out.println(System.currentTimeMillis()-start);
		
		start = System.currentTimeMillis();
		s = new Sequencer("AGGGGTCAAAACTGGTTCGTAGCTAGCTAGCTACAAAGTTCCTAAG");
		System.out.println(System.currentTimeMillis()-start);
		
		start = System.currentTimeMillis();
		s = new Sequencer("RACECAR");
		System.out.println(System.currentTimeMillis()-start);
	}
}
