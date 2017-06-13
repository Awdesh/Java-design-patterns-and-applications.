public class BinaryTree
{
  public BinaryTree Node;
  public BinaryTree left;
  public BinaryTree right;
  public int val;
  public int level;

  public BinaryTree(){
    Node = new BinaryTree();
  }

  public BinaryTree CreateBinaryTree(int[] ip){
    int len = ip.length;
    int mid = ip [ len / 2];

    Node.val  = ip[mid];
    Node.level = 0;

    BinaryTree left = new BinaryTree();
    left.val = ip[mid - 1];
    Node.left = left;

    BinaryTree right = new BinaryTree();
    right.val = ip[mid + 1];
    Node.right = right;

    return Node;
  }

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    int[] arr = new int[6];
    arr[0] = 1;
    arr[1] = 3;
    arr[2] = 4;
    arr[3] = 5;
    arr[4] = 6;
    arr[5] = 8;


    BinaryTree t =  tree.CreateBinaryTree(arr);
    System.out.println(t);

  }
}
