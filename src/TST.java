public class TST
{
    private class TSTNode
    {
        public static final int NUM_CHILDREN = 3;
        TSTNode[] children;
        boolean isWord;
        char c;
        public TSTNode(char c)
        {
            children = new TSTNode[NUM_CHILDREN];
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

    TSTNode root;
    public static final int LEFT_CHILD = 0;
    public static final int MIDDLE_CHILD = 1;
    public static final int RIGHT_CHILD = 2;

    public TST()
    {
        root = new TSTNode('m');
    }

    public TSTNode getRoot() {
        return root;
    }

    public void insert(String word)
    {
        if(word.isEmpty())
        {
            return;
        }
        TSTNode currentNode = root;
        char currentChar;
        int index = 0;
        while(currentNode != null)
        {
            currentChar = word.charAt(index);
            if(currentChar > currentNode.getC())
            {
                if(currentNode.getChild(RIGHT_CHILD) == null)
                {
                    currentNode.setChild(currentChar, RIGHT_CHILD);
                }
                currentNode = currentNode.getChild(RIGHT_CHILD);
            }
            else if(currentChar < currentNode.getC())
            {
                if(currentNode.getChild(LEFT_CHILD) == null)
                {
                    currentNode.setChild(currentChar, LEFT_CHILD);
                }
                currentNode = currentNode.getChild(LEFT_CHILD);
            }
            else
            {
                if(index == word.length() - 1)
                {
                    currentNode.setWord(true);
                    break;
                }
                index++;
                if(currentNode.getChild(MIDDLE_CHILD) == null)
                {
                    currentNode.setChild(word.charAt(index),  MIDDLE_CHILD);
                }
                currentNode = currentNode.getChild(MIDDLE_CHILD);
            }
        }
    }

    public boolean lookUp(String word)
    {
        if(word.isEmpty())
        {
            return false;
        }
        TSTNode currentNode = root;
        char currentChar;
        int index = 0;
        while(currentNode != null)
        {
            currentChar = word.charAt(index);
            if(currentChar > currentNode.getC())
            {
                currentNode = currentNode.getChild(RIGHT_CHILD);

            }
            else if(currentChar < currentNode.getC())
            {
                currentNode = currentNode.getChild(LEFT_CHILD);
            }
            else
            {
                if(index == word.length() - 1)
                {
                    return currentNode.isWord;
                }
                index++;
                currentNode = currentNode.getChild(MIDDLE_CHILD);
            }
            }
        return false;
    }
}
