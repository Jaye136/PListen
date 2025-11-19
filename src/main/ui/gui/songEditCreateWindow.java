package ui.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.plaf.metal.MetalComboBoxUI;
import javax.swing.plaf.metal.MetalLookAndFeel;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.data.exceptions.SongNotFoundException;
import model.data.plain.Genre;
import model.data.plain.Song;
import ui.Main;
import ui.gui.components.ButtonStyle;
import ui.gui.components.LabelStyle;
import ui.gui.components.TextFieldStyle;

@ExcludeFromJacocoGeneratedReport
public class SongEditCreateWindow extends JFrame {
    private int frameSizeX;
    private int frameSizeY;
    private JFrame editCreateWindow;
    private JPanel display;
    private JPanel displayColourBlock;
    private JLabel throwNewSong;
    private JLabel declareAsSong;

    private JLabel title;
    private JLabel linkpath;
    private JLabel artistName;
    private JLabel albumTitle;
    private JLabel splitLine;
    private JLabel genre;
    private JLabel splitLineTwo;
    private JLabel duration;
    private JLabel colour;

    private JTextField titleField;
    private JTextField linkField;
    private JTextField artistField;
    private JTextField albumField;
    private JComboBox<Genre> genreField;
    private JTextField durationField;
    private JTextField colourField;
    private JButton nextButton;
    private JButton likeButton;
    private JButton unLikeButton;
    private JButton doneButton;

    private Song addingThisSong;

    // EFFECTS: construct a sub-window to add song information
    public SongEditCreateWindow() {
        frameSizeX = 400;
        frameSizeY = 550;
        initialise();
    }

    // MODIFIES: this
    // EFFECTS: edit window behaviour
    private void initialise() {
        editCreateWindow = new JFrame();
        editCreateWindow.setTitle("New song+");
        editCreateWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        editCreateWindow.setLayout(null);
        editCreateWindow.setSize(frameSizeX, frameSizeY);
        editCreateWindow.getContentPane().setBackground(Color.decode(MainWindow.DARKER));

        setUpDisplay();
        setUpLabels();
        switchVisibility(true);
        setUpButtons();
        setUpTextFields();
        setUpComboBox();

        editCreateWindow.setResizable(false);
        editCreateWindow.setLocationRelativeTo(null);
        editCreateWindow.setVisible(true);
        editCreateWindow.requestFocusInWindow();
    }

    // MODIFIES: this
    // EFFECTS: set up the title display
    private void setUpDisplay() {
        display = new JPanel(null);
        display.setBackground(Color.decode(MainWindow.DARK));
        display.setBounds(10, 12, 368, 492);

        displayColourBlock = new JPanel(null);
        displayColourBlock.setBackground(Color.decode("#c3cdde"));
        displayColourBlock.setBounds(12, 10, 345, 125);

        ImageIcon eminemThrow = new ImageIcon("./data/eminemThrow.png");
        Image throwScale = eminemThrow.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_DEFAULT);
        throwNewSong = new JLabel(new ImageIcon(throwScale));
        throwNewSong.setBounds(35, 5, 150, 150);

        declarePanelShown();

