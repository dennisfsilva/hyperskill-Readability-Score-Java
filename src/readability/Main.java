package readability;

import java.io.IOException;
import java.util.Scanner;

import static readability.Parameters.*;
import static readability.Readabilities.*;
import static readability.Utils.readFromFile;

public class Main {
    static StringBuilder output = new StringBuilder();
    static double sum = 0;
    public static void main(String[] args) throws IOException {
        String text = readFromFile(args[0]);

        int wordsNum = getWordsNum(text);
        int sentencesNum = getSentencesNum(text);
        int charactersNum = getCharactersNum(text);
        int syllablesNum = getSyllablesNum(text);
        int polysyllablesNum = getPolysyllablesNum(text);

        System.out.println("The text is:\n" + text);
        System.out.println("\nWords: " + wordsNum);
        System.out.println("Sentences: " + sentencesNum);
        System.out.println("Characters: " + charactersNum);
        System.out.println("Syllables: " + syllablesNum);
        System.out.println("Polysyllables: " + polysyllablesNum);

        String decision = new Scanner(System.in).next();

        switch (decision.toUpperCase()) {
            case "ARI" -> appendOutput("Automated Readability Index", calculateARI(charactersNum, wordsNum, sentencesNum));
            case "FK" -> appendOutput("Flesch–Kincaid readability tests", calculateFK(wordsNum, sentencesNum, syllablesNum));
            case "SMOG" -> appendOutput("Simple Measure of Gobbledygook", calculateSMOG(polysyllablesNum, sentencesNum));
            case "CL" -> appendOutput("Coleman–Liau index", calculateCL(charactersNum, wordsNum, sentencesNum));
            case "ALL" -> {
                appendOutput("Automated Readability Index", calculateARI(charactersNum, wordsNum, sentencesNum));
                appendOutput("Flesch–Kincaid readability tests", calculateFK(wordsNum, sentencesNum, syllablesNum));
                appendOutput("Simple Measure of Gobbledygook", calculateSMOG(polysyllablesNum, sentencesNum));
                appendOutput("Coleman–Liau index", calculateCL(charactersNum, wordsNum, sentencesNum));
            }
        }

        System.out.println(output);

        int avgAge = (int) Math.ceil(sum / (decision.equals("ALL") ? 4 : 1));
        System.out.println("\nThis text should be understood in average by " + avgAge + " year olds.");
    }

    public static void appendOutput(String testName, double score) {
        int age = getAge(score);
        output.append(String.format("%s: %.2f (about %d year olds).\n", testName, score, age));
        sum += age;
    }
}
