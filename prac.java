import java.util.Scanner;
public class prac{
    public static int sumint(int a,int b){
        return a+b;
    }
    public static float sumfloat(float a,float b){
        return a+b;
    }
    public static void main(String []args){
		while(true){
			Scanner sc=new Scanner(System.in);
			System.out.println("enter operations(0 for int,1 for float):");
			int choice=sc.nextInt();
			if(choice==0){
				int a=sc.nextInt();
				int b=sc.nextInt();
				int s1=sumint(a,b);
				System.out.println("sumint"+s1);
			}
			else{
				float a=sc.nextFloat();
				float b=sc.nextFloat();
				float s2=sumfloat(a,b);
				System.out.println("sumint"+s2);
			}
			System.out.println("to continue enter(Y/N)");
			String s=sc.next();
			if(!s.equalsIgnoreCase("y")){
                break;
            }
		}
    }
}
