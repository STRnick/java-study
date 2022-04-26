package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {

			/* 게임 작성 */
					
			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt(100) + 1;
			int count = 0;
			int num = 1;
			System.out.println("수를 결정하였습니다. 맟추어보세요");
//			System.out.println(correctNumber);

			while (true) {
				System.out.println(num + " - 100");
				System.out.print(count + " >> ");
				num = scanner.nextInt();

				if (num < correctNumber) {
					System.out.println("더 크게");
				} else if (num > correctNumber) {
					System.out.println("더 작게");
				} else if (num == correctNumber) {
					System.out.println("맞았습니다.");
					break;
				}

			}

			// 새 게임 여부 확인하기
			System.out.print("다시 하겠습니까(y/n)>>");
			String answer = scanner.next();
			if ("y".equals(answer) == false) {
				break;
			}
			else {
				System.out.println("종료.");
				break;
			}
		}

		scanner.close();
	}

}