/**
 * Created by awdesh on 4/26/17.
 */
class TreeNode{
    private TreeNode left;
    private TreeNode right;
    int val;
    int level;

    public TreeNode(int val){
        this.val = val;
    }

    public void setLeft(TreeNode left){
        this.left = left;
    }

    public void setRight(TreeNode right){
        this.right = right;
    }

    public TreeNode getLeft(){
        return left;
    }

    public TreeNode getRight(){
        return right;
    }
}

/**
 *
 */
public class Tree {
    TreeNode root;

    public Tree(int item){
        root = new TreeNode(item);
    }

    public TreeNode createBinaryTree(){
        TreeNode left1 = new TreeNode(10);
        TreeNode right1 = new TreeNode(30);
        TreeNode left1left2 = new TreeNode(60);
        TreeNode left1right2 = new TreeNode(80);
        TreeNode right1left2 = new TreeNode(90);
        TreeNode right1right2 = new TreeNode(40);
        root.setLeft(left1);
        root.setRight(right1);

        left1.setLeft(left1left2);
        left1.setRight(left1right2);

        right1.setLeft(right1left2);
        right1.setRight(right1right2);

        System.out.println(root.val);
        System.out.println(left1.val);
        System.out.println(right1.val);
        System.out.println(left1left2.val);
        System.out.println(left1right2.val);
        System.out.println(right1left2.val);
        System.out.println(right1right2.val);
        return root;
    }


    public TreeNode createBinaryTree1(){
        TreeNode left1 = new TreeNode(10);
        TreeNode right1 = new TreeNode(80);
        TreeNode left1left2 = new TreeNode(5);
        TreeNode left1right2 = new TreeNode(20);
        TreeNode right1left2 = new TreeNode(60);
        TreeNode right1right2 = new TreeNode(90);
        root.setLeft(left1);
        root.setRight(right1);

        left1.setLeft(left1left2);
        left1.setRight(left1right2);

        right1.setLeft(right1left2);
        right1.setRight(right1right2);

        System.out.println(root.val);
        System.out.println(left1.val);
        System.out.println(right1.val);
        System.out.println(left1left2.val);
        System.out.println(left1right2.val);
        System.out.println(right1left2.val);
        System.out.println(right1right2.val);
        return root;
    }

    public TreeNode createBinaryTree2(){
        TreeNode left1 = new TreeNode(10);
//        TreeNode right1 = new TreeNode(80);
        TreeNode left1left2 = new TreeNode(5);
        TreeNode left1right2 = new TreeNode(20);
//        TreeNode right1left2 = new TreeNode(60);
//        TreeNode right1right2 = new TreeNode(90);
        root.setLeft(left1);
//        root.setRight(right1);
//
        left1.setLeft(left1left2);
        left1.setRight(left1right2);
//
//        right1.setLeft(right1left2);
//        right1.setRight(right1right2);

        System.out.println(root.val);
//        System.out.println(left1.val);
//        System.out.println(right1.val);
//        System.out.println(left1left2.val);
//        System.out.println(left1right2.val);
//        System.out.println(right1left2.val);
//        System.out.println(right1right2.val);
        return root;
    }


    /**
     *
     * @param runner NLR
     */
    public void preOrderTraversal(TreeNode runner){
        if(runner == null){
            return;
        }
        System.out.println(runner.val);
        preOrderTraversal(runner.getLeft());
        preOrderTraversal(runner.getRight());
    }

    /**
     *
     * @param runner LNR
     */
    public void inorderTraversal(TreeNode runner){
        if(runner == null){
            return;
        }
        inorderTraversal(runner.getLeft());
        System.out.println(runner.val);
        inorderTraversal(runner.getRight());
    }

    /**
     *
     * @param runner LRN
     */
    public void postOrderTraversal(TreeNode runner){
        if(runner == null){
            return;
        }
        postOrderTraversal(runner.getLeft());
        postOrderTraversal(runner.getRight());
        System.out.println(runner.val);
    }

