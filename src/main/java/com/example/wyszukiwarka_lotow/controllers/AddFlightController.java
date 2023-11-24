package com.example.wyszukiwarka_lotow.controllers;

import com.example.wyszukiwarka_lotow.dataClasses.FlightData;
import com.example.wyszukiwarka_lotow.models.Flight;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.wyszukiwarka_lotow.repositories.FlightRepository;

import java.util.ArrayList;

@Controller
@RequestMapping("/flight")
public class FlightController {
    private static FlightRepository fr;

    public FlightController(FlightRepository fr){
        this.fr = fr;
    }
    @RequestMapping("/a")
    String getIndex(){
        return "index";
    }

    @RequestMapping("/addFlights")
    String addFlights(){
        return "info_error";
    }

    @PostMapping("/addFlights")
    String processForm(@RequestParam("inputNum") String inputNum) {
        try{
            int number = Integer.parseInt(inputNum);
            System.out.println("udalo sie");
            FlightData flightData = new FlightData();
            flightData.initData(number);
            ArrayList<Flight> flights = new ArrayList<>();
            for(int i=0;i<number;i++){
                Flight flight = new Flight(
                        flightData.getPlaneId(),
                        flightData.getArrive(),
                        flightData.getArriveDate().get(i),
                        flightData.getDeparture(),
                        flightData.getDepartureDate().get(i),
                        flightData.getGate().get(i),
                        flightData.getTerminal().get(i)
                );
                flights.add(flight);
            }
            fr.addFlight(flights);
            return "info_good";
        }catch (NumberFormatException e){
            System.out.println(e);
            return "info_error";
        }
    }

}
