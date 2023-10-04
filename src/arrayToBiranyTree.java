public class arrayToBiranyTree {

    public static void main(String[] args) {
        binaryTree tree = new binaryTree();
        int[] arr = new int[]{1,2,3,4,5,6};
        tree.root = treeFromArray(arr,0);
        tree.breathFirstTraversal();
        System.out.println(leftMostElement(tree.root));
    }
    static binaryTreeNode treeFromArray(int[] arr, int index){ // returns the root of that array
        if(index<arr.length){
            binaryTreeNode root = new binaryTreeNode(arr[index]);
            root.left = treeFromArray(arr,2*index+1);
            root.right =treeFromArray(arr,2*index+2);
            return root;
        }else {
            return null;
        }
    }

    static int leftMostElement(binaryTreeNode root){
        if(root.left !=null){
            return leftMostElement(root.left);
        }else {
            return root.data;
        }
    }
}
