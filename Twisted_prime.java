//Twisted prime: A prime number is said to be twisted prime if the new number obtained after reversing digits is also a prime number.
//Example:167, 761-->also prime
import java.util.*;
class TwistedPrime
{
    public static void main(String[] args) 
    {
        System.out.println("Enter a number");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=0,r=0,d;
        for(int i=2;i<n;i++)
        {
            if(n%i==0)
            {
                c++;
                break;
            }
        }
        if(c==0)
        {
            while(n>0)
            {
                d=n%10;
                n=n/10;
                r=r*10+d;
            }
            for(int i=2;i<n;i++)
            {
                if(n%i==0)
                {
                    c++;
                    break;
                }
            }
        }
        if(c==0)
        {
            System.out.println("The entered number is a twisted prime number");
        }
        else
        {
          System.out.println(n+"The entered number is not a twisted prime number");   
        }
    }
}
