public class Trie
{
    private class Node
    {
        boolean isWord;
        // Creates an array of possible children for a node
        Node[] children;
        public Node()
        {
            isWord = false;
            // Size of 256 represents possible extended ascii characters
            children = new Node[SpellCheck.EXT_ASCII_LENGTH];
        }

        public boolean isWord()
        {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }

        public Node[] getChildren() {
            return children;
        }
    }
    Node root;
    public Trie()
    {
        root = new Node();
    }

    public Node getRoot() {
        return root;
    }
    // Inserts a given word into the trie
    public void insert(String word)
    {
        // Start from root node of the trie
        Node currentNode = root;
        int index = 0;
        // Loops through each char in a given word
        for(char c: word.toCharArray())
        {
            index = (int) c;
            // If there is no existing node for this character,
            // create a new one in the children array
            if(currentNode.getChildren()[index] == null)
            {
                currentNode.getChildren()[index] = new Node();
            }
            // Move down to the child node corresponding to this character
            currentNode = currentNode.getChildren()[index];
        }
        // Mark the final node in the word as the end of a word
        currentNode.setWord(true);
    }
    // Checks whether a given word is in the trie
    public boolean lookUp(String word)
    {
        Node currentNode = root;
        int index = 0;
        for(char c: word.toCharArray())
        {
            index = (int) c;
            // If the index is outside the valid ASCII range
            // or the current node does not have a child for this character,
            // the word does not exist in the trie so return false
            if(index >= SpellCheck.EXT_ASCII_LENGTH || currentNode.getChildren()[index] == null)
            {
                return false;
            }
            // Moves to the next node in the word
            currentNode = currentNode.getChildren()[index];
        }
        return currentNode.isWord();
    }
}
