package com.Java8;

import java.util.List;

public class FP01 {
	public static void main(String[] args) {
	
		//printAllNumbersInStructural(List.of(1, 4, 2, 12, 17, 36, 29, 19, 43, 57));
		printAllNumbersInFunctional(List.of(1, 4, 2, 12, 17, 36, 29, 19, 43, 57));
	}

	//structural approach
	private static void printAllNumbersInStructural(List<Integer> numbers) {
		
		for(int i:numbers)
			System.out.print(i+" ");
	}

	//functional approach
	private static void printAllNumbersInFunctional(List<Integer> numbers) {
		//approach 1
		//numbers.stream().forEach(FP01::printNum);
		
		//approach 2
		numbers.stream().forEach(System.out::print);
		
		//approach 3 printing even numbers only
		numbers.stream()
			   .filter(FP01::isEven)  // Filter - Only allow even numbers
		       .forEach(System.out::println); //Method reference
		
		//approach 4 
		numbers.stream()
		       .filter(number -> number%2==0) //Lambda expression
		       .forEach(System.out::println);
		
		
	}
	
	private static boolean isEven(int numbers) {
		 return numbers%2==0;
	}
	private static void printNum(int numbers) {
		System.out.print(numbers+" ");
	}
}
