public class TSTNode
{

    TSTNode[] children;
    boolean isWord;
    char c;
    public TSTNode(char c)
    {
        children = new TSTNode[3];
        isWord = false;
        this.c = c;
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
    public void setChild(char c, int spot) {
        this.children[spot] = new TSTNode(c);
    }

    public TSTNode[] getChildren() {
        return children;
    }
}
