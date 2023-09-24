public class TreeTest {
    public static void main(String[] args) {
        MyBinaryTree tree1 = new MyBinaryTree(5);
        tree1.insertData(2);
        tree1.insertData(7);
        tree1.insertData(10);
        tree1.insertData(15);    
        tree1.insertData(20);
        tree1.insertData(12);

        tree1.print2D();

        System.out.println(tree1.searchTree(5));
        // Print deve ser true

        System.out.println(tree1.searchTree(17));
        // Print deve ser false

        tree1.deleteData(10);
        tree1.print2D();
    }
}
