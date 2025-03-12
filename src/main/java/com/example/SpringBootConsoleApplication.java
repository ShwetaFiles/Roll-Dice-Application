package com.example;

import com.example.service.impl.ParseCommandServiceImpl;
import com.example.service.impl.RandomNumberServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.MessageFormat;
import java.util.*;
import java.util.stream.IntStream;

@SpringBootApplication
@AllArgsConstructor
public class SpringBootConsoleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class);
    }

    // Dependencies for random number generation and command parsing
    private final RandomNumberServiceImpl randomNumberService;
    private final ParseCommandServiceImpl parseCommandService;

    @Override
    public void run(String... args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Keeps the application interactive, asking for user input continuously
        while (true) {
            System.out.println("Enter Command:");
            String command = scanner.nextLine();
            String[] commandArgs = parseCommandService.getArgs(command);

            if (commandArgs.length == 0) {
                System.out.println("Invalid command. Try Again.");
                continue;
            }

            // Command handling using a switch-case structure
            switch (commandArgs[0].toLowerCase()) {
                case "roll-dice":
                    handleRollDice(commandArgs); // Handles rolling one or multiple dice
                    break;

                case "roll-dice-5":
                    handleRollFiveDice(); // Handles rolling 5 dice and summing the highest two
                    break;

                case "help":
                    displayHelp(); // Displays available commands
                    break;

                case "exit":
                    System.out.println("Exiting Application...");
                    return; // Terminates the program

                default:
                    System.out.println("No matching command found. Try using the 'help' command.");
                    break;
            }
        }
    }

    /*
     * Handles the roll-dice command.
     * Allows rolling one or multiple dice of a given size.
     * `roll-dice 6` (Rolls 1 six-sided die)
     * `roll-dice 8 3` (Rolls 3 eight-sided dice)
     */
    private void handleRollDice(String[] commandArgs) {
        if (commandArgs.length < 2) {
            System.out.println("Usage: roll-dice <size> [count]");
            return;
        }
        try {
            int diceSize = Integer.parseInt(commandArgs[1]); // First argument is dice size
            int diceCount = (commandArgs.length > 2) ? Integer.parseInt(commandArgs[2]) : 1; // Second argument (optional) is number of dice

            System.out.println(MessageFormat.format("---- Rolling {0}d{1} ----", diceCount, diceSize));
            IntStream.range(0, diceCount)
                    .map(i -> randomNumberService.getRandomNumber(diceSize)) // Generate random roll for each die
                    .forEach(result -> System.out.println("Result: " + result)); // Print results

        } catch (NumberFormatException e) {
            System.err.println("Error: Dice size and count must be valid numbers.");
        }
    }

    /*
     * Handles rolling 5 six-sided dice and summing the highest two values.
     * `roll-dice-5`
     */

    private void handleRollFiveDice() {
        System.out.println("---- Rolling 5d6 ----");
        List<Integer> rolls = new ArrayList<>();

        // Roll 5 dice of size 6 and store results
        for (int i = 0; i < 5; i++) {
            rolls.add(randomNumberService.getRandomNumber(6));
        }

        System.out.println("Rolled: " + rolls);
        rolls.sort(Collections.reverseOrder()); // Sort in descending order

        int highestSum = rolls.get(0) + rolls.get(1); // Take the highest 2 rolls
        System.out.println("Sum of highest two: " + highestSum);
    }

    //Displays the help menu.
     
    private void displayHelp() {
        System.out.println("Available Commands:");
        System.out.println("- roll-dice <size> [count]: Rolls one or more dice of the specified size.");
        System.out.println("- roll-dice-5: Rolls 5 six-sided dice and returns the sum of the two highest.");
        System.out.println("- help: Displays this message.");
        System.out.println("- exit: Exits the application.");
    }
}
