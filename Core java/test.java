import java.util.*;
class Cloning implements Cloneable
{
    int sno=0;
    public Object clone() throws CloneNotSupportedException
    {
	return super.clone();
   }
}
class test {
    public static void main(String[] args) throws CloneNotSupportedException
    {
        Cloning cob = new Cloning();
	System.out.println(cob.sno);
	cob.sno=1;
	Cloning cob2 = (Cloning)cob.clone();
	System.out.println(cob2.sno);
	cob2.sno=2;
	System.out.println(cob.sno);
    }
}
