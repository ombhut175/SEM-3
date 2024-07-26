// 75. Write a program to simulate music player application using suitable data
// structure. There is no estimation about number of music files to be managed by
// the music player. Your program should support all the basic music player
// operations to play and manage the playlist.
/**
 * Q75
 */
import java.util.Scanner;
public class Q75gpt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MusicPlayer m1 = new MusicPlayer();
        m1.addLast("1");
        m1.display();
        m1.addLast("2");
        m1.display();
        m1.addLast("3");
        m1.display();
        m1.addLast("4");
        m1.display();
        m1.addLast("5");
        m1.display();
        m1.swapMusic(2, 4);
        m1.display();
        // m1.playThis("4");
        // outer:
        // while (true) {
        //     System.out.println("1 for add music at first 2 for add music at last 3 for adding music at specific position 4 for delete first track 5 for delete last track 6 for delete at specific position 7 to play any track 8 to change two tracks 9 for exit");
        //     int check= sc.nextInt();
        //     sc.nextLine();
        //     switch (check) {
        //         case 1:
        //             System.out.println("enter name of music track");
        //             String x = sc.nextLine();
        //             m1.addFirst(x);
        //             m1.display();
        //             break;
        //         case 2:
        //             System.out.println("enter name of music track");
        //             x = sc.nextLine();
        //             m1.addLast(x);
        //             m1.display();
        //             break;
        //         case 3:
        //             System.out.println("enter name of music track");
        //             x = sc.nextLine();
        //             System.out.println("enter position");
        //             int i=sc.nextInt();
        //             m1.insertAtPosition(x, i);
        //             m1.display();
        //             break;
        //         case 4: 
        //             m1.deleteFirst();
        //             m1.display();
        //             break;
        //         case 5:
        //             m1.deleteLast();
        //             m1.display();
        //             break;
        //         case 6:
        //             System.out.println("enter index");
        //             i=sc.nextInt();
        //             m1.deleteAtPosition(i);
        //             m1.display();
        //             break;
        //         case 7:
        //             System.out.println("enter name of track");
        //             x=sc.nextLine();
        //             m1.playThis(x);
        //             m1.display();
        //             break;
        //         case 8:
        //             System.out.println("enter position of track 1");
        //             int i1 = sc.nextInt();
        //             System.out.println("enter position of track 2");
        //             int i2 = sc.nextInt();
        //             m1.swapMusic(i1, i2);
        //             m1.display();
        //             break;
        //         default:
        //             break outer;
        //     }
        // }
    }
}

