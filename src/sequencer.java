import java.util.Scanner;


public class Sequencer {
	
	private String sequence;
	
	public Sequencer(String x) {
		sequence = x;
	}
	
	public String getSeq() {
		
		return sequence;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter sequence: ");
		Sequencer s = new Sequencer(sc.nextLine());
		System.out.println(s.getSeq());
	}
}
