public class Seat {
    private String seatId;
    private SeatStatus status;

    public Seat(String seatId) {
        this.seatId = seatId;
        this.status = SeatStatus.FREE;
    }

    public String getSeatId() { return seatId; }
    public SeatStatus getStatus() { return status; }
    public void setStatus(SeatStatus status) { this.status = status; }
}
