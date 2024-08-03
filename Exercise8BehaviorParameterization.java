package com.Java8;

import java.util.List;
import java.util.function.Predicate;

public class Exercise8BehaviorParameterization {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 3, 8, 5, 17, 4, 9, 13, 23, 6,11,14);
		behaviorWithFunctionalInterface(numbers);
	}

	private static void behaviorWithFunctionalInterface(List<Integer> numbers) {
		
		Predicate<? super Integer> evenPredicate = x-> x%2==0;
		filterAndPrint(numbers, evenPredicate);
		
		Predicate<? super Integer> oddPredicate = x-> x%2==1;
		filterAndPrint(numbers, x-> x%2==1);
	}

	//In this method we are passing the logic(behavior) of the method argument that's why we are calling it 
	//behavior parameterization 
	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream().filter(predicate).forEach(System.out::println);
	}
	
	
	

}
