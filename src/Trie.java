public class Trie
{
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
        int num = 0;
        for(char c: word.toCharArray())
        {
            num = (int) c;
            if(currentNode.getNext()[num] == null)
            {
                currentNode.getNext()[num] = new Node();
            }
            currentNode = currentNode.getNext()[num];
        }
        currentNode.setWord(true);
    }

    public boolean lookUp(String word)
    {
        Node currentNode = root;
        int num = 0;
        for(char c: word.toCharArray())
        {
            num = (int) c;
            if(num < 0 || num >= SpellCheck.EXT_ASCII_LENGTH || currentNode.getNext()[num] == null)
            {
                return false;
            }
            currentNode = currentNode.getNext()[num];
        }
        return currentNode.isWord();
    }
}
