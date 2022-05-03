package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferdOutputStreamTest {

	public static void main(String[] args) {
		BufferedOutputStream bos = null;
		try {
			// 기반 스트림
			FileOutputStream fos = new FileOutputStream("test.txt");

			// 보조 스트림
			bos = new BufferedOutputStream(fos);
		} catch (FileNotFoundException ex) {
			System.out.println("Can't Open: " + ex);
		} finally {
			try {
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
