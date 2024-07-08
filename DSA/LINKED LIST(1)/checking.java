class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node copy(Node first) {
        // 1. [Is Empty list?]
        if (first == null) {
            return null;
        }
        
        Node avail = new Node(0); // Dummy node to represent available memory
        Node begin, pred, save, newNode;
        
        // 2. [Copy first node]
        if (avail == null) {
            System.out.println("Underflow");
            return null;
        } else {
            newNode = avail;
            avail = avail.next;
            newNode.data = first.data;
            begin = newNode;
        }
        
        // 3. [Initialize Traversal]
        save = first;
        
        // 4. [Move to the next node if not at the end of list]
        while (save.next != null) {
            // 5. [Update predecessor and save pointer]
            pred = newNode;
            save = save.next;
            
            // 6. [Copy Node]
            if (avail == null) {
                System.out.println("Underflow");
                return null;
            } else {
                newNode = avail;
                avail = avail.next;
                newNode.data = save.data;
                pred.next = newNode;
            }
        }
        
        // 7. [Set link of last node and return]
        newNode.next = null;
        return begin;
    }
}