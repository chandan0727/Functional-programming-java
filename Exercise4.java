package com.Java8;

import java.util.List;

public class Exercise4 {

	public static void main(String[] args) {
		//
		List<Integer> numbers = List.of(3,3,2,2,4,4,5);
		//Sum of squares of the numbers
		int sum = squersSum(numbers);
		System.out.println(sum);
		//Sum of the cubes of the numbers
		int sumC = cubeSum(numbers);
		System.out.println(sumC);
		//Sum of the odd numbers of the list 
		int sumOdd = oddSum(numbers);
		System.out.println(sumOdd);
	}
	
	private static int oddSum(List<Integer> numbers) {
		return numbers.stream().filter(x ->x%2==1).reduce(0,(x,z) ->x+z);
	}

	private static int cubeSum(List<Integer> numbers) {
		return numbers.stream().map(x -> x*x*x).reduce(0, (a,b) -> a+b);
	}

	private static int squersSum(List<Integer> numbers) {
		//return numbers.stream().map(x -> x*x).reduce(0,Exercise4::sum);
		return numbers.stream().map(x -> x*x).reduce(0, (x,y) -> x+y);
		
	}
	private static int sum(int a, int b) {
		System.out.println(a+ " "+b);
		return a + b;
	}

}
