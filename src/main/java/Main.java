public class Main {
    public static void main(String[] args) {
        NodeBST nodeBST = new NodeBST(10);

        nodeBST.insert(5);
        nodeBST.insert(15);
        nodeBST.insert(8);

        System.out.println(nodeBST.contains(8));
        System.out.println(nodeBST.contains(12));
        System.out.println("---------------");
        nodeBST.printInOrder();
        System.out.println("---------------");
        nodeBST.printPreOrder();
        System.out.println("---------------");
        nodeBST.printPostOrder();
    }
}
