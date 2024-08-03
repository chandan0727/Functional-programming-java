package com.Java8;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercise9 {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 3, 8, 5, 17, 4, 9, 13, 23, 6,11,14);
		List<Integer> list = squareOfNumbers(numbers);
		System.out.println(list);
	}

	private static List<Integer> squareOfNumbers(List<Integer> numbers) {
		
		Function< Integer, Integer> mapperFunction = x -> x*x;
		
		return mapAndCreateNewList(numbers, mapperFunction);
		
	}

	private static List<Integer> mapAndCreateNewList(List<Integer> numbers,
			Function< Integer, Integer> mapperFunction) {
		return numbers.stream().map(mapperFunction).collect(Collectors.toList());
	}
}
