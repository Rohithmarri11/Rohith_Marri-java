class hari{
	public void method1(){
		System.out.println("method1 in hari");
	}
}
class hariSchild extends hari{
	public void method1(){
		//super.method1();
		System.out.println("method1 in child");
	}
}
class inhari{
	public static void main(String[] args){
		hari gf1 = new hariSchild();
		hariSchild gf2 = new hariSchild();
		gf1.method1();
		gf2.method1();
	}
}