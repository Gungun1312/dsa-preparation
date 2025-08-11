import java.util.*;

class Node{
    int data;
    Node left, right;
    Node(int data) {
        data = item;
        left = right = null;
    }
}    
public class Main{
    static int index = 0;

    static Node BuildTree(int [] preorder){
        if(index == preorder.length || preorder[index] == -1) {
            index++;
            return null;
        }
        Node root = new Node(preorder[index++]);
        root.left = BuildTree(preorder);
        root.right = BuildTree(preorder);
        return root;
    }
    static void preorder(Node root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the preorder traversal: ");
        int n = sc.nextInt();
        int[] preorder = new int[n];
        System.out.println("Enter the elements of the preorder traversal (use -1 for null):");
        for(int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }
        
        Node root = BuildTree(preorder);
        System.out.println("Preorder traversal of the constructed tree:");
        preorder(root);
        sc.close();
    }
}