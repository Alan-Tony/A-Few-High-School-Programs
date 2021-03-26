import java.io.*;
public class Restaurant
{
    String fooditems[]=new String[21];
    int quantity[]=new int[21];
    public void displaymenu()
    {
        System.out.println("                             MENU");
        System.out.println();
        System.out.println("                                           PRICE");
        System.out.println("                                           (in Rs.)");
        System.out.println();
        System.out.println(" NON VEG SPECIALS ");
        System.out.println("chicken lollipop              -            120");
        System.out.println("mutton roast                  -            200");
        System.out.println("non veg kaima                 -            100");
        System.out.println("andhra style chilli chicken   -            160");
        System.out.println("fish fry                      -            180");
        System.out.println("tandoori chicken              -            120");
        System.out.println("chicken kabab                 -            100");
        System.out.println("omlette                       -            20");
        System.out.println();
        System.out.println("VEG SPECIALS");
        System.out.println("alu kabab                     -            30");
        System.out.println("gobi manchuri                 -            80");
        System.out.println("onion fry                     -            30");
        System.out.println("paneer tika                   -            120");
        System.out.println();
        System.out.println("MAIN COURSE");
        System.out.println("rice meals                    -            60");
        System.out.println("naan                          -            40");
        System.out.println("boiled rice                   -            40");
        System.out.println("egg/veg fried rice            -            80");
        System.out.println("chinese noodles               -            120");
        System.out.println("veg/non veg biriyani          -            120");
        System.out.println("roti                          -            15/pc");
        System.out.println("idli-sambar                   -            40/4pc");
        System.out.println("dosa                          -            40/pc\n");
    }
    public int acceptorder()throws IOException
    {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        System.out.println("Enter the food items to be ordered(21 items totally contained in the menu");
        System.out.println("followed by units required");
        System.out.println("Enter \"satisfied\" when ordering is enough");
        int i;int donepoint=0;
        String str;
        for(i=0;i<21;i++)
        {
          str=in.readLine();
          if(str.compareTo("satisfied")==0)
          {
              donepoint=i;
              System.out.println("\n");
              break;
          }
          else
          {
            fooditems[i]=str;
            quantity[i]=Integer.parseInt(in.readLine());
          }
        }
        return(donepoint);
    }
    public int calculatebill(int donepoint)
    {   
        int amount=0;
        String str="";
        for(int i=0;i<donepoint;i++)
        {
            str=fooditems[i];
            if(str.equalsIgnoreCase("roti"))
            amount=amount+(quantity[i]*15);
            if(str.equalsIgnoreCase("omlette"))
            amount=amount+(quantity[i]*20);
            if(str.equalsIgnoreCase("alu kabab"))
            amount=amount+(quantity[i]*30);
            if(str.equalsIgnoreCase("onion fry"))
            amount=amount+(quantity[i]*30);
            if(str.equalsIgnoreCase("naan"))
            amount=amount+(quantity[i]*40);
            if(str.equalsIgnoreCase("boiled rice"))
            amount=amount+(quantity[i]*40);
            if(str.equalsIgnoreCase("idli&sambar"))
            amount=amount+(quantity[i]*40);
            if(str.equalsIgnoreCase("dosa"))
            amount=amount+(quantity[i]*40);
            if(str.equalsIgnoreCase("rice meal"))
            amount=amount+(quantity[i]*60);
            if(str.equalsIgnoreCase("gobi manchuri"))
            amount=amount+(quantity[i]*80);
            if(str.equalsIgnoreCase("egg fried rice")||str.equalsIgnoreCase("veg fried rice"))
            amount=amount+(quantity[i]*80);
            if(str.equalsIgnoreCase("non veg kaima"))
            amount=amount+(quantity[i]*100);
            if(str.equalsIgnoreCase("chicken kabab"))
            amount=amount+(quantity[i]*100);
            if(str.equalsIgnoreCase("chicken lollipop"))
            amount=amount+(quantity[i]*120);
            if(str.equalsIgnoreCase("tandoori chicken"))
            amount=amount+(quantity[i]*120);
            if(str.equalsIgnoreCase("panner tikka"))
            amount=amount+(quantity[i]*120);
            if(str.equalsIgnoreCase("chinese noodles"))
            amount=amount+(quantity[i]*120);
            if(str.equalsIgnoreCase("veg biriyani")||str.equalsIgnoreCase("non veg biriyani"))
            amount=amount+(quantity[i]*120);
            if(str.equalsIgnoreCase("andhra style chilli chicken"))
            amount=amount+(quantity[i]*160);
            if(str.equalsIgnoreCase("fish fry"))
            amount=amount+(quantity[i]*180);
            if(str.equalsIgnoreCase("mutton roast"))
            amount=amount+(quantity[i]*200);
        }
        return(amount);        
    }
    public void displaybill(int total,int donepoint)
    {
        String str;str="";
        int dishtotal=0;
                System.out.println("                                  BILL\n");
                System.out.println("FOOD ITEM                         RATE           NO. OF       AMOUNT");
                System.out.println("                                                 ITEMS");  
        for(int i=0;i<donepoint;i++)
        {
            str=fooditems[i];
            if(str.equalsIgnoreCase("roti"))
            {
                dishtotal=15*quantity[i];
                System.out.println("roti                  -            15/pc          "+quantity[i]+"            "+dishtotal);
            }
            if(str.equalsIgnoreCase("omlette"))
            {
                dishtotal=20*quantity[i];
                System.out.println("omlette               -            20             "+quantity[i]+"            "+dishtotal);
            }
            if(str.equalsIgnoreCase("alu kabab"))
            {
                dishtotal=30*quantity[i];
                System.out.println("alu kabab             -            30             "+quantity[i]+"            "+dishtotal);
            }
            if(str.equalsIgnoreCase("onion fry"))
            {
                dishtotal=30*quantity[i];
                System.out.println("onion fry             -            30             "+quantity[i]+"            "+dishtotal);
            }
            if(str.equalsIgnoreCase("naan"))
            {
                dishtotal=30*quantity[i];
                System.out.println("naan                  -            40             "+quantity[i]+"            "+dishtotal);
            }
            if(str.equalsIgnoreCase("boiled rice"))
            {
                dishtotal=40*quantity[i];
                System.out.println("boiled rice           -            40             "+quantity[i]+"            "+dishtotal);
            }
            if(str.equalsIgnoreCase("idli&sambar"))
            {
                dishtotal=40*quantity[i];
                System.out.println("idli&sambar           -            40             "+quantity[i]+"            "+dishtotal);
            }
            if(str.equalsIgnoreCase("dosa"))
            {
                dishtotal=40*quantity[i];
                System.out.println("dosa                  -            40             "+quantity[i]+"            "+dishtotal);
            }
            if(str.equalsIgnoreCase("rice meal"))
            {
                dishtotal=60*quantity[i];
                System.out.println("rice meal             -            60             "+quantity[i]+"            "+dishtotal);
            }
            if(str.equalsIgnoreCase("gobi manchuri"))
            {
                dishtotal=80*quantity[i];
                System.out.println("gobi manchuri         -            80             "+quantity[i]+"            "+dishtotal);
            }
            if(str.equalsIgnoreCase("egg fried rice")||str.equalsIgnoreCase("veg fried rice"))
            {
                dishtotal=80*quantity[i];
                System.out.println("egg/veg fried rice    -            80             "+quantity[i]+"            "+dishtotal);
            }
            if(str.equalsIgnoreCase("non veg kaima"))
            {
                dishtotal=100*quantity[i];
                System.out.println("non veg kaima         -            100            "+quantity[i]+"            "+dishtotal);
            }
            if(str.equalsIgnoreCase("chicken kabab"))
            {
                dishtotal=100*quantity[i];
                System.out.println("chicken kabab         -            100            "+quantity[i]+"            "+dishtotal);
            }
            if(str.equalsIgnoreCase("chicken lollipop"))
            {
                dishtotal=120*quantity[i];
                System.out.println("chicken lollipop      -            120            "+quantity[i]+"            "+dishtotal);
            }
            if(str.equalsIgnoreCase("tandoori chicken"))
            {
                dishtotal=120*quantity[i];
                System.out.println("tandoori chicken      -            120            "+quantity[i]+"            "+dishtotal);
            }
            if(str.equalsIgnoreCase("panner tikka"))
            {
                dishtotal=120*quantity[i];
                System.out.println("panner tikka          -            120            "+quantity[i]+"            "+dishtotal);
            }
            if(str.equalsIgnoreCase("chinese noodles"))
            {
                dishtotal=120*quantity[i];
                System.out.println("chinese noodles       -            120            "+quantity[i]+"            "+dishtotal);
            }
            if(str.equalsIgnoreCase("veg biriyani")||str.equalsIgnoreCase("non veg biriyani"))
            {
                dishtotal=120*quantity[i];
                System.out.println("veg/non veg biriyani  -            120            "+quantity[i]+"            "+dishtotal);
            }
            if(str.equalsIgnoreCase("andhra style chilli chicken"))
            {
                dishtotal=160*quantity[i];
                System.out.println("andhra style");          
                System.out.println("chilli chicken        -              160          "+quantity[i]+"            "+dishtotal);
            }
            if(str.equalsIgnoreCase("fish fry"))
            {
                dishtotal=180*quantity[i];
                System.out.println("fish fry              -            180            "+quantity[i]+"            "+dishtotal);
            }
            if(str.equalsIgnoreCase("mutton roast"))
            {
                dishtotal=200*quantity[i];
                System.out.println("mutton roast          -            200            "+quantity[i]+"            "+dishtotal);
            }
        }
                System.out.println("                                                  TOTAL AMOUNT="+total+"\n");
    }
    public static void main(String args[])throws IOException
    {
                System.out.println("                    WELCOME TO ABC RESTAURANT\n");
        Restaurant ob=new Restaurant();
        ob.displaymenu();
        int donepoint=ob.acceptorder();
        int total=ob.calculatebill(donepoint);
        ob.displaybill(total,donepoint);
                System.out.println("                       THANK YOU FOR YOUR VISIT");
                System.out.println("                         KINDLY VISIT AGAIN");
    }
}
//howzaat!!
            
            