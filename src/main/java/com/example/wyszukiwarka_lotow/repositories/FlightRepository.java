package repositories;

import models.Flight;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

public class FlightRepository {
    JdbcTemplate jt;
    FlightRepository(JdbcTemplate jt){
        this.jt = jt;
    }

    public void addLot(ArrayList<Flight> newFlights){
        for(Flight newFlight : newFlights){
            jt.update("insert into loty (PlaneId,Arrive,ArriveDateTime,Departure,DepartureDateTime,Gate,Terminal) values(?,?,?,?,?,?,?)",newFlight.getPlaneId(),newFlight.getArrive(),newFlight.getArriveDate(),newFlight.getDeparture(),newFlight.getDepartureDate(),newFlight.getGate(),newFlight.getTerminal());
        }
    }
}