    public boolean isBST(TreeNode root)
    {
        if (root == null){
            return true;
        }

        if(root.getLeft() != null)
        {
            if(root.val < root.getLeft().val)
                return false;
        }

        if(root.getRight() != null)
        {
            if(root.val > root.getRight().val)
                return false;
        }

        // both left and right subtrees requires different boolean vars
        // which will contains boolean value of the result of the recursive calls.
        boolean val1 = isBST(root.getLeft());
        boolean val2 = isBST(root.getRight());

        return val1 && val2;

//        or above three lines can be shrunk down to one below.
//        return (isBST(root.getLeft()) && isBST(root.getRight()));
    }

    public boolean hasPathSum(TreeNode node, int sum)
    {
        if(node == null)
            return (sum == 0);

        else
        {
            sum = sum - node.val;
            // base case.
            if (sum == 0 && node.getRight() == null && node.getLeft() == null)
                return true;

            boolean val1 = hasPathSum(node.getLeft(), sum);
            boolean val2 = hasPathSum(node.getRight(), sum);

            return val1 || val2;
        }
    }


    public int maxHeight(TreeNode node)
    {
        if(node == null)
            return 0;

        int left_height = maxHeight(node.getLeft());
        int right_height = maxHeight(node.getRight());

        return (left_height > right_height) ? left_height + 1 : right_height + 1;

        // or line 220 - 223 can be replaced with below-:
        // return (maxHeight(root.getLeft()) > maxHeight(root.getRight()) ? maxHeight(root.getLeft()) : maxHeight(root.getRight()));
    }

    private int maxHeight1(TreeNode node)
    {
        return (node == null) ? 0 : 1 + Math.max(maxHeight1(node.getLeft()), maxHeight1(node.getRight()));
    }

    public boolean isHeightBalanced(TreeNode node)
    {
        if(node == null)
            return true;

        int left_height = maxHeight(node.getLeft());
        int right_height = maxHeight(node.getRight());

        return Math.abs(left_height - right_height) <= 1 ? true : false;

//        if (Math.abs(left_height - right_height) <= 1)
//            return true;
//        else
//            return false;
    }
}

class treeClient {
    public static void main(String[] args) {
        Tree tree = new Tree(50);
        TreeNode runner = tree.createBinaryTree2();
        System.out.println("===============");
        tree.preOrderTraversal(runner);
        System.out.println("===============");
        tree.inorderTraversal(runner);
        System.out.println("===============");
        tree.postOrderTraversal(runner);
        System.out.println("===============");

        System.out.println("Max. Height of Tree is-: ");
        System.out.println(tree.maxHeight(runner));
        System.out.print("Tree contains sum: 65 and it's-: ");
        System.out.println(tree.hasPathSum(runner,65));
        System.out.print("Tree contains sum: 80 and it's-: ");
        System.out.println(tree.hasPathSum(runner,80));
        System.out.print("Tree contains sum: 60 and it's-: ");
        System.out.println(tree.hasPathSum(runner,60));
        System.out.print("Tree contains sum: 190 and it's-: ");
        System.out.println(tree.hasPathSum(runner,190));
        System.out.print("Tree contains sum: 82 and it's-: ");
        System.out.println(tree.hasPathSum(runner,82));
        System.out.print("Tree contains sum: 220 and it's-: ");
        System.out.println(tree.hasPathSum(runner,220));

        System.out.println("===============");

        System.out.println("Tree is Height Balanced-: ");
        System.out.println(tree.isHeightBalanced(runner));







//        boolean isBST =  tree.isBST(runner);
//        String isABST = "Is A BST";
//        String notBST = "NOT A BST";
//        String val = (isBST == true) ? isABST : notBST;
//        System.out.println(val);
////        System.out.println(isBST);

//        tree.preOrderTraversal(runner);
//        System.out.println("===============");
//        tree.inorderTraversal(runner);
//        System.out.println("===============");
//        tree.postOrderTraversal(runner);
    }
}

