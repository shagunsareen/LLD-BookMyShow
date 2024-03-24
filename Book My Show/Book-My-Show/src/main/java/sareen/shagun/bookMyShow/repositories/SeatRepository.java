package sareen.shagun.bookMyShow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sareen.shagun.bookMyShow.models.Seat;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findAllByIdIn(List<Long> seatIds);
}
