package sareen.shagun.bookMyShow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sareen.shagun.bookMyShow.models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Ticket save(Ticket ticket);
}
