class AVL {
    int height, data;
    AVL right, left;

    AVL(int data) {
        this.data = data;
        height = 1;
    }


}

class AvlTree {
    AVL root;

    private int height(AVL node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int max(int a, int b) {
        return Math.max(a, b);
    }

    private AVL rightRotate(AVL y) {
        AVL x = y.left;
        AVL t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private AVL leftRotate(AVL y) {
        AVL x = y.right;
        AVL t2 = x.left;

        y.left = x;
        x.right = t2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return x;
    }

    private int getBalance(AVL n) {
        if (n == null) {
            return 0;
        }
        return height(n.left) - height(n.right);
    }

    AVL insert(AVL avl, int value) {
        if (avl == null) {
            return new AVL(value);
        }

        if (value < avl.data) {
            avl.left = insert(avl.left, value);
        } else if (value > avl.data) {
            avl.right = insert(avl.right, value);
        } else {
            return avl;
        }

        avl.height = 1 + max(height(avl.left), height(avl.right));
        int balance = getBalance(avl);

        if (balance > 1 && value < avl.left.data) {
            return rightRotate(avl);
        }
        if (balance < -1 && value > avl.right.data) {
            return leftRotate(avl);
        }
        if (balance > 1 && value > avl.left.data) {
            avl.left = leftRotate(avl.left);
            return rightRotate(avl);
        }
        if (balance < -1 && value < avl.right.data) {
            avl.right = rightRotate(avl.right);
            return leftRotate(avl);
        }
        return avl;
    }

    void preOrder(AVL avl) {
        if (avl != null) {
            System.out.println(avl.data + " ");
            preOrder(avl.left);
            preOrder(avl.right);
        }
    }

}
