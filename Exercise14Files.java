package com.Java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Exercise14Files {
public static void main(String[] args) throws IOException {
	
	Files.lines(Paths.get("file.txt")).forEach(System.out::println);
	
	//find the unique content in the file
	Files.lines(Paths.get("file.txt")).map(st-> st.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
}
}
