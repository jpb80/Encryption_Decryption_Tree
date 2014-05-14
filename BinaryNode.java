/** Jordan Buttkevitz
 *  University of Pittsburgh
 *  Data Structures
 *  Project: Tree
 * */

public class BinaryNode<T> implements BinaryNodeInterface<T> {
    public T data;
    public BinaryNode<T> right;
    public BinaryNode<T> left;
    
    public BinaryNode() {
        this(null); //this calls the next constructor
    } //end default constructor

    public BinaryNode(T dataPortion) {
        this(dataPortion,null, null); // calls the next constructor
    }//end constructor
   
    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.left = left;
        this.right = right;
        this.data = data;
    }//end constructor

    public T getData() {
        return data; 
    } //end getData
        
    public void setData(T newEntry) {
        data = newEntry;
    }

    public BinaryNode<T> getLeftChild() {
        return left;
    }
    public BinaryNode<T> getRightChild() {
        return right;
    }

    public void setLeftChild(BinaryNode<T> leftChild) {
        left = leftChild;
    }

    public void setRightChild(BinaryNode<T> rightChild) {
        right = rightChild;
    }

    public boolean hasLeftChild() {
        return left != null;
    }

    public boolean hasRightChild() {
        return right != null;
    }

    public boolean hasLeaf() {
        return (left == null) && (right == null);
    }

    public int getNumberOfNodes() {
        return getNumberOfNodes(this);        
    } //end of getNumberOfNodes

    public int getHeight() {
        return getHeight(this);
    } //end getHeight

    public BinaryNodeInterface<T> copy() {
        BinaryNode<T> newRoot = new BinaryNode<T>(data);
        
        if (left != null) {
            newRoot.left = (BinaryNode<T>) left.copy();
        }

        if (right != null) {
            newRoot.right = (BinaryNode<T>) right.copy(); 
        } 
        return newRoot;
    } //end copy

    private int getHeight(BinaryNode<T> node) {
        int height = 0;

        if (node != null) {
            height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }
        return height;
    } //end getHeight

    private int getNumberOfNodes(BinaryNode<T> node) {
        int leftNumber = 0;
        int rightNumber = 0;

        if (left != null) {
            leftNumber = left.getNumberOfNodes();
        }

        if (right != null) {
            rightNumber = right.getNumberOfNodes();
        }

        return 1 + leftNumber + rightNumber;
    }// end getNumberOfNodes
} //end BinaryNode
