package ui.gui;

import java.awt.Color;
import javax.swing.JFrame;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class MainWindow extends JFrame {
    private int frameSizeX;
    private int frameSizeY;

    public MainWindow() {
        frameSizeX = 1000;
        frameSizeY = 600;
        initialise();
    }

    private void initialise() {
        setTitle("PListen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(frameSizeX, frameSizeY);
        setBackground(Color.decode("#333436"));

        setResizable(false);
        setVisible(true);
    }

}


// Routing buttons refactoring proposal (instead of true/false setting)
// DO NOT USE!!!!!!!!!!!

// BackButtonPressed, ExistButtonPressed, implements RouteButtonPressed

// methodCallingMethodInUI() throws RouteButtonPressed {
//     doingThings();
//     doingThings();
//     doingThings();
//     if (enterMethodInUI.isPressed()) {
//         try {
//             methodInUI()
//         } catch (BackButtonPressed e) {
//             methodCallingMethodInUI();
//         }
//     } else if (backButton.isPressed()) {
//         throw new BackButtonPressed e; // caught, handled in caller method (this)
//     } else if (exitButton.isPressed()) {
//         throw new ExitButtonPressed e; // not caught, propogates up until main
//     }
// }

// methodInUI() throws BackButtonPressed {
//     if (backIsPressed()) {
//         throw new BackButtonPressed e;
//     }
// }