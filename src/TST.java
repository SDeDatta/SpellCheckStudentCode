public class TST
{
    TSTNode root;
    public TST()
    {
        root = null;
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
        if (root == null) {
            root = new TSTNode(word.charAt(0));
        }
        TSTNode current = root;
        char c;
        int index = 0;
        while(current != null)
        {
            c = word.charAt(index);
            if(c > current.getC())
            {
                if(current.getChild(2) == null)
                {
                    current.setChild(c, 2);
                }
                current = current.getChild(2);
            }
            else if(c < current.getC())
            {
                if(current.getChild(0) == null)
                {
                    current.setChild(c, 0);
                }
                current = current.getChild(0);
            }
            else if (c == current.getC())
            {
                if(index == word.length() - 1)
                {
                    current.setWord(true);
                    break;
                }
                index++;
                if(current.getChild(1) == null)
                {
                    if(index < word.length())
                    {
                        current.setChild(word.charAt(index), 1);
                    }
                }
                current = current.getChild(1);
            }
        }
    }

    public boolean lookUp(String word)
    {
        if(word.isEmpty())
        {
            return false;
        }
        TSTNode current = root;
        char c;
        int index = 0;
        while(current != null)
        {
            c = word.charAt(index);
            if(c > current.getC())
            {
                    current = current.getChild(2);

            }
            else if(c < current.getC())
            {
                    current = current.getChild(0);
            }
            else if (c == current.getC())
            {
                if(index == word.length() - 1)
                {
                    return current.isWord;
                }
                index++;
                current = current.getChild(1);
            }
            }
        return false;
    }
}
