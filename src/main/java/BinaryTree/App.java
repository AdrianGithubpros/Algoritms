package BinaryTree;

public class App {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.addNode(10);
        tree.addNode(5);
        tree.addNode(20);
        tree.addNode(2);
        tree.addNode(8);
        tree.addNode(15);

        System.out.println(tree.getRoot().getValue());
        System.out.println("root \n");

        tree.inOrder(tree.getRoot());
        System.out.println("pierwsze \n");
        tree.preOrder(tree.getRoot());
        System.out.println("drugie \n");
        tree.postOrder(tree.getRoot());
    }

    }

