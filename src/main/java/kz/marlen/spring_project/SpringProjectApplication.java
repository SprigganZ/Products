package kz.marlen.spring_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class SpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			Scanner scanner = new Scanner(System.in);
			ProductRepository productRepository = context.getBean(ProductRepository.class);

			while (true) {
				Cart cart = context.getBean(Cart.class);
				System.out.println("Commands: list, add, remove, view, exit");
				String command = scanner.nextLine();

				switch (command) {
					case "list":
						productRepository.findAll().forEach(product ->
								System.out.println(product.getId() + ": " + product.getName() + " - ₸" + product.getPrice()));
						break;
					case "add":
						System.out.println("Введите ID продукта чтобы добавить:");
						Long addId = Long.parseLong(scanner.nextLine());
						cart.addProduct(addId);
						break;
					case "remove":
						System.out.println("Введите ID продукта чтобы удалить:");
						Long removeId = Long.parseLong(scanner.nextLine());
						cart.removeProduct(removeId);
						break;
					case "view":
						cart.getItems().forEach(product ->
								System.out.println(product.getId() + ": " + product.getName() + " - ₸" + product.getPrice()));
						break;
					case "exit":
						return;
					default:
						System.out.println("Unknown command");
				}
			}
		};
	}
}
