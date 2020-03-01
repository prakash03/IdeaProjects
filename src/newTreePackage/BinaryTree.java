package newTreePackage;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTree {
    TreeNode root;

    TreeNode insertInTree(TreeNode root, int key){
        // This insertion logic isn't quiet optimal solution. In the sense that is doesn't provide a height balance BST.
        // In the worst case, we could be adding elements to the tree in a way where every node ends up with only one child
        // and the resulting insertion takes O(n) runtime as opposed to O(logn).
        if(root == null){
            return new TreeNode(key);
        }

        if(root.val > key){
            root.left = insertInTree(root.left, key);
        }
        else root.right = insertInTree(root.right, key);

        return root;
    }

    void inOrderTraversal() { inOrderTraversal(root); }

    void inOrderTraversal(TreeNode root){
        if(root != null){
            inOrderTraversal(root.left);
            System.out.println(root.val);
            inOrderTraversal(root.right);
        }
    }

    // Static inOrder tree traversal
    static void inOrderStaticTraversal(TreeNode root){
        if(root != null){
            inOrderStaticTraversal(root.left);
            System.out.println(root.val);
            inOrderStaticTraversal(root.right);
        }
    }

    List<List<Integer>> zigZagLevelTraversal() {
        return zigZagLevelTraversal(root);
    }

    List<List<Integer>> zigZagLevelOrderTraversal(TreeNode root){
        if(root == null) return new LinkedList<List<Integer>>();

        LinkedList<TreeNode> node_queue = new LinkedList<>();
        LinkedList<Integer> levelList = new LinkedList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        node_queue.addLast(root);
        node_queue.addLast(null);

        boolean is_order_left = true;

        while(node_queue.size() > 0){
            TreeNode currentNode = node_queue.pollFirst();

            if(currentNode != null){
                if(is_order_left){
                    levelList.addLast(currentNode.val);
                }
                else levelList.addFirst(currentNode.val);

                if(currentNode.left != null){
                    node_queue.addLast(currentNode.left);
                }

                if(currentNode.right != null){
                    node_queue.addLast(currentNode.right);
                }
            }
            else {
                resultList.add(levelList);
                levelList = new LinkedList<>();
                if(node_queue.size() > 0) node_queue.addLast(null);
                is_order_left = !is_order_left;
            }
        }

        return resultList;
    }

    List<List<Integer>> zigZagLevelTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        if(root == null) return resultList;
        levelList.add(root.val);
        resultList.add(levelList);

        int level = 1;
        if(root.right != null) queue.add(root.right);
        if(root.left != null) queue.add(root.left);

        while(queue.size() != 0){
            Queue<TreeNode> newQueue = new LinkedList<>();
            levelList = new ArrayList<>();
            if(level%2 != 0){
                while(queue.size() > 0){
                    TreeNode current = queue.poll();
                    levelList.add(current.val);
                    if(current.right != null) newQueue.add(current.right);
                    if(current.left != null) newQueue.add(current.left);
                }
                resultList.add(levelList);
                queue = newQueue;
                level++;
            }
            else {
                while(queue.size() > 0){
                    TreeNode current = queue.poll();
                    levelList.add(current.val);
                    if(current.right != null) newQueue.add(current.right);
                    if(current.left != null) newQueue.add(current.left);
                }
                Collections.reverse(levelList);
                resultList.add(levelList);
                queue = newQueue;
                level++;
            }
        }
        return resultList;
    }

//    List<Integer> ascendingOrder(TreeNode root)
//    {
//        List<Integer> list = new LinkedList<>();
//
//        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
//
//        while (true) {
//            while (root != null) {
//                stack.add(root);
//                root = root.left;
//            }
//            root = stack.removeLast();
//            list.add(root.val);
////            if (--k == 0) return root.val;
//            root = root.right;
//        }
//
//        return list;
//    }

    // Constructs a Balanced BST
    static TreeNode constructBST(int[] keys){
        Arrays.sort(keys);

        return (keys.length > 0) ? constructBalancedBST(keys, 0, keys.length-1) : null;
    }


    static TreeNode constructBalancedBST(int[] keys, int start, int end) {
        if(start == end){
            return new TreeNode(keys[start]);
        }
        int mid_element = (end + start) / 2;

        TreeNode root = new TreeNode(keys[mid_element]);


        if(mid_element > start){
            root.left = constructBalancedBST(keys, start, mid_element-1);
        }
        if(mid_element < end){
            root.right = constructBalancedBST(keys, mid_element + 1, end);
        }
        return root;
    }


    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(5);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(10);
        tree.root.left.left = new TreeNode(2);
        tree.root.left.right = new TreeNode(4);
        tree.root.right.left = new TreeNode(7);
        tree.root.right.right = new TreeNode(15);

//        tree.inOrderTraversal();

        // ------ Zig Zag Traversal testing------
//        List<List<Integer>> result = tree.zigZagLevelOrderTraversal(tree.root);
//
//        for(List<Integer> list : result){
//            System.out.println(Arrays.toString(list.toArray()));
//        }

        // ------ Insertion into a BST testing below ---------
//        System.out.println("Before Inserting");
//        tree.inOrderTraversal();
//
//        tree.insertInTree(tree.root, 10);
//
//        System.out.println("After inserting:");
//        tree.inOrderTraversal();

        // -------- Construction of a Balanced BST testing below ------
        int[] keys = new int[] {7,15,10,4,3,5};
        int[] keys2 = new int[0];
        TreeNode root_found = constructBST(keys2);

        System.out.println("---- Tree constructed ----");
        inOrderStaticTraversal(root_found);
    }
}
