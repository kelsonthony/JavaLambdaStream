package javalambdaandstream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8Streams {

	public static void main(String[] args) {

		List<Integer> lista = Arrays.asList(1, 5, 8, 9, 1, 4, 7, 6, 6, 6, 9, 9);

		// Java 4
		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			// System.out.println(integer);

		}

		// Java 5
		for (Integer integer : lista) {
			// System.out.println(integer);
		}

		// Java 8
		lista.stream()
				// .skip(2) // Ignora is 2 dois primeiros itens // operação intermediária
				.limit(4) // quantos vão ser processados
				// .distinct() // remove numeros repetidos equals and hashcode
				// .filter( e -> e % 2 == 0)
				.map(e -> e * 2) // transformação de dados // não modifica a lista original
				// .forEach(e -> System.out.println(e)); // operacao final
				.count(); // quantos elementos restar

		// System.out.println(lista);

		Optional<Integer> count = lista.stream()
				// .skip(2) // Ignora is 2 dois primeiros itens // operação intermediária
				// .limit(4) // quantos vão ser processados
				// .distinct() // remove numeros repetidos equals and hashcode
				// .filter( e -> e % 2 == 0)

				// .map(e -> e * 2) // transformação de dados // não modifica a lista original
				// .forEach(e -> System.out.println(e)); // operacao final
				// .count(); // quantos elementos restaram
				// .min(Comparator.naturalOrder());
				.max(Comparator.naturalOrder());

		// System.out.println(count.get());

		List<Integer> novaLista = lista.stream()
				// .skip(2) // Ignora is 2 dois primeiros itens // operação intermediária
				// .limit(4) // quantos vão ser processados
				// .distinct() // remove numeros repetidos equals and hashcode
				.filter(e -> e % 2 == 0)

				.map(e -> e * 3) // transformação de dados // não modifica a lista original
				// .forEach(e -> System.out.println(e)); // operacao final
				// .count(); // quantos elementos restaram
				// .min(Comparator.naturalOrder());
				// .max(Comparator.naturalOrder());
				// .collect(Collectors.toList());
				.collect(Collectors.toList());

		// System.out.println(lista);
		// System.out.println(count.get());
		// System.out.println(novaLista);

		Map<Boolean, List<Integer>> mapa = lista.stream()
				// .skip(2) // Ignora is 2 dois primeiros itens // operação intermediária
				// .limit(4) // quantos vão ser processados
				// .distinct() // remove numeros repetidos equals and hashcode
				// .filter( e -> e % 2 == 0)

				.map(e -> e * 3) // transformação de dados // não modifica a lista original
				// .forEach(e -> System.out.println(e)); // operacao final
				// .count(); // quantos elementos restaram
				// .min(Comparator.naturalOrder());
				// .max(Comparator.naturalOrder());
				// .collect(Collectors.toList());
				.collect(Collectors.groupingBy(e -> e % 2 == 0));

		// System.out.println(lista);
		// System.out.println(count.get());
		// System.out.println(mapa);
		Map<Integer, List<Integer>> mapa2 = lista.stream()
				.collect(Collectors.groupingBy(e -> e % 3));

		// System.out.println(lista);
		// System.out.println(count.get());
		//System.out.println(mapa2);

		String myJoin = lista.stream()
				.map(e -> String.valueOf(e))
				.collect(Collectors.joining(";"));

		// System.out.println(lista);
		// System.out.println(count.get());
		//System.out.println(myJoin);
		
		String myJoin2 = lista.parallelStream()
				.map(e -> String.valueOf(e))
				.collect(Collectors.joining(";"));

		// System.out.println(lista);
		// System.out.println(count.get());
		System.out.println(myJoin2);
	}
}

// stream = loops impliticos
// for - while - do while = loops explicitos


