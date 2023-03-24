import java.util.Scanner;
import java.util.Random;

public class GTN 
{
    public static void main(String[] ag) 
    {
        System.out.println("1.Start the game \n2.Exit");
        System.out.println("Enter your choice :");
        int choice_your =tii(2);
        int nr=1;
        int roundNo=0;
        
        if(choice_your ==1) 
        {
            while(nr ==1) 
            {
                RG g=new RG();
                boolean mat =false;
                boolean limi=false;
                System.out.println("\nRound "+ ++roundNo + "status ...");
                while(!mat && !limi){
                    limi =g.tui();
                    mat =g.icg();
                    
                }
                System.out.println("1.Next Round \n2.Exit");
                System.out.println("Enter your choice :");
                nr= tii(2);
                if(nr != 1)
                    System.exit(0);
            }
        }
        else
            System.exit(0);
    }
    public static int tii(int limit) 
    {
        int input_from=0;
        boolean t =false;
        while(t==false) 
        {
            try 
            {
                Scanner sc=new Scanner(System.in);
                input_from=sc.nextInt();
                t=true;
                
                if(t && input_from>limit ||input_from <1) 
                {
                    System.out.println("Choose the number  between 1 to "+limit);
                    t=false;    
                }
            }
            catch(Exception e) 
            {
                System.out.println("Enter only integer value :");
                t=false;
            }
        };
        return input_from;
    }
}

class RG
{
    int ifs;
    int ifu;
    int cg=0;
    RG()
    {
        Random random_obj=new Random();
        this.ifs=random_obj.nextInt(100)+1;
    }
    public boolean icg() 
    {
        if(ifs==ifu) 
        {
            System.out.println("you found number , congo : "+ifs+"in"+cg+"guesses");
            switch(cg) 
            {
                case 1:System.out.println("100 score points");break;
                case 2:System.out.println("90 score points");break;
                case 3:System.out.println("80 score points");break;
                case 4:System.out.println("70 score points");break;
                case 5:System.out.println("60 score points");break;
                case 6:System.out.println("50 score points");break;
                case 7:System.out.println("40 score points");break;
                case 8:System.out.println("30 score points");break;
                case 9:System.out.println(" 20 score points");break;
                case 10:System.out.println("10 score points");break;
            }
            System.out.println();
            return true;
        }
        else if(cg < 10 && ifu>ifs) 
        {
            if(ifu-ifs>10)
                System.out.println("very High");
            else
                System.out.println("bit High");
        }
        else if(cg<10 && ifu<ifs) 
        {
            if(ifs -ifu >10)
                System.out.println("very Low");
            else
                System.out.println("bit Low");
        }
        return false;
    }
    public boolean tui() 
    {
        if(cg <10) 
        {
            System.out.print("number guess :");
            this.ifu=GTN.tii(100);
            cg++;
            return false;
        }
        else 
        {
            System.out.println("oof attempts finised...next time better luck");
            return true; 
        }
    }
}