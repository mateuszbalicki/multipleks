import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private Screening screening;
    private List<Seat> seats;
    private Customer owner;
    private boolean isPaid;

    public Ticket(Screening screening, List<Seat> seats, Customer owner, boolean isPaid) {
        this.screening = screening;
        this.seats = seats;
        this.owner = owner;
        this.isPaid = isPaid;
    }

    public Screening getScreening() { return screening; }

    public String getReservedSeatsIds() {
        List<String> ids = new ArrayList<>();
        for (Seat seat : seats) {
            ids.add(seat.getSeatId());
        }
        return String.join(", ", ids);
    }
}
