public class Reservation {
    private String guestName;
    private int checkIn;
    private int checkOut;
    private String roomInfo;

    public Reservation(String guestName, int checkIn, int checkOut, String roomInfo){
        this.guestName = guestName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomInfo = roomInfo;
    }

    public int getNumberOfDays(int checkIn, int checkOut){
        return checkOut-checkIn;
    }

    public int getCheckIn() {
        return checkIn;
    }

    public int getCheckOut() {
        return checkOut;
    }

    public String getRoomInfo() {
        return roomInfo;
    }

    public void setCheckIn(int checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(int checkOut) {
        this.checkOut = checkOut;
    }

    public void setRoomInfo(String roomInfo) {
        this.roomInfo = roomInfo;
    }
}
