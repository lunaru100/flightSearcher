package models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    int id;
    int planeId;
    int arrive;
    long arriveDate;
    int departure;
    long departureDate;
    int gate;
    int terminal;

}
