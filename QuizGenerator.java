
import java.util.*;

public class QuizGenerator {
    // Data structure to store quizzes
    private static Map<String, List<Question>> quizzes = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Quiz Generator!");
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create a new quiz");
            System.out.println("2. Take a quiz");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> createQuiz();
                case 2 -> takeQuiz();
                case 3 -> {
                    System.out.println("Exiting Quiz Generator. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Create a new quiz
    private static void createQuiz() {
        System.out.print("Enter the quiz topic: ");
        String topic = scanner.nextLine();
        List<Question> questions = new ArrayList<>();

        System.out.print("How many questions do you want to add? ");
        int questionCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 1; i <= questionCount; i++) {
            System.out.println("Question " + i + ":");
            System.out.print("Enter the question: ");
            String text = scanner.nextLine();

            System.out.print("Enter the number of options: ");
            int optionCount = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            List<String> options = new ArrayList<>();
            for (int j = 1; j <= optionCount; j++) {
                System.out.print("Option " + j + ": ");
                options.add(scanner.nextLine());
            }

            System.out.print("Enter the correct option number (1-" + optionCount + "): ");
            int correctAnswer = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            questions.add(new Question(text, options, correctAnswer));
        }

        quizzes.put(topic, questions);
        System.out.println("Quiz "" + topic + "" created successfully!");
    }

    // Take a quiz
    private static void takeQuiz() {
        if (quizzes.isEmpty()) {
            System.out.println("No quizzes available. Create a quiz first.");
            return;
        }

        System.out.println("Available quizzes:");
        for (String topic : quizzes.keySet()) {
            System.out.println("- " + topic);
        }

        System.out.print("Enter the quiz topic you want to take: ");
        String topic = scanner.nextLine();

        if (!quizzes.containsKey(topic)) {
            System.out.println("Quiz not found. Please try again.");
            return;
        }

        List<Question> questions = quizzes.get(topic);
        int score = 0;

        for (Question question : questions) {
            System.out.println("\n" + question.getText());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (userAnswer == question.getCorrectAnswer()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + question.getCorrectAnswer());
            }
        }

        System.out.println("\nQuiz completed! Your score: " + score + "/" + questions.size());
    }

    // Inner class to represent a question
    static class Question {
        private final String text;
        private final List<String> options;
        private final int correctAnswer;

        public Question(String text, List<String> options, int correctAnswer) {
            this.text = text;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        public String getText() {
            return text;
        }

        public List<String> getOptions() {
            return options;
        }

        public int getCorrectAnswer() {
            return correctAnswer;
        }
    }
}
