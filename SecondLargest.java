package com.Java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SecondLargest {
	public static void main(String args[]){
		int [] arr = {12,3,1,10,10,12,12,13};
		//approachFirst(arr);
		approachSecond(arr);
		//customMethod(arr);
		
		}

	private static void customMethod(int[] arr) {
		// TODO Auto-generated method stub
		List<Integer> l =  Arrays.asList(0,1,2,3,4,5,5,6,4,1,2,4,5,66,6,7,8,55,65,77,78);
		int a = l.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).collect(Collectors.toList()).get(0);
				//Arrays.stream(arr).distinct().sorted().skip(1).collect((Supplier<R>) Collectors.toList()).get(0);
		System.out.println(a);
	}

	private static void approachSecond(int[] arr) {
		
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>first) {
				second = first;
				first = arr[i];
			}else if(arr[i]>second && arr[i]<first){
				second = arr[i];
			}
		}
		System.out.println(second);
		
	}

	private static void approachFirst(int [] arr) {
		int second = 0;
		Arrays.sort(arr);
		int largest = arr[arr.length-1];
		for(int i:arr) {
			if(largest>i) {
				second = i;
			}
		}
		
		System.out.print("approachFirst::" + second);
		
	}
	
	

}
