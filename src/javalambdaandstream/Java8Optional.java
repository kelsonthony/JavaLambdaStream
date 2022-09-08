package javalambdaandstream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Java8Optional {

	public static void main(String[] args) {

		String s = "1";
		//String s = "Hello";

//		Optional<Integer> numero = converteEmNumero(s);
//		//System.out.println(numero.get());
//		numero.ifPresent( n -> System.out.println(n));
		//converteEmNumero(s).ifPresent( n -> System.out.println(n));
		//System.out.println(converteEmNumero(s).orElse(2));
		//System.out.println(converteEmNumero(s).orElseGet(() -> 5)); // operacao mais custosa
		//System.out.println(converteEmNumero(s)
			//	.orElseThrow(() -> new NullPointerException("Valor vazio")));
		int numero = converteEmNumeroOptional(s)
			.orElseThrow(() -> new NullPointerException("Valor vazio"));
		
		System.out.println(numero);
		
//		Optional<Integer> numero = Stream.of(1, 2, 3)
//				.findFirst();
//		System.out.println(numero.get());
//		Stream.of(1, 2, 3)
//				.findFirst()
//				.ifPresent(n -> System.out.println(n));
		
		
	}

	// 	Java 7 
	//	public static Integer converteEmNumero(String numeroStr) {
	//		
	//		return Integer.valueOf(numeroStr);
	//	}

	public static Optional<Integer> converteEmNumero(String numeroStr) {

		try {
			Integer integer = Integer.valueOf(numeroStr);
			return Optional.of(integer);
		} catch (Exception e) {
			return Optional.empty();
		}
	}
	
	public static OptionalInt converteEmNumeroOptional(String numeroStr) {

		try {
			int integer = Integer.parseInt(numeroStr);
			return OptionalInt.of(integer);
		} catch (Exception e) {
			return OptionalInt.empty();
		}
	}

}
