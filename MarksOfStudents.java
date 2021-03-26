import java.io.*;
public class MarksOfStudents
{
    public static void main(String args[])throws IOException
    {   //a is the number of students whereas b is the number of subjects
        int a,b;
        int i,j,x;double maxmark;int min;
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        System.out.print("No. of students= ");
        a=Integer.parseInt(in.readLine());
        System.out.print("No. of subjects= ");
        b=Integer.parseInt(in.readLine());
        double m[][]=new double[a][b];
        String n[]=new String[a];
        double pc[]=new double[a];
        double total[]=new double[a];
        for(i=0;i<a;i++)
        total[i]=0.0;
        String subn[]=new String[b];
        double tto,tsm,tpc;String tn;
        String strsb="",strst="",str="",str2="",str3="";// str3 is for "subject's " or "subjects;" decision
        if(b==1)
        str3="Subject's";
        else if(b>1)
        str3="Subjects'";
        if(a>1&&b>1)
        {
            str="marks for the subjects";
            str2="names of the subjects";
            strst="each student with the marks of their ";
            strsb="subjects' following each name";
        }
        else if(a==1&&b>1)
        {
            str="marks for the subjects";
            str2="names of the subjects";
            strst="the student and the marks of";
            strsb="the subjects following the name";
        }
        else if(a>1&&b==1)
        {
            str="marks for the subject";
            str2="name of the subject";
            strst="each student with the mark of their ";
            strsb="subject following each name";
        }
        else if(a==1&&b==1)
        {
            str="marks for the subject";
            str2="name of the subject";
            strst="the student and the marks of the ";
            strsb="subject following the name";
        }//Just for the grammar!
        System.out.println("Enter a maximum "+str);
        maxmark=Integer.parseInt(in.readLine());
        System.out.println("Enter the "+str2);
        for(i=0;i<b;i++)
        subn[i]=in.readLine();
        System.out.println("Enter the name of "+strst+strsb);
        for(i=0;i<a;i++)
        {
            n[i]=in.readLine();
            for(j=0;j<b;j++)
            m[i][j]=Double.parseDouble(in.readLine());
        }
        for(i=0;i<a;i++)
        {
          for(j=0;j<b;j++)  
              total[i]=total[i]+m[i][j];
          pc[i]=total[i]/(b*maxmark)*100;
        }
        for(i=0;i<a;i++)
        {
            min=i;
            for(j=i+1;j<a;j++)
            if(total[min]<total[j])
                min=j;
            tto=total[min];
            total[min]=total[i];
            total[i]=tto;//Exchanging total marks
            for(x=0;x<b;x++)
            {
                tsm=m[min][x];
                m[min][x]=m[i][x];
                m[i][x]=tsm;//Exchanging subjects marks
            }
            tn=n[min];
            n[min]=n[i];
            n[i]=tn;//Exchanging names
            tpc=pc[min];
            pc[min]=pc[i];
            pc[i]=tpc;//Exchanging percentages
        }
        System.out.println();
        for(i=0;i<a;i++)
        {
          System.out.println("Rank number "+(i+1)+": "+n[i]);
          System.out.println(str3+" marks:");
          for(x=0;x<b;x++)
          System.out.println(subn[x]+": "+m[i][x]);
          System.out.println("Total marks= "+total[i]);
          System.out.println("Total percentage: "+pc[i]);
          System.out.println();
          for(j=0;j<1100000000;j++){}
        }
    }
}