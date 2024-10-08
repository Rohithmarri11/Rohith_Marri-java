import java.util.*;
class Swap{
	public void swap(int x, int y){
		System.out.println("Before Swapping : x = " + x + " ,y = " + y);
		int temp = x;
		x=y;
		y=temp;
		System.out.println("After Swapping : x = " + x + " ,y = " + y);
	}
}

class Operations extends Swap{
	public void add(int x, int y){
		System.out.println("Addition of two numbers is: " + (x+y));
	}
	public void sub(int x, int y){
		System.out.println("Substraction of two numbers is: " + (x-y));
	}
	public void mul(int x, int y){
		System.out.println("Multiplication of two numbers is: " + (x*y));
	}
	public void div(int x, int y){
		System.out.println("Division of two numbers is: " + (x/y));
	}
}

class Sort extends Operations{
    public void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
	System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

    }
}

class Rs500Code{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Sort ob = new Sort();
		System.out.println();
		System.out.println("Now we are Doing Swapping");
		System.out.println("Enter two numbers to swap: ");
		int x = sc.nextInt();
		int y = sc.nextInt();
		ob.swap(x,y);
		System.out.println();

		System.out.println("Now we are Doing Arthamatic operations");
		System.out.println("Enter two numbers to perform Arthamatic operations: ");
		x = sc.nextInt();
		y = sc.nextInt();
		ob.add(x,y);
		ob.sub(x,y);
		ob.mul(x,y);
		ob.div(x,y);
		System.out.println();

		System.out.println("Now we are Doing Bubble Sort");
		System.out.print("Enter the size of the array: ");
        	int size = sc.nextInt();
		int[] array = new int[size];
        	System.out.println("Enter the elements of the array:");
        	for (int i = 0; i < size; i++) {
            		array[i] = sc.nextInt();
        	}
		ob.bubbleSort(array);
	}
}