package sareen.shagun.bookMyShow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sareen.shagun.bookMyShow.models.Show;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long> {
    Optional<Show> findById(Long showId);
}
