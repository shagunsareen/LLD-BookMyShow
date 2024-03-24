package sareen.shagun.bookMyShow.models;


import jakarta.persistence.*;

import java.util.Date;

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
