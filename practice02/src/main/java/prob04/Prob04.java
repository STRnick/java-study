package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		char[] word = str.toCharArray();

		int count = word.length / 2;
		
		for(int i = 0; i < count; i++) {
			char Keep = word[i];
			word[i] = word[word.length - 1 - i];
			word[word.length - 1 - i] = Keep;
		}

		return word;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println( array );
	}
}