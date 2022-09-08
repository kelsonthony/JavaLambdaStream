package javalambdaandstream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8_Streams_Creation {

	public static void main(String[] args) throws FileNotFoundException  {
		
		// Collection
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		
		list.stream()
			.forEach(System.out::println);
		
		//Arrays
		Integer[] intArray = new Integer[] {1,2,3,4};
		
		Arrays.stream(intArray).forEach(System.out::println);
		
		//Stream.of de qual tipo de objeto
		Stream
			.of("Olá", "Mundo", "tudo", "ok")
			.forEach(System.out::println);
		
		//IntStream.range
		IntStream.range(0, 5).forEach(System.out::println);
		IntStream.rangeClosed(0, 5).forEach(System.out::println);
		
		//Stream iterate
		Stream
			.iterate(5, n ->  n * 2)
			.limit(10)
			.forEach(System.out::println);
		
		// BufferedReader - lines
		//stream.txt - 11, 12, 13
		File file = new File("stream.txt");
		FileReader reader = new FileReader(file);
		try(BufferedReader bufferedReader = new BufferedReader(reader)) {
			bufferedReader.lines().forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Files
//		Path p = Paths.get("");
//		try {
//			Files.lines(p).forEach(System.out::println);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// Random
		new Random().ints()
			.limit(10)
			.forEach(System.out::println);
		
		//Pattern
		String s = "Olá mundo";
		Pattern pattern = Pattern.compile(" ");
		pattern.splitAsStream(s).forEach(System.out::println);
	}
}
