public class stopwatch
{
   public static void main(String args[])
   {
        long a=0;long b=0;long c=0;String str,str2,str3;
      while(true)
        {
            for(int i=0;i<1100000000;i++){}
            System.out.print("\f");
         a=a+1;
         if(a%60==0)
         {
         b=b+1;
         a=0;
        }
        if(b!=0)
        if(b%60==0)
        {
            c=c+1;
            b=0;
        }
        str=Long.toString(a);
        str2=Long.toString(b);
        str3=Long.toString(c);
        if(a<10)
        str="0"+str;
        if(b<10)
        str2="0"+str2;
        if(c<10)
        str3="0"+str3;
        System.out.print("   "+str3+":"+str2+":"+str);
      }
   }
}
//fast-734000000    

       