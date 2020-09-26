package sk.richard.adventsCode;

import java.util.ArrayList;

public class Day16 {
     static String input="59728839950345262750652573835965979939888018102191625099946787791682326347549309844135638586166731548034760365897189592233753445638181247676324660686068855684292956604998590827637221627543512414238407861211421936232231340691500214827820904991045564597324533808990098343557895760522104140762068572528148690396033860391137697751034053950225418906057288850192115676834742394553585487838826710005579833289943702498162546384263561449255093278108677331969126402467573596116021040898708023407842928838817237736084235431065576909382323833184591099600309974914741618495832080930442596854495321267401706790270027803358798899922938307821234896434934824289476011";
     static int [] numbers=new int[input.length()];
     static int [] phases=new int[input.length()];

    public static void main(String[] args) {
        
        for (int i=0;i<input.length();i++){
            numbers[i]=Character.getNumericValue(input.charAt(i));
        }
        solveFFT(numbers);
    }
    static void solveFFT(int [] array){
        int sum;
        int l;
        int [] pattern={0,1,0,-1};
        ArrayList<Integer> pattern1=new ArrayList<>();

            for (int p = 0; p < 100; p++) {
                for (int i = 0; i < array.length; i++) {
                    sum = 0;
                    l = 0;
                    // vytvorime vhodny pattern
                    for (int t = 0; t < 4; t++) {
                        for (int h = 0; h < i + 1; h++) {
                            pattern1.add(pattern[t]);
                        }
                    }
                    // test listu
                    for (int j = 0; j < array.length; j++) {
                        //uplne prvy krat bez prveho prvku
                        if (j < pattern1.size() - 1) {
                            sum = sum + array[j] * pattern1.get(l + 1);
                            l++;
                        } else {
                            if (j == pattern1.size() - 1) {
                                l = 0;
                            }
                            sum = sum + array[j] * pattern1.get(l);
                            l++;
                            if (l == pattern1.size()) {
                                l = 0;
                            }
                        }
                    }
                    pattern1.clear();
                    phases[i] = (Math.abs(sum) % 10);
                }
                System.arraycopy(phases, 0, array, 0, phases.length);
            }
        for (int x=0;x<8;x++){
            System.out.print(array[x]);
        }
    }
}
