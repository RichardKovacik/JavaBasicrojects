package sk.richard.adventsCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day20 {

    static char[][] maze;
    static ArrayList<Character> data;

    public static void main(String[] args) throws IOException {
        File f=new File("resources/simpleMaze.txt");     //Creation of File Descriptor for input file
        FileReader fr=new FileReader(f);   //Creation of File Reader object
        BufferedReader br=new BufferedReader(fr);  //Creation of BufferedReader object
        int c=0 ;
        while((c = br.read()) != -1)         //Read char by Char
        {
//            char character = ;//converting integer to char
            data.add((char) c);
        }
        System.out.println(data.get(5));



    }
}
