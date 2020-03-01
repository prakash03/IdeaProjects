package tree.practice;

import tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//protected class TreeNode{
//    int val;
//    TreeNode left, right;
//    TreeNode(int val){
//        this.val = val;
//        left = right = null;
//    }
//}
//
//public class GreaterTree {
//    TreeNode root;
//    List<Integer> nodesInTree = new ArrayList<>();
//    Integer[] originalTree;
//    Integer[] newTreeNodes;
//
//
//    void inOrderTraversal() {
//       inOrderTraversal(root);
//    }
//
//    void inOrderTraversal(TreeNode root){
//        if(root != null){
//            inOrderTraversal(root.left);
//            nodesInTree.add(root.val);
////            System.out.println(root.val);
//            inOrderTraversal(root.right);
//        }
//    }
//
//    int sum(int i, Integer[] nodesArray){
//        int result = 0;
//        for(int p = i; p < nodesArray.length; p++){
//            result += nodesArray[p];
//        }
//        return result;
//    }
//
//
//    Integer[] findGreaterNodeValues(Integer[] nodesArray){
//
//        for(int i=1; i < nodesArray.length; i++){
//            if(nodesArray[i-1] < nodesArray[i]){  //nodesArray could be just one element or 0 elements?
//                nodesArray[i-1] += sum(i, nodesArray);
//            }
//        }
//
//        return nodesArray;
//    }
//
//    void updateTree() { updateTree(root); }
//
//    void updateTree(TreeNode root) {
//        if(root != null){
//            updateTree(root.left);
////            System.out.println(nodesInTree.indexOf(root.data));
//            root.val = newTreeNodes[nodesInTree.indexOf(root.val)];
//            updateTree(root.right);
//        }
//    }
//
//
//    TreeNode convertBST(TreeNode root) {
//        inOrderTraversal();
//        Integer[] nodesArray = (Integer[]) nodesInTree.toArray(new Integer[nodesInTree.size()]);
//        originalTree = nodesArray;
//        System.out.println(Arrays.toString(nodesArray));
//        Integer[] updatedArray = findGreaterNodeValues(nodesArray);
//        System.out.println(Arrays.toString(updatedArray));
//
//
//        newTreeNodes = updatedArray;
//
//        updateTree();
//        return root;
//    }
//
//
//
//
//    public static void main(String[] args) {
//        GreaterTree tree = new GreaterTree();
//        tree.root = new TreeNode(5);
//        tree.root.left = new TreeNode(3);
//        tree.root.left.left = new TreeNode(1);
//        tree.root.left.right = new TreeNode(4);
//        tree.root.right = new TreeNode(9);
//        tree.root.right.left = new TreeNode(7);
//        tree.root.right.right = new TreeNode(11);
//
//        System.out.println("------------- InOrder traversal --------");
////        tree.inOrderTraversal();
//
//        System.out.printf("------Nodes array------");
//        System.out.println(tree.convertBST(tree.root).val);
//
//        tree.inOrderTraversal();
//    }
//}
