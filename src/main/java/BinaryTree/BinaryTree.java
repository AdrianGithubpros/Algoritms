package BinaryTree;

public class BinaryTree {
    private Node root;



    public Node getNode(int value) {
        Node current = getRoot();
        while(current != null && current.getValue() != value) {
            if(value > current.getValue()) {
                current = current.getRightNode();
            }else {
                current = current.getLeftNode();
            }
        }
        if(current == null) {
            throw new NullPointerException("There is no node with such number: " + value);
        }
        return current;
    }

    public Node getNode(Node node, int value) {
        if (value > node.getValue()){
            return getNode(node.getRightNode(), value);
        }else if(value < node.getValue()) {
            return getNode(node.getLeftNode(), value);
        }else {
            return node;
        }
    }

    public boolean addNode(int value){
        Node parent = null;
        Node current = getRoot();
        while(current != null) {
            parent = current;
            if(current.getValue() == value) {
                return false;
            }

            if(value > current.getValue()) {
                current = current.getRightNode();
            }else if(value < current.getValue()) {
                current = current.getLeftNode();
            }
        }

        Node tmp = new Node(value);
        if(parent == null) {
            setRoot(tmp);
        }else if(value > parent.getValue()) {
            parent.setRightNode(tmp);
            tmp.setParent(parent);
        }else if(value < parent.getValue()) {
            parent.setLeftNode(tmp);
            tmp.setParent(parent);
        }

        return true;
    }

    public void removeNode(int value) {
        Node toDelete = getNode(value);
        Node tmp;
        Node pred = null;

        if(toDelete.getLeftNode() == null || toDelete.getRightNode() == null) {
            tmp = toDelete;
        }else {
            tmp = successor(toDelete);
        }

        if(tmp.getLeftNode() != null) {
            pred = tmp.getLeftNode();
        }else {
            pred = tmp.getRightNode();
        }

        if(pred != null) {
            pred.setParent(tmp.getParent());
        }

        if(tmp.getParent() == null) {
            setRoot(pred);
        }else {
            if(tmp == tmp.getParent().getLeftNode()) {
                tmp.getParent().setLeftNode(pred);
            }else {
                tmp.getParent().setRightNode(pred);
            }
        }

        if(tmp.getValue() != toDelete.getValue()) {
            toDelete.setValue(tmp.getValue());
        }
    }

    public Node predecessor(Node node) {
        if(node.getLeftNode() != null) {
            return getMax(node.getLeftNode());
        }

        Node tmp = node.getParent();
        while(node != null && node.getRightNode().getValue() != tmp.getValue()) {
            tmp = node;
            node = node.getRightNode();
        }

        return node;
    }

    public Node successor(Node node) {
        if(node.getRightNode() != null) {
            return getMin(node.getRightNode());
        }

        Node tmp = node.getParent();
        while(node != null && node.getLeftNode().getValue() != tmp.getValue()) {
            tmp = node;
            node = node.getLeftNode();
        }

        return node;
    }


    public Node getMin(Node node) {
        Node current = node;
        while(current.getLeftNode() != null) {
            current = current.getLeftNode();
        }

        return current;
    }

    public Node getMax(Node node) {
        Node current = node;
        while(current.getRightNode() != null) {
            current = current.getRightNode();
        }

        return current;
    }


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /*  InOrder */
    public void inOrder(Node node) {
        if(node != null) {
            inOrder(node.leftNode);
            System.out.print(node.getValue() + ", ");
            inOrder(node.rightNode);
        }
    }

    /* preOrder */
    public void preOrder(Node node) {
        if(node != null) {
            System.out.print(node.getValue() + ", ");
            if(node.leftNode != null)
                System.out.print(node.leftNode.getValue() + ", ");
            else
                System.out.print("-, ");
            if(node.rightNode != null)
                System.out.println(node.rightNode.getValue());
            else
                System.out.println("-");

            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
    }


    /*  PostOrder   */
    public void postOrder(Node node) {
        if(node != null) {
            postOrder(node.leftNode);
            postOrder(node.rightNode);
            System.out.print(node.getValue() + ", ");
            if(node.leftNode != null)
                System.out.print(node.leftNode.getValue() + ", ");
            else
                System.out.print("-, ");
            if(node.rightNode != null)
                System.out.println(node.rightNode.getValue());
            else
                System.out.println("-");
        }
    }
    public void showTree(){




    }


}


