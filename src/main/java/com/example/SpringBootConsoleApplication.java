package com.example;

import com.example.service.impl.ParseCommandServiceImpl;
import com.example.service.impl.RandomNumberServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.MessageFormat;
import java.util.Scanner;

@SpringBootApplication
@AllArgsConstructor

public class SpringBootConsoleApplication
        implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class);
    }

    private final RandomNumberServiceImpl randomNumberService;
    private final ParseCommandServiceImpl parseCommandService;

    @Override
    public void run(String... args) {
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);

    while(true){ 
        System.out.println("Enter Command:");
        String command = scanner.nextLine();
        String[] commandArgs = parseCommandService.getArgs(command);

        if(commandArgs.length == 0){
            System.out.println("Invalid command. Try Again.");
            continue;
        }
        if(commandArgs[0].equalsIgnoreCase("roll-dice")){
            if(commandArgs.length < 2){
                System.out.println("Usage: roll-dice <size>");
                continue;
            }
            try{
                int diceSize = Integer.parseInt(commandArgs[1]);
                System.out.println(MessageFormat.format("----Rolling 1d{0} ----", diceSize));
                int rollValue = randomNumberService.getRandomNumber(diceSize);
                System.out.println("Result: " + rollValue);
            }catch(NumberFormatException e){
                System.err.println("Error: Dice size must be a valid number");
            }

            } else if(commandArgs[0].equalsIgnoreCase("Exit")){
                System.out.println("Exiting Application...");
                break;
            }else{
                System.out.println("No Matching command found. Try using command help");
            }
        }

    
    }
}