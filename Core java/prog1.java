//prime or not
import java.util.*;
class prog1{
	public static void main(String [] args){
		int num, count=0;
		System.out.print("enter a number: ");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		for(int i=2;i<=num/2;i++)
			if(num%i==0) count++;
		
		if(count==0) System.out.print("It is Prime");
		else System.out.print("Not a prime");
	}
}
