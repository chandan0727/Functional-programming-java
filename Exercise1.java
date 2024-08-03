package com.Java8;

import java.util.List;

public class Exercise1 {

	public static void main(String[] args) {
		// Q1
		//printOddNumbersOnly(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18, 19, 20, 21));
		// Q2
		//printOddNumbersSquares(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 19, 20, 21));
		//Q3
		printOddNumbersCubes(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 19, 20, 21));
	}

	// Question 1 printing using lambda expression
	private static void printOddNumbersOnly(List<Integer> number) {

		// ODD numbers
		number.stream().filter(num -> num % 2 != 0).forEach(System.out::println);
	}
	
	//Question 2 printing squares of Even numbers 
	private static void printOddNumbersSquares(List<Integer> number) {

		number.stream()
			  .filter(n -> n%2 ==0)
			  .map(n -> n*n)
			  .forEach(System.out::println);
						
	}
	
	//Question 3 printing cubes of odd numbers
	private static void printOddNumbersCubes(List<Integer> numbers) {
		numbers.stream().filter(num -> num%2 != 0).map(n ->n+"-"+ n*n*n).forEach(System.out::println);
		
	}

}
