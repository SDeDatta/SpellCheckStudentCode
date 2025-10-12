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

    // Constant for the size of each array in the trie
    public static final int EXT_ASCII_LENGTH = 256;
    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {
        // return runTrie(text, dictionary);
        return runTST(text, dictionary);

    }
    // Runs the trie
    private String[] runTrie(String[] text, String[] dictionary)
    {
        Trie dictTrie = new Trie();
        // Inserts every word in the dictionary into a single trie
        for(String word: dictionary)
        {
            dictTrie.insert(word);
        }
        // Creates a trie for all words in text that don't appear in the dictionary
        Trie missedTrie = new Trie();
        ArrayList<String> missedList = new ArrayList<>();
        for(String word: text)
        {
            if(!dictTrie.lookUp(word))
            {
                if(!missedTrie.lookUp(word))
                {
                    missedList.add(word);
                    // Adds to the "missed" trie if a word doesn't appear to actually be a word
                    missedTrie.insert(word);
                }
            }
        }
        // Converts the trie to a String array using a built-in java function
        return missedList.toArray(new String[0]);
    }
    // Runs the TST
    private String[] runTST(String[] text, String[] dictionary)
    {
        TST dictTST = new TST();
        // Puts every word in the dictionary into a TST
        for(String word: dictionary)
        {
            dictTST.insert(word);
        }
        // Creates a TST for all words in text that don't appear in the dictionary
        TST missedTST = new TST();
        ArrayList<String> missedList = new ArrayList<>();
        for(String word: text)
        {
            if(!dictTST.lookUp(word))
            {
                if(!missedTST.lookUp(word))
                {
                    missedList.add(word);
                    missedTST.insert(word);
                }
            }
        }
        // Converts the TST to a String array using a built-in java function
        return missedList.toArray(new String[0]);
    }
}
