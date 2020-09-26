package sk.richard.adventsCode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Day8 {

    public static void main(String[] args) throws IOException {
        List<Character> digits=new ArrayList<>();
        List<Character> currentLayer=new ArrayList<>();
        List<Integer> counters0=new ArrayList<>();//15 000/(25x6)=100
        List<Character> min0Layer=new ArrayList<>();

        try (FileReader inputStream = new FileReader("resources/images1.txt")) {
            int c;
            while ((c = inputStream.read()) != -1) {
                //System.out.println((char)c);
               digits.add((char)c);
            }
        }
        System.out.println(digits.size());

        int poc2=0;
        int counter0=0;

        for (int i=1;i<digits.size()+1;i++){
            currentLayer.add(digits.get(i-1));
            if(i%25==0){
                poc2++;
            }
            if (poc2==6){

                //skotrolovat pocet 0 v aktualnej vrstve pixelov
                for (int j=0;j<currentLayer.size();j++){
                    if (currentLayer.get(j)=='0'){
                        counter0++;
                    }
                }
//                if (counter0<counters0.indexOf(0)){
//
//                }
                counters0.add(counter0);
                if (counters0.size()==8){
                    for (char ch:currentLayer) {
                        min0Layer.add(ch);
                    }
                    break;
                }
                System.out.println(currentLayer.size());
                currentLayer.clear();
                counter0=0;
                poc2=0;}

        }
        System.out.println(counters0.size());
        System.out.println(counters0);

        int counter1=0;
        int counter2=0;

        for (int i=0;i<min0Layer.size();i++){
           // System.out.print(min0Layer.get(i)+",");
            if (min0Layer.get(i)=='1'){
                counter1++;
            }
            if (min0Layer.get(i)=='2'){
                counter2++;
            }
        }
        System.out.println(counter1*counter2);

        }
}