class MusicPlayer{
    Scanner sc;
    Node l;
    Node r;
    MusicPlayer(){
       this.sc = new Scanner(System.in);
    }
    void addFirst(String x){
        Node newNode = new Node(x);
        if(l==null){
            l=newNode;
            r=newNode;
            return;
        }
        newNode.rpter=l;
        l.lpter=newNode;
        l=newNode;
    }
    void addLast(String x){
        Node newNode = new Node(x);
        if(l==null){
            l=newNode;
            r=newNode;
            return;
        }
        Node save=l;
        while (save.rpter!=null) {
            save=save.rpter;
        }
        save.rpter=newNode;
        newNode.lpter=save;
        r=newNode;
    }
    void insertAtPosition(String x , int y){
        if(y<0){
            System.out.println("enter valid index");
            return;
        }
        if(y==0){
            addFirst(x);
            return;
        }
        Node newNode = new Node(x);
        if(l==null){
            l=newNode;
            r=newNode;
            return;
        }
        Node save=l;
        int count=-1;
        while(save!=null){
            count++;
            save=save.rpter;
        }
        if(y>=count){
            addLast(x);
            return;
        }
        save=l;
        count=-1;
        while(save!=null){
            count++;
            if(count==y){
                break;
            }
            save=save.rpter;
        }
        newNode.rpter=save.rpter;
        save.rpter.lpter=newNode;
        save.rpter=newNode;
        newNode.lpter=save;
    }
    void deleteFirst(){
        if(l==null){
            System.out.println("Playlist is empty");
            return;
        }
        if(l==r){
            l=l.lpter;
            return;
        }
        l=l.rpter;
        l.lpter=null;
    }
    void deleteLast(){
        if(l==null){
            System.out.println("playlist is empty");
            return;
        }
        if(l==r){
            l=l.lpter;
            return;
        }
        Node save=l;
        while (save.rpter!=null) {
            save=save.rpter;
        }
        r=save.lpter;
        r.rpter=null;
    }
    void deleteAtPosition(int i){
        if(l==null){
            System.out.println("LL is empty");
            return;
        }
        if(i<0){
            System.out.println("invalid index");
            return;
        }
        if(i==0){
            deleteFirst();
            return;
        }
        Node save=l;
        int count=-1;
        while(save!=null){
            count++;
            save=save.rpter;
        }
        if(i>=count){
            deleteLast();
            return;
        }
        save=l;
        count=-1;
        while(save!=null){
            count++;
            if(count==i){
                break;
            }
            save=save.rpter;
        }
        save.lpter.rpter=save.rpter;
        save.rpter.lpter=save.lpter;
    }
    void playThis(String y){
        if(l==null){
            System.out.println("LL is empty");
            return;
        }
        Node save=l;
        while(save!=null){
            if((save.info).equals(y)){
                System.out.println("playing "+y+".....");
                outer:
                while (true) {
                    System.out.println("1 to play previous 2 to play next 3 to stop");
                    int check=sc.nextInt();
                    if(check==1){
                        if(save.lpter==null){
                            System.out.println("music list ended");
                        }
                        else{

                            save=save.lpter;
                            System.out.println("playing "+save.info+".....");
                        }
                    }
                    else if(check==2){
                        if(save.rpter==null){
                            System.out.println("music list ended");
                        }
                        else{

                            save=save.rpter;
                            System.out.println("playing "+save.info+".....");
                        }
                    }
                    else{
                        break outer;
                    }                    
                }
                return;
            }
            save=save.rpter;
        }
        if(save==null){
            System.out.println("song not founded");
        }
    }
    void swapMusic(int i1, int i2) {
        Node save = l;
        int count = -1;
        while (save != null) {
            count++;
            if (count == i1) {
                break;
            }
            save = save.rpter;
        }
    
        boolean check2 = false;
        if (save == l) {
            check2 = true;
        }
    
        boolean check1 = false;
        if ((i1 - i2) == -1) {
            check1 = true;
        }
    
        Node save2 = l;
        Node pred2 = null;
        Node suc2 = save2.rpter;
        count = -1;
        while (save2 != null) {
            count++;
            if (count == i2) {
                break;
            }
            pred2 = save2;
            save2 = save2.rpter;
            suc2 = save2.rpter;
        }
    
        if (!check2) {
            save.lpter.rpter = save2;
        } else {
            l = save2;
        }
    
        if (!check1 && (pred2 != save)) {
            save.rpter.lpter = save2;
            save2.rpter = save.rpter;
            pred2.rpter = save;
            save.lpter = pred2;
        } else {
            save.rpter = save2.rpter;
            save2.rpter = save;
        }
    
        if (save2 != null) {
            save2.lpter = save.lpter;
        }
    
        if (save.lpter != null) {
            save.lpter.rpter = save;
        } else {
            l = save;
        }
    
        if (save2.lpter != null) {
            save2.lpter.rpter = save2;
        } else {
            l = save2;
        }
    }
    
    
    void display(){
        Node save=l;
        while (save!=null) {
            if(save.rpter==null){
            System.out.print(save.info);
            }
            else{

                System.out.print(save.info+" "+" , ");
            }
            save=save.rpter;
        }
        System.out.println();
    }
}


class Node {
    String info;
    Node lpter;
    Node rpter;
    public Node(String info) {
        this.info = info;
        this.lpter = null;
        this.rpter = null;
    }
}