package algorhytms;

import lombok.Data;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
The input is a list of names in random order. We need a function that chains elements of the list in such a way that the last character of an name is the same as the first one of the next name.

For instance:

Input: [“Raymond”, “Nora”, “Daniel”, “Louie”, “Peter”, “Esteban”]
Output: [“Peter”, “Raymond”, “Daniel”, “Louie”, “Esteban”, “Nora”]
There should be only one solution, so the first element is unique.
 */
public class OrderNames {
    public List<String> orderNamesLinkedList(List<String> names) {
        NodeName node = new NodeName(names.get(0));
        names = names.subList(1, names.size());

        names.stream().forEach(name -> {
            char b = node.value.charAt(0);
            char f = node.value.charAt(node.value.length() - 1);
            if (f == name.charAt(0) && node.right == null) {
                assembleNodeRight(name, node);
            }
            if (b == name.charAt(name.length() - 1) && node.left == null) {
                assembleNodeLeft(name, node);
            }
        });

        List<String> collect = clearList(node, names);

        NodeName currentNode = node.right;

        while (collect.size() > 0) {
            currentNode = assembleNode(collect, currentNode).right;
            collect = clearList(node, names);
        }

        return assembleList(node);
    }

    private NodeName assembleNodeLeft(String name, NodeName nodeName){
        NodeName nodeLeft = new NodeName(name);
        nodeLeft.right = nodeName;
        nodeName.left = nodeLeft;
        return nodeName;
    }

    private NodeName assembleNodeRight(String name, NodeName nodeName){
        NodeName nodeRight = new NodeName(name);
        nodeRight.left = nodeName;
        nodeName.right = nodeRight;
        return nodeName;
    }

    private NodeName assembleNode(List<String> names, NodeName node) {
        names.stream().forEach(name -> {
                    char f = node.value.charAt(node.value.length() - 1);
                    if (name.charAt(0) == f) {
                        assembleNodeRight(name, node);
                    }
                }
        );
        return node;
    }

    private List<String> assembleList(NodeName root) {
        NodeName head = root.left;
        List<String> ordered = new ArrayList<>();
        while (head != null) {
            ordered.add(head.value);
            head = head.right;
        }
        return ordered;
    }

    private List<String> clearList(NodeName root, List<String> names) {
        NodeName head = root.left;
        while (head != null) {
            if (names.contains(head.value)) {
                names.remove(names.indexOf(head.value));
            }
            head = head.right;
        }
        return names;
    }


    class NodeName {
        String value;
        NodeName left, right;

        public NodeName(String name) {
            this.value = name;
            left = null;
            right = null;
        }
    }
}
