public class MyBinaryTree {
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

            } else if (data > node.data) {
                node.rightNode = insertRecursion(node.rightNode, data);

            } else {
                return node;

            }
            return node;
        }
    }

    // W.I.P.
    void deleteData(int data) {
        MyNode deleteNode = deleteRecursion(this.root, data);

        if (deleteNode.leftNode == null && deleteNode.rightNode == null) {
            // código para caso o Nó não tenha filhos
        } else {
            // código para caso o Nó tenha pelo menos um dos filhos
        }
    }

    // W.I.P.
    private MyNode deleteRecursion(MyNode node, int data) {
        if (node.data == data && node.leftNode == null || node.rightNode == null) {
            return null;
        }
        if (data < node.data) {
            return deleteRecursion(node.leftNode, data);

        } else if (data > node.data) {
            return deleteRecursion(node.rightNode, data);

        } else {
            return node;

        }
    }

    // Função para encontrar dados na Árvore seguindo o sistema de coordenadas (ex.: 1.2.2.1)
    int getData(String pos) {
        MyNode returnNode = this.getNodeByPos(pos);

        return returnNode.data;
    }

    // Parte recursiva da função de busca
    private MyNode getNodeByPos(String pos) {
        if (pos == "1") {
            return this.root;

        } else {
            String auxStr = pos.substring(2, pos.length());
            char[] coordinates = auxStr.toCharArray();
            MyNode node = this.root;

            for (char coord : coordinates) {
                if (coord == '1') {
                    node = node.leftNode;

                } else if (coord == '2') {
                    node = node.rightNode;

                }
            }
            return node;
        }
    }
}