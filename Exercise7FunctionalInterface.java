package com.Java8;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercise7FunctionalInterface {
	// Here we learn how lambda expression works internally with the examples
	
	
	
	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 3, 8, 5, 17, 4, 9, 13, 23, 6);
		functionalInterfaces(numbers);
		functionalInterfaces(numbers,"");
	}

	private static int functionalInterfaces(List<Integer> numbers, String string) {
		
		//4. BinaryOperator is functional interface
		BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
		BinaryOperator<Integer> sumBinaryOperator1 = new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer x, Integer y) {
				
				return x+y;
			}
		};
		return numbers.stream().reduce(0,sumBinaryOperator1);
	}

	private static void functionalInterfaces(List<Integer> numbers) {
		
		//1. Predicate is functional interface
		Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
		Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer x) {
				return x % 2 == 0;
			}
		};
		 
		// 2 Function is functional interface
		Function<Integer, Integer> squareFunction = y -> y * y;
		Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer t) {
				return t * t;
			}
		};

		//3. Consumer is functional interface
		Consumer<Integer> sysoutConsumer = System.out::println;

		Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println(t);

			}
		};

		numbers.stream().filter(isEvenPredicate2).map(squareFunction2).forEach(sysoutConsumer2);

	}

}
