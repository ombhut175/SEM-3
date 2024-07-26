public class checking {
    public static void main(String[] args) {
        String s1 = "523x^2";
        StringBuilder sb1 = new StringBuilder();

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if (Character.isDigit(ch)) {
                sb1.append(ch);
            } else {
                break; // Stop collecting digits once a non-digit character is encountered
            }
        }

        // int a = 0;
        // if (sb1.length() > 0) {
        //     String s2 = sb1.toString();
        //     a = Integer.parseInt(s2);
        // } else {
        //     System.out.println("No numeric characters found.");
        // }

        // System.out.println(a);

        // Example of using the Node class
        Node newNode = new Node(Integer.parseInt(sb1.toString()));
        System.out.println("newNode.info: " + newNode.info);
    }
}

class Node {
    int info;
    Node link;

    public Node(int info) {
        this.info = info;
        this.link = null;
    }
}
