import java.io.*;
import java.util.*;
public class Main
{
  public static int helper (int n, int m)
  {
    if (m == 0)
      {
	return 0;
      }
    int sum = n + helper (n, m - 1);
    return sum;
  }
  public static void multiplyRecursively (int n, int m)
  {
    System.out.println (helper (n, m));

  }

  public static void main (String[]args)
  {
    Scanner scn = new Scanner (System.in);
    int n = scn.nextInt ();
    int m = scn.nextInt ();
    multiplyRecursively (n, m);
  }
}
