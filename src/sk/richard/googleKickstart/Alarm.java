package sk.richard.googleKickstart;

public class Alarm {
    static int[] array = {3, 2};

    public static void main(String[] args) {
        System.out.println(solveAlarm(array));

    }

    static int solveAlarm(int[] someArray) {
        int sum = 0;
        int sum2 = 0;
        int counter = 1;
        for (int i = 0; i < someArray.length; i++) {
            sum = sum + someArray[i];
            sum2 = sum2 + someArray[i] * squareNumber(counter, 3);
            counter++;
        }
        if (someArray.length > 2) {
            for (int j = 0; j < someArray.length - 1; j++) {
                sum = sum + someArray[j] + (someArray[j + 1] * squareNumber(3, 2));
            }

        }
        sum = sum + sum2;
        return sum;
        }

     static int squareNumber(int number,int mocnitel){
        int result=1;
        for (int i=0;i<mocnitel;i++){
            result=result*number;

        }
        return result;
    }

}
