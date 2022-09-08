package javalambdaandstream;

public class Java8LambdaRunnable {

	public static void main(String[] args) {

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Olá mundo");
			}
		}).run();

		new Thread(() -> System.out.println("Olá mundo")).run();
		
		
		
	}
}

// SAM - Single Abstract Method
// Qualquer interface que tenha um método abstratoc
// API DE STREAM
// Um FLUXO DE DADOS