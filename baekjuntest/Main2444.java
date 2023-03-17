package baekjuntest;
import java.util.Scanner;

public class Main2444 {
	public static void main(String[] args) {
	   
		Scanner sc = new Scanner(System.in);
	    
		int n = sc.nextInt();
	    
		for (int i = 1; i <= n; i++) {
	      for (int j = 0; j < n - i; j++)
	        System.out.print(" ");
	      
	      for (int j = 0; j < 2 * i - 1; j++)
	        System.out.print("*");
	  
	      System.out.println();
	    }
	    
	    for (int i = n - 1; i >= 1; i--) {
	      for (int j = 0; j < n - i; j++)
	        System.out.print(" ");
	     
	      for (int j = 0; j < 2 * i - 1; j++)
	        System.out.print("*");
	     
	      System.out.println();
	      
	    }
	  }
	}