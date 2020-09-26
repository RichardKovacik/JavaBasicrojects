package sk.richard.simpleTasks;

public class Task2 {

    public static void main(String[] args) {
        int poc=0;
        int number=108;
        do {
            if ((number>100)&&(number%19==13)){
                poc++;
                System.out.println(number);
            }
            number++;

        }while (number<=1000);
        System.out.println("Pocet vsetkych trojicifernych cisel delitelnych 19 so zvyskom 13 je "+poc);
    }

}
