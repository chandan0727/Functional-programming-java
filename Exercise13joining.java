package com.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise13joining {
public static void main(String[] args) {
	
	List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernates");
	//1.
	System.out.println(courses.stream().collect(Collectors.joining(",")));
	//.printing all characters of the stream
	System.out.println(courses.stream().map(c -> c.split("")).flatMap(Arrays::stream).collect(Collectors.toList()));
	//3.pairs of courses which have same no of digits
	List<String> courses1 = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernates");
	System.out.println(courses.stream().flatMap(c -> courses1.stream().map(c2->List.of(c,c2))).collect(Collectors.toList()));
}
}
