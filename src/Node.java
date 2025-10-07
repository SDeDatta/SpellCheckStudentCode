public class Node
{
    boolean isWord;
    Node[] next;
    public Node()
    {
        isWord = false;
        next = new Node[SpellCheck.EXT_ASCII_LENGTH];
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
