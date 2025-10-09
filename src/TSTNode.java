public class TSTNode
{

    TSTNode[] children;
    boolean isWord;
    char c;
    public TSTNode(char c2)
    {
        children = new TSTNode[3];
        isWord = false;
        c = c2;
    }

    public char getC() {
        return c;
    }

    public boolean isWord()
    {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }
    public TSTNode getChild(int spot)
    {
        return children[spot];
    }
    public void setChild(char c3, int spot) {
        this.children[spot] = new TSTNode(c3);
    }

    public TSTNode[] getChildren() {
        return children;
    }
}
