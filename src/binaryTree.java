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
        tree.deleteByCopy(9);
       // System.out.println(tree.root.left.right.data);
        //tree.postOrderTraversal();
       tree.breathFirstTraversal();
        System.out.println("jjjjjjjjjj");
        System.out.println(tree.size(tree.root));
        System.out.println(tree.height(tree.root));

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
        while (temp.left !=null){
                temp=temp.left;

        }
        binaryTreeNode Node =temp;

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


    public void deleteByCopy(int val){
        deletionByCoping(root,val);
    }
    public binaryTreeNode deletionByCoping(binaryTreeNode root, int val){
    if(root!=null){
        if (val<root.data){
            root.left= deletionByCoping(root.left,val);
        }else if(val>root.data){
            root.right= deletionByCoping(root.right,val);
        }else if(root.data==val){ // if root is the node to delete

            // leaf node then just delete
            if (root.left==null &&root.right==null){
                System.out.println("equal " + root.data);
                return null;
            }else if (root.right==null){// only left element then replace
                // we are going to replace data instead of the objects
                root.data = root.left.data;
                root.left= null;
                return root;
            }else if(root.left==null){// only right element exists
                root.data =root.right.data;
                root.right=null;
                return root;
            }else if(root.right!=null && root.left!=null){
                // this is not necessary use just else
                    root.data = findSuccessor(root).data;// gives the left most element of the subtree
                    // find predecessor deletes the connection of left most element
                    root.left = deletionByCoping(root.left,root.data);
                    return root;
            }
        }

    }
    return root;
    }
//// todo:this one is not working idk the below
//    binaryTreeNode deleteByCopyImp(binaryTreeNode root, int val) {
//        if (root != null) {
//            if (val < root.data) {
//                root.left = deleteByCopyImp(root.left, val);
//
//            }else if (val > root.data) {
//                root.left = deleteByCopyImp(root.right, val);
//
//            }else {
//                if(root.left==null && root.right==null){
//                    return null;
//                }else if(root.left==null){
//                    root.data=root.right.data;
//                    root.right =null;
//                    return root;
//                }else if(root.right==null){
//                    root.data=root.left.data;
//                    root.left =null;
//                    return root;
//
//                }else {
//                    //find
//                    root.data = findSuccessor(root).data;// gives the left most element of the subtree
//                    // find predecessor deletes the connection of left most element
//                    root.left = deleteByCopyImp(root.left,root.data);
//                    return root;
//
//                }
//            }
//
//        }
//        return root;
//    }

    public int size(binaryTreeNode root){
        if(root!=null){
            return size(root.left) +1 +size(root.right);
        }else {
            return 0;
        }
    }

    public int height(binaryTreeNode root){
        if(root!=null){
            if (height(root.left)<height(root.right)){
                return height(root.right)+1;
            }else {
                return height(root.left)+1;
            }

        }else {
            return 0;
        }
    }
}
