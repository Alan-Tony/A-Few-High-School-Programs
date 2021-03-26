import java.io.*;
public class SineCosWaves
{
    public static void main(String args[])throws IOException
    {
          InputStreamReader read=new InputStreamReader(System.in);
          BufferedReader in=new BufferedReader(read);
          int a=0;int k;
          int T;
          int stop=0;
          int i=0;
          int j;
          double s;
          int O,A;
          String str;int x=0;int y=0;;
          int n=0;int p=0;
          int choice;
          char ch;String str2;
          System.out.println("Enter the offset and amplitude");
      while(true)
          {
            System.out.println("Enter the character to be printed in the waveform");
            str2=in.readLine();
            ch=str2.charAt(0);
            System.out.print("Enter the value of O :");
            O=Integer.parseInt(in.readLine());
            System.out.print("Enter the value of A :");
            A=Integer.parseInt(in.readLine());
            System.out.print("Enter the value of T :");
            T=Integer.parseInt(in.readLine());
            System.out.println("Enter the value of n:-(count) or the no. of periods(p) to be printed :");
            System.out.print("Enter 1 for counts or 2 for no. of periods:");
            choice=Integer.parseInt(in.readLine());
           switch(choice)
            {
             case 1:
              {
               System.out.print("Enter the value of n:");
               n=Integer.parseInt(in.readLine());
               break;
              }
             case 2:
              {
                System.out.print("Enter the no. of periods:");
                p=Integer.parseInt(in.readLine());
                n=p*T;
                break;
              }
             default:
             System.out.println("Wrong choice");
            }
            System.out.println("O= "+O);
            System.out.println("A= "+A);
            System.out.println("T = "+T);
            if(choice==2)
            System.out.println("p= "+p);
            System.out.println("n= "+n);
            i=0;
            x=0;
            while(i<n)
                {
                   s=O+(Math.round((Math.sin(2*3.141592654*i/T)*((double)A))));
                   for(j=1;j<=s;j++)
                   System.out.print(" ");
                   System.out.print(ch);
                   x=x+1;
                   s=(3*O)+(Math.round((Math.cos(2*3.141592654*i/T)*((double)A))))-s; 
                   for(j=1;j<=s;j++)
                   System.out.print(" ");
                   System.out.println(ch);
                   i=i+1;
                   a=0;
                   for(k=0;k<30000000;k++)
                    a=a+1;
               }
               y=n/T;
               System.out.println(" No. of stars printed in each wave="+x+" , the no.of complete oscillations= "+y);
            System.out.println("Do u want to continue?(yes or no)");
            str=in.readLine();
           if(str.compareTo("yes")==0)
            continue;
           else if(str.compareTo("no")==0)
            break;
          }
    }
}