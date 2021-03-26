import java.io.*;
public class Restaurant2
{
    int total;
    int fooditemsprice[]=new int[23];
    String fooditems[]=new String[23];
    int dishtotal[]=new int[23];
    int order[]=new int[50];//maximum orders assumed to be 50.
    int quantity[]=new int[23];
      public String printbillcontents(String str1,String str2,String str3,String str4)
    {
     String str="";
     int x;
       str=str+str1;
       x=35-str1.length();
       for(int j=0;j<x;j++)
       str=str+" ";
       str=str+str2;
       x=13-str2.length();
       for(int j=0;j<x;j++)
       str=str+" ";
       str=str+str3;
       x=13-str3.length();
       for(int j=0;j<x;j++)
       str=str+" ";
       str=str+str4;
       return(str);
    }
    public Restaurant2()
    {
      fooditems[0]="chicken lollipop";                fooditemsprice[0]=120;
      fooditems[1]="mutton roast";                    fooditemsprice[1]=200;
      fooditems[2]="non veg kaima";                   fooditemsprice[2]=100;
      fooditems[3]="andhra style chilli chicken";     fooditemsprice[3]=160;
      fooditems[4]="fish fry";                        fooditemsprice[4]=180;
      fooditems[5]="tandoori chicken";                fooditemsprice[5]=120;
      fooditems[6]="chicken kabab";                   fooditemsprice[6]=100;
      fooditems[7]="omlette";                         fooditemsprice[7]=20;
      fooditems[8]="alu kabab";                       fooditemsprice[8]=30;
      fooditems[9]="gobi manchuri";                   fooditemsprice[9]=80;
      fooditems[10]="onion fry";                      fooditemsprice[10]=30;
      fooditems[11]="paneer tikka";                   fooditemsprice[11]=120;
      fooditems[12]="rice meals";                     fooditemsprice[12]=60;
      fooditems[13]="naan";                           fooditemsprice[13]=40;
      fooditems[14]="boiled rice";                    fooditemsprice[14]=40;
      fooditems[15]="egg fried rice";                 fooditemsprice[15]=80;
      fooditems[16]="veg fried rice";                 fooditemsprice[16]=80;
      fooditems[17]="chinese noodles";                fooditemsprice[17]=120;
      fooditems[18]="veg biriyani";                   fooditemsprice[18]=120;
      fooditems[19]="non veg biriyani";               fooditemsprice[19]=120;
      fooditems[20]="roti";                           fooditemsprice[20]=15;
      fooditems[21]="idli";                           fooditemsprice[21]=40;
      fooditems[22]="dosa";                           fooditemsprice[22]=40;
    }
    void initq()
    {
      for(int i=0;i<23;i++)
       quantity[i]=0;
    }     
    public void displaymenu2()
    {
        System.out.println("                             MENU");
        System.out.println();
        System.out.println("                                           PRICE");
        System.out.println("                                           (in Rs.)");
        System.out.println();
        System.out.println(" NON VEG SPECIALS ");
        System.out.println("1.chicken lollipop              -            120");
        System.out.println("2.mutton roast                  -            200");
        System.out.println("3.non veg kaima                 -            100");
        System.out.println("4.andhra style chilli chicken   -            160");
        System.out.println("5.fish fry                      -            180");
        System.out.println("6.tandoori chicken              -            120");
        System.out.println("7.chicken kabab                 -            100");
        System.out.println("8.omlette                       -            20");
        System.out.println();
        System.out.println("VEG SPECIALS");
        System.out.println("9.alu kabab                     -            30");
        System.out.println("10.gobi manchuri                -            80");
        System.out.println("11.onion fry                    -            30");
        System.out.println("12.paneer tikka                 -            120");
        System.out.println();
        System.out.println("MAIN COURSE");
        System.out.println("13.rice meals                   -            60");
        System.out.println("14.naan                         -            40");
        System.out.println("15.boiled rice                  -            40");
        System.out.println("16.egg fried rice               -            80");
        System.out.println("17.veg fried rice               -            80");
        System.out.println("18.chinese noodles              -            120");
        System.out.println("19.veg biriyani                 -            120");
        System.out.println("20.non veg biriyani             -            120");
        System.out.println("21.roti                         -            15/pc");
        System.out.println("22.idli                         -            40/3pc");
        System.out.println("23.dosa                         -            40/pc\n");
    }
    public int acceptorder()throws IOException
    {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        System.out.println("Enter the serial no.of the food items to be ordered(21 items totally contained in the menu)");
        System.out.println("After that, type yes if confirmed");
        System.out.println("Then enter the no. of the food item required");
        System.out.println("Enter \"satisfied\" when ordering is enough");
        int i=0;int donepoint=0;
        String str;String str2;
        int virtualorder=0;String cl="";int ord;String str3="";
          str=in.readLine();
          while(true)
          {
          if(str.equalsIgnoreCase("satisfied"))
          {
              donepoint=i+1;;
              System.out.println("\n");
              break;
          }
          else
          {
            virtualorder=Integer.parseInt(str);
            order[i]=virtualorder-1;ord=order[i];
            i+=1;
            cl=fooditems[ord].toUpperCase();System.out.println(cl);//This and......
            System.out.println("You have ordered "+fooditems[ord]+" Please confirm-yes or no");/*this are also reminders 
            for you to type yes or no!!!*/
            str2=in.readLine();
           if(str2.equalsIgnoreCase("yes"))
            {
               System.out.println("Please tell the no. of orders of "+fooditems[ord]+" required");
               quantity[ord]=Integer.parseInt(in.readLine());
               System.out.print("\n");
               str=in.readLine();
            }
            else if(str2.equalsIgnoreCase("no"))
            {
              System.out.println("Then can you tell your next order or that you are satisfied(if so type\"satisfied\")");
              str=in.readLine();
            }
          }
        }
        return(donepoint);
    }
    public int calculatebill2(int donepoint)
    { 
        int ord=0;      
        int amount=0;
        int q=0;
        for(int i=0;i<donepoint;i++)
        {
           ord=order[i]; 
           q=quantity[ord];
           if(q>0)
           {
              dishtotal[ord]=dishtotal[ord]+quantity[ord]*fooditemsprice[ord];  
              amount=amount+quantity[ord]*fooditemsprice[ord];
           }
        }
        this.total=amount;
        return(amount);
    }
    public void displaybill2(int total)
    {
        Restaurant2 ob2=new Restaurant2();
        String str,str1,str2,str3,str4;
        int a,b;
                System.out.println("                                  BILL\n");
                System.out.println("FOOD ITEM                         RATE           NO. OF       AMOUNT");
                System.out.println("                                                 ITEMS");
                for(int i=0;i<23;i++)
                {
                    if(quantity[i]>0)
                    {
                      str1=fooditems[i];
                      str2=Integer.toString(fooditemsprice[i]);
                      str3=Integer.toString(quantity[i]);
                      str4=Integer.toString(dishtotal[i]);
                      str=ob2.printbillcontents(str1,str2,str3,str4);
                      System.out.println(str);
                     }
                }
                System.out.println("                                                  TOTAL AMOUNT="+total+"\n");
        }
    public void paybill(int total)throws IOException
    {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        int rem,acc2;rem=0;acc2=0;
        System.out.println("Please pay the bill- total amount="+total);
        int billamt=Integer.parseInt(in.readLine());
        rem=total-billamt;
        if(billamt<total)
        {
            while(true)
            {
                System.out.println("Sir/Madam, your pay is short of "+rem);
                System.out.println("Kindly pay the amount");
                acc2=Integer.parseInt(in.readLine());
                if(acc2==rem)
                {
                 System.out.println("Thank you Sir/Madam");
                 break;
                }
                else if(acc2<rem)
                rem=rem-acc2;
                else if(acc2>rem)
                {
                   System.out.println("Thank you Sir/Madam");   
                  System.out.println("Sir/Madam, you have paid "+(acc2-rem)+"more than then total amount");
                  System.out.println("Here is the balance");
                  System.out.println((acc2-rem));
                  break;
                 }
                
                }
        }
        else if(billamt==total)
        System.out.println("Thank you Sir/Madam");
        else if(billamt>total)
        {
         System.out.println("Thank you Sir/Madam");   
         System.out.println("Sir/Madam, you have paid "+(billamt-total)+" more than then total amount");
         System.out.println("Here is the extra money");
         System.out.println((billamt-total));
        }
    }
    public void discount()
    {
      Restaurant2 ob1=new Restaurant2();
      int a;
      float d=0;float fp=0;int dpc=0;
      System.out.println("Enter the amount spent on your shopping");
      a=this.total;
      if(a<500)
      {
          fp=(float)a;
      }
      else if((a>=500)&&(a<1000))
      {
          dpc=10;
          d=(float)a*dpc/100;
          fp=(float)a-d;
      }
      else if((a>=1000)&&(a<1500))
      {
          dpc=15;
          d=(float)a*dpc/100;
          fp=(float)a-d;
      }
      else if((a>=1500)&&(a<2000))
      {
          dpc=20;
          d=(float)a*dpc/100;
          fp=(float)a-d;
      }
      else if((a>=2000)&&(a<2500))
      {
          dpc=30;
          d=(float)a*dpc/100;
          fp=(float)a-d;
      }
      else if(a>=2500)
      {
          dpc=40;
          d=(float)a*dpc/100;
          fp=(float)a-d;
      }
      this.total=Math.round(fp);
      System.out.println("Amount="+a);
      System.out.println("Your discount p.c. is  "+dpc+"%");
      System.out.println("Price after discount= "+fp);
    }
    public static void main()throws IOException
    {
                System.out.println("                   WELCOME TO THE ROYALE RESTAURANT\n");
        Restaurant2 ob1=new Restaurant2();
        ob1.initq();
        ob1.displaymenu2();        
        int donepoint=ob1.acceptorder();
        int total=ob1.calculatebill2(donepoint);
        ob1.displaybill2(total);
        ob1.discount();
        total=ob1.total;
        ob1.paybill(total);
                System.out.println("                       THANK YOU FOR YOUR VISIT");
                System.out.println("                         KINDLY VISIT AGAIN\n\n");
    }
}
//howzaat!!  
//Kevin says,"Well done!!!!!!"     