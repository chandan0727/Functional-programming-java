package com.Java8;

import java.util.List;

public class Exercise2 {

	public static void main(String[] args) {
		//Q1
		//printCourse(List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes"));
		
		
		  String s = "Microservice169s 27jnfdjl"; 
		  String st = s.replaceAll("[^0-9]","");
		  System.out.println(st);
		 

	}

	//printing the courses that contains "Sp"
	//
	private static void printCourse(List<String> courses) {
		
		//printing the courses that contains "Sp"
		courses.stream().filter(c -> c.contains("Sp")).forEach(System.out::println);
		
		//printing those coursed whose length more than 4
		courses.stream().filter(cr -> cr.length()>3).forEach(System.out::println);
	}

}
