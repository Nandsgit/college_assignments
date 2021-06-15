public class FHsdTree<E> extends FHtree<E> implements Cloneable {
 
    public int sizePhysical() {
        return super.size();
    }
 
    public boolean empty() {
        return size() == 0;
    }
 
    public FHsdTreeNode<E> addChild(FHsdTreeNode<E> treeNode, E s) {
 
        // is tree null?
        if (mSize == 0) {
            if (treeNode != null) {
                return null;
            }
            this.mRoot = new FHsdTreeNode<E>(s, null, null, null, false);
            ((FHsdTreeNode<E>) mRoot).setRoot(mRoot);
            mSize = 1;
            return (FHsdTreeNode<E>) mRoot;
        }
 
        // is node null?
        if (treeNode == null) {
            return null;
        }
 
        // is the root set/does root belong to tree?
        if (treeNode.getRoot() != mRoot) {
            return null;
        }
 
        // initialize sd node
        FHsdTreeNode<E> sdNode = new FHsdTreeNode<E>(s, treeNode.getFirstChild(), null, treeNode, false);
 
        // set root for sd node
        sdNode.setRoot(mRoot);
 
        // set firstChild for sd node
        sdNode.setFirstChild(sdNode);
 
        // set previous sibling
        if (sdNode.getSibling() != null) {
            sdNode.getSibling().setPrevious(sdNode);
        }
 
        ++mSize;
        return (FHsdTreeNode<E>) sdNode;
    }
 