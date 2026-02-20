import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private String name;
    private String address;
    private List<Screening> screenings;
    private List<Movie> movies;

    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
        this.screenings = new ArrayList<>();
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) { movies.add(movie); }
    public void addScreening(Screening screening) { screenings.add(screening); }
    public List<Screening> getScreenings() { return screenings; }

    public void printProgramme() {
        System.out.println("--- Repertuar Kina: " + name + " (" + address + ") ---");
        for (Screening s : screenings) {
            System.out.println(s.getStartTime() + " | " + s.getMovie().getTitle() + " [" + s.getType() + "]");
        }
        System.out.println("-------------------------------------------------");
    }

    public Movie findMovie(String title) {
        for (Movie m : movies) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }
}