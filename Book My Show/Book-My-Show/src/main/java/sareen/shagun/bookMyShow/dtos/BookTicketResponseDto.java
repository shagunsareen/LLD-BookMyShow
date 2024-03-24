package sareen.shagun.bookMyShow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketResponseDto {
    private Long ticketId;
    private int amount;
    private List<String> seatNumbers;
    private String auditoriumName;
    private String message;
    private String status;
}
