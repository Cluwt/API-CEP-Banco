package br.com.cluwt.CEPDB;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;

import br.com.cluwt.CEPDB.Models.Cep;
import br.com.cluwt.CEPDB.Controllers.CepController; // Import the controller
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("br.com.cluwt.CEPDB.Models")
@EnableJpaRepositories("br.com.cluwt.CEPDB.Repository")
public class CepDbApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CepDbApplication.class, args);
		CepController cepController = context.getBean(CepController.class); // Get controller bean

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nMenu:");
			System.out.println("1. Consultar Todos CEPs");
			System.out.println("0. Sair");

			System.out.print("Digite sua opção: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1:
					cepController.getAllCeps();
					break;
				case 0:
					System.out.println("Saindo do sistema...");
					scanner.close();
					System.exit(0);
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}
}
