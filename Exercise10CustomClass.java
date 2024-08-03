package com.Java8;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Courses {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public Courses(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	@Override
	public String toString() {
		return name + ":" + category + ":" + reviewScore + ":" + noOfStudents;
	}

}

public class Exercise10CustomClass {

	public static void main(String[] args) {

		List<Courses> courses = List.of(new Courses("Spring", "Framework", 98, 2000),
				new Courses("Spring Boot", "Framework", 95, 1800), new Courses("API", "Microservices", 97, 2200),
				new Courses("Microservices", "Microservices", 96, 2500),
				new Courses("FullStack", "FullStack", 91, 1400), new Courses("AWS", "Framework", 92, 2100),
				new Courses("Azure", "Framework", 99, 2100), new Courses("Docker", "Cloud", 92, 2000),
				new Courses("Kubernetes", "Cloud", 91, 2000));

		// The three utility method in stream class
		// allMatch, noneMatch, anyMatch
		System.out.println(courses.stream().allMatch(c -> c.getReviewScore() > 90));
		System.out.println(courses.stream().noneMatch(c -> c.getReviewScore() > 99));

		Predicate<Courses> predicate = c -> c.getReviewScore() < 90;
		System.out.println(courses.stream().anyMatch(predicate));
		
		Comparator<Courses> comparingByNoOfSudentsIncreasing = Comparator.comparing(Courses::getNoOfStudents);
		System.out.println(courses.stream().sorted(comparingByNoOfSudentsIncreasing).collect(Collectors.toList()));
		//[FullStack:FullStack:91:1400, Spring Boot:Framework:95:1800, Spring:Framework:98:2000, Docker:Cloud:92:2000, Kubernetes:Cloud:91:2000, AWS:Framework:92:2100, Azure:Framework:99:2100, API:Microservices:97:2200, Microservices:Microservices:96:2500]
		
		Comparator<Courses> comparingByNoOfSudentsDecreasing = Comparator.comparing(Courses::getNoOfStudents).reversed();
		System.out.println(courses.stream().sorted(comparingByNoOfSudentsDecreasing).collect(Collectors.toList()));
		//[Microservices:Microservices:96:2500, API:Microservices:97:2200, AWS:Framework:92:2100, Azure:Framework:99:2100, Spring:Framework:98:2000, Docker:Cloud:92:2000, Kubernetes:Cloud:91:2000, Spring Boot:Framework:95:1800, FullStack:FullStack:91:1400]
		
		Comparator<Courses> comparingByNoOfSudentsAndNoOfReviews = Comparator.comparing(Courses::getNoOfStudents).thenComparing(Courses::getReviewScore);
		System.out.println(courses.stream().sorted(comparingByNoOfSudentsAndNoOfReviews).collect(Collectors.toList()));
		//[FullStack:FullStack:91:1400, Spring Boot:Framework:95:1800, Kubernetes:Cloud:91:2000, Docker:Cloud:92:2000, Spring:Framework:98:2000, AWS:Framework:92:2100, Azure:Framework:99:2100, API:Microservices:97:2200, Microservices:Microservices:96:2500]
		//
		//skip & limit
		System.out.println(
		courses.stream().sorted(Comparator.comparing(c-> c.getNoOfStudents())).skip(3).collect(Collectors.toList()));
		
		//limit
		System.out.println(
		courses.stream().sorted(Comparator.comparing(c->c.getReviewScore())).limit(5).collect(Collectors.toList()));
		
		//skip & limit
		System.out.println(
		courses.stream().sorted(Comparator.comparing(c ->c.getNoOfStudents())).skip(2).limit(3).collect(Collectors.toList()));
		
		//takeWhile
		System.out.println(
		courses.stream().takeWhile(c ->c.getReviewScore()>=91).collect(Collectors.toList()));
		
		//dropWhile
		System.out.println(
		courses.stream().sorted(Comparator.comparing(Courses::getNoOfStudents).reversed()).dropWhile(c ->c.getReviewScore()>=95).collect(Collectors.toList()));
		
		System.out.println(
		courses.stream().max(comparingByNoOfSudentsAndNoOfReviews)
		.orElse(new Courses("Kubernates", "Cloud", 91, 2000)));		
		
		System.out.println(
		courses.stream().filter(c ->c.getReviewScore()<90).findFirst());
		//Optional.empty
		
		System.out.println(
				courses.stream().filter(c ->c.getReviewScore()>90).findFirst());
				//Optional[Spring:Framework:98:2000]
		
		System.out.println(
				courses.stream().filter(c ->c.getReviewScore()>90).findAny());
				//Optional[Spring:Framework:98:2000]
		
		System.out.println(
				courses.stream().filter(c ->c.getReviewScore()>90)
				.mapToInt(Courses::getNoOfStudents).sum()); //18100
		
		System.out.println(
		courses.stream().collect(Collectors.groupingBy(Courses::getCategory)));
		//{Cloud=[Docker:Cloud:92:2000, Kubernetes:Cloud:91:2000], 
		//FullStack=[FullStack:FullStack:91:1400], 
		//Microservices=[API:Microservices:97:2200, Microservices:Microservices:96:2500], 
		//Framework=[Spring:Framework:98:2000, Spring Boot:Framework:95:1800, AWS:Framework:92:2100, Azure:Framework:99:2100]}
		System.out.println(
		courses.stream().collect(Collectors.groupingBy(Courses::getCategory,Collectors.counting())));
		//{Cloud=2, FullStack=1, Microservices=2, Framework=4}
		
		System.out.println(
				courses.stream().collect(Collectors.groupingBy(Courses::getCategory,
						Collectors.maxBy(Comparator.comparing(Courses::getReviewScore)))));
		//{Cloud=Optional[Docker:Cloud:92:2000], FullStack=Optional[FullStack:FullStack:91:1400], Microservices=Optional[API:Microservices:97:2200], Framework=Optional[Azure:Framework:99:2100]}
		System.out.println(
		courses.stream().collect(Collectors.groupingBy(Courses::getCategory,
				Collectors.mapping(Courses::getName, Collectors.toList()))));
		//{Cloud=[Docker, Kubernetes], FullStack=[FullStack], Microservices=[API, Microservices], Framework=[Spring, Spring Boot, AWS, Azure]}
		
		
	}

}
