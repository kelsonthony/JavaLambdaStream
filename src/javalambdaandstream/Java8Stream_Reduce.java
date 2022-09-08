package javalambdaandstream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

public class Java8Stream_Reduce {

	public static void main(String[] args) {

		String s = "Hello World";

		String[] split = s.split(" ");

		List<String> listSrt = Arrays.asList(split);

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

//		list.stream()
//		.forEach(l -> System.out.println(l));
		// reduce soma
		Optional<Integer> soma = list.stream().reduce((n1, n2) -> n1 + n2);
		System.out.println(soma.get());

		// reduce multiplicacao
		Optional<Integer> multiplicaco = list.stream().reduce((n1, n2) -> n1 * n2);
		System.out.println(multiplicaco.get());

		// reduce concatenacao
		Optional<String> concatenacao = listSrt.stream().reduce((s1, s2) -> s1.concat(s2));

		System.out.println(concatenacao.get());

		// reduce subtracao // não é associativo
		// Optional<Integer> subtracao = list.stream().reduce((n1, n2) -> n1 - n2);
		// result -19
		Optional<Integer> subtracao = list.stream().parallel().reduce((n1, n2) -> n1 - n2);

		System.out.println(subtracao.get()); // outro resultado -3

		List<Integer> listVazia = Arrays.asList();

		// reduce soma 2, iniciar com o valor de identidade
		Integer soma2 = listVazia.stream().reduce(0, (n1, n2) -> n1 + n2);
		System.out.println("Soma 2 " + soma2);

		// reduce multiplicacao
		Integer multiplicaco2 = list.stream().reduce(1, (n1, n2) -> n1 * n2);
		System.out.println(multiplicaco2);

		// reduce concatenacao
		String concatenacao2 = listSrt.stream().reduce("", (s1, s2) -> s1.concat(s2));

		System.out.println(concatenacao2);

		// reduce do menor valor
		double menorValor = DoubleStream.of(1.5, 2.9, 6.7)
				// .forEach((n) -> System.out.println(n));
				.reduce(Double.POSITIVE_INFINITY, (d1, d2) -> Math.min(d1, d2));
		System.out.println(menorValor);

		// reduce soma 3
		Integer soma3 = list.stream()
				.reduce(0, (n1, n2) -> n1 + n2, (n1, n2) -> n1 + n2);
		System.out.println(soma3);
		
		// reduce - map + combiner
		Optional<String> soma4  = list.stream()
				.map(n1 -> n1.toString())
				.reduce((n1, n2) -> n1.concat(n2));
		System.out.println(soma4);
		
		// reduce - map + combiner 2
		String stringConcat  = list.stream()
						.reduce("",
							(n1, n2) -> n1.toString().concat(n2.toString()),
							(n1, n2) -> n1.concat(n2)
								);
		System.out.println(stringConcat);
	}
}
