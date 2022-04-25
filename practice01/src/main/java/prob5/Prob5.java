package prob5;

public class Prob5 {

	public static void main(String[] args) {
		
		int i;
		int num = 0;
		
		for(i=1;i<=99;i++) {
			if(i == 3 | i == 6 | i == 9) {
				System.out.println(i + " 짝");
			}
			else if(i % 10 == 3 | i % 10 == 6 || i % 10 == 9) {
				System.out.println(i + " 짝");
			}
		}
	}
}
