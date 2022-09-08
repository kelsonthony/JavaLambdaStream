package javalambdaandstream;

import java.util.stream.IntStream;

public class Java8Lambda {

	public static void main(String[] args) {
		
		//Paranteses
		Runnable runnable = () -> System.out.println("Hello World");
		
		IntStream.range(0, 5)
			.filter((int n) -> n % 2 == 0)
			.reduce((n1, n2) -> n1 + n2)
			.ifPresent(System.out::println);
		
		//Chaves
		IntStream.range(0, 5)
			.filter((int n) -> {
				System.out.println("Hello World 2");
				return n % 2 == 0; 
			})
			.forEach(n -> System.out.println(n)); //simples
	}
}
