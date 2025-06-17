import java.util.Scanner;
import java.util.Arrays;
public class j {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(nums));
        sc.close();
    }
    
}
