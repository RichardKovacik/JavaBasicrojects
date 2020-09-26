package sk.richard.simpleTasks;

public class Task4 {
    public static void main(String[] args) {
        String text1="abc";
        String text2="axc";
        System.out.println(stringMatch(text1,text2));
    }

    public static int stringMatch(String a,String b){
        int length=0;
        int counter=0;
        //ziskam si dlzku kratsieho textu z danej dvojice Stringov
        if(a.length()>b.length()){
            length=b.length();
        }else length=a.length();

        for (int i=0;i<length-1;i++) {
            if (a.substring(i, i + 2).equals(b.substring(i, i + 2))) {
                counter++;
            }
        }
        return counter;
    }
}
