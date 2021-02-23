import java.util.List;

public class NodeBT {
    NodeBT left, right;
    int data;


    public NodeBT(int data) {
        this.data = data;
    }

    public int getLCA(NodeBT n, int n1, int n2, List<Integer> path1, List<Integer> path2) {
        path1.clear();
        path2.clear();
        return findLCA(n, n1, n2, path1, path2);
    }

    private int findLCA(NodeBT node, int n1, int n2, List<Integer> path1, List<Integer> path2) {
        if (!findPath(node, n1, path1) || !findPath(node, n2, path2)) {
            return -1;
        }
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i))) {
                break;
            }
        }
        return path1.get(i - 1);
    }

    private boolean findPath(NodeBT node, int n, List<Integer> path) {
        if (node == null) {
            return false;
        }
        path.add(node.data);
        if (node.data == n) {
            return true;
        }
        if (node.left != null && findPath(node.left, n, path)) {
            return true;
        }
        if (node.right != null && findPath(node.right, n, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public NodeBT getLCAFromNode(NodeBT nodeBT, int n1, int n2) {
        if (nodeBT == null) {
            return null;
        }
        if (nodeBT.data == n1 || nodeBT.data == n2) {
            return nodeBT;
        }
        NodeBT left = getLCAFromNode(nodeBT.left, n1, n2);
        NodeBT right = getLCAFromNode(nodeBT.right, n1, n2);
        if (left != null && right != null) {
            return nodeBT;
        }

        return (left != null) ? left : right;
    }

    void printLeafNodes(NodeBT node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            System.out.println(node.data + " ");
        }
        if(node.right != null){
            printLeafNodes(node.right);
        }
        if(node.left != null){
            printLeafNodes(node.left);
        }
    }
}
