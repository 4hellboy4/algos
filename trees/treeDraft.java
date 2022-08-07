package trees;

public class treeDraft {

    public static void main(String[] args) throws Exception {

        AVLTree<Integer> tree = new AVLTree<>();

        tree.insert(1);
        tree.insert(23);
        tree.insert(5);

//        tree.print();

        tree.insert(103);

        tree.insert(2);

        tree.insert(88);

        tree.print();

        System.out.println();

        tree.whoIsRoot();

    }

}


