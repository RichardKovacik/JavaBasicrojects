package sk.richard.adventsCode;

public class Day4 {
    public static void main(String[] args) {
        int startNumber = 178416;
        int endNumber = 676461;
        int[] numbers = new int[endNumber - startNumber + 1];
        String[] strings = new String[endNumber - startNumber + 1];
        int poc = 0;
        int validPass = 0;
        System.out.println("Day 4");

        //filling interval
        do {
            numbers[poc] = startNumber;
            startNumber++;
            poc++;
        } while (startNumber <= endNumber);
//
        for (int i = 0; i < strings.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
           // System.out.println(strings[i]);
        }
        for (String string : strings) {
            boolean f=false;
            if (passValidation(string)) {
                if (digitsEquals(string)){
                    f=true;
                    System.out.println(string);
                }
            }
            if (f){validPass++;}
        }
        System.out.println("Total valid passwords: "+validPass);

        boolean b = false;
        if (passValidation("123444")) {
            if (digitsEquals("123444")) {
                b = true;
            }
        }

        System.out.println(b);

    }

    public static boolean passValidation(String s) {
        boolean flag = false;
        for (int i = 0; i < s.length() + 1; i++) {

            if (i < s.length() - 1) {
                int index = Character.getNumericValue(s.charAt(i));
                int nextIndex = Character.getNumericValue(s.charAt(i + 1));
                if (nextIndex >= index) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static boolean digitsEquals(String s) {
        boolean result;
        int counter = 0;
        int counter2=0;
        for (int i = 0; i < s.length() + 1; i++) {
            if (i < s.length() - 1) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    counter++;
                    counter2++;
                    //add else ked sa narovnaju vedljsie cisla
                }else{counter2=0;}
            }
//            if (counter == 2) {
//                result = false;
//                break;
//            }
        }//koniec foru
        //counter2!=2
        //counter2==3||counter2==1||counter2==5
        if ((counter==5||counter==1)&&(counter2==1||counter2==0)){
            result=true;
        }else if (counter==3&&counter2==2||counter2==1){
         result=true;
        }
        else result=false;
            return result;
        }
//330 bey trojic

}

