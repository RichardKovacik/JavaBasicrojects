package sk.richard.adventsCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {
     static List<Integer> massList = new ArrayList<>();
     static List<Float> fuelList = new ArrayList<>();
     static List<Float> extraFuelList=new ArrayList<>();
     static List<Float> listOfSums=new ArrayList<>();

    public static void main(String[] args) {

        float counter = 0;
        float counter2 = 0;
        float sumAllExtra=0;
        try {
            File myObj = new File("resources/AdventDay1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                int data = myReader.nextInt();
                massList.add(data);//add numbers to list
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //tento for prechadza vsetky vahy (masses) ktory som nacital zo suboru
        for (Integer mass : massList) {
            fuelList.add(SetFuel(mass));//basic fuel
            setExtraFuel((float)mass);//extra fuel
            sumOfExtraFuel(counter2);

        }
        for (Float fuel : fuelList) {
            counter += fuel;
        }
        System.out.println("Basic requirement of fuel: "+counter);

        for (Float f :listOfSums) {
            sumAllExtra+=f;
       }
        System.out.println("sum of all extra fuel: "+sumAllExtra);

    }

    private static void sumOfExtraFuel(float counter2) {
        for (Float f:extraFuelList) {
            counter2+=f;
        }
        System.out.println(counter2);
        extraFuelList.clear();
        listOfSums.add(counter2);
    }

    public static float SetFuel(Integer mass) {
        float f = (float) mass / 3;
        return (int) f - 2;
    }

    //pouzijem rekurziu
    public static float setExtraFuel(Float fuel) {
        if(fuel>0){
            float f = fuel / 3;
            int extraFuel=(int)f-2;
            if (extraFuel>0){
                extraFuelList.add((float)extraFuel);
            }
            return setExtraFuel((float)extraFuel);
        }else return 0;

    }
}

