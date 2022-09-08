package javalambdaandstream;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Java8Streams_Collect1 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		//fornecedor = acumulação - combinação
		Set<String> collect = list.stream()
			.collect(
					() -> new HashSet<>(), 
					(l, e) -> l.add(e.toString()), 
					(l1, l2) -> l1.addAll(l2));
		
		System.out.println(list);
		System.out.println(collect);
		
		// toList
		List<Integer> collect2 = list.stream()
				.filter((n) -> n % 2 == 0)
				//.collect(Collectors.toList());
				.collect(Collectors.toList());
		
		System.out.println(collect2);
		
		Set<Integer> collect3 = list.stream()
			.filter((n) -> n % 2 == 0)
			//.collect(Collectors.toList());
			.collect(Collectors.toSet());
		
		System.out.println(collect3);
		
		TreeSet<Integer> collect4 = list.stream()
				.filter((n) -> n % 2 == 0)
				//.collect(Collectors.toList());
				.collect(Collectors.toCollection(() -> new TreeSet<>()));
			
		System.out.println(collect4);
			
		Deque<Integer> collect5 = list.stream()
					.filter((n) -> n % 2 == 0)
					//.collect(Collectors.toList());
					.collect(Collectors.toCollection(() -> new ArrayDeque<>()));
				
		System.out.println(collect5);
		
		String join = list.stream()
				.map(n -> n.toString())
				.collect(Collectors.joining(";"));
			
		System.out.println(join);
		
		//averaging
		Double media = list.stream()
			.collect(Collectors.averagingInt(n -> n.intValue()));
			
		System.out.println(media);
		
		//summing
		Integer media2= list.stream()
				.collect(Collectors.summingInt(n -> n.intValue()));
				
			System.out.println(media2);
			
		//summarizing
		IntSummaryStatistics media3= list.stream()
				.collect(Collectors.summarizingInt(n -> n.intValue()));
		System.out.println("IntSummaryStatistics");		
		System.out.println(media3.getAverage());
		System.out.println(media3.getCount());
		System.out.println(media3.getMax());
		System.out.println(media3.getMin());
		System.out.println(media3.getSum());
		
		// counting
		Long count = list.stream()
			.filter((n) -> n % 2 == 0)
			.collect(Collectors.counting());
		System.out.println(count);
		
		// max / min
		list.stream()
			.filter((n) -> n % 2 == 0)
			//.collect(Collectors.maxBy(Comparator.naturalOrder()))
			.collect(Collectors.minBy(Comparator.naturalOrder()))
			.ifPresent(System.out::println);
		
		// groupingBy
		Map<Integer, List<Integer>> groupingBy = list.stream()
				.collect(Collectors.groupingBy((n) -> n % 3));
				
		System.out.println(groupingBy);
		
		// partitiongBy
		Map<Boolean, List<Integer>> partitiongBy = list.stream()
				.collect(Collectors.partitioningBy((n) -> n % 3 == 0));
				
		System.out.println(partitiongBy);
		
		//toMap
		Map<Integer, Double> toMap = list.stream()
				.collect(Collectors.toMap(
						n -> n, 
						n -> Math.pow(n.doubleValue(), 5)));
				
		System.out.println(toMap);
	}
	

}
