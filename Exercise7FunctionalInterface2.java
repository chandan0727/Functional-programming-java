package com.Java8;

import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Exercise7FunctionalInterface2 {
public static void main(String[] args) {
	List<Integer> numbers = List.of(12, 3, 8, 5, 17, 4, 9, 13, 23, 6);
	
	//1. takes inputs return boolean
	Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
	
	//2. Taking an input and giving an output
	Function<Integer, Integer> squareFunction = y -> y * y;
	
	//3. Taking an input and no output
	Consumer<Integer> consumer = x ->System.out.println(x);
	
	//4. accept two integer inputs and returning one integer output
	BinaryOperator<Integer> sumBinaryOperator = (x,y) -> x+y;
	
	//5.No input return something
	//Supplier<Integer> randomNumber = ()-> 2;
	Supplier<Integer> randomNumber = ()-> {
		//return 2;
		Random random = new Random();
		return random.nextInt(100);
	};
	//System.out.println(randomNumber.get());
	
	//6.take one parameter input and return same type of output
	UnaryOperator<Integer> unaryOperator = (x) ->3*x;
	System.out.println(unaryOperator.apply(10));
}
}
