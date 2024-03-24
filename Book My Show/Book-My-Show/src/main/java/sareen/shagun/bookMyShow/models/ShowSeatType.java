package sareen.shagun.bookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//This class is required as price is an attribute of a relation between show and seat type
public class ShowSeatType {
    private int price;
    @ManyToOne
    private Show show;
    @ManyToOne
    private SeatType seatType;
}
