import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Screening {
    private Movie movie;
    private Hall hall;
    private LocalDateTime startTime;
    private ScreeningType type;
    private List<Seat> seats;

    public Screening(Movie movie, Hall hall, LocalDateTime startTime, ScreeningType type) {
        this.movie = movie;
        this.hall = hall;
        this.startTime = startTime;
        this.type = type;
        this.seats = new ArrayList<>();
        // Inicjalizacja przykładowych miejsc dla seansu
        seats.add(new Seat("H34"));
        seats.add(new Seat("H35"));
        seats.add(new Seat("H36"));
    }

    public Movie getMovie() { return movie; }
    public LocalDateTime getStartTime() { return startTime; }
    public ScreeningType getType() { return type; }

    public Seat getSeat(String seatId) {
        for (Seat seat : seats) {
            if (seat.getSeatId().equals(seatId)) {
                return seat;
            }
        }
        return null;
    }

    public void reservePlaces(String... seatIds) {
        reservePlaces(null, seatIds); // Wywołuje główną metodę poniżej bez klienta
    }

    public void reservePlaces(Seat... selectedSeats) {
        for (Seat seat : selectedSeats) {
            if (seat != null && seat.getStatus() == SeatStatus.FREE) {
                seat.setStatus(SeatStatus.RESERVED);
                System.out.println("Zarezerwowano miejsce: " + seat.getSeatId());
            } else {
                System.out.println("Miejsce niedostępne.");
            }
        }
    }

    public void reservePlaces(Customer customer, String... seatIds) {
        List<Seat> reservedSeats = new ArrayList<>();
        for (String seatId : seatIds) {
            Seat seat = getSeat(seatId);
            if (seat != null && seat.getStatus() == SeatStatus.FREE) {
                seat.setStatus(SeatStatus.RESERVED);
                reservedSeats.add(seat);
            }
        }

        if (!reservedSeats.isEmpty()) {
            Ticket ticket = new Ticket(this, reservedSeats, customer, false);
            if (customer != null) customer.addTicket(ticket);
            System.out.println("Rezerwacja zakończona sukcesem dla: " +
                    (customer != null ? customer : "Gość"));
        }
    }

    public void buyTickets(Customer customer, String... seatIds) {
        List<Seat> boughtSeats = new ArrayList<>();
        for (String seatId : seatIds) {
            Seat seat = getSeat(seatId);
            if (seat != null && (seat.getStatus() == SeatStatus.FREE || seat.getStatus() == SeatStatus.RESERVED)) {
                seat.setStatus(SeatStatus.BOUGHT);
                boughtSeats.add(seat);
            }
        }
        if (!boughtSeats.isEmpty()) {
            Ticket ticket = new Ticket(this, boughtSeats, customer, true);
            if (customer != null) customer.addTicket(ticket);
            System.out.println("Zakup zakończony sukcesem.");
        }
    }
}