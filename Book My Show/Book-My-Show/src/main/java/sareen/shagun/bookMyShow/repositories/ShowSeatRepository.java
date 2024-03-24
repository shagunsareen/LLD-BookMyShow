package sareen.shagun.bookMyShow.repositories;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import sareen.shagun.bookMyShow.models.Seat;
import sareen.shagun.bookMyShow.models.Show;
import sareen.shagun.bookMyShow.models.ShowSeat;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<ShowSeat> findAllBySeatInAndShow(List<Seat> seats, Show show);

    ShowSeat save(ShowSeat showSeat);
}
