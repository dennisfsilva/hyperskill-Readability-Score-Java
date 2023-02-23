package readability;

public class Readabilities {
    public static double calculateARI(int charactersNum, int wordsNum, int sentencesNum) {
        return 4.71 * (1.0 * charactersNum / wordsNum) + 0.5 * (1.0 * wordsNum / sentencesNum) - 21.43;
    }

    public static double calculateFK(int wordsNum, int sentencesNum, int syllablesNum) {
        return 0.39 * (1.0 * wordsNum / sentencesNum) + 11.8 * (1.0 * syllablesNum / wordsNum) - 15.59;
    }

    public static double calculateSMOG(int polysyllablesNum, int sentencesNum) {
        return 1.043 * Math.sqrt(polysyllablesNum * (30.0 / sentencesNum)) + 3.1291;
    }

    public static double calculateCL(int charactersNum, int wordsNum, int sentencesNum) {
        return 0.0588 * (100.0 * charactersNum / wordsNum) - 0.296 * (100.0 * sentencesNum / wordsNum) - 15.8;
    }
}
