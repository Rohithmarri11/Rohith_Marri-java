import java.util.Scanner;
class StringExample{
	public static void main(String [] args){
		String name = new String();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Name: ");
		name = sc.next();
		for(int i = 0; i< name.length() -2 ; i++) System.out.print(name.charAt(i));
	}
}