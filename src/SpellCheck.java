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

    public static final int EXT_ASCII_LENGTH = 256;
    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {

        Trie dictTrie = new Trie();

        for(String word: dictionary)
        {
            dictTrie.insert(word);
        }
        Trie missedTrie = new Trie();
        ArrayList<String> missedList = new ArrayList<>();
        for(String word: text)
        {
            if(dictTrie.lookUp(word) == false)
            {
                if(!missedTrie.lookUp(word))
                {
                    missedList.add(word);
                    missedTrie.insert(word);
                }
            }
        }
        return missedList.toArray(new String[0]);
    }
    public String[] trieToArray(Trie trie)
    {
        ArrayList<String> arr = new ArrayList<>();
        helper(trie.getRoot(), "", arr);
        return arr.toArray(new String[0]);
    }

    public void helper(Node node, String current, ArrayList<String>arr)
    {
        if(node == null)
        {
            return;
        }
        if(node.isWord())
        {
            arr.add(current);
        }
        for (int i = 0; i < 256; i++)
        {
            if(node.getNext()[i] != null)
            {
                char toAdd = (char) (i);
                helper(node.getNext()[i],current + toAdd, arr);
            }
        }
    }
}
