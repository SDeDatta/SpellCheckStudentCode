public class Node
{
    boolean isWord;
    Node[] next;

    public Node()
    {
        isWord = false;
        next = new Node[27];
    }

    public boolean isWord()
    {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public Node[] getNext() {
        return next;
    }
}
