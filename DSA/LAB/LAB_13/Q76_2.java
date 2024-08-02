package LAB_13;

import java.util.Scanner;

public class Q76_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        addPolynomialLL2 apl = new addPolynomialLL2();
//        apl.insertAtEnd(3,0);
//        apl.insertAtEnd(5,3);
//        apl.insertAtEnd(4,1);
        System.out.println("enter for 1st equation");
        int i=1;
        outer:
        while (true){
            System.out.println("enter 1 to enter or 2 to exit");
            int check=sc.nextInt();
            switch (check){
                case 1:
                    System.out.println("enter number "+i);
                    int n = sc.nextInt();
                    System.out.println("enter exponential power of "+i);
                    int p = sc.nextInt();
                    i++;
                    apl.insertAtEnd(n,p);
                    break;
                default:
                    break outer;
            }
        }
        addPolynomialLL2 apl2 = new addPolynomialLL2();
//        apl2.insertAtEnd(4,2);
//        apl2.insertAtEnd(2,0);
//        apl2.insertAtEnd(3,1);
        System.out.println("enter for 2nd equation");
        i=1;
        outer:
        while (true){
            System.out.println("enter 1 to enter or 2 to exit");
            int check=sc.nextInt();
            switch (check){
                case 1:
                    System.out.println("enter number "+i);
                    int n = sc.nextInt();
                    System.out.println("enter exponential power of "+i);
                    int p = sc.nextInt();
                    apl2.insertAtEnd(n,p);
                    i++;
                    break;
                default:
                    break outer;
            }
        }
        apl.sortLL();
        apl2.sortLL();
        addPolynomialLL2 result = apl.addPolynomial(apl2);
        apl.display();
        apl2.display();
        result.display();
    }
}


class addPolynomialLL2{
    Node first;
    Node last;
    void insertAtEnd(int n,int p){
        Node newNode = new Node(n,p);
        if(first==null){
            first=newNode;
            last=newNode;
            return;
        }
        last.link=newNode;
        last=newNode;
    }
    void sortLL(){
        if(first==null){
            System.out.println("list is empty");
            return;
        }
        Node save = first;
        Node pred=null;
        while (save!=null){
            Node temp = save.link;
            Node predTemp = save;
            while (temp!=null){
                if(temp.power>save.power){
                    predTemp.link=temp.link;
                    temp.link=save;
                    save=temp;
                    if(pred==null){
                        first=save;
                    }
                    else{
                    pred.link=temp;
                    }
                    if(save.link==null){
                        last=save;
                    }
                }
                predTemp=temp;
                temp=temp.link;
            }
            pred=save;
            save=save.link;
        }
    }
    addPolynomialLL2 addPolynomial(addPolynomialLL2 apl2){
        addPolynomialLL2 result = new addPolynomialLL2();
        if(this.first==null || apl2.first==null){
            System.out.println("LL is empty");
            return result;
        }
        Node save1 = this.first;
        Node save2 = apl2.first;
        while (save1!=null && save2!=null){
            boolean check1 = true;
            boolean check2 = true;
            if(save1.power==save2.power){
                result.insertAtEnd(save1.number+ save2.number,save1.power);
            }
            else if(save1.power> save2.power){
                result.insertAtEnd(save1.number,save1.power);
                check2=false;
            }
            else if(save1.power< save2.power){
                result.insertAtEnd(save2.number,save2.power);
                check1=false;
            }
            if(check1){
            save1=save1.link;
            }
            if(check2){
            save2=save2.link;
            }
        }
        while (save1!=null){
            result.insertAtEnd(save1.number, save1.power);
            save1=save1.link;
        }
        while(save2!=null){
            result.insertAtEnd(save2.number, save2.power);
            save2=save2.link;
        }
        return result;
    }
    void display(){
        Node save = first;
        while(save!=null){
            if(save.link!=null){
            System.out.print(save.number+" x^"+ save.power+" + ");
            }
            else{
                System.out.print(save.number+" x^"+ save.power);
            }
            save=save.link;
        }
        System.out.println();
    }
}


class Node {
    int number;
    int power;
    Node link;
    public Node(int number,int power) {
        this.number=number;
        this.power=power;
        this.link = null;
    }
}