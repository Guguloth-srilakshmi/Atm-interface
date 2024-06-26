import java.util.Scanner;

public class Atm{
    static int pass;
   static float accbal;
    public static void main(String[] args) {
       // System.out.println("hello world");
       int pin;
       System.out.println("Welcome to ATM Interface!!!!!!!!!!!!!!!!!!!!!! Its our pleasure to help you");
       System.out.println("enter your password");
       Scanner sc=new Scanner(System.in);
       pass=sc.nextInt();
       try{
        System.out.println("please enter your pin ");
        pin=sc.nextInt();
        if(isvalid(pin,pass)){
           // System.out.println("welcome!!!!");
           System.out.println("welcome!!");
           System.out.println("----------MENU BAR--------");
           int option;
           do{
            System.out.println("please select the service you want");
            System.out.println("select 1-check balance,2-withdraw,3-deposit,4-exit");
            option=sc.nextInt();
            switch (option) {
                case 1:
                   accbal=checkbalance();
                    System.out.println("your account bal is "+ " "+accbal+" "+"rupees only");
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    System.out.println("bye!!! see uoy again:)");
                default:
                    break;
            }

           }while(option!=4);
        }
        else{
            throw new Exception();
        }
       }
       catch(Exception e){
        System.out.println("incorrect pin is enterd");
       }
    }
    private static boolean isvalid(int pin,int pass){
        int res=pin^pass;
        return res==0 ? true :false;
    }
    private static float checkbalance(){
       return accbal; 
    }
    private static void withdraw(){
        Scanner obj=new Scanner(System.in);
        float amnt;
        System.out.println("enter amount you want to withdraw");
        amnt=obj.nextFloat();
        if(amnt<=checkbalance()){
            accbal=accbal-amnt;
            System.out.println("your trasaction is sucessful please check the sms regarding bank balance");
            if(accbal<1000){
                System.out.println("please maintain minimum balance");
            }
        }
        else{
            System.out.println("we can not proceed further as your balance is less than your amount to withdraw");
            System.out.println("do you want to check balance select 1");
            int c;
            c=obj.nextInt();
            if(c==1){
                float bal=checkbalance();
                System.out.println("your balance"+" "+bal+"/-");
            }
            else{
                System.out.println("thank you!!!");
            }
        }
        //obj.close();

    }
    private static void deposit(){
        Scanner obj=new Scanner(System.in);
        float amnt;
        System.out.println("enter the amount you want to credit");
        amnt=obj.nextFloat();
        accbal=accbal+amnt;
        System.out.println("money deposited successfully");
        //obj.close();
    }
    // private static void exit(){
    //     return;
    // }
}