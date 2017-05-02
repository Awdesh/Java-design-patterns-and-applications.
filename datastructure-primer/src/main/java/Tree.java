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
}

class treeClient {
    public static void main(String[] args) {
        Tree tree = new Tree(50);
        TreeNode runner = tree.createBinaryTree();
        System.out.println("===============");
        tree.preOrderTraversal(runner);
        System.out.println("===============");
        tree.inorderTraversal(runner);
        System.out.println("===============");
        tree.postOrderTraversal(runner);
    }
}

