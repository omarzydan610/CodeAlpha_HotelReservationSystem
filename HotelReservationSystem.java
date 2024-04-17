import java.util.Scanner;

public class HotelReservationSystem {
    static String reset = "\u001B[0m";
    static String red = "\u001B[31m";
    static String green = "\u001B[32m";
    static String blue = "\u001B[34m";
    static String yellow = "\u001B[33m";
    static String bold = "\u001B[1m";
    Scanner sc=new Scanner(System.in);
    int size=100;
    public class Room{
        Boolean reserved;
        String name;
        int  category;
        int payment;
        int duration;
        public Room(boolean reserved,String name,int category){
            this.reserved=reserved;
            this.name=name;
            this.category=category;
        }
    }

    Room[]rooms=new Room[size];
    void initialization(){
        for(int i=0;i<80;i++){
            rooms[i]=new Room(false, null,1);
        }
        for(int i=80;i<100;i++){
            rooms[i]=new Room(false, null,2);
        }
    }
    void checkRoom(){
        System.out.print(yellow+"Enter room number :"+reset);
        int n=sc.nextInt();
        while(n<1 || n>size){
            System.out.println(bold+red+"Error! Enter room number between 1 : 100"+reset);
            n=sc.nextInt();
        }
        n--;
        if(rooms[n].reserved==false){
            System.out.println(bold+red+"Empty Room!"+reset);
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println(bold+blue+"Gest : "+green+rooms[n].name+reset);
            if(rooms[n].category==1){
                System.out.println(bold+blue+"Category : "+green+"Regular Room"+reset);
            }
            else{
                System.out.println(bold+blue+"Category : "+green+"Suite"+reset);
            }
            if(rooms[n].duration==1){
                System.out.println(bold+blue+"Duration : "+green+rooms[n].duration+" Day"+reset);
            }
            else{
                System.out.println(bold+blue+"Duration : "+green+rooms[n].duration+" Days"+reset);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sc.nextLine();
        viewRooms();
    }

    void reserveRoom(){
        System.out.print(yellow+"Enter room number :"+reset);
        int n=sc.nextInt();
        while(n<1 || n>size){
            System.out.println(bold+red+"Error! Enter room number between 1 : 100"+reset);
            n=sc.nextInt();
        }
        n--;
        sc.nextLine();
        if(rooms[n].reserved==true){
            System.out.println(bold+red+"Error: This room is already reserved"+reset);
        }
        else{
            int cost;
            if(n<80){
                System.out.println(bold+blue+"This is a "+green+"Regular Room"+blue+" : Night cost is "+green+"100$"+reset);
                cost=100;
            }
            else{
                System.out.println(bold+blue+"This is a "+green+"Suite"+blue+" : Night cost is "+green+"300$"+reset);
                cost=300;
            }
            System.out.print(yellow+"Enter Gest Name : "+reset);
            String name=sc.nextLine();
            System.out.print(yellow+"Enter number of nights you want to stay : "+reset);
            int duration=sc.nextInt();
            cost*=duration;
            System.out.println(bold+blue+"Your cost is "+green+cost+"$"+reset);
            System.out.println(yellow+"Do you want to confirm reservation?\n1-Yes\n2-No"+reset);
            int ans=sc.nextInt();
            while (ans>2 ||ans<1){
                System.out.println(bold+red+"Error!Choose 1 or 2"+reset);
                ans=sc.nextInt();
            }
            if(ans==1){
                rooms[n].name=name;
                rooms[n].reserved=true;
                rooms[n].duration=duration;
                System.out.println(bold+green+"Reserved Successfully"+reset);
            }
            else{
                System.out.println(bold+red+"Reservation failed"+reset);
            }
            sc.nextLine();
        }
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        viewRooms();
    }

    void checkOut(){
        System.out.print(yellow+"Enter room number :"+reset);
        int n=sc.nextInt();
        while(n<1 || n>size){
            System.out.println(bold+red+"Error! Enter room number between 1 : 100"+reset);
            n=sc.nextInt();
        }
        n--;
        if(rooms[n].reserved==false){
            System.out.println(bold+red+"Error: This room is empty!"+reset);
        }
        else{
            rooms[n].reserved=false;
            System.out.println(bold+green+"CheckedOut Successfully"+reset);
        }
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sc.nextLine();
        viewRooms();
    }

    void menu(){
        System.out.println();
        System.out.println(bold+blue+"Choose Operation You want"+reset);
        System.out.println(blue+"1- Check Room's Details");
        System.out.println("2- Reserve a Room");
        System.out.println("3- CheckOut");
        System.out.println("4- Exit"+reset);
        char c=sc.nextLine().charAt(0);
        while(c!='1' && c!='2' && c!='3' &&c!='4'){
            System.out.println(bold+red+"Error! Enter a number between 1:3"+reset);
            c=sc.nextLine().charAt(0);
        }
        switch (c) {
            case '1':
                checkRoom();
                break;
            case '2':
                reserveRoom();
                break;
            case '3':
                checkOut();
                break;
            case '4':
                System.out.println(bold+red+"Thanks For Using Our System :)"+reset);
                System.exit(0);
                break;
        }
    }

    void viewRooms(){
        System.out.println();
        for(int i=1;i<=size;i++){
            if(i==1){
                System.out.println(bold+yellow+"Regular Rooms:"+reset);
            }
            if(i==81){
                System.out.println();
                System.out.println(bold+yellow+"Suites:"+reset);
            }
            if(i<10){
                System.out.print(" ");
            }
            if((i%4)!=0){
                if(i==99){
                    if(rooms[i-1].reserved==false){
                        System.out.print(bold+green+i+" - Empty               "+reset);
                    }
                    else{
                        System.out.print(bold+red+i+" - Reserved            "+reset);
                    }
                }
                else{
                    if(rooms[i-1].reserved==false){
                        System.out.print(bold+green+i+" - Empty                "+reset);
                    }
                    else{
                        System.out.print(bold+red+i+" - Reserved             "+reset);
                    }
                }
            }
            else{
                if(rooms[i-1].reserved==false){
                    System.out.println(bold+green+i+" - Empty"+reset);
                }
                else{
                    System.out.println(bold+red+i+" - Reserved"+reset);
                }
            }
        }
        menu();
    }
    public static void main(String[] args) {
        System.out.println();
        System.out.println(bold+red+"                             Welcome To Our Hotel"+reset);
        HotelReservationSystem temp=new HotelReservationSystem();
        temp.initialization();
        temp.viewRooms();
    }
}
