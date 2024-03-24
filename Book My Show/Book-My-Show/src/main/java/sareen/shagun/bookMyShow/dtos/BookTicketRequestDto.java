package sareen.shagun.bookMyShow.dtos;

import java.util.List;

public class BookTicketRequestDto {
    private List<Long> seatIds;
    private Long showId;
    private Long userId;

    public List<Long> getSeatIds() {
        return seatIds;
    }

    public void setSeatIds(List<Long> seatIds) {
        this.seatIds = seatIds;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
