import java.util.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;


public class A{
    public static String na;
    public static int balance=0;
    public static String acc;
    public static ArrayList<String> history=new ArrayList<String>();

    static void update_b(int d){
        balance=balance+d;
    }
    static void showbalance(){
        System.out.println(balance);
        System.out.println("-----------------------------");
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME TO ATM");
        System.out.println("--------------");
        System.out.println("select one option :");
        System.out.println("1.Register");
        System.out.println("2.Exit");
        System.out.println("Enter Your choice:");
        int choice =sc.nextInt();
        if (choice==1)
        {
            Account.registers();
        }
        else 
        {
            if(choice==2)
            {
                System.exit(0);
            }
            else
            {
                int f=0;
                while(f==0)
                {
                    System.out.println("select a valid option:");
                    int c=sc.nextInt();
                    if(c==1)
                    {
                        f=1;
                        Account.registers();
                    }
                    else if(c==2)
                    {
                        System.exit(0);
                    }
                }
            }
        }
        //sc.close();
    }
    
    static void prompt_d(){
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME "+A.na+"! TO ATM SYSTEM");
        System.out.println("------------------------");
        System.out.println("Select option : ");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Check balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice : ");
        int ch=sc.nextInt();
        switch (ch) 
        {
            case 1:
                De.deposit();break;
            case 2:
                wi.withdraw();break;
            case 3:
                tr.transfer();break;
            case 4:
                che.checkbalance();break;
            case 5:
                his.h_o_tra();break;
            case 6:
                System.exit(0);break;
            default:System.out.println("Enter the valid option\n-------------------------");prompt_d();break;
        }
        //sc.close();
    }

    
}

class Account
{
    static  void registers()
    {
        Scanner scc=new Scanner(System.in);
        System.out.println("-----------------");
        System.out.println("Enter your  name:");
        A.na=scc.nextLine();
        System.out.println("Enter username:");
        String use=scc.nextLine();
        System.out.println("register your password:");
        String pas=scc.nextLine();
        System.out.println("Enter your Account number:");
        A.acc=scc.nextLine();
        System.out.println("SUCCESSFULLY REGISTERED");
        System.out.println("------------------");
        //scc.close();
        A.prompt_d();
        if(use==pas)
            A.prompt_d();
    }
    
}

class De{
    static void deposit(){
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------------");
        System.out.print("Enter amount to deposit in your account:");
        int d=sc.nextInt();
        A.update_b(d);
        A.history.add("Deposit     - ");
        A.history.add(Integer.toString(d));
        System.out.println("Amount Rs."+d+"/- deposit successful in your account");
        System.out.println("--------------------------------");
        //sc.close();
        A.prompt_d();
    }
}

class wi
{
    static void withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------------");
        System.out.println("Enter amount to withdraw in your account:");
        int w=sc.nextInt();
        //sc.close();
        if(w<=A.balance){
            A.balance=A.balance-w;
            A.history.add("Withdraw    - ");
            A.history.add(Integer.toString(w));
            System.out.println("Amount Rs"+w+"/- withdraw successfully in your account");
            System.out.println("-------------------------------");
        }
        else{
            System.out.println("Insufficient balance to withdraw the cash in your account");
            System.out.println("---------------------------");
        }
        A.prompt_d();
    }
}
class tr
{
    static void transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter transfer account number");
        int num=sc.nextInt();
        System.out.println("Transferred amount is:");
        int t=sc.nextInt();
        if(t<=A.balance){
            A.balance=A.balance-t;
            A.history.add("Transferred - ");
            A.history.add(Integer.toString(t));
            System.out.println("cash Rs."+t+"/-  successfully it got transferred");
        }
        else if(num==-1)
        {
            A.prompt_d();
        }
        else{
            System.out.println("Balance is insufficient...so no transferring");
        }
        System.out.println("---------------------------");
        A.prompt_d();
        //sc.close();
    }
}
class che{
    static void checkbalance()
    {
        System.out.println("------------------");
        System.out.println("Bank account available balance:");
        A.showbalance();
        A.prompt_d();
    }
}
class his
{
    static void h_o_tra()
    {
        int p=0;
        if(A.history.size()>0){
            System.out.println("Transaction History :");
            System.out.println("---------------------");
            for(int i=0;i<(A.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.print(A.history.get(p)+" ");
                    p++;
                }
                System.out.println();
            }
        }
        else {
            System.out.println("you have not made any Transaction");
        }
        System.out.println("------------------------");
        A.prompt_d();
    }
}
