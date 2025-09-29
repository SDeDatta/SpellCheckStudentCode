import java.util.ArrayList;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 \*
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
        int[] bau = new int[text.length];
        for (int j = 0; j < text.length; j++)
        {
            bau[j] = computeNum(text[j]);
        }
        boolean[] matches = new boolean[text.length];
        for(int k = 0; k < bau.length; k++)
        {
            for(int q = 0; q < gurt.length; q++)
            {
                if(bau[k] == gurt[q])
                {
                    matches[k] = true;
                    break;
                }
                else
                {
                    matches[k] = false;
                }
            }
        }
        ArrayList<String> bad = new ArrayList<String>();
        for(int z = 0; z < matches.length; z++)
        {
            if(matches[z] == false)
            {
                bad.add(text[z]);
            }
        }
        String[] badStr = new String[bad.size()];
        for(int h = 0; h < badStr.length; h++)
        {
            badStr[h] = bad.get(h);
        }
        return badStr;

    }

    public int computeNum(String mysteryWord)
    {
        int finalNum = 0;
        for(int i = 0; i < mysteryWord.length(); i++)
        {
            finalNum += (int) mysteryWord.charAt(i) * Math.pow(26,i);
        }
        return finalNum;
    }
}
