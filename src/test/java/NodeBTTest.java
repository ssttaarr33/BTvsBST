import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class NodeBTTest {
    private NodeBT nodeBT;

    @BeforeEach
    public void setUp() {
        nodeBT = new NodeBT(1);
        nodeBT.left = new NodeBT(2);
        nodeBT.right = new NodeBT(3);
        nodeBT.left.left = new NodeBT(4);
        nodeBT.left.right = new NodeBT(5);
        nodeBT.right.left = new NodeBT(6);
        nodeBT.right.right = new NodeBT(7);
    }

    @Test
    @DisplayName("LCA for BT tree")
    public void testLCABT() {
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();
        assertEquals(2, nodeBT.getLCA(nodeBT, 4, 5, path1, path2));
        assertEquals(1, nodeBT.getLCA(nodeBT, 4, 6, path1, path2));
        assertEquals(1, nodeBT.getLCA(nodeBT, 3, 4, path1, path2));
        assertEquals(2, nodeBT.getLCA(nodeBT, 2, 4, path1, path2));
        assertNotEquals(2, nodeBT.getLCA(nodeBT, 6, 7, path1, path2));
    }

    @Test
    @DisplayName("LCA for BT tree from node")
    public void testLCABTFromNode() {
        assertEquals(2, nodeBT.getLCAFromNode(nodeBT, 4, 5).data);
        assertEquals(1, nodeBT.getLCAFromNode(nodeBT, 4, 6).data);
        assertEquals(1, nodeBT.getLCAFromNode(nodeBT, 3, 4).data);
        assertEquals(2, nodeBT.getLCAFromNode(nodeBT, 2, 4).data);
        assertNotEquals(2, nodeBT.getLCAFromNode(nodeBT, 6, 7).data);
    }
}
