package com.Java8;

import java.util.stream.IntStream;

public class Exercise15Thread {
public static void main(String[] args) {
	
	//1.by structural
	Runnable runnable = new Runnable() {
		
		@Override
		public void run() {
			for (int i = 0; i < 10000; i++) {
				System.out.println(Thread.currentThread().getId()+ " : "+i);
			}
			
		}
	};
	
	//2. by functional
	Runnable runnable2 = () -> {

		for (int i = 0; i < 10000; i++) {
			System.out.println(Thread.currentThread().getId() + " : " + i);
		}
	};
	
	//3. eliminate the loop
	Runnable runnable3 = () -> {

		IntStream.range(0, 10000).forEach(i->System.out.println(Thread.currentThread().getId()+" : "+i));
	};

	Thread thread1 = new Thread(runnable3);
	thread1.start();
	Thread thread2 = new Thread(runnable3);
	thread2.start();
	Thread thread3 = new Thread(runnable3);
	thread3.start();
}
}
