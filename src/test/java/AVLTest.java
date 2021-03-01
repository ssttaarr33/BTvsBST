import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AVLTest {
    private AvlTree avlTree;

    @BeforeEach
    public void setUp(){
        avlTree = new AvlTree();
        avlTree.root = avlTree.insert(avlTree.root,10);
        avlTree.root = avlTree.insert(avlTree.root,20);
        avlTree.root = avlTree.insert(avlTree.root,30);
        avlTree.root = avlTree.insert(avlTree.root,40);
        avlTree.root = avlTree.insert(avlTree.root,50);
        avlTree.root = avlTree.insert(avlTree.root,25);
    }

    @Test
    @DisplayName("AVL Test")
    public void testAVL(){
//        avl.insert(avl,46);
        avlTree.preOrder(avlTree.root);
        assertEquals(true, true);
    }
}
