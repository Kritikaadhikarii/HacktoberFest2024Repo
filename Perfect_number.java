//Perfect number: number which is equal to the sum of its factors other than the number itself
//Example:6, as 6=1+2+3
import java.util.*;
class PerfectNumber
{

    static boolean isPerfect(int n)
{
    int sum = 1;
 
    for (int i = 2; i * i <= n; i++)
    {
        if (n % i==0)
        {
            if(i * i != n)
                sum = sum + i + n / i;
            else
                sum = sum + i;
        }
    } 

    if (sum == n && n != 1)
        return true;
 
    return false;
}
    public static void main(String[] args) 
    {
        System.out.println("Enter a number");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        if(isPerfect(n))
        System.out.println("It is a perfect number");
        else
        System.out.println("Not a perfect number");
    }
}
