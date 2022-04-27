package chapter03;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayUtil {

	public static double[] intToDouble(int[] a) {
		double[] result = new double[a.length];
		for(int i=0;i<a.length;i++) {
			result[i] = a[i];
		}
		
		return result;
	}

	public static int[] doubleToInt(double[] ds) {
		int[] result_int = new int[ds.length];
		for(int j=0;j<ds.length;j++) {
			result_int[j] = (int) ds[j];
		}
		return result_int;
	}

	public static int[] concat(int[] is1, int[] is2) {
		
		return null;
	}
}
