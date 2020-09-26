package sk.richard.adventsCode;

import javax.swing.text.Position;
import java.awt.*;
import java.io.Console;

public class Day3 {

    public static void main(String[] args) {
        char[][] multiArray = new char[10][10];
        char[] wire1 = {'R', 'U', 'L', 'D'};//potom si to rozdelim na pismenka a dalsie pole budu cisla ,idexz sa budu zhodovat
        int[] positionData = {8, 5, 5, 3};
        String[] wire2 = {"U7", "R6", "D4", "L4"};

        Console console;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                multiArray[j][i] = '0';
                // System.out.print(multiArray[j][i]);
            }
            // System.out.println();
        }


        for (int i = 0; i < wire1.length; i++) {
            if (wire1[i] == 'R') {
                for (int j = 0; j < positionData[i]; j++) {
                    multiArray[9][j] = '-';

                }
            }
            if (wire1[i] == 'U') {
                for (int j = 0; j < positionData[i]; j++) {
                    multiArray[j+positionData[0]-positionData[1]+1][positionData[0]-1] = '|';
                }
            }
            if (wire1[i] == 'L') {
                for (int j = 0; j < positionData[i]; j++) {
                    multiArray[positionData[1]-1][j+2] = '-';
                }
            }

            }

            for (char[] a : multiArray) {
                System.out.println(a);
            }

        }


    }


