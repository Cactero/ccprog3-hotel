public class Client {
    private String firstName;
    private String lastName;
    private int checkInDay;
    private int checkOutDay;
    private Room bookedRoom;

    public Client(String firstName, String lastName, int checkInDay, int checkOutDay, Room bookedRoom) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.checkInDay = checkInDay;
        this.checkOutDay = checkOutDay;
        this.bookedRoom = bookedRoom;
    }

    public Room getBookedRoom() {
        return bookedRoom;
    }

    public void setBookedRoom(Room bookedRoom) {
        this.bookedRoom = bookedRoom;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCheckInDay() {
        return checkInDay;
    }

    public void setCheckInDay(int checkInDay) {
        this.checkInDay = checkInDay;
    }

    public int getCheckOutDay() {
        return checkOutDay;
    }

    public void setCheckOutDay(int checkOutDay) {
        this.checkOutDay = checkOutDay;
    }

    public int getDaysBooked(){
        return checkOutDay - checkInDay + 1;
    }
}
