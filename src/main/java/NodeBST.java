public class NodeBST {
    NodeBST left, right;
    int data;

    public NodeBST(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new NodeBST(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new NodeBST(value);
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contains(int value) {
        if (value == data) {
            return true;
        } else if (value < data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if(right == null){
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    public void printInOrder(){
        if(left != null){
            left.printInOrder();
        }
        System.out.println(data);
        if(right != null){
            right.printInOrder();
        }
    }

    public void printPreOrder(){
        System.out.println(data);
        if(left != null){
            left.printPreOrder();
        }
        if(right != null){
            right.printPreOrder();
        }
    }

    public void printPostOrder(){
        if(left != null){
            left.printPostOrder();
        }
        if(right != null){
            right.printPostOrder();
        }
        System.out.println(data);

    }

    public NodeBST getLCA(NodeBST n, int n1, int n2) {
        if (n == null) {
            return null;
        }
        if (n.data < n1 && n.data < n2) {
            return getLCA(n.right, n1, n2);
        } else if (n.data > n1 && n.data > n2) {
            return getLCA(n.left, n1, n2);
        }
        return n;
    }
}
