// student grade
import java.util.*;
class prog2{
	public static void main(String [] args){
		int grade;
		System.out.print("Enter student percentage: ");
		Scanner sc = new Scanner(System.in);
		grade = sc.nextInt();
		if(grade>= 90) System.out.print("O grade");
		else if(grade>= 80) System.out.print("S grade");
		else if(grade>= 70) System.out.print("A grade");
		else if(grade>= 60) System.out.print("B grade");
		else if(grade>= 50) System.out.print("C grade");
		else if(grade>= 40) System.out.print("D grade");
		else System.out.print("Fail");
	}
}
