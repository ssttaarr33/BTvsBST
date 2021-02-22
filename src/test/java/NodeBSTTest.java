import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeBSTTest {
    private NodeBST nodeBST;

    @BeforeEach
    public void setUp(){
        nodeBST = new NodeBST(20);

        nodeBST.insert(8);
        nodeBST.insert(22);
        nodeBST.insert(4);
        nodeBST.insert(12);
        nodeBST.insert(10);
        nodeBST.insert(14);
    }

    @Test
    @DisplayName("Insertion & Contain test")
    public void testInsertion(){
        nodeBST.insert(6);
        assertTrue(nodeBST.contains(6), "Value should be contained");
        assertFalse(nodeBST.contains(7), "Value should not be contained");
    }

    @Test
    @DisplayName("Test LCA")
    public void testLca(){
        assertEquals(12, nodeBST.getLCA(nodeBST, 10, 14).data);
        assertEquals(8, nodeBST.getLCA(nodeBST, 8, 14).data);
        assertEquals(20, nodeBST.getLCA(nodeBST, 10, 22).data);
    }
}
