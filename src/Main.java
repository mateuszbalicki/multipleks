import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Cinema cinema1 = new Cinema("Multikino", "ul. Krakowska 5");

        Movie m1 = new Movie("Hobbit", 120);
        Movie m2 = new Movie("Avatar 3", 160);
        cinema1.addMovie(m1);
        cinema1.addMovie(m2);

        Hall hall1 = new Hall("Sala 1", 50);

        Screening s1 = new Screening(m1, hall1, LocalDateTime.now().plusDays(1), ScreeningType.STANDARD);
        Screening s2 = new Screening(m2, hall1, LocalDateTime.now().plusDays(2), ScreeningType.THREE_D);
        cinema1.addScreening(s1);
        cinema1.addScreening(s2);

        Customer customer = new Customer("Jan Kowalski");

        System.out.println("\n1. Sprawdzenie repertuaru:");
        cinema1.printProgramme();

        Screening screening = cinema1.getScreenings().get(0);

        System.out.println("\n2. Rezerwacja - Opcja 1 (po ID miejsc):");
        screening.reservePlaces("H34");

        System.out.println("\n3. Rezerwacja - Opcja 2 (po obiektach Seat):");
        Seat seat1 = screening.getSeat("H35");
        Seat seat2 = screening.getSeat("H36");
        screening.reservePlaces(seat1, seat2);

        System.out.println("\n4. Rezerwacja dla zalogowanego klienta:");
        // Tu zrobimy to na drugim seansie, żeby miejsca były wolne
        Screening screening2 = cinema1.getScreenings().get(1);
        screening2.reservePlaces(customer, "H34", "H35");

        System.out.println("\n5. Wyszukiwanie filmu:");
        Movie movie1 = cinema1.findMovie("Hobbit");
        System.out.println("Znaleziono film: " + (movie1 != null ? movie1.getTitle() : "Brak"));

        System.out.println("\n6. Zakup biletów bez konta (Gość):");
        screening.buyTickets(null, "H36");

        System.out.println("\n7. Sprawdzenie swoich biletów:");
        customer.showMyTickets();
    }
}