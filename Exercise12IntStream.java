package com.Java8;

import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Exercise12IntStream {
public static void main(String[] args) {
	
	//1. range method excludes the 10 here
	System.out.println(IntStream.range(1, 10).sum());
	//2. range closed
	System.out.println(IntStream.rangeClosed(1, 10).sum());
	//3.
	System.out.println(IntStream.iterate(1, e->e+2).limit(10).sum());
	//4
	System.out.println(IntStream.iterate(1, c -> c+2).limit(10).peek(System.out::println).sum());
	//5 even numbers and sum
	//System.out.println(IntStream.iterate(1, c -> c+1).limit(10).filter(s->s%2==0).peek(System.out::println).sum());
	System.out.println(IntStream.iterate(2, c -> c+2).limit(10).peek(System.out::println).sum());
	//6.
	System.out.println(IntStream.iterate(2, c -> c*2).limit(10).peek(System.out::println).sum());
	//7. boxed()
	System.out.println(IntStream.iterate(2, c -> c+2).limit(10).boxed().collect(Collectors.toList()));
	
	
	
	//factorial
	System.out.println(IntStream.rangeClosed(1, 4).reduce(1,(x,y)->x*y));
	//
	System.out.println(LongStream.rangeClosed(1, 50).reduce(1, (x,y)->x*y));
	//	
	System.out.println(LongStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));

}
}
