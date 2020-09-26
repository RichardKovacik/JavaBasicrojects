package sk.richard.simpleTasks;

public class Task3 {
    public static void main(String[] args) {
        int[] array={1, 4, 1, 5};

        fix(array);
        for (int a: array) {
            System.out.print(a+",");
        }
    }

    static   public int[] fix(int[] array){
        int p=0;
        for (int i=0;i<array.length;i++){
            if (array[i]!=4&&array[i]!=5){
                p=array[i];
                int counter=0;
                for (int j=0;j<array.length;j++){
                    if (array[j]==5&&counter==0)
                    {array[j]=p;
                        counter=counter-1;}
                }

            }

        }
        for (int i=0;i<array.length;i++){
            if (array[i]==4){
                array[i+1]=5;
            }

        }
        return array;
    }

}
