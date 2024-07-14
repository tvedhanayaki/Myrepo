import java.util.*;
class Pro
{
  public static void main(String[]args)
  {
    Scanner sc = new Scanner(System.in);
    int input  = sc.nextInt();
    int fact =1;
    for(int  i =1;i<=input;i+=1)
    {
     fact = fact*i;
    }
    System.out.print(fact);
  }
}