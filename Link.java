class Node{
    int data;
    Node next;
    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class Link{
    private static Node convert(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1;i<arr.length;i++){
            mover.next = new Node(arr[i]);
            mover = mover.next;
        }   return head;

    }
    private static void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    private static  Node removehead(Node head){
        if(head==null){
            return head;
        }
        head = head.next;
        return head;

    }
    private static Node removeTail(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node temp = head;
        while(temp.next.next !=null){
            temp=temp.next;
        }
        temp.next = null;
        return head;
    }
    private static Node removeK(Node head,int k){
        if(head == null){
            return head;
        }
        if(k==1){
            return head.next;
        }
        int count =0;
        Node temp = head;
        Node prev = null;
        while(temp != null){
            count++;
            if(count == k){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    private static Node removeelem (Node head,int elem){
        if(head == null){
            return head;
        }
        if(head.data == elem){
            return head.next;
        }
        Node temp = head;
        Node prev = null;
        while(temp != null){
            if(temp.data == elem){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
    
        return head;
    }
    private static Node insertTail(Node head, int val){
        if(head == null){
            return new Node(val);
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node (val);
        return head;
    }

    private static Node insertK(Node head,int val,int k){
        if(head == null){
            return new Node(val);
        }
        if(k==1){
            return new Node(val, head);
        }
        int count =0;
        Node temp = head;
        while(temp != null){
            count++;
            if(count == k-1){
                Node x = new Node(val,temp.next);
                // x.next = temp.next;
                temp.next = x;
                break;
            }
            temp = temp.next;
        }
        
        return head;

    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        Node head = convert(arr);
        System.out.println(head.next.data);
        // head = removehead(head);
        // head = removeTail(head);
        head = removeelem(head, 25);
        head = new Node(10, head);
        head = insertTail(head, 20);
        head = insertK(head, 15, 3);
        
        display(head);
        
    }
}