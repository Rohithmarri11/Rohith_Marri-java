class playstring{
	public static void main(String Args[]){
		String name = "jagan lal";
		int index=0;
		String s1 = "";
		String s2 = "";
		for (int i = 0; i < name.length(); i++) {
			if(name.charAt(i) == ' ') index= i; 
        	}
		for (int i = index+1; i < name.length(); i++) {
 			//System.out.print(name.charAt(i));
			s1 = s1 + name.charAt(i);
        	}
System.out.println();
		for (int i = 0; i < index; i++) {
 			//System.out.print(name.charAt(i));
			s2 = s2 + name.charAt(i);
        	}
		System.out.print(s1 + " " + s2);
	}
}