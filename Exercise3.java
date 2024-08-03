package com.Java8;

import java.util.List;

public class Exercise3 {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,3,8,5,17,4,9,13,23,6);
		
		// Traditional way 
		int sum1 = sumStructured(numbers);
		System.out.println(sum1);
		
		// Functional way
		int sum2 = sumFunctional(numbers);
		System.out.println("Functional: "+sum2);
		
		// Functional way using lambda expression
		int sum3 = sumFunctional(numbers,"");
	    System.out.println("Functional -> : "+sum3);

	}

	// Method overloaded
	private static int sumFunctional(List<Integer> numbers,String overload) {
		
		//Sum using Integer class sum method;
		//return numbers.stream().reduce(0,Integer::sum);
		
		return numbers.stream().reduce(0, (x,y)-> x+y);
	}
	
	private static int sumFunctional(List<Integer> numbers) {
		//Stream of number -> One result value
		//Combine them into one result => One value
		// 0 and Exercise3::sum
		return numbers.stream().reduce(0,Exercise3::sum);
		
	}
	private static int sum(int a, int b) {
		return a + b;
	}

	private static int sumStructured(List<Integer> numbers) {
		int sum =0 ;
		for(int i:numbers)
			sum+=i;
		return sum;
	}

}
