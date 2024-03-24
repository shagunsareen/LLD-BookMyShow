package sareen.shagun.bookMyShow.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Auditorium extends BaseModel {
    @OneToMany
    private List<Seat> seats;
    private String name;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Feature> features;
}
