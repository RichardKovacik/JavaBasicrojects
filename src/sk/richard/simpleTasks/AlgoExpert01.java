package sk.richard.simpleTasks;

import java.util.Arrays;

public class AlgoExpert01 {
    static int[] numbers={8, 4, 2, 10, 3, 6, 7, 9, 1};
    static  int lenght;
    public static void main(String[] args) {

         lenght=removeDuplicateElements(numbers,numbers.length);
        System.out.println(lenght);
        System.out.println(Arrays.toString(largestRange()));


    }
// zoradime pole od najmnsieho po najvacsi
    public static void bubleArray(int[] array) {
        int p;
        for (int i=0;i<lenght;i++){
            for (int j=0;j<i;j++){
                if (array[i]<array[j]){
                    p=array[i];
                    array[i]=array[j];
                    array[j]=p;
                }
            }
        }
    }
    public static int removeDuplicateElements(int [] arr,int n){
        int[] temp = new int[n];
        int j = 0;
        for (int i=0; i<n-1; i++){
            if (arr[i] != arr[i+1]){
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[n-1];
        // Changing original array
        for (int i=0; i<j; i++){
            arr[i] = temp[i];
        }
        return j;


    }
    public static int[] largestRange() {
        int [] result=new int[2];
        bubleArray(numbers);
        int p=0;
        for (int i=0;i<lenght-1;i++){
            if (Math.abs(numbers[i+1])- Math.abs(numbers[i])==1||Math.abs(numbers[i+1])- Math.abs(numbers[i])==-1) {
                if (p==0){result[0] = numbers[i];}
                result[1]=numbers[i+1];
                p++;
            }
        }
        return result;
    }
}
