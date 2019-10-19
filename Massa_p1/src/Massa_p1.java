import java.util.Scanner;
import java.security.SecureRandom;


public class Massa_p1 {
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Would you like to Start a new session? (Y/N)");
        String userResponse = scnr.next();
        while (userResponse.equals("Y")) {
            int numDigits = difficulty();
            tenQuestionQuiz(numDigits);

            System.out.println("Would you like to Start a new session? (Y/N)");
            userResponse = scnr.next();
        }

        return;
    }




    public static double problemType(int userInput, double num1, double num2) {

        SecureRandom rand = new SecureRandom();
        double answer = 0;
        int wildCardProb;
        wildCardProb = rand.nextInt(5) + 1;

        switch (userInput) {
            case 1:
                System.out.printf("How much is %.0f plus %.0f?\n", num1, num2);
                answer = num1 + num2;
                break;
            case 2:
                System.out.printf("How much is %.0f times %.0f?\n", num1, num2);
                answer = num1 * num2;
                break;
            case 3:
                System.out.printf("How much is %.0f minus %.0f?\n", num1, num2);
                answer = num1 - num2;
                break;
            case 4:
                System.out.printf("How much is %.0f divided by %.0f?\n", num1, num2);
                answer = num1 / num2;
                break;
            case 5:
                answer = problemType(wildCardProb, num1, num2);
                break;
        }

        return answer;
    }

    public static int difficulty() {

        int userInput;
        int numDigits = 10;
        Scanner scnr = new Scanner(System.in);

        System.out.println("Choose a difficulty. Type 1, 2, 3, or 4.");
        userInput = scnr.nextInt();

        switch (userInput) {
            case 1:
                numDigits = 10;
                break;
            case 2:
                numDigits = 100;
                break;
            case 3:
                numDigits = 1000;
                break;
            case 4:
                numDigits = 10000;
                break;
        }


        return numDigits;
    }

    public static void tenQuestionQuiz(int numDigits) {

        SecureRandom rand = new SecureRandom();
        Scanner scnr = new Scanner(System.in);

        int questionNum;
        int numRight = 0;
        int numWrong = 0;
        int problemOperation;
        double percentage;
        double userInput;
        double randNum1;
        double randNum2;
        double answer;

        System.out.println("What type of problem do you want to do? 1. (+) 2. (*) 3. (-) 4. (/) 5. (random mix)");
        problemOperation = scnr.nextInt();

        for (questionNum = 0; questionNum < 10; questionNum++) {

            randNum1 = rand.nextInt(numDigits);
            randNum2 = rand.nextInt(numDigits);

            answer = problemType(problemOperation, randNum1, randNum2);
            userInput = scnr.nextDouble();

            if (userInput == answer) {
                rightResponseGen(userInput, answer);
                numRight = numRight + 1;

            } else {
                wrongResponseGen(userInput, answer);
                numWrong = numWrong + 1;
            }
        }

        percentage = numRight / 10.0;
        System.out.println();
        System.out.println("You got " + numRight + " questions right and " + numWrong + " questions wrong.");
        System.out.printf("Your percentage is %.0f%%.\n", (percentage * 100));

        if (percentage < .75) {
            System.out.println("Please ask your teacher for extra help.");
            return;
        } else {
            System.out.println("Congratulations, you are ready to go to the next level!");
        }

    }

    public static void wrongResponseGen(double userInput, double answer) {
        SecureRandom rand = new SecureRandom();

        int responseNum = rand.nextInt(4) + 1;

        switch (responseNum) {

            case 1:
                System.out.println("No. Please try again.");
                break;
            case 2:
                System.out.println("Wrong. Try once more.");
                break;
            case 3:
                System.out.println("Don't give up!");
                break;
            case 4:
                System.out.println("No. Keep trying.");
                break;
        }

        return;
    }

    public static void rightResponseGen(double userInput, double answer) {
        SecureRandom rand = new SecureRandom();

        int responseNum = rand.nextInt(4) + 1;

        switch (responseNum) {

            case 1:
                System.out.println("Very Good!");
                break;
            case 2:
                System.out.println("Excellent!");
                break;
            case 3:
                System.out.println("Nice work!");
                break;
            case 4:
                System.out.println("Keep up the good work!");
                break;
        }

        return;
    }
}