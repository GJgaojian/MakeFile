package com.hxg.makefile.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

	private static FileOutputStream fos;

	public static void writeFile(String str){
		File file = new File("D:/test.txt");
		try {
			fos = new FileOutputStream(file);
			byte[] buffer = str.getBytes();
			fos.write(buffer);
			fos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
