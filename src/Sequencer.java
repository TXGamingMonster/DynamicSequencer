import java.util.Scanner;

public class Sequencer {
	
	public String sequence, subsequence;
	
	public Sequencer(String x) {
		System.out.println("Sequence: "+x);
		System.out.println("Subsequence: "+function1(x));
	}
	
	public String getSeq() {
		return subsequence;
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.out.print("Enter sequence: ");
		Sequencer s = new Sequencer("ACGTGTCAAAATCG");
		//Sequencer s = new Sequencer(sc.nextLine());
		//System.out.println(s.getSeq());
	}
}
