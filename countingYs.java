import java.util.*;
public class countingYs
{
  public static void main(String args[])
   {
    Scanner in=new Scanner(System.in);
    String str="",str2="",s="";
    System.out.println("Enter a String");
    str=in.nextLine();
    System.out.println("Enter the letter to be checked for");
    s=in.nextLine();
    char ch=s.charAt(0);
    str=str.trim();
    str=str+' ';
    int x=str.length();
    char p1=' ',p2=' ',p3=' ';int y=0;int i2;int j=0;
    boolean b=false;
    int a[]=new int[21];
    for(int i1=0;i1<x;i1++)
    {
        p1=str.charAt(i1);
        if(p1==' ')
        {
            p2=str.charAt(i1-1);
            if(p2==ch)
            {
                y=y+1;
                a[j]=i1;
                j=j+1;
            }
     }
    }
    if(y!=0)
    {
     System.out.println("The words in the string ending with "+ch+" are: ");
     str=' '+str;
     int l=a.length;
     for(int i3=0;i3<=y-1;i3++)
     {
        i2=(a[i3]+1);
        p3=str.charAt(i2);
        b=false;
        while(b!=true)
          {
               if(i2!=(a[i3]+1))
                str2=p3+str2;
               i2=i2-1;
               p3=str.charAt(i2);
               if(p3==' ')
                 {
                   b=true;
                   System.out.println(str2);
                   str2="";
                 }
          }   
      }
    }
     System.out.println("The no. of words ending with "+ch+" is "+y);
  }
}  
                    