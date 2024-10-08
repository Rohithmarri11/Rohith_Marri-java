import java.util.*;
class bank{
	private int balance = 64437;
	private String password = "ab@gh4";
	public String checkBalance(String password){
		if(password.equals(this.password)) return Integer.toString(balance);
		else return "Wrong Password";
	}
}

class encapsulation{
	public static void main(String[] args){
		bank account = new bank();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Password to check password: ");
		System.out.println(account.checkBalance(sc.next()));
	}
}