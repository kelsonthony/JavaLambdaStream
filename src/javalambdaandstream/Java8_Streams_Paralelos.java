package javalambdaandstream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8_Streams_Paralelos {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4);
		
		//list.parallelStream()
		//IntStream.range(0, 5).parallel().
		
		//forEarch forEachOrdered
		list.parallelStream()
			.forEach(System.out::println);
		
		System.out.println("=============");
		
		list.parallelStream()
			.forEachOrdered(System.out::println);
		
		System.out.println("=============");
		
		//findany
		list.parallelStream()
			.findAny()
			.ifPresent(System.out::println);
		
		System.out.println("=============");
		
		list.stream()
			.findAny()
			.ifPresent(System.out::println);
		
		System.out.println("=============");
		
		//unordered
		list.parallelStream()
			.unordered()
			.skip(1)
			.limit(2)
			.forEach(System.out::println);
		
		System.out.println("=============");
		//reduce
		// (1 + 2) + (3 + 4) = 10 é associativa
		// (1 - 2) - (3 - 4) != 10 não é associativa
		list.parallelStream()
			.reduce((n1, n2) -> n1 - n2)
			.ifPresent(System.out::println);
		
		System.out.println("=============");
		
		// toMap
		Map<Integer, Boolean> collect = 
				list.parallelStream()
					.collect(
							Collectors
								.toConcurrentMap(n -> n, n -> n % 2 == 0) // Map mais lento
							);
					
		System.out.println(collect);
		
		System.out.println("=============");
		
		// groupingBy
		Map<Boolean, List<Integer>> collect2 = 
				list.parallelStream()
					.collect(
							Collectors
								.groupingByConcurrent(n -> n % 2 == 0) // não tem garantia de ordem
							);
					
		System.out.println(collect2);
	}
}
