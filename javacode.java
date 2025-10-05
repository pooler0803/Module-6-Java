import java.util.Scanner;
import java.util.InputMismatchException;

public class CoffeeSurvey {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] questions = {
            "What is your rating of the dark roast coffee (1-poor, 2-fair, 3-good, 4-excellent, 5-outstanding)? ",
            "What is your rating of the medium roast coffee (1-poor, 2-fair, 3-good, 4-excellent, 5-outstanding)? ",
            "What is your rating of the light roast coffee (1-poor, 2-fair, 3-good, 4-excellent, 5-outstanding)? ",
            "What is your rating of the french vanilla coffee (1-poor, 2-fair, 3-good, 4-excellent, 5-outstanding)? ",
            "What is your rating of the caramel coffee (1-poor, 2-fair, 3-good, 4-excellent, 5-outstanding)? "
        };

        int[] ratings = new int[5];
        double total = 0;

        for (int i = 0; i < questions.length; i++) {
            while (true) {
                try {
                    System.out.print(questions[i]);
                    int rating = input.nextInt();

                    if (rating < 1 || rating > 5) {
                        throw new IllegalArgumentException("Rating must be between 1 and 5.");
                    }

                    ratings[i] = rating;
                    total += rating;
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
                    input.next(); // clear bad input
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.println("\nRatings:");
        for (int i = 0; i < ratings.length; i++) {
            String stars = "*".repeat(ratings[i]);
            System.out.println("Question " + (i + 1) + ": " + stars);
        }

        double average = total / ratings.length;
        System.out.printf("\nYour average rating is %.1f\n", average);
    }
}
