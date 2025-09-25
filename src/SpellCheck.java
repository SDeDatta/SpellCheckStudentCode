/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Surya De Datta
 * */

public class SpellCheck {


    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {

        int[] gurt = new int[dictionary.length];
        for(int i = 0; i < dictionary.length; i++)
        {
            gurt[i] = computeNum(dictionary[i]);
        }
        
        return null;
    }

    public int computeNum(String mysteryWord)
    {
        int finalNum = 0;
        for(int i = 0; i < mysteryWord.length(); i++)
        {
            finalNum += (int) mysteryWord.charAt(i) * 26^i;
        }
        return finalNum;
    }
}
