import java.util.Arrays;
import java.util.Scanner;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}
public class k{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int[] nums=new int[a];
        for(int s=0;s<a;s++){
            nums[s]=sc.nextInt();
        }
        int target=sc.nextInt();
        Solution sol=new Solution();
        int[] result=sol.twoSum( nums,target);
        if(result.length==0){
            System.out.println("");
        }
        else{
            System.out.println(Arrays.toString(result));
        }
        sc.close();
    }
}