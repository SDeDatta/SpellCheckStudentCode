public class Trie
{
    Node root;

    public Trie()
    {
        root = new Node();
    }

    public void insert(String word)
    {
        Node currentNode = root;
        boolean found = false;
        for(char c: word.toCharArray())
        {
            int num = c - 'a';
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
        for(char c: word.toCharArray())
        {
            int num = c - 'a';
            if(currentNode.getNext()[num] == null)
            {
                return false;
            }
            currentNode = currentNode.getNext()[num];
        }
        return currentNode.isWord();
    }
}
