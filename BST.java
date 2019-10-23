public class BST<T>{
    Node root = null;


    class Node{
        Comparable data;
        Node left;
        Node right;
        int instance;

        public Node(Comparable item) {
            this.data = item;
            this.left = null;
            this.right = null;
            this.instance = 1;
        }
    }

    public boolean find(Comparable target) {
        return find(target, root);
    }

    private boolean find(Comparable target, Node node) {
        if (node == null) {
            return false;
        }
        if (target.compareTo(node.data) == 0) {
            return true;
        }
        if (node.data.compareTo(target) > 0) {
            return find(target, node.left);
        } else {
            return find(target, node.right);
        }
    }

    public void insert(Comparable item) {
        root = add(item, root);
    }

    private Node add(Comparable item, Node node) {
        if (node == null) {
            return new Node(item);
        }
        if (item.compareTo(node.data) == 0) {
            node.instance++; // not defined yet
            return node;
        }
        if (item.compareTo(node.data) < 0) {
            node.left = add(item, node.left);
        } else {
            node.right = add(item, node.right);
        }
        return node;
    }
    public void delete(Comparable item){
        root = delete(root, item);
    }

    private Node delete(Node node, Comparable item) {
        if (node == null) {
            return null;
        }
        if (node.data.compareTo(item) == 0) {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            if (node.right.left == null) {
                node.data = node.right.data;
                node.right = node.right.right;
                return node;
            } else {
                node.data = removesmallest(node.right);
                return node;
            }
        }

            if (node.data.compareTo(item) < 0) {
                node.right = delete(node.right, item);
                return node;
            }
            return null;
    }

    private Comparable removesmallest(Node node) {
        if (node.left.left == null) {
            Comparable smallest = node.left.data;
            node.left = node.left.right;
            return smallest;
        }
        return removesmallest(node.left);
    }

    public void print(){
        printAll(root);
    }
    private void printAll(Node node){
        if(node != null){
            printAll(node.left);
            if(node.instance > 1) {
                for (int i = node.instance; i >= 1; i--) {
                    System.out.println(node.data);
                }
            }else {
                System.out.println(node.data);
            }
            printAll(node.right);
        }
    }
}

