package sk.richard.simpleTasks;

public class Task5 {
    public static void main(String[] args) {
        int [] numbers={1, 1, 2, 1, 1};

        System.out.println( countClumps(numbers));
    }
    public static int countClumps(int[] nums) {
        int p=0;
        int sameGroup=50;
        int blb=0;
        for (int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                blb++;}else blb=0;

            if (nums[i]==nums[i+1]&&sameGroup!=nums[i]||blb==1){
                p++;
                sameGroup=nums[i];
            }
            if (p==nums.length-1){
                p=1;
            }

        }
        return p;
    }
}
