package 数值方法实验3;

public class Main {
	double [][]equation;
	double []result0;
	double []result;
	public Main(double [][]arr) {
		this.equation=arr;
		result=new double[arr.length];
		result0=new double[arr.length];
		sovle();
	}
	void sovle()
	{
		for (int i = 0; i < result0.length; i++) {
			result[i]=0;
			result0[i]=0;
		}
		while (true) {
			for(int i=0;i<result.length;i++)
			{
				result[i]=0;
				for(int j=0;j<equation[i].length-1;j++)
				{
					if (i==j) continue;
					result[i]-=result0[j]*equation[i][j]/equation[i][i];
				}
				result[i]+=equation[i][equation[i].length-1]/equation[i][i];
			}
			swap(result0, result);
			if (Math.abs(result[0]-result0[0])<=0.0000001) break;
		}
	}
	void show(){
		System.out.println("The result is:");
		for(int i=0;i<result.length;i++)
			System.out.println("x"+(i+1)+"="+result[i]);
	}
	static void swap(double []arr1,double[]arr2)
	{
		if (arr1.length==arr2.length) {
			for(int i=0;i<arr1.length;i++)
			{
				double temp;
				temp=arr1[i];
				arr1[i]=arr2[i];
				arr2[i]=temp;
			}
		}
		else {
			System.err.println("交换失败！！！");
		}
	}
	public static void main(String[] args) {
		double [][]arr={
				{10,-1,-2,7.2},
				{-1,10,-2,8.3},
				{-1,-1,5,4.2}
		};
		Main aMain=new Main(arr);
		aMain.show();
	}
}
