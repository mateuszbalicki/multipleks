import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Ticket> tickets;

    public Customer(String name) {
        this.name = name;
        this.tickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void showMyTickets() {
        System.out.println("Bilety klienta: " + name);
        for (Ticket t : tickets) {
            System.out.println("- Seans: " + t.getScreening().getMovie().getTitle() +
                    " | Miejsca: " + t.getReservedSeatsIds());
        }
    }
}