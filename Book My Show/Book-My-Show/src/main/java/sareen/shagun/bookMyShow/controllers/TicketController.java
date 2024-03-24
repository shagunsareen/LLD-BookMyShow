package sareen.shagun.bookMyShow.controllers;

import sareen.shagun.bookMyShow.dtos.BookTicketRequestDto;
import sareen.shagun.bookMyShow.dtos.BookTicketResponseDto;
import sareen.shagun.bookMyShow.exceptions.InvalidArgumentsException;
import sareen.shagun.bookMyShow.exceptions.SeatNotAvailableException;
import sareen.shagun.bookMyShow.models.Ticket;
import sareen.shagun.bookMyShow.services.TicketService;

public class TicketController {
    TicketService ticketService;

    TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto requestDto) {
        BookTicketResponseDto responseDto = new BookTicketResponseDto();
        try {
            Ticket ticket = ticketService.bookTicket(requestDto.getSeatIds(),
                                                                         requestDto.getShowId(),
                                                                         requestDto.getUserId());
        } catch (InvalidArgumentsException e) {
            responseDto.setStatus("FAILURE");
            responseDto.setMessage("Something is wrong");
            throw new RuntimeException(e);
        } catch (SeatNotAvailableException e) {
            responseDto.setStatus("FAILURE");
            responseDto.setMessage("Seat Not Available");
            throw new RuntimeException(e);
        }

        //set correct response as per current ticket saved
        return responseDto;
    }
}
