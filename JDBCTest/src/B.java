
public class B {
private int a;
public static void main(String[] args) {
	int []arr=new int[10];
	for(int i=1;i<arr.length+1;i++)
	{
		arr[i]+=i;
		System.out.println(arr[i]);
	}
	
}
@Override
public String toString() {
	return "B [a=" + a + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
			+ super.toString() + "]";
}

public int getA() {
	return a;
}

public void setA(int a) {
	this.a = a;
}
}
