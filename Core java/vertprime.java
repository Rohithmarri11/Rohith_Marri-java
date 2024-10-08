import java.util.*;
class vertprime{
	public static boolean primeCheck(int a){
		int count = 0;
		for(int i=2; i<=a/2 ; i++) if(a%i == 0) count++;
		if(count==0) return true;
		return false;
	}
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number :");
		int n = sc.nextInt();
		for(int i =2; i<=n ; i++) if(n%i==0) if(primeCheck(i)) System.out.print(i+" ");
	}
}