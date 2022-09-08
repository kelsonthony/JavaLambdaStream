package javalambdaandstream;

import java.util.Arrays;
import java.util.List;

public class Java8LambdaStream {

	public static void main(String[] args) {

		
		List<Integer> asList = Arrays.asList(1, 2, 3, 4);
		
//		for (Integer integer : asList) {
//			System.out.println(integer);
//		}
		
		//asList.stream().forEach(e -> System.out.println(e));
		
		// for, while, do while
		
		
		asList.stream()
			.filter(e -> e % 2 == 0)
			.forEach(e -> System.out.println(e));
	}
}

// SAM - Single Abstract Method
// Qualquer interface que tenha um método abstratoc
// API DE STREAM
// Um FLUXO DE DADOS