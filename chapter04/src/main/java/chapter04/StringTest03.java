package chapter04;

public class StringTest03 {
	public static void main(String[] args) {
		// String method들..
		String s1 = "aBcABCabcAbc";
		System.out.println(s1.length());
		System.out.println(s1.charAt(2));
		System.out.println(s1.indexOf("abc"));
		System.out.println(s1.indexOf("abc", 7));
		System.out.println(s1.substring(3));
		System.out.println(s1.substring(3, 6));

		String s2 = "  ab  cd  ";
		String s3 = "efg,hij,klm,nop,qrs";

		String s4 = s2.concat(s3);
		System.out.println(s4);

		System.out.println("---" + s2.trim() + "---");
		System.out.println("---" + s2.replaceAll(" ", "") + "---");

		String[] tokens = s3.split(",");
		for (String s : tokens) {
			System.out.println(s);
		}

		// 해당 구분자가 없는 경우의 split : null을 return하는것이 아니라 원본을 그대로 출력한다.
		String[] tokens2 = s3.split(" ");
		for (String s : tokens2) {
			System.out.println(s);
		}

		// + : Siring concat(연결) 연산자
//		String s5 = "Hello" + "World" + "Java" + "1.8";
		String s5 = new StringBuffer("Hello")
				.append("World")
				.append("java")
				.append(1.8).toString();

		String s6 = "";
		for (int i = 0; i < 1000000; i++) {
//			s6 = s6 + i;
//			s6 = new StringBuffer(s6).append(i).toString();
		}

		StringBuffer sb6 = new StringBuffer("");
		for (int i = 0; i < 1000000; i++) {
			sb6.append(i);
		}

		String s7 = sb6.toString();
		System.out.println(s7.length());
	}
}