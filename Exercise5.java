package com.Java8;

import java.util.Comparator;
import java.util.List;

public class Exercise5 {
	public static void main(String[] args) {

		List<Integer> list = List.of(12, 3, 8, 5, 17, 4, 9, 13, 23, 6);
		//sortingList(list);
		sortingByComarator(list);
				
		List<String> stingArr = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");
		
		sortingByLength(stingArr);

		
	}

	private static void sortingByLength(List<String> str) {
		str.stream().sorted(Comparator.comparing(s -> s.length())).forEach(System.out::println);
		
	}

	private static void sortingByComarator(List<Integer> numbers) {
		
		//Sorting in ascending order
		numbers.stream().sorted(Comparator.naturalOrder()).map(a -> a+" ").forEach(System.out::print);
		
		System.out.println();
		
		//Sorting in descending order
		numbers.stream().sorted(Comparator.reverseOrder()).map(a -> a+" ").forEach(System.out::print);
		
	}

	private static void sortingList(List<Integer> list) {

		// distinct element in list
		list.stream().distinct().map(n -> n + " ").forEach(System.out::print);

		System.out.println();
		// distinct element & sorted
		list.stream().distinct().sorted().map(n -> n + " ").forEach(System.out::print);

	}

}
