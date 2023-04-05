package com.icecrm_automation.testngExamples;

import org.testng.annotations.Test;

public class TestNGEample1 {

	@Test
	public void add() {
		int a=10;
		int b=20;
		System.out.println("This is a addition method");
		System.out.println("addition of a and b is :" + (a+b));
	}
	
	@Test
	public void divide() {
		int a=10;
		int b=20;
		System.out.println("This is Test2 method");
		System.out.println("Dividation of a and b is :" + (a/b));
	}
	
	@Test
	public void sub() {
		int a=10;
		int b=20;
		System.out.println("This is substraction method");
		System.out.println("Substraction is "+(a-b));
	}
	
	@Test
	public void multi() {
		int a=10;
		int b=20;
		System.out.println("This is multiplication method");
		System.out.println("multiplication is "+(a*b));
	}
}
