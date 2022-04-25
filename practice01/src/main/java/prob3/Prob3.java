package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		for(int i=0;i<=2;i++) {
			System.out.print("숫자를 입력하세요 : ");
			int number = scanner.nextInt();
			int Even_sum = 0 ;
			int Odd_sum = 0;
			
			if(number % 2 == 0) {
				for(int j=2;j<=number;j+=2) {
					Even_sum += j;
				}
				System.out.println("결과 값 : " + Even_sum);
			}
			else if(number % 2 != 0) {
				for(int j=1;j<=number;j+=2) {
					Odd_sum += j;
				}
				System.out.println("결과 값 : " + Odd_sum);
			}
			else {
				System.out.println("입력값 오류!!");
			}
		}
		scanner.close();
	}
}
