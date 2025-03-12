# GODev Code Test

## Project Summary

To run this project you will need up to date versions of:

- Java 17
- Maven 4.0.0

This is a small command line app that allows the user to role a die.

To run it make sure you have got all your packages up to date
`mvn clean package -U`

Then you can run the following from the root directory to launch it.
`./mvnw spring-boot:run`

When you run this app it the console should ask the user to `Enter Command:`.
At this point the user should be able to enter a command to interact with the application.

At the start all it can do is roll 1 die of a size decided by the user.

So for example if you run this app and type in the command `roll-dice 6`,
The application should output a number between 1 and 6.

---

## Tasks

### 1. Make the Application More interactive

At the moment after you run a command the tool becomes unresponsive.
Update the tool so that once a command has been run, you are asked for another command and the tool stays active.

**User Story:**
As a user,
I would like to be able to run multiple commands,
So that I don't need to keep rebooting the tool.

**Acceptance Criteria:**

- After one command is processed, the tool asks for another command.

### 2. Add Error Handling

At the moment if you run the command with a piece of text for the dice size the application crashes.
For example `roll-dice f`.

Update the tool so that if a user inputs a string, the application doesn't crash.

**User Story:**
As a user,
I would like the application to not crash when I make an error,
So that I don't need to keep rebooting the tool.

**Acceptance Criteria:**

- Typing `roll-dice f` doesn't crash the application
- If any string is entered for the dice size, the application doesn't crash.

### 3. Add a Help Command

Add a help command that helps explain to the user how to use the application

**User Story:**
As a user,
I would like a help command,
So I can understand how to use the tool better.

**Acceptance Criteria:**

- A `help` command that outlines which commands the tool accepts

### 4. Allow Multiple Dice

Update the `roll-dice` command to allow multiple dice to be rolled.

**User Story:**
As a user,
I would like to be able to roll multiple dice,
So I can more easily roll multiple dice.

**Acceptance Criteria:**

- Command `roll-dice 6 3` outputs the result of 3, 6 sided dice.
- Command `roll-dice 8` outputs the result of 1, 8 sided die.

### 5. Take highest 2 Dice from 5

We also would like a command for a specific game.
This command rolls 5, 6-sided dice and returns the total of the 2 highest dice.

For example if we ran the command, it could roll (6,1,4,2,4) and it would output 10

**User Story:**
As a user,
I would like to be able to roll 5 dice and get total of the 2 highest,
So I can play my game more quickly.

**Acceptance Criteria:**

- Somehow the user can ask the program to roll 5 d6 and gets the total of the 2 highest values

---

## Submission

Submit this to us by uploading it to some form of version control and sending us the link.
**Please do not include the word Jagex in your submission anywhere**

Once submitted our team will review your code.
If the code test is good, and you are invited for an interview, there will be discussion around your submission.
You will be asked to run us through your code, followed up by any questions we noted during the review
