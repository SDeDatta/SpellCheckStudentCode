public class Trie
{
    private class Node
    {
        boolean isWord;
        Node[] children;
        public Node()
        {
            isWord = false;
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

    public void insert(String word)
    {
        Node currentNode = root;
        boolean found = false;
        int index = 0;
        for(char c: word.toCharArray())
        {
            index = (int) c;
            if(currentNode.getChildren()[index] == null)
            {
                currentNode.getChildren()[index] = new Node();
            }
            currentNode = currentNode.getChildren()[index];
        }
        currentNode.setWord(true);
    }

    public boolean lookUp(String word)
    {
        Node currentNode = root;
        int index = 0;
        for(char c: word.toCharArray())
        {
            index = (int) c;
            if(index < 0 || index >= SpellCheck.EXT_ASCII_LENGTH || currentNode.getChildren()[index] == null)
            {
                return false;
            }
            currentNode = currentNode.getChildren()[index];
        }
        return currentNode.isWord();
    }
}
