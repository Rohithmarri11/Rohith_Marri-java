//perfect or not
import java.util.*;
class prog4{
	public static void main(String [] args){
		int num, sum=0;
		System.out.print("enter number: ");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		for(int i=1; i<=num/2;i++){
			if(num%i==0) sum+=i;
		}
		if(sum == num) System.out.print("it is a perfect number");
		else System.out.print("it is not a perfect");
	}
}
