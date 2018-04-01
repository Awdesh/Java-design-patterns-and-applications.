/**
 * Created by awdesh on 4/25/17.
 */
class Node {
    Node next;
    int value;

    public Node(int value){
        this.value = value;
    }
}

/*
LinkedList has a head which we need to traverse to add a new element.
 */
class LinkedList {
    Node head;

    public LinkedList(int item){
        head = new Node((item));
    }

    public void insert(int item){
        // traverse from head until node->next == null.
        // create a new node then point node->next to it.
        // if head->next == null then create a new node, point head->next to new node.
        // point next of new node to null.
        Node temp = head;
        if (head.next == null){
            Node newNode = new Node(item);
            head.next = newNode;
            newNode.next = null;
            return;
        }

        while(temp.next != null){
            temp = temp.next;
        }

        Node newNode = new Node(item);
        temp.next = newNode;
        newNode.next = null;
    }

    /*
    start traversing from head.
     */
    public boolean find(int item){
        if(head.value == item){
            return true;
        }

        Node temp = head;
        while (temp.next != null){
            if(temp.value == item){
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    /*
    Drawing helped here a lot.
    Essentially when we delete an item, we point deleted node's prev node to deleted node's next node.
     */
    public void delete(int item){
        if(head.value == item){
            Node temp = head.next;
            head.next = null;
            head = temp;
        }

        Node temp = head;
        while (temp.next != null){
            if(temp.next.value == item){
                Node prev = temp;
                prev.next = temp.next.next;
            }
            temp = temp.next;
        }
    }

    public void print(){
        Node iterator = head;
        while(iterator.next != null){
            System.out.println(iterator.value);
            iterator = iterator.next;
        }
        System.out.println(iterator.value);
    }
}

class client {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        System.out.println("**********************");
        ll.print();
        System.out.println("**********************");

        System.out.println(ll.find(4));
        System.out.println(ll.find(40));

        ll.delete(1);
        ll.print();
        System.out.println("**********************");
        ll.delete(3);
        ll.print();
    }
}


