import java.util.Arrays;
import java.util.Scanner;
public class c{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int[] arr=new int[a];
        for(int s=0;s<a;s++){
            arr[s]=sc.nextInt();
        }
        int n=arr.length;
        int t;
        for(int i=0;i<n/2;i++){
            int j=n-1-i;
            t=arr[i];
            arr[i]=arr[j];
            arr[j]=t;
        }
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}