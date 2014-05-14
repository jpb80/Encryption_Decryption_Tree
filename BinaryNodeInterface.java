/** Jordan Buttkevitz
 *  University of Pittsburgh
 *  Data Structures
 *  Project: Tree
 * */

public interface BinaryNodeInterface<T> {
    public T getData();

    public void setData(T newEntry );

    public BinaryNodeInterface<T> getLeftChild();

    public BinaryNodeInterface<T> getRightChild();    

    public void setLeftChild(BinaryNode<T> leftChild);

    public void setRightChild(BinaryNode<T> rightChild);

    public boolean hasLeftChild();

    public boolean hasRightChild();

    public boolean hasLeaf();
    
    public int getNumberOfNodes();

    public int getHeight();

    public BinaryNodeInterface<T> copy();

}//end BinaryNodeInterface
