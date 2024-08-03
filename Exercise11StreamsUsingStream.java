package com.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Exercise11StreamsUsingStream {

	public static void main(String[] args) {
		List<Integer> number = List.of(4,7,3,2,11,9,12,19,15,6,1,5);
		System.out.println(number);
		
		//1.
		System.out.println(Stream.of(4,7,3,2,11,9,12,19,15,6,1,5).count());
		//2.
		System.out.println(Stream.of(4,7,3,2,11,9,12,19,15,6,1,5).reduce(0, Integer::sum));
		//3.
		int[] arr = {4,7,3,2,11,9,12,19,15,6,1,5};
		int s = Arrays.stream(arr).sum();
		System.out.println(s);

	}

}