        displayColourBlock.add(declareAsSong);
        displayColourBlock.add(throwNewSong);
        display.add(displayColourBlock);
        editCreateWindow.add(display);
    }

    // MODIFIES: this
    // EFFECTS: sets up label declaring what kind of information panel this is
    private void declarePanelShown() {
        declareAsSong = new JLabel("Required information");
        declareAsSong.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        declareAsSong.setBounds(110, 35, 175, 25);
        declareAsSong.setForeground(Color.decode(MainWindow.DARKEST));
        declareAsSong.setBackground(Color.decode(MainWindow.DAIKON));
        declareAsSong.setHorizontalAlignment(SwingConstants.CENTER);
        declareAsSong.setOpaque(true);
    }

    // MODIFIES: this
    // EFFECTS: set up instruction labels
    private void setUpLabels() {
        title = new LabelStyle("Title:", 20, 20, 115, 200, 100);
        linkpath = new LabelStyle("Link/filepath:", 20, 20, 215, 200, 100);
        artistName = new LabelStyle("Creator:", 15, 20, 115, 200, 100);
        albumTitle = new LabelStyle("Album:", 15, 25, 155, 200, 100);
        splitLine = new LabelStyle("___________________________", 20, 30, 215, 500, 22);
        genre = new LabelStyle("Genre:", 15, 25, 213, 200, 100);
        splitLineTwo = new LabelStyle("___________________________", 20, 30, 275, 500, 22);
        duration = new LabelStyle("Duration (seconds):", 15, 20, 275, 200, 100);
        colour = new LabelStyle("Cover colour (HEX):", 15, 20, 315, 200, 100);

        display.add(title);
        display.add(linkpath);
        display.add(artistName);
        display.add(albumTitle);
        display.add(splitLine);
        display.add(genre);
        display.add(splitLineTwo);
        display.add(duration);
        display.add(colour);
    }

    // MODIFIES: this
    // EFFECTS: set up text fields
    private void setUpTextFields() {
        titleField = new TextFieldStyle("Enter song title...", 35, 185, 17, 295, 35);
        linkField = new TextFieldStyle("Enter filepath or https://link...", 35, 287, 17, 295, 35);
        artistField = new TextFieldStyle("Enter artist name...", 90, 151, 15, 250, 30);
        albumField = new TextFieldStyle("Enter album name...", 90, 191, 15, 250, 30);
        durationField = new TextFieldStyle("Enter in seconds...", 180, 312, 15, 160, 30);
        colourField = new TextFieldStyle("c3cdde", 180, 352, 15, 160, 30);

        textFieldBehaviourAddition();

        display.add(titleField);
        display.add(linkField);
        display.add(artistField);
        display.add(albumField);
        display.add(durationField);
        display.add(colourField);
    }

    // MODIFIES: this
    // EFFECTS: set up JComboBox selector formatting
    private void setUpComboBox() {
        genreField = new JComboBox<>(Genre.values());
        genreField.setFont(new Font("SansSerif", Font.BOLD, 15));
        genreField.setForeground(Color.decode(MainWindow.getSteel()));
        genreField.setBackground(Color.decode(MainWindow.getDarker()));
        genreField.setBounds(90, 250, 250, 30);
        genreField.setFocusable(false);

        // NOTE: code for getting rid of the incredibly ugly blue focus border
        // in JComboBox taken from stackoverflow forum
        // https://stackoverflow.com/questions/78019684/how-to-disable-blue-focus-indicator-effect-inside-jcombobox
        genreField.setUI(new MetalComboBoxUI() {
            @ExcludeFromJacocoGeneratedReport
            @Override
            public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
                g.setColor(MetalLookAndFeel.getControlDarkShadow());
                g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height - 1);
                g.setColor(((BasicComboBoxRenderer) comboBox.getRenderer()).getBackground());
                g.drawRect(bounds.x + 1, bounds.y + 1, bounds.width - 2, bounds.height - 3);
            }
        });

        setStateGiven(genreField, false);
        display.add(genreField);
    }

    // MODIFIES: this
    // EFFECTS: set up the buttons
    private void setUpButtons() {
        nextButton = new ButtonStyle("Next", 36, 420, 20, 295, 45);
        likeButton = new ButtonStyle(DisPlay.LIKED, 300, 420, 30, 45, 45);
        unLikeButton = new ButtonStyle(DisPlay.UNLIKED, 300, 420, 30, 45, 45);
        doneButton = new ButtonStyle("Finish & close", 36, 420, 20, 250, 45);

        setUpNextButton();
        setUpLikeUnlike();
        setUpDoneButton();
    }

    // MODIFIES: this
    // EFFECTS: add default prompt behaviour to each text field
    private void textFieldBehaviourAddition() {
        setStateGiven(artistField, false);
        setStateGiven(albumField, false);
        setStateGiven(durationField, false);
        setStateGiven(colourField, false);

        infoPromptClear(titleField);
        infoPromptClear(linkField);
        infoPromptClear(artistField);
        infoPromptClear(albumField);
        infoPromptClear(durationField);
        infoPromptClear(colourField);
    }

    // MODIFIES: this
    // EFFECTS: add clear prompt behaviour to each text field
    private void infoPromptClear(JTextField textField) {
        textField.addMouseListener(new MouseAdapter() {
            @ExcludeFromJacocoGeneratedReport
            @Override
            public void mouseClicked(MouseEvent e) {
                textField.setText("");
                textField.setForeground(Color.decode(MainWindow.DAIKON));
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: display the creation panel for putting in title/linkpath
    private void setUpNextButton() {
        nextButton.addActionListener(new ActionListener() {
            @ExcludeFromJacocoGeneratedReport
            @Override
            public void actionPerformed(ActionEvent e) {
                if (trySet()) {
                    declareAsSong.setText("Non-required information");
                    declareAsSong.setBounds(110, 35, 200, 25);
                    editCreateWindow.requestFocusInWindow();

                    switchVisibility(false);

                    setStateGiven(titleField, false);
                    setStateGiven(linkField, false);
                    setStateGiven(artistField, true);
                    setStateGiven(albumField, true);
                    setStateGiven(genreField, true);
                    setStateGiven(durationField, true);
                    setStateGiven(colourField, true);
                    setStateGiven(doneButton, true);
                    buttonState(true, false);
                    setStateGiven(nextButton, false);
                }
            }
        });
        display.add(nextButton);
    }

    // MODIFIES: this
    // EFFECTS: attempts to create a song with the given information. True if
    // successful, false if the values are the default prompting values, or
    // are "" (no value entered)
    private Boolean trySet() {
        String proposedTitle = titleField.getText();
        String proposedLink = linkField.getText();
        if (!proposedTitle.equals("") && !proposedTitle.equals("Enter song title...")
                && !proposedLink.equals("") && !proposedLink.equals("Enter filepath or https://link...")) {
            Main.getLibrary().addSongToLibrary(proposedTitle, proposedLink);
            MainWindow.infoPanel.updateShown();
            try {
                addingThisSong = Main.getLibrary().searchSong(proposedTitle);
            } catch (SongNotFoundException e) {
                // can never happen
            }
            return true;
        } else {
            return false;
        }
    }

    // MODIFIES: this
    // EFFECTS: add all given information to the newly added song, then
    // close the song creation window
    private void setUpDoneButton() {
        doneButton.addActionListener(new ActionListener() {
            @ExcludeFromJacocoGeneratedReport
            @Override
            public void actionPerformed(ActionEvent e) {
                if (trySetThePrequel()) {
                    trySetTheSequel();
                    trySetGenre();
                    MainWindow.infoPanel.updateShown();
                    editCreateWindow.dispose();
                }
            }
        });
        setStateGiven(doneButton, false);
        display.add(doneButton);
    }

    // MODIFIES: this
    // EFFECTS: attempts to add given information to song. If entered value is the
    // default prompt value, or "" (no value entered), does not set to any value
    private void trySetTheSequel() {
        String proposedArtist = titleField.getText();
        String proposedAlbum = linkField.getText();
        if (!proposedArtist.equals("") && !proposedArtist.equals("Enter artist name...")) {
            Main.getLibrary().songArtist(proposedArtist, addingThisSong);
        }
        if (!proposedAlbum.equals("") && !proposedAlbum.equals("Enter album title...")) {
            if (!proposedArtist.equals("") && !proposedArtist.equals("Enter artist name...")) {
                Main.getLibrary().songAlbum(proposedAlbum, proposedArtist, addingThisSong);
            } else {
                Main.getLibrary().songAlbum(proposedAlbum, "unknown", addingThisSong);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: attempts to add given information to song. If entered value is the
    // default prompt value, or "" (no value entered), does not set to any value
    private boolean trySetThePrequel() {
        String proposedDuration = durationField.getText();
        String proposedColour = colourField.getText();
        try {
            int durationParseSuccess = Integer.parseInt(proposedDuration);
            if (durationParseSuccess > 0) {
                addingThisSong.setDuration(durationParseSuccess);
            }
        } catch (NumberFormatException e) {
            if (!proposedDuration.equals("") && !proposedDuration.equals("Enter in seconds...")) {
                return false;
            }
        }
        if (!proposedColour.equals("") && !proposedColour.equals("c3cdde")) {
            addingThisSong.setColour(proposedColour);
        }
        return true;
    }

    // MODIFIES: this
    // EFFECTS: attempts to add given information to song
    private void trySetGenre() {
        addingThisSong.setGenre(Genre.valueOf(genreField.getSelectedItem().toString()));
    }

    // MODIFIES: this
    // EFFECTS: switches label visibilities between states
    // true -> adding necessary information panel
    // false -> adding non-necessary information panel
    private void switchVisibility(boolean state) {
        title.setVisible(state);
        linkpath.setVisible(state);
        artistName.setVisible(!state);
        albumTitle.setVisible(!state);
        splitLine.setVisible(!state);
        genre.setVisible(!state);
        splitLineTwo.setVisible(!state);
        duration.setVisible(!state);
        colour.setVisible(!state);
    }

    // MODIFIES: this
    // EFFECTS: adds functionality to like/unlike buttons
    private void setUpLikeUnlike() {
        likeButton.addActionListener(new ActionListener() {
            @ExcludeFromJacocoGeneratedReport
            @Override
            public void actionPerformed(ActionEvent e) {
                addingThisSong.switchLikedStatus(false);
                buttonState(true, false);
            }
        });
        unLikeButton.addActionListener(new ActionListener() {
            @ExcludeFromJacocoGeneratedReport
            @Override
            public void actionPerformed(ActionEvent e) {
                addingThisSong.switchLikedStatus(true);
                buttonState(true, true);
            }
        });
        buttonState(false, false);
        display.add(likeButton);
        display.add(unLikeButton);
    }

    // MODIFIES: this
    // EFFECTS: changes button visibly depending on given state. If first
    // boolean is false, disables button behaviour (display is in emptyState()).
    // If first boolean is true, and the second variable is true, button behaviour
    // is on, and the button is liked. If first boolean is true, and the second is
    // false, button behaviour is on, and the button is unliked
    private void buttonState(Boolean b1, Boolean b2) {
        if (b1) {
            if (b2) {
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
        } else {
            likeButton.setVisible(false);
            likeButton.setEnabled(false);
            unLikeButton.setVisible(false);
            unLikeButton.setEnabled(false);
        }
    }

    // MODIFIES: this
    // EFFECTS: set component to visibility and enabled state given by boolean
    private void setStateGiven(JComponent component, boolean state) {
        component.setEnabled(state);
        component.setVisible(state);
    }
}
