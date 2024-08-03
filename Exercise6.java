package com.Java8;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise6 {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 3, 8, 5, 17, 4, 9, 13, 23, 6);
		
		List<Integer> list = doubleList(numbers);
		System.out.println(list);
	}

	private static List<Integer> doubleList(List<Integer> numbers) {
		
		return numbers.stream().map(x -> x*x).collect(Collectors.toList());
	}
}
