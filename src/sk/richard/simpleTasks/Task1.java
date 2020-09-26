package sk.richard.simpleTasks;

public class Task1 {
    public static void main(String[] args) {
        int[] numbers ={10,52,2,5,54};//expected output 5,52


        bubleElements(numbers);//call method for sort array of numbers
        for (int number : numbers) {
            System.out.print(number + ",");
        }
        System.out.println("\nSecond largest is "+numbers[numbers.length-2]);
        System.out.println("Second smallest is "+numbers[1]);

        }

    public static void bubleElements(int[] array){//sort arraz from min to max element
        int number;
        for (int i=0;i<array.length;i++){
            for (int j=0;j<i;j++){
                if (array[i]<array[j]){
                    number=array[i];
                    array[i]=array[j];
                    array[j]=number;
                }
            }
        }
        //        int j;
//        for (int i=0;i<testArray.length;i++){
//            if (i==0){j=0;}
//            else {j=+4;}//step forward 4 position
//            if (testArray[j]==1||testArray[j]==2) {
//                //algoritmus pre 1-tku
//                if (testArray[j] == 1) {
//                    testArray[testArray[j+3]] = testArray[testArray[j + 1]] + testArray[testArray[j + 2]];
//                }
//                //algoritmus pre 2-jku
//                if (testArray[j] == 2) {
//                    testArray[testArray[j+3]] = testArray[testArray[j + 1]] * testArray[testArray[j + 2]];
//                }
//            }
//        }

    }
}
