import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Initializes ArrayLists / Adding default elements to ArrayLists.
        ArrayList<String> questionList = new ArrayList<>();
        ArrayList<String> answerList = new ArrayList<>();
        ArrayList<String> usedQuestions = new ArrayList<>();

        questionList.add("What is the capital of Japan");
        questionList.add("What year did League of Legends release");
        questionList.add("Who is Jung Kook");
        questionList.add("What city is Rosemead Donuts in");
        questionList.add("What is the most popular coffee chain in the world?");

        answerList.add("tokyo");
        answerList.add("2009");
        answerList.add("eric yan");
        answerList.add("rosemead");
        answerList.add("starbucks");


        //Initializes variables
        var roundCount = 1;
        var score = 0;
        var keyboard = new Scanner(System.in);
        Random rnd = new Random();
        var continueGame = true;

        System.out.println("Welcome to Trivia Night!");
        System.out.println("Every three rounds, you may add your own question!");

        //Starts game loop; continues until player quits.
        while (continueGame) {
            //Determines the next question by generating a random number based on the ArrayList (Questions) size.
            var questionNum = rnd.nextInt(questionList.size());

            //Ensures that the same question is not chosen twice in a row.
            while (usedQuestions.contains(questionList.get(questionNum))) {
                questionNum = rnd.nextInt(questionList.size());
            }

            //Updates the usedQuestion ArrayList AFTER the check has been complete.
            usedQuestions.add(questionList.get(questionNum));


            //Prints out the question and creates the response variable.
            System.out.println("Round " + roundCount + "!");
            System.out.println(questionList.get(questionNum) + "?");
            var response = keyboard.nextLine();


            //Checks the response in lowercase, adds one to score variable if the answers match.
            if (response.toLowerCase().equals(answerList.get(questionNum))) {

                score += 1;

            }

            System.out.println("Your current score is : " + score);


            //If three rounds have passed, it gives the player the option to add a question to the ArrayList
            //If the player refuses, they are instead given the option to quit the game
            if (roundCount % 3 == 0) {

                //Clears the log of used questions for the next loop.
                usedQuestions.clear();

                //Prompts the user if they would like to increase the question list.
                System.out.println("Would you like to add a question? (Y/N)");
                var addResponse = keyboard.nextLine();

                //Maintains a loop until the user provides a valid answer (Y/N). note : not case sensitive.
                while (!addResponse.equalsIgnoreCase("Y") && !addResponse.equalsIgnoreCase("N")) {
                    System.out.println("Please enter a valid response (Y/N)");
                    addResponse = keyboard.nextLine();
                }


                //If the user responds with Y, they are then prompted to
                if (addResponse.equalsIgnoreCase("Y")) {

                    System.out.println("Add your question : ");
                    var addedQuestion = keyboard.nextLine();
                    questionList.add(addedQuestion);

                    System.out.println("Add your answer : ");
                    var addedAnswer = keyboard.nextLine();
                    answerList.add(addedAnswer.toLowerCase());

                }

                if (addResponse.equalsIgnoreCase("N")) {
                    System.out.println("Would you like to keep playing? (Y/N)");

                    var contResponse = keyboard.nextLine();
                    while (!contResponse.equalsIgnoreCase("Y") && !contResponse.equalsIgnoreCase("N")) {
                        System.out.println("Please enter a valid response (Y/N)");
                        contResponse = keyboard.nextLine();
                    }

                    if (contResponse.equalsIgnoreCase("Y")) {

                        System.out.println("Starting next round..");

                    }

                    if (contResponse.equalsIgnoreCase("N")) {

                        continueGame = false;
                    }
                }
            }
            roundCount += 1;
        }
    }
}