package AProjektKoncowy;

import AProjektKoncowy.Enums.ReservationState;

import java.time.LocalDate;

public class Reservation {
    private int id;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private ReservationState state;

    public Reservation(){

    }

    public void changeState(ReservationState state){
        this.state = state;
    }

    public void save(){

    }

    public void delete(){

    }
}
