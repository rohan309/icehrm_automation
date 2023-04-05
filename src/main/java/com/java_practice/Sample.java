package com.java_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Sample {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		FileInputStream inputStream = new FileInputStream("‪‪D:\\FillInput.docx");
		System.out.println((char)inputStream.read());
		inputStream.close();
	}  
}
