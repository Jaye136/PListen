package ui.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.data.plain.Song;

public class songEditCreateWindow extends JFrame {
    private final String unLiked = "☆";
    private final String liked = "★";

    private int frameSizeX;
    private int frameSizeY;
    private JFrame editCreateWindow;

    private JLabel title;
    private JLabel linkpath;
    private JLabel artistName;
    private JLabel albumTitle;
    private JLabel Genre;
    private JLabel duration;
    private JLabel colour;

    private JTextField titleField;
    private JTextField linkField;
    private JTextField artistField;
    private JTextField albumField;
    private JComboBox GenreField;
    private JFormattedTextField durationField;
    private JButton likeButton;
    private JButton unLikeButton;

    private Song addingThisSong;

    // EFFECTS: construct a sub-window to add song information
    public songEditCreateWindow() {
        frameSizeX = 450;
        frameSizeY = 550;
        initialise();
    }

    // EFFECTS: edit window behaviour
    private void initialise() {
        editCreateWindow = new JFrame();
        editCreateWindow.setTitle("PListen");
        editCreateWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        editCreateWindow.setLayout(null);
        editCreateWindow.setSize(frameSizeX, frameSizeY);
        editCreateWindow.getContentPane().setBackground(Color.decode(MainWindow.DARKER));

        setUpLabels();
        setUpTextFields();

        editCreateWindow.setResizable(false);
        editCreateWindow.setLocationRelativeTo(null);
        editCreateWindow.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: set up instruction labels
    private void setUpLabels() {
        title = null;
        linkpath = null;
        artistName = null;
        albumTitle = null;
        Genre = null;
        duration = null;
        colour = null;
    }

    // MODIFIES: this
    // EFFECTS: set up text fields
    private void setUpTextFields() {
    }

    // MODIFIES: this
    // EFFECTS: adds functionality to like/unlike buttons
    // !!! Disabled until name and link are added !!!
    private void setUpLikeUnlike() {
        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addingThisSong.switchLikedStatus(false);
                buttonState(false);
            }
        });
        unLikeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addingThisSong.switchLikedStatus(true);
                buttonState(true);
            }
        });
        add(likeButton);
        add(unLikeButton);
    }

    // MODIFIES: this
    // EFFECTS: changes button visibly depending on given state. If true is passed,
    // the button is liked. If false is passed, the button is unliked
    private void buttonState(Boolean status) {
        if (status) {
            likeButton.setVisible(true);
            likeButton.setEnabled(true);
            unLikeButton.setVisible(false);
            unLikeButton.setEnabled(false);
        } else {
            likeButton.setVisible(false);
            likeButton.setEnabled(false);
            unLikeButton.setVisible(true);
            unLikeButton.setEnabled(true);
        }
    }

    // Main.getLibrary().addSongToLibrary(, TOOL_TIP_TEXT_KEY);
    // MainWindow.infoPanel.updateShown();
}
