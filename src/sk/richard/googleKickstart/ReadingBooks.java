package sk.richard.googleKickstart;
import java.util.Random;
import java.util.Scanner;

public class ReadingBooks {
      static int amountOfBooks=0;
      static Random random=new Random();
      static int [] books=new int[100];
      static int [] array=new int[100];
      static int [][] TwoArray=new int[3][50];
      static int sum=5000;
     static Scanner scanner=new Scanner(System.in);
     static int p=0;


    public static void main(String[] args) {
//        System.out.println("Enter input:");
       while (scanner.hasNextInt()){
           array[p]=scanner.nextInt();
           amountOfBooks=array[0];
           p++;
           if (p==amountOfBooks*3+3){break;}
       }
       int k=-1;
       for (int i=0;i<(amountOfBooks)+1;i++){
           for (int j=0;j<3;j++){
               k++;
               if (i>0){ TwoArray[j][i]=array[k]; //bez prvych troch parametrov, pracujem len s knihami
                   }
           }
       }
        solveProblem(array[1],TwoArray);
    }
     static void solveProblem(int n, int[][] twoArray){
        int book;
        int jeriesenie=0;// ked  sa bude opakovat cyklus prilis vela krat znamena ze nema riesenie, ye program nevie najst vohdnu k-ticu
        int j=0;
        int i=0;
        books[0]=5000;
        int poc=0;
        int [] indexes=new int[n];
        int []  finalIndexes=new int[n];

        do {
            poc++;
            do {
                //vyberam nohdnu k-ticu tak aby sa dane prvky neopakovali
            for (int l=0;l<n;l++){

                do {
                    i=random.nextInt(amountOfBooks)+1;
                    book=twoArray[j][i];
                }while (!checkDuplicates(book,books));
                books[l]=book;
                indexes[l]=i;
            }
            //skotrlojuem ci nahodne vybrata k-tica splna podmienky druheho argumentu
                jeriesenie++;
            if (jeriesenie==100000){
                System.out.println(-1);
                break;
            }
            }while (!checkArgument(indexes,array[2],twoArray));

            if (sumOFTime()<sum){
                sum=sumOFTime();
                for (int k=0;k<finalIndexes.length;k++){
                    finalIndexes[k]=indexes[k];
                }
            }
        }while (poc<=5000);

        if (jeriesenie<=100000){
            System.out.println(sum);
            for (int e=0;e<finalIndexes.length;e++){
                System.out.print(finalIndexes[e]+" ");
            }
        }

    }
    static boolean checkDuplicates(int book, int [] array){
        boolean flag=true;
        for (int i=0;i<array.length;i++){
            if (array[i]==book){
                flag=false;
                break;
            }
        }
        return flag;
    }
    static boolean checkArgument(int [] indexes,int k, int [][] twoArray){
        int x=0;
        int y=0;
        int o=0;
        boolean flag=false;

        for (int u=0;u<indexes.length;u++) {
            x = x + twoArray[o + 1][indexes[u]];
            y = y + twoArray[o + 2][indexes[u]];
        }
        if (x==k&&y==k){
            flag=true;
        }
        return flag;
    }
    static  int sumOFTime(){
        int sum=0;
        for (int i=0;i<books.length;i++){
            sum=sum+books[i];
        }
        return sum;
    }

}
