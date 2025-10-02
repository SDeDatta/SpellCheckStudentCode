public class Node
{
    boolean isWord;
    Node[] next;

    public Node(boolean isWord2, Node[] next2)
    {
        isWord = isWord2;
        next = next2;
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
