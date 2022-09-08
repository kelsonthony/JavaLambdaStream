package javalambdaandstream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Java8_MethodReference {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		
		//Method Reference ::
		
		list.stream()
			.forEach(System.out::println);
		
		// Sem Method Referece
		list.stream()
		.forEach((n) -> System.out.println(n));
		
		//metodos estaticos sem Method Reference
		list.stream()
			.map((n) -> multipliquePorDois(n))
			.forEach((n) -> System.out.println(n));
		
		//metodos estaticos com Method Reference
		list.stream()
			.map(Java8_MethodReference::multipliquePorDois)
			.forEach((n) -> System.out.println(n));
		
		//construtores sem method reference
		list.stream()
			.map((n) -> new BigDecimal(n))
			.forEach((n) -> System.out.println("construtores 1 " + n));
		
		//construtores com method reference
		list.stream()
			.map(BigDecimal::new)
			.forEach((n) -> System.out.println("construtores 2 " + n));
		
		//várias instancias
		list.stream()
			.map((n) -> n.doubleValue())
			.forEach((n) -> System.out.println("doubleValue " + n));
		
		//várias instancias com Method Reference
		list.stream()
			.map(Integer::doubleValue)
			.forEach((n) -> System.out.println("doubleValue " + n));
		
		// única instancia
		BigDecimal dois = new BigDecimal(2);
		list.stream()
			.map(BigDecimal::new)
			.map((b) -> dois.multiply(b))
			.forEach((n) -> System.out.println("BigDecimal " + n));
		
		// única instancia com method reference
		BigDecimal dois2 = new BigDecimal(2);
		list.stream()
			.map(BigDecimal::new)
			.map(dois2::multiply)
			.forEach((n) -> System.out.println("BigDecimal 2 " + n));
	}
	
	private static Integer multipliquePorDois(Integer i) {
		return i * 2;
	}
}
