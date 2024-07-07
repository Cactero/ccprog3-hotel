package createHotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.*;


public class CreateHotelController {
    private JPanel panel1;
    private JTextField floorTextField;
    private JTextField numberTextField;
    private JTextField roomTypeTextField;
    private JButton cancelButton;
    private JButton createButton;

    private final CreateHotelModel createHotelModel;

    public CreateHotelController(CreateHotelModel createHotelModel, Hotel hotel){
        this.createHotelModel = createHotelModel;
        JFrame frame = new JFrame("App");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean hasConflict;
                String floor = floorTextField.getText();
                int number = Integer.parseInt(numberTextField.getText());
                for(int i = 0; i < hotel.getRoomCount(); i++){
                    if(app.ManageHotel.roomsMatch(floor, number, hotel.getRoom(i).getRoomFloor(), hotel.getRoom(i).getRoomNumber())){
                        JOptionPane.showMessageDialog(null, "There is already a room with this name!");
                        hasConflict = true;
                    }
                }
            }
        });
    }
}
