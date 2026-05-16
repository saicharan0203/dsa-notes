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
        current = insertAtPositon(head, 7, 2);
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
}