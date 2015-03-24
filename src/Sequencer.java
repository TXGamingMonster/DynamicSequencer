import java.util.HashMap;
import java.util.Scanner;

public class Sequencer {
	
	public String sequence;
	public HashMap<String, String> palindromes = new HashMap<String, String>();
	
	public Sequencer(String x) {
		sequence = x;
		//System.out.println("Sequence: "+x);
		//System.out.println("Subsequence: "+function1(x));
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
	
	public String longPalSeq(String s, int i, int j){
		String temp = s;
		//base cases
		//return the character if string length is one.
		if(i == j){
			palindromes.put(temp, s);
			return temp;
		}
		//return the two characters if length is two and they match
		if(i+1 == j && temp.charAt(i) == temp.charAt(j)){
			palindromes.put(temp, s);
			return temp;
		}
		else if(i+1 == j){
			return ""+temp.charAt(0);
		}
		// do the first and last chars match? return recursive value of inside chars
		if(temp.charAt(i) 
				== temp.charAt(j)){
			String first = "" + temp.charAt(i);
			String middle = longPalSeq(temp.substring(i+1, j), i, j-2);
			char last = temp.charAt(j);
			
			return (first += middle + last);
		}
		//if they dont match, return the longer of i+1 to j, and i to j-1.
		if(temp.charAt(i) != temp.charAt(j)){
			String first = "" + temp.charAt(i);
			///get the possible midsections
			String middle1 = longPalSeq(temp.substring(i+1, j+1), i, j-1);
			System.out.println(temp+": "+middle1);
			String middle2 = longPalSeq(temp.substring(i, j), i, j-1);
			String middle = "";
			//figure out which midsection is longer.
			if(middle1.length() > middle2.length()){
				middle += middle1;
			}
			else{
				middle += middle2;
			}
			char last = temp.charAt(j);
			return (first += middle + last);
		}
		//return null if the above didn't return anything;
		return null;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.out.print("Enter sequence: ");
		Sequencer s = new Sequencer("ACGTGTCAAAATCG");
		//Sequencer s = new Sequencer(sc.nextLine());
		//System.out.println(s.getSeq());
		System.out.println(s.longPalSeq(s.getSeq(), 0, s.getSeq().length()-1));
	}
}
