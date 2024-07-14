import java.util.Scanner;
import java.util.Random;

public class Hangman {

    private static String[] words = {
        "apple|It's a fruit",
        "banana|It's yellow and curved",
        "orange|It's a citrus fruit",
        "grape|Comes in bunches",
        "melon|Large fruit with juicy flesh",
        "computer|Used for processing data",
        "keyboard|Used for typing",
        "monitor|Displays output",
        "mouse|Used for pointing and clicking",
        "internet|Global network",
        "java|Programming language",
        "python|Programming language",
        "hangman|Word guessing game",
        "sunflower|Yellow flower with seeds",
        "mountain|Large natural elevation",
        "ocean|Large body of saltwater",
        "football|Sport played with a ball",
        "guitar|Musical instrument",
        "book|Contains stories or information",
        "movie|Moving picture"
    };
    private static Random random = new Random();
    private static String wordToGuess;
    private static String clue;
    private static char[] guessedLetters;
    private static int attemptsLeft = 6;

    public static void main(String[] args) {
        wordToGuess = getRandomWord();
        guessedLetters = new char[wordToGuess.length()];
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        System.out.println("Try to guess the word:");
        System.out.println("Clue: " + clue);

        boolean gameEnded = false;
        while (!gameEnded) {
            System.out.println("\nCurrent word: " + new String(guessedLetters));
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);

            if (!isLetterGuessed(guess)) {
                if (isLetterInWord(guess)) {
                    System.out.println("Good guess!");
                    if (isWordGuessed()) {
                        gameEnded = true;
                        System.out.println("Congratulations! You guessed the word: " + wordToGuess);
                    }
                } else {
                    attemptsLeft--;
                    System.out.println("Wrong guess!");
                    if (attemptsLeft == 0) {
                        gameEnded = true;
                        System.out.println("Game over! The word was: " + wordToGuess);
                    }
                }
            } else {
                System.out.println("You already guessed that letter. Try again.");
            }
        }

        scanner.close();
    }

    private static String getRandomWord() {
        String wordInfo = words[random.nextInt(words.length)];
        String[] wordParts = wordInfo.split("\\|");
        wordToGuess = wordParts[0];
        clue = wordParts[1];
        return wordToGuess;
    }

    private static boolean isLetterGuessed(char letter) {
        for (char c : guessedLetters) {
            if (c == letter) {
                return true;
            }
        }
        return false;
    }

    private static boolean isLetterInWord(char letter) {
        boolean letterFound = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                guessedLetters[i] = letter;
                letterFound = true;
            }
        }
        return letterFound;
    }

    private static boolean isWordGuessed() {
        for (char c : guessedLetters) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}
