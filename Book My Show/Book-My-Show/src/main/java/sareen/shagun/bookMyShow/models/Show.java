package sareen.shagun.bookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;

    @Enumerated(EnumType.ORDINAL)
    private Language language;

    @ManyToOne
    private Auditorium auditorium;

    private Date startTime;

    private Date endTime;
}
