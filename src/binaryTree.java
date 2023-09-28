public class binaryTree {
    binaryTreeNode root;

    public static void main(String[] args) {
        binaryTree tree = new binaryTree();
        tree.root = new binaryTreeNode(7);
        tree.insertion(3);
        tree.insertion(4);
        tree.insertion(1);
        System.out.println(tree.root.left.right.data);
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

}
