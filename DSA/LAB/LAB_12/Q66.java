import java.util.Scanner;

import javax.print.DocFlavor;

public class Q66 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SwapLL sl1 = new SwapLL();
        outer:
        while (true) {
            System.out.println("1 for enter at last 2 for swapping from first and last index");
            int check = sc.nextInt();
            switch (check) {
                case 1:
                        System.out.println("enter number");
                        int x = sc.nextInt();
                        sl1.addLast(x);
                        sl1.display();
                    break;
                case 2:
                        System.out.println("enter 1st index");
                        int first=sc.nextInt();
                        System.out.println("enter last index");
                        int last=sc.nextInt();
                        sl1.swap(first, last);
                        sl1.display();
                        break;
                default:
                    break outer;
            }
        }
    }
}

class SwapLL{
    Node first;
    Node last;
    public void addLast(int x){
        Node newNode = new Node(x);
        if(first==null){
            first=newNode;
            last=newNode;
            return;
        }
        Node save=first;
        while(save.link!=null){
            save=save.link;
        }
        save.link=newNode;
        last=newNode;
    }


    void swap(int start,int end){
        if(first==null){
            System.out.println("list is empty");
            return;
        }
        int count=-1;
        Node save = first;
        while(save!=null){
            count++;
            save=save.link;
        }
        end=count-end;
        // System.out.println("count = "+count);
        // System.out.println("end = "+end);
        if(end<0 || start>count || start==end || start<0 || end>count){
            System.out.println("invalid index");
            return;
        }
        if(start==0 && end==count || start==count && end==0){
            Node save1=first;
            Node save2=first;
            Node pred2=null;
            while(save2.link!=null){
                pred2=save2;
                save2=save2.link;
            }
            save2.link=save1.link;      
            pred2.link=save1;
            save1.link=null;
            first=save2;
            last=save1;
            return;
        }
        save=first;
        count=-1;
        Node pred1 = null;
        while(save.link!=null){
            count++;
            if(count==start){
                break;
            }
            pred1=save;
            save=save.link;
        }
        Node save2=first;
        count=-1;
        Node pred2 = save2;
        Node successor2 = save2.link;
        while(save2!=null){
            count++;
            if(count==end){
                break;
            }   
            pred2=save2;
            save2=save2.link;
            if(save2==null){
                break;
            }
            successor2 = save2.link;
        }
        boolean check = false;
        boolean check2 = false;
        boolean check3 = false;
        boolean check4=false;
        if((end-start)==1){
            check3=true;
        }
        if((start-end)==1){
            check4=true;
        }
        if(start==0){
            first=save2;
            check2=true;
        }
        if(!check3){
            save2.link=save.link;
        }
        else{
            save2.link=save;
        }
        if(!check2 && !check4){
            pred1.link=save2;
        }
        if(!check4){
            save.link=successor2;
        }
        else{
            successor2.link=save2;
        }
        if(end==0){
            first=save;
            last=save2;
            check=true;
        }
        if(!check && !check3){
            pred2.link=save;
        }
    }
    void display(){
        Node save=first;
        while (save!=null) {
            System.out.print(save.info+" ");
            save=save.link;
        }
        System.out.println();
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