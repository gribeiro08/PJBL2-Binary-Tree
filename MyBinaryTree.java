public class MyBinaryTree {
    static final int COUNT = 10; // Variável da função de print
    private MyNode root;

    // Subclasse dos nós da Árvore
    private static class MyNode {
        MyNode leftNode;
        MyNode rightNode;
        int data;
        
        public MyNode(int data) {
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    // Constructor da Árvore
    public MyBinaryTree(int data) {
        this.root = new MyNode(data);
    }
    
    // Função para adicionar valores para a Árvore
    void insertData(int data) {
        this.root = insertRecursion(this.root, data);
    }

    // Parte recursiva da função de adição
    private MyNode insertRecursion(MyNode node, int data) {
        if (node == null) {
            return new MyNode(data);

        } else {
            if (data < node.data) {
                node.leftNode = insertRecursion(node.leftNode, data);

            } else if (data >= node.data) {
                node.rightNode = insertRecursion(node.rightNode, data);

            }
            return node;
        }
    }

    // Função para verificar se um valor está na árvore
    boolean searchTree(int data) {
        MyNode node = searchRecursion(this.root, data);

        if (node != null && node.data == data) {
            return true;

        } else {
            return false;

        }
    }

    // Parte recursiva da função de busca
    private MyNode searchRecursion(MyNode node, int data) {
        if (node == null) {
            return null;
        }

        if (data < node.data) {
            return searchRecursion(node.leftNode, data);
            
        } else if (data > node.data) {
            return searchRecursion(node.rightNode, data);
            
        }
        return node;
    }

    // Função de deletar um dado da Árvore
    void deleteData(int data) {
        this.root = deleteRecursion(this.root, data);
    }

    // Parte recursiva da função de delete
    private MyNode deleteRecursion(MyNode node, int data) {
        if (node == null) {
            return null;
        }

        if (data < node.data) {
            return searchRecursion(node.leftNode, data);
            
        } else if (data > node.data) {
            return searchRecursion(node.rightNode, data);
            
        } else {
            if (node.leftNode == null) {
                return node.rightNode;

            } else if (node.rightNode == null) {
                return node.leftNode;

            }

            node.data = minValue(node);

            root.rightNode = deleteRecursion(node.rightNode, root.data);
        }

        return node;
    }

    // Função para encontrar o menor valor na Árvore
    private int minValue(MyNode node) {
        int minValue = node.data;

        while (node.leftNode != null) {
            minValue = node.leftNode.data;
            node = node.leftNode;

        }
        return minValue;
    }

    // – = – Função de Print pega da internet 🤙 – = –

    void print2D() {
        // Pass initial space count as 0
        print2DUtil(this.root, 0);
    }

    private void print2DUtil(MyNode root, int space) {
        // Base case
        if (root == null)
            return;
 
        // Increase distance between levels
        space += COUNT;
 
        // Process right child first
        print2DUtil(root.rightNode, space);
 
        // Print current node after space count
        System.out.print("\n");

        for (int i = COUNT; i < space; i++)
            System.out.print(" ");

        System.out.print(root.data + "\n");
 
        // Process left child
        print2DUtil(root.leftNode, space);
    }
}