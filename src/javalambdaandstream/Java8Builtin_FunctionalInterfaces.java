package javalambdaandstream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Java8Builtin_FunctionalInterfaces {

	public static void main(String[] args) {
		
		Stream.generate(() -> new Random().nextInt()) // Supplier, não recebe nada e retorna um valor
		.limit(5)
		.forEach(System.out::println); //Consumer, recebe um valor e não retorna nada
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		
		list.stream()
			.filter(e -> e % 2 == 0) // Predicate, é m teste, vai comparar algo
			.map(e -> e.doubleValue()) // Function, receba um valor e retorna outro
			.reduce((r1, r2) -> r1 * r2) // BinaryOperator
			.ifPresent(System.out::println);
	}
}
