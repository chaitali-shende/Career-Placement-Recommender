package com.cs.main;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cs.config.AppConfig;
import com.cs.model.Student;
import com.cs.service.PlacementService;
import com.cs.strategy.PlacementStrategy;
import com.cs.util.ConsoleColors;

public class PlacementProgramTest {
	// Disable Hibernate Validator log
	static {
		System.setProperty("org.jboss.logging.provider", "slf4j");
		java.util.logging.LogManager.getLogManager().reset();
	}

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
				Scanner sc = new Scanner(System.in)) {

			PlacementService placementService = ctx.getBean(PlacementService.class);

			System.out.println(ConsoleColors.CYAN_BOLD + "==============================");
			System.out.println(" CAREER PLACEMENT RECOMMENDER ");
			System.out.println("==============================" + ConsoleColors.RESET);

			// Choose Strategy, Ask user which strategy to use
			System.out.println("\n" + ConsoleColors.YELLOW_BOLD + "Choose Placement Type:" + ConsoleColors.RESET);
			System.out.println("1. IT");
			System.out.println("2. Core");
			System.out.println("3. Management");
			System.out.println("4. Finance");
			System.out.print(ConsoleColors.YELLOW_BOLD + "Enter option: " + ConsoleColors.RESET);
			System.out.print(ConsoleColors.BLUE_BOLD + "Enter your choice (1-4): " + ConsoleColors.RESET);
			int ch = sc.nextInt();
			sc.nextLine(); // clear

			String selectedType = switch (ch) {
			case 1 -> "it";
			case 2 -> "core";
			case 3 -> "mgmt";
			case 4 -> "finance";
			default -> {
				System.out.println(ConsoleColors.RED_BOLD + "Invalid option! Defaulting to IT." + ConsoleColors.RESET);
				yield "it";
			}
			};

			// ---------- Student Input ----------
			System.out.println(ConsoleColors.CYAN_BOLD + "\nEnter Student Details:" + ConsoleColors.RESET);

			System.out.print(ConsoleColors.BLUE + "Name      : " + ConsoleColors.RESET);
			String name = sc.nextLine();

			System.out.print(ConsoleColors.BLUE + "CGPA      : " + ConsoleColors.RESET);
			double cgpa = sc.nextDouble();
			sc.nextLine();

			System.out.print(ConsoleColors.BLUE + "Skills    : " + ConsoleColors.RESET);
			String skillLine = sc.nextLine();
			List<String> skills = Arrays.asList(skillLine.split(","));

			Student student = new Student(name, cgpa, skills);

			// Get strategy object
			PlacementStrategy strategy = placementService.getStrategyByType(selectedType);

			String result = placementService.executeStrategy(strategy, student);

			System.out.println(ConsoleColors.GREEN + "\n" + result + ConsoleColors.RESET);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
