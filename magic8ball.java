import java.util.Random;
import java.util.Scanner;

public class Magic8Ball {
    public static void main(String[] args) {
        // Array of possible Magic 8-ball responses
        String[] responses = {
            "Yes", 
            "No", 
            "Maybe", 
            "Ask again later", 
            "Definitely", 
            "It is certain", 
            "Unlikely", 
            "Better not tell you now"
        };

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Magic 8-Ball!");
        
        while (true) {
            System.out.print("Ask your question (or type 'quit' to exit): ");
            String question = scanner.nextLine();

            if (question.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                break;
            }

            // Select a random response
            String answer = responses[random.nextInt(responses.length)];
            System.out.println("Magic 8-Ball says: " + answer);
        }

        scanner.close();
    }
}
