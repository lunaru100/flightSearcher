package dataClasses;

import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

@Data
public class FlightData {
    public static ArrayList<Integer> planeId;
    public static ArrayList<Integer> arrive;
    public static ArrayList<Long> arriveDate;
    public static ArrayList<Integer> departure;
    public static ArrayList<Long> departureDate;
    public static ArrayList<Integer> gate;
    public static ArrayList<Integer> terminal;

    void initData(){
        for(int i=0;i<50;i++){
            planeId.add(i);
            arrive.add(i);
            departure.add(i);
            gate.add(i);
            terminal.add(i);
            arriveDate.add(System.currentTimeMillis() + new Random().nextInt(10) * 3600000);
            departureDate.add(System.currentTimeMillis());
        }
    }

}
