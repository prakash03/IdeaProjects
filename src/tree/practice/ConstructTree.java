package tree.practice;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class Index {
    int index;
}

class ConstructTree {
    TreeNode root;
    int preOrderIndex = 0;
    int postOrderIndex = 7;

    int search(int[] inOrder, int start, int end, int val) {
        int i = start;
        for(; i <= end; i++){
            if(inOrder[i] == val){
//                System.out.println(i);
                return i;
            }
        }
        return i;
    }

    TreeNode buildTreeFromInOrderPreOrder(int[] inOrder, int[] preOrder, int start, int end){

        if(start > end) { return null; }

        TreeNode root = new TreeNode(preOrder[preOrderIndex++]);
//        System.out.println(root.val);


        if(start == end){
            return root;
        }

        int indexInOrder = search(inOrder, start, end, root.val);
        root.left = buildTreeFromInOrderPreOrder(inOrder, preOrder, start, indexInOrder-1);
        root.right = buildTreeFromInOrderPreOrder(inOrder, preOrder, indexInOrder+1, end);

        return root;
    }

    TreeNode buildTreeFromInOrderPostOrder(int[] inOrder, int[] postOrder, int start, int end, Index postOrderIndex){

        if(start > end) { return null; }

        TreeNode root = new TreeNode(postOrder[postOrderIndex.index]);
        (postOrderIndex.index)--;

        if(start == end){
            return root;
        }

        int indexInOrder = search(inOrder, start, end, root.val);

        root.right = buildTreeFromInOrderPostOrder(inOrder, postOrder, indexInOrder+1, end, postOrderIndex);
        root.left  = buildTreeFromInOrderPostOrder(inOrder, postOrder, start, indexInOrder-1, postOrderIndex);

        return root;
    }

    TreeNode buildTreeFromInOrderPostOrder(int[] inOrder, int[] postOrder){
        Index postOrderIndex = new Index();
        postOrderIndex.index = inOrder.length-1;
        return buildTreeFromInOrderPostOrder(inOrder, postOrder, 0, inOrder.length-1, postOrderIndex);
    }

    void inOrderTraversal() { inOrderTraversal(root); }

    void inOrderTraversal(TreeNode root) {
        if(root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.val);
            inOrderTraversal(root.right);
        }
    }

    void postOrderTraversal(TreeNode root){
        if(root != null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.val);
        }
    }

    public static void main(String[] args){
        int[] inOrder = new int[] {1,3,4,5,6,7,10,12};
        int[] preOrder = new int[] {5,3,1,4,10,7,6,12};
        int[] postOrder = new int[] {1,4,3,6,7,12,10,5};

        ConstructTree tree = new ConstructTree();
        TreeNode root = tree.buildTreeFromInOrderPreOrder(inOrder, preOrder, 0, inOrder.length-1);



        System.out.println("-------- InOrder Traversal ---------");
        tree.inOrderTraversal(root);

//        System.out.println("--------- PostOrder Traversal --------");
//        tree.postOrderTraversal(root);

        ConstructTree tree2 = new ConstructTree();
        TreeNode root2 = tree2.buildTreeFromInOrderPostOrder(inOrder, postOrder);

        System.out.println("-------- InOrder Traversal ---------");
        tree2.inOrderTraversal(root2);

    }
}
