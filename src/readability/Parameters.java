package readability;

import java.util.regex.Pattern;

public class Parameters {
    public static int getWordsNum(String text) {
        return Pattern.compile("\\s").split(text).length;
    }

    public static int getSentencesNum(String text) {
        return Pattern.compile("[?!.][\\s]*").split(text).length;
    }

    public static int getCharactersNum(String text) {
        return text.replaceAll("\\s", "").length();
    }

    public static int getSyllablesNum(String text) {
        int count = 0;
        for (String word : text.split("\\s")) {
            count += getSyllables(word);
        }
        return count;
    }

    public static int getPolysyllablesNum(String text) {
        int count = 0;
        for (String word : text.split("\\s")) {
            int syllables = getSyllables(word);
            if (syllables > 2) {
                count++;
            }
        }
        return count;
    }

    public static int getSyllables(String word) {
        int counter = 0;
        boolean wasVowel = false;
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') {
                if (!wasVowel) {
                    wasVowel = true;
                    counter++;
                }
            } else {
                wasVowel = false;
            }
        }
        if (word.charAt(word.length() - 1) == 'e') {
            counter--;
        }
        if (counter == 0) {
            counter = 1;
        }
        return counter;
    }

    public static int getAge(double score) {
        final int[] age = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 24, 25};
        int intScore = (int) Math.ceil(score);
        if (intScore >= age.length - 1) {
            intScore = age.length - 1;
        }
        return age[intScore];
    }
}
