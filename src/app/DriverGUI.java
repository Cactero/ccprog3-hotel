package app;

import com.sun.tools.javac.Main;
import discount.DatePriceModifier;
import mainMenu.MainMenuController;
import mainMenu.MainMenuModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class DriverGUI {
    public static void main(String[] args) {
        new MainMenuModel(new ArrayList<Hotel>());
    }
}