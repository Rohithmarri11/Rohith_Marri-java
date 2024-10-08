import java.util.*;
import java.lang.Math;
class BintoDec{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter binary number: ");
		int binNo= sc.nextInt(), rem, realVal=0, i=0;
		while(binNo != 0){
			rem = binNo%10;
			if(rem==1) realVal += (int)Math.pow(2,i);
			binNo /= 10;
			i++;
		}
		System.out.print(realVal);
	}
}