class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class Test{
    public static void main(String[] lets){
        int arr[] = {1, 2, 3, 4, 5};
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }   
        // Print the linked list    
        // current = deleteFirst(head);
        current = deleteValue(head, 3);
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }   

    }
    static Node deleteFirst(Node head) {

    if(head == null)
        return null;

    return head.next;
}
    static Node insertAtFirst(Node head,int data){
        Node newNOde = new Node(data);
        newNOde.next = head;
        return newNOde;

    }
    static Node insertAtLast(Node head,int data){
        Node newNode = new Node(data);
        if(head == null) return newNode;
        Node current = head;
        while(current.next!= null){
            current = current.next; 
        }
        current.next = newNode;
        return head;

    }
    static Node insertAtPositon(Node head,int data,int pos){
        if(head == null || pos == 0){
            return new Node(data);
        }
        Node newNode = new Node(data);
        Node temp = head;
        for(int i = 0; i < pos-1 && temp != null; i++){
            temp = temp.next;
        }   
        if(temp == null){
            return head;
        }   
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }
    static Node deleteLast(Node head){
        Node current = head;
        if(head == null || head.next == null){
            return null;
        }
        while(current.next.next != null){
            current = current.next;
        }
        current.next = null;
        return head;
    } 
    static Node deleteValue(Node head,int value){
        if(head == null) return null;
        if(head.data == value){
            return head.next;
        }
        Node current = head;
        while(current.next != null){
            if(current.next.data == value){
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }
        return head;
    }
}