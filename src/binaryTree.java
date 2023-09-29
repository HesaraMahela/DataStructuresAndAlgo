import java.util.Queue;
import java.util.LinkedList;

public class binaryTree {
    binaryTreeNode root;

    public static void main(String[] args) {
        binaryTree tree = new binaryTree();
        tree.root = new binaryTreeNode(7);
        tree.insertion(3);
        tree.insertion(4);
        tree.insertion(1);
        tree.insertion(9);
       // System.out.println(tree.root.left.right.data);
        //tree.postOrderTraversal();
       // tree.breathFirstTraversal();

    }

    public void insertion(int data){
        if (root==null){
            root = new binaryTreeNode(data);
        }else{
            insertImp(root,data);
        }
    }

    public void insertImp(binaryTreeNode root,int data){
        if (root!=null){

            if(root.data<data){
                if(root.right==null){
                    root.right = new binaryTreeNode(data);
                }else {
                    insertImp(root.right, data);
                }

            }
            if(root.data>data){
                if(root.left==null){
                    root.left = new binaryTreeNode(data);
                }else {
                    insertImp(root.left, data);
                }
            }

        }

    }




    public void inOrderTraversal(){
        inOrderTraversalImp(root);
    }
    public void inOrderTraversalImp(binaryTreeNode root){
        if(root!=null){
            inOrderTraversalImp(root.left);
            System.out.println(root.data);
            inOrderTraversalImp(root.right);

        }
    }

    public void preOrderTraversal(){
        preOrderTraversalImp(root);
    }
    public void preOrderTraversalImp(binaryTreeNode root){
        if(root!=null){
            System.out.println(root.data);
            preOrderTraversalImp(root.left);
            preOrderTraversalImp(root.right);
        }
    }

    public void postOrderTraversal(){
        postOrderTraversalImp(root);
    }
    public void postOrderTraversalImp(binaryTreeNode root){
        if(root!=null){
            postOrderTraversalImp(root.right);
            postOrderTraversalImp(root.left);
            System.out.println(root.data);
        }
    }

    public void breathFirstTraversal(){
        Queue<binaryTreeNode> queue = new LinkedList<binaryTreeNode>();
         queue.add(root);

        while(!queue.isEmpty()){
            binaryTreeNode treeNode = queue.remove();
            System.out.println(treeNode.data);
            if(treeNode.left !=null){
                queue.add(treeNode.left);
            }
            if(treeNode.right !=null){
                queue.add(treeNode.right);
            }
        }
    }

    private binaryTreeNode findPredecessor(binaryTreeNode temp){
        temp =temp.right;
        // go to the left most element of the subtree
        while (temp.left.left !=null){
                temp=temp.left;

        }
        binaryTreeNode Node =temp.left;
        temp.left = null;
        return Node;// returns predecessor
    }

    private  binaryTreeNode findSuccessor(binaryTreeNode root){
        root =root.left;
        while (root.right !=null){
            root=root.right;

        }
        binaryTreeNode Node =root;

        return Node;// returns predecessor
    }


    public void deletion(binaryTreeNode root, int val){
    if(root!=null){
        if (val<root.data){
            deletion(root.left,val);
        }else if(val>root.data){
            deletion(root.right,val);
        }else { // if root is the node to delete

            // leaf node then just delete
            if (root.left==null &&root.right==null){
                root=null;
            }else if (root.right==null){// only left element then replace
                // we are going to replace data instead of the objects
                root.data = root.left.data;
                root.left= null;
            }else if(root.left==null){// only right element exists
                root.data =root.right.data;
                root.right=null;
            }else if(root.right!=null && root.left!=null){// this is not necessary use just else
                root.data = findPredecessor(root).data;// gives the left most element of the subtree
                // find predecessor deletes the connection of left most element
            }
        }

    }
    }

    /*
    public void delete(int value){
        // if the node was a leaf node (no children)then just remove it
        binaryTreeNode parentNode= root;
        binaryTreeNode temp = root;
        while (temp !=null){
            if (value<temp.data){
                parentNode =temp;
                temp=temp.left;
            }else if( value>temp.data){
                parentNode =temp;
                temp = temp.right;
            }else {
                break;
            }
        } // traversal to find the node

        if (temp!=null){// node exists
            if(temp.left ==null && temp.right==null){
                if (parentNode.left == temp){
                    parentNode.left=null;
                } else {
                    parentNode.right=null;
                }
            }else if(temp.left ==null){
                // set right child to the parent directly
                if (parentNode.left == temp){
                    parentNode.left=temp.right;
                } else {
                    parentNode.right=temp.right;
                }

            }else if(temp.right ==null){
                // set right child to the parent directly
                if (parentNode.right == temp){
                    parentNode.right=temp.left;
                } else {
                    parentNode.left=temp.left;
                }

            }else {// todo: tow children case and somethings wrong i can feel it


            }

        }



    }
    */

}
