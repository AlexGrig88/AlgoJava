package codewars;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoopInspector {

    public static void main(String[] args) {

        Node node7 = new Node();
        Node node6 = new Node(node7);
        Node node5 = new Node(node6);
        Node node4 = new Node(node5);
        Node node3 = new Node(node4);
        Node node2 = new Node(node3);
        Node node1 = new Node(node2);

        Node target = node3;

        List<Node> list = new ArrayList<>(Arrays.asList(node1,node2,node3,node4,node5));
        System.out.println(list.contains(target));
        System.out.println(list.indexOf(target));

    }


    public int loopSize(Node node) {
        List<Node> list = new ArrayList<>();
        list.add(node);
        Node nextNode = node.getNext();
        while (true) {
            if (list.contains(nextNode)) {
                return list.size() - list.indexOf(nextNode);
            } else {
                list.add(nextNode);
            }
            nextNode = nextNode.getNext();
        }
    }

}

class Node {
    Node next = null;
    public Node(Node n) {
        next = n;
    }
    public Node() {}

    public Node getNext() {
        return null;
    }
}