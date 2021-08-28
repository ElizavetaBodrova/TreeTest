/**
 * Реализовать функцию, которая изменить двоичное дерево следующим образом: Присоединит к самому правому листу
 * в дереве в качестве правого потомка левое поддерево корня дерева (левый потомок у корня дерева при этом надо убрать)
 */
public class Tree<T> {
    private Node<T> root;

    public Tree() {
        root = null;
    }

    public void insertNode(T data) { // метод вставки нового элемента
        Node<T> node = new Node<T>(); // создание нового узла
        node.setData(data); // вставка данных
        if (root == null) { // если корневой узел не существует
            root = node;// то новый элемент и есть корневой узел
        }
        else { // корневой узел занят
            Node<T> currentNode = root; // начинаем с корневого узла
            Node<T> parentNode;
            while (true) // мы имеем внутренний выход из цикла
            {
                parentNode = currentNode;
                if(data == currentNode.getData()) {   // если такой элемент в дереве уже есть, не сохраняем его
                    return;    // просто выходим из метода
                }
                else  if (data < currentNode.getData()) {   // движение влево?
                    currentNode = currentNode.getLeft();
                    if (currentNode == null){ // если был достигнут конец цепочки,
                        parentNode.setLeft(node); //  то вставить слева и выйти из методы
                        return;
                    }
                }
                else { // Или направо?
                    currentNode = currentNode.getRight();
                    if (currentNode == null) { // если был достигнут конец цепочки,
                        parentNode.setRight(node);  //то вставить справа
                        return; // и выйти
                    }
                }
            }
        }
    }


    public static class Node<T> implements Comparable<T>{
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node() {
            left = null;
            right = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        @Override
        public int compareTo(T o) {
            return 0;
        }
    }
}
