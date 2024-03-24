package sareen.shagun.bookMyShow.services;

import com.zaxxer.hikari.util.IsolationLevel;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sareen.shagun.bookMyShow.dtos.BookTicketResponseDto;
import sareen.shagun.bookMyShow.exceptions.InvalidArgumentsException;
import sareen.shagun.bookMyShow.exceptions.SeatNotAvailableException;
import sareen.shagun.bookMyShow.models.*;
import sareen.shagun.bookMyShow.repositories.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class TicketService {
    private ShowRepository showRepository;
    private SeatRepository seatRepository;
    private UserRepository userRepository;
    private TicketRepository ticketRepository;
    private ShowSeatRepository showSeatRepository;

    public Ticket bookTicket(List<Long> seatIds, Long showId, Long userId) throws InvalidArgumentsException, SeatNotAvailableException {
        Optional<Show> show = showRepository.findById(showId);
        if (show.isEmpty()) {
            throw new InvalidArgumentsException(
                    "Show by: " + showId + " doesn't exist."
            );
        }

        List<Seat> seats = seatRepository.findAllByIdIn(seatIds);

        List<ShowSeat> lockedSeats = getAndLockShowSeats(seats, show.get());

        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            throw new InvalidArgumentsException("User with id: " + userId + " doesn't exist.");
        }

        Ticket ticket = new Ticket();
        ticket.setBookedBy(userOptional.get());
        ticket.setTicketStatus(TicketStatus.PROCESSING);
        ticket.setShow(show.get());
        ticket.setSeats(seats);
        ticket.setAmount(0);
        ticket.setTimeOfBooking(new Date());

        return ticketRepository.save(ticket);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, timeout = 2)
    private List<ShowSeat> getAndLockShowSeats(List<Seat> seats, Show show) throws SeatNotAvailableException {
        List<ShowSeat> showSeats = showSeatRepository.findAllBySeatInAndShow(seats, show);

        //check status of all the seats
        for(ShowSeat showSeat : showSeats){
            if(!(showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) ||
                    !(showSeat.getShowSeatStatus().equals(ShowSeatStatus.LOCKED))){
                throw new SeatNotAvailableException();
            }
        }

        //all seats are available, update the status as locked for all these seats
        List<ShowSeat> savedShowSeats = new ArrayList<>();
        for(ShowSeat showSeat : showSeats){
            showSeat.setLockedAt(new Date());
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }

        return savedShowSeats;
    }

}
