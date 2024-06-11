public class Driver {
    public static void main(String[] args) {
        Hotel[] hotels = new Hotel[50];


        switch (DisplayManager.mainMenuOptions()) {

            case 1:
                DisplayManager.createHotel();
                break;

            case 2:
                DisplayManager.viewHotel(null);
                break;

            case 3:
                DisplayManager.manageHotel();
                break;

            case 4:
                DisplayManager.bookRoom();
                break;
        }
    }
}