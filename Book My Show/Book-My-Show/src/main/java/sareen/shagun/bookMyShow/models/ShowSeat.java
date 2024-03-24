package sareen.shagun.bookMyShow.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
//This class is required as seatStatus is an attribute for the relation between show and seat
public class ShowSeat {
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
    private Date lockedAt;
}
