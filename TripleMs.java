import java.io.*;
import java.util.Scanner;
public class TripleMs
{
    double mean;
    double median;
    double mode[];
    public int calMs(double sp,int f1[],double cs,int a,double x1[],int f2[],String str,String str2)
    {
        mode=new double[a];
        int i;
        int f[]=new int[a];
        double x[]=new double[a];
        double d[]=new double[a];
        double u[]=new double[a];
        double mp=0.0;
       if(str.equals("CI"))
       {
        double x2[]=new double[a];
        for(i=0;i<a;i++)
         x2[i]=0;
        x2[0]=sp;
        for(i=1;i<a;i++)
         x2[i]=x2[i-1]+cs;
        mp=cs/2;
        for(i=0;i<a;i++)
        {
         x2[i]=x2[i]+mp;
         x[i]=x2[i];
        }
        for(i=0;i<a;i++)
        {
         f[i]=f1[i];
        }
        }
       else if(str.equals("X"))
       {
        for(i=0;i<a;i++)
        {
         f[i]=f2[i];
        } 
        for(i=0;i<a;i++)
        {
         x[i]=x1[i];
        } 
        }
        int smf=0;
        for(i=0;i<a;i++)
         smf=f[i]+smf;
      double fx[]=new double[a];
     double smfx=0.0;
      //-----
      double A=x[0];
      double fd[]=new double[a];
      double smfd=0.0;
        //-----
      double fu[]=new double[a];
      double smfu=0.0;
       if(str2.equalsIgnoreCase("direct method"))
       {
        for(i=0;i<a;i++)
        {
        fx[i]=x[i]*(double)f[i];
        smfx=smfx+fx[i];
       }
       mean=smfx/smf;
      }
      else if(str2.equalsIgnoreCase("short cut method"))
       {
        for(i=0;i<a;i++)
        {
          d[i]=x[i]-A;   
          fd[i]=d[i]*(double)f[i];
          smfd=smfd+fd[i];
       }
       mean=smfd/smf+A;
      }
      else if(str2.equalsIgnoreCase("step deviation method"))
       {
        for(i=0;i<a;i++)
        {
         d[i]=x[i]-A;
         u[i]=d[i]/cs;
         fu[i]=u[i]*(double)f[i];
         smfu=smfu+fu[i];
       }
       mean=smfu/smf*cs+A;
      }
       //mean done
       double m,n;
       double M,N;M=0.0;N=0.0;
       int cf[]=new int[a];  
         smf=0;
      for(i=0;i<a;i++)
       {
           smf=smf+f[i];
           cf[i]=smf;
        }
       char oe=' ';
       double medianOb=0;
       double hN=0.0;
       int xP=0;
       double L=0.0;
       int B=0;
      if(smf%2==0)
        oe='e';
      else
        oe='o';
        if(str.equalsIgnoreCase("X"))
        {
       if(oe=='e')
       {
        m=smf/2;
        n=smf/2+1;
        if(m<=cf[0])
         M=x[0];
        for(i=1;i<a;i++)
        {
            if((m<cf[i])&&(m>cf[i-1]))
            M=x[i];
        }
        if(n<=cf[0])
         N=x[0];
        for(i=1;i<a;i++)
        {
            if((n<cf[i])&&(n>cf[i-1]))
            N=x[i];
        }
        median=(M+N)/2;
       }
       else if(oe=='o')
       {
        medianOb=((double)smf+1)/2.0;System.out.println(medianOb+"a");
        if(medianOb<=cf[0])
         median=x[0];
        for(i=1;i<a;i++)
        {
            if((medianOb<cf[i])&&(medianOb>cf[i-1]))
            {
            median=x[i];
            break;
           }
        }
       }
      }
      else if(str.equalsIgnoreCase("CI"))
      {
        hN=(double)smf/2.0;
       if(hN<=(double)cf[0])
        xP=0;
       for(i=1;i<a;i++)
       {
         if((hN<=(double)cf[i])&&(hN>(double)cf[i-1]))
          xP=i;
       }
        L=x[xP]-mp;
        for(i=0;i<cf[xP-1];i++)
         B=B+1;
        median=L+(hN-(double)B)*cs/f[xP]; 
      }
       //median done
           int max=0,maxP=0;
     for(i=0;i<a;i++)
         {
            if(f[i]>max)
              {
              max=f[i];
              maxP=i;
              }
          }
          int c=0;
     if(str.equalsIgnoreCase("CI"))
      {
          double Llmf=x[maxP]-mp;
          double fmax1;
          if(maxP==0)
          fmax1=0.0;
          else
          fmax1=(double)f[maxP-1];
          double fmax2;
          if(maxP==(a-1))
          fmax2=0.0;
          else
          fmax2=(double)f[maxP+1];
          if(fmax1==0.0&&fmax2==0)
          mode[0]=Llmf+cs*(((double)max-fmax1)/(2.0*(double)max-fmax1-fmax2));
          else
          mode[0]=Llmf+cs/2.0;
       }
        else if(str.equalsIgnoreCase("X"))
        {
            i=0;
            do
            {
                if(f[i]==max)
                {
                   mode[c]=x[i];
                   c=c+1;
                }
                i++;
            }
            while(i<a);
        }
       //mode done
     if(str.equals("CI"))
        System.out.print("CI           ");
     if(str2.equalsIgnoreCase("direct method"))
       System.out.println("x            f            fx                                cf");
     else if(str2.equalsIgnoreCase("short cut method"))
       System.out.println("x            f            d            fd                   cf");
     else if(str2.equalsIgnoreCase("step deviation method"))
       System.out.println("x            f            d            u            fu      cf");
     for(i=0;i<a;i++)
       {
          if(str.equals("CI"))
          {
           if(i<1)
           System.out.print((float)(x[i]-(cs/2))+"-"+(float)(x[i]+(cs/2))+"     ");
           else if(i<2)
           System.out.print((float)(x[i]-(cs/2))+"-"+(float)(x[i]+(cs/2))+"    ");
           else
           System.out.print((float)(x[i]-(cs/2))+"-"+(float)(x[i]+(cs/2))+"   ");
        }
        if(str2.equalsIgnoreCase("direct method"))
         System.out.println((float)x[i]+"         "+(float)f[i]+"         "+(float)fx[i]+"                             "+(float)cf[i]);
        else if(str2.equalsIgnoreCase("short cut method"))
         System.out.println((float)x[i]+"         "+(float)f[i]+"         "+(float)d[i]+"         "+(float)fd[i]+"                      "+(float)cf[i]);
        else if(str2.equalsIgnoreCase("step deviation method"))
         System.out.println((float)x[i]+"         "+(float)f[i]+"         "+(float)d[i]+"         "+(float)u[i]+"         "+(float)fu[i]+"      "+(float)cf[i]);
       }
     if(str.equals("CI"))
         System.out.print("           ");
     if(str2.equalsIgnoreCase("direct method"))
         System.out.println("                       "+"smfx= "+(float)smfx);
     else if(str2.equalsIgnoreCase("short cut method"))
         System.out.println("                                "+"smfd= "+(float)smfd);
     else if(str2.equalsIgnoreCase("step deviation method"))
         System.out.println("                                              "+"smfu= "+(float)smfu);
      return(c);
    }
    public int calMs(double x[],int a)
    {
        mode=new double[a];
        double smx=0;
        int i,j;
        for(i=0;i<a;i++)
         smx=smx+x[i];
        mean=smx/a;
        //mean done
       int min;
       double t;
       for(i=0;i<(a-1);i++)
        {
           min=i;
           for(j=(i+1);j<a;j++)
           {
               if(x[min]>x[j])
                min=j;
            }
            t=x[i];
            x[i]=x[min];
            x[min]=t;
         }
        char oe=' ';
       if(a%2==0)
       oe='e';
       else
       oe='o';
       if(oe=='e')
       median=(x[a/2]+x[a/2+1])/2;
       else if(oe=='o')
       median=x[(a+1)/2];
       //median done
        int c=0;
        double x2[]=new double[a];
        int k=0;
        int y[]=new int[a];
        for(i=0;i<a;i++)
            y[i]=0;
       for(i=0;i<a;i++)
       {
           for(j=0;j<a;j++)
           {
               if(y[j]==1)
               {
                   if(x[j]==x[i])
                   {
                       k=1;
                       break;
                    }
                }
            }
           if(k!=1)
            {
                x2[i]=x[i];
                y[i]=1;
                c=c+1;
            }
            k=0;
        }
       double x3[]=new double[c];
        for(i=0;i<c;i++)
          x3[i]=x2[i];
          int f[]=new int[c];
       for(i=0;i<c;i++)
          {
              for(j=0;j<a;j++)
              {
                  if(x[j]==x3[i])
                   f[i]=f[i]+1;
                }
            }
       int maxf=0;
       for(i=0;i<c;i++)
       {
          if(f[i]>maxf)
            maxf=f[i];  
        }
       i=0;
       int c2=0;
       do
       {
         if(f[i]==maxf)
         {
           mode[c2]=x3[i];
           c2=c2+1;
          }
         i++; 
        }
        while(i<c);
       //mode done
       for(i=0;i<a;i++)
       {
          if(i!=(a-1))
          System.out.print((float)x[i]+",");
          else
          System.out.println((float)x[i]);
       }
       return(c2);
    }
    public void InputAndExecute()throws IOException
    {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        TripleMs ob=new TripleMs();
        String str="";
        int a;int i,j;
        int c=0;
        System.out.println("Enter 1 if you want to enter grouped data and 2 for entering ungrouped data");
        int choice1=Integer.parseInt(in.readLine());
        switch(choice1)
        {
            case 1:
            double cs,sp;
            System.out.println("Enter \"CI\" if you want to enter CI(mean calculated in direct method) or \"X\" if you want to enter observations");
            str=in.readLine();
            if(str.equals("CI"))
            {
              System.out.println("Enter the number of class intervals");
              a=Integer.parseInt(in.readLine());
              int f1[]=new int[a];
              double x1[]=new double[a];
              for(i=0;i<a;i++)
                 x1[i]=0.0;
               int f2[]=new int[a];
              for(i=0;i<a;i++)
                 f2[i]=0;
              System.out.println("Enter the class size");
              cs=Double.parseDouble(in.readLine());
              System.out.println("Enter the starting number");
              sp=Double.parseDouble(in.readLine());
              System.out.println("Enter the frequencies(let the frequencies be in ascending in values and then go descending)");
              for(i=0;i<a;i++)
               f1[i]=Integer.parseInt(in.readLine());
              System.out.println("Enter whether mean should be calculated in \"direct method\", \"short cut method\", or \"step deviation method\"");
              String str2=in.readLine();
              c=ob.calMs(sp,f1,cs,a,x1,f2,str,str2);
            }
            else if(str.equals("X"))
            {
                cs=0.0;
                sp=0.0;
                System.out.println("Enter the number of obsevations");
                a=Integer.parseInt(in.readLine());
                double x1[]=new double[a];
                int f2[]=new int[a];
                int f1[]=new int[a];
                double m[][]=new double[a][2];
                for(i=0;i<a;i++)
                  f1[i]=0;
                     int min;
                     double t;
                System.out.println("Enter 1 for entering freq. after arranging the ob. & 2 for arranging both after entering both ob.& freq. ");
                 int choice2=Integer.parseInt(in.readLine());
                switch(choice2)
                 {
                     case 1:
                    System.out.println("Enter the observations");
                    for(i=0;i<a;i++)
                      x1[i]=Double.parseDouble(in.readLine()); 
                       for(i=0;i<(a-1);i++)
                       {
                         min=i;
                     for(j=(i+1);j<a;j++)
                     {
                        if(x1[min]>x1[j])
                         min=j;
                     }
                      t=x1[i];                
                      x1[i]=x1[min];        
                      x1[min]=t;
                    }
                    System.out.println("Here are the observations in ascending order: ");
                    for(i=0;i<a;i++)
                     System.out.println(x1[i]);
                    System.out.println("Enter the frequencies(let the frequencies be in ascending in values and then go descending)");
                    for(i=0;i<a;i++)
                      f2[i]=Integer.parseInt(in.readLine());
                      break;
                     case 2:
                    System.out.println("Enter the observations");
                    for(i=0;i<a;i++)
                      m[i][0]=Double.parseDouble(in.readLine());
                    System.out.println("Enter the frequencies(let the frequencies be in ascending in values and then go descending)");
                    for(i=0;i<a;i++)
                      m[i][1]=Double.parseDouble(in.readLine());                
                     for(i=0;i<(a-1);i++)
                       {
                         min=i;
                     for(j=(i+1);j<a;j++)
                     {
                        if(m[min][0]>m[j][0])
                         min=j;
                     }
                      t=m[i][0];                
                      m[i][0]=m[min][0];        
                      m[min][0]=t;
                                 
                      t=m[i][1];
                      m[i][1]=m[min][1];
                      m[min][1]=t;
                    }
                    for(i=0;i<a;i++)
                    {
                       x1[i]=m[i][0];
                       f2[i]=(int)m[i][1];
                    }
                     break;
                     default:
                     System.out.println("Wrong Choice");
                    }
                String str2="direct method";
                c=ob.calMs(sp,f1,cs,a,x1,f2,str,str2);
            }
            break;
            case 2:
            System.out.println("Enter the no. of observations");
            a=Integer.parseInt(in.readLine());
            double x[]=new double[a];
            System.out.println("Enter the observations");
            for(i=0;i<a;i++)
              x[i]=Double.parseDouble(in.readLine());
            c=ob.calMs(x,a);
            break;
            default:
            System.out.println("Wrong choice");
        }
        System.out.println("mean= "+ob.mean);
        System.out.println("median= "+ob.median);
       if(str.equalsIgnoreCase("X")||(choice1==2))
        {
          if(c>1)
          {
            System.out.println("Modal values are:");
            for(i=0;i<c;i++)
             System.out.println(ob.mode[i]);
         }
         else
          System.out.println("mode= "+ob.mode[0]);
        }
        else
        System.out.println("mode= "+ob.mode[0]);
        System.out.println();
    }
    public static void main()throws IOException
    {
        TripleMs ob2=new TripleMs();
        Scanner in=new Scanner(System.in);
        String str;
        ob2.InputAndExecute();
        while(true)
        {
          System.out.println("Enter ' ' to continue or anything else to exit");
          str=in.nextLine();
          if(str.equals(" "))
          ob2.InputAndExecute();
          else
          break;
       }
    }
}
  //Kevin says,"Well done!!!!!!"
  //48 loops!!