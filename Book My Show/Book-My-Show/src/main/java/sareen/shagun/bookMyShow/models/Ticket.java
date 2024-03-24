package sareen.shagun.bookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{

    private int amount;

    private Date timeOfBooking;

    @ManyToOne
    private Show show;

    @ManyToMany
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;

    @OneToMany(mappedBy = "ticket")
    private List<Payment> payments;

    @ManyToOne
    private User bookedBy;
}
