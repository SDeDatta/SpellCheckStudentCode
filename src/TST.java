public class TST
{
    private class TSTNode
    {
        public static final int NUM_CHILDREN = 3;
        TSTNode[] children;
        boolean isWord;
        // Variable representing the char held at a given TST node
        char c;
        public TSTNode(char c)
        {
            // Creates a node
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
    // Each TST should have a root
    TSTNode root;
    public static final int LEFT_CHILD = 0;
    public static final int MIDDLE_CHILD = 1;
    public static final int RIGHT_CHILD = 2;
    // Makes the starting root of the TST "m" because it is the middle letter of the alphabet so the TST splits
    // more evenly and requires less checks
    public TST()
    {
        root = new TSTNode('m');
    }

    public TSTNode getRoot() {
        return root;
    }
    // Inserts a given word into the TST
    public void insert(String word)
    {
        // Ensures there is something in the string
        if(word.isEmpty())
        {
            return;
        }
        // Starts inserting from the root of the TST
        TSTNode currentNode = root;
        char currentChar;
        // Keeps track of which character of 'word' we’re at
        int index = 0;
        // Continue looping until there are no more nodes to follow
        while(currentNode != null)
        {
            currentChar = word.charAt(index);
            // 1st Case: currentChar is greater than the node’s character
            // Go or create a RIGHT child
            if(currentChar > currentNode.getC())
            {
                // If no right child exists, create one with the current character
                if(currentNode.getChild(RIGHT_CHILD) == null)
                {
                    currentNode.setChild(currentChar, RIGHT_CHILD);
                }
                // Move down to right child
                currentNode = currentNode.getChild(RIGHT_CHILD);
            }
            // 2nd Case: currentChar is less than the node’s character
            // Go or create a LEFT child
            else if(currentChar < currentNode.getC())
            {
                // If no left child exists, create one with the current character
                if(currentNode.getChild(LEFT_CHILD) == null)
                {
                    currentNode.setChild(currentChar, LEFT_CHILD);
                }
                // Move down to left child
                currentNode = currentNode.getChild(LEFT_CHILD);
            }
            else
            {
                // If we're at the last character of the word, mark the node as a word end
                if(index == word.length() - 1)
                {
                    currentNode.setWord(true);
                    break;
                }
                // Move to next character in the word
                index++;
                // If there’s no middle child yet, create one for the next character
                if(currentNode.getChild(MIDDLE_CHILD) == null)
                {
                    currentNode.setChild(word.charAt(index),  MIDDLE_CHILD);
                }
                // Move down to the middle child to continue inserting
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
        // Continue searching as long as we have a node to examine
        while(currentNode != null)
        {
            currentChar = word.charAt(index);
            // Goes through all the "cases" and follows the word through the TST
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
                // If at the end of the given word, see if it is an actual word
                if(index == word.length() - 1)
                {
                    return currentNode.isWord;
                }
                // Move to the next character in the word
                index++;
                currentNode = currentNode.getChild(MIDDLE_CHILD);
            }
            }
        return false;
    }
}
