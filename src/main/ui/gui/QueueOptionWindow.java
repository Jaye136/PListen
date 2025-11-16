package ui.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.data.plain.Song;
import ui.Main;
import ui.gui.components.ButtonStyle;
import ui.gui.components.LabelStyle;

@ExcludeFromJacocoGeneratedReport
public class QueueOptionWindow extends JFrame {
    private int frameSizeX;
    private int frameSizeY;
    private JFrame queueTypesLook;
    private Song song;
    private JPanel background;
    private JLabel throwNewSong;
    private JLabel declareAsSong;
    private JLabel declareAsSeconds;
    private JLabel splitLine;
    private JButton addToPlaylistNew;
    private JButton addToPlaylistOld;
    private JLabel splitLineTwo;
    private JButton playNow;
    private JButton playInNext;
    private JButton playInQueue;

    // EFFECTS: construct a sub-window to bring up queue options
    public QueueOptionWindow(Song song) {
        frameSizeX = 350;
        frameSizeY = 500;
        this.song = song;
        initialise();
    }

    // MODIFIES: this
    // EFFECTS: edit window behaviour
    private void initialise() {
        queueTypesLook = new JFrame();
        queueTypesLook.setTitle("Queue options");
        queueTypesLook.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        queueTypesLook.setLayout(null);
        queueTypesLook.setSize(frameSizeX, frameSizeY);
        queueTypesLook.getContentPane().setBackground(Color.decode(MainWindow.DARKER));

        setUpLabels();
        setUpButtons();

        queueTypesLook.setResizable(false);
        queueTypesLook.setLocationRelativeTo(null);
        queueTypesLook.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: sets up the labels
    private void setUpLabels() {
        background = new JPanel(null);
        background.setBackground(Color.decode(song.getCoverColour()));
        background.setBounds(18, 20, 300, 125);

        ImageIcon eminemThrow = new ImageIcon("./data/eminemThrow.png");
        Image throwScale = eminemThrow.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_DEFAULT);
        throwNewSong = new JLabel(new ImageIcon(throwScale));
        throwNewSong.setBounds(35, 5, 150, 150);

        songTitleLabel();
        songDurationLabel();

        splitLine = new LabelStyle("________________________________________", 10, 50, 150, 500, 21);
        splitLine.setEnabled(false);
        splitLineTwo = new LabelStyle("________________________________________", 10, 50, 275, 500, 21);
        splitLineTwo.setEnabled(false);

        queueTypesLook.add(background);
        background.add(declareAsSong);
        background.add(declareAsSeconds);
        background.add(throwNewSong);
        queueTypesLook.add(splitLine);
        queueTypesLook.add(splitLineTwo);
    }

    // MODIFIES: this
    // EFFECTS: set up the label for the song title
    private void songTitleLabel() {
        Font thisFont = new Font("Comic Sans MS", Font.BOLD, 15);
        FontMetrics thisFontMetrics = getFontMetrics(thisFont);

        declareAsSong = new JLabel(letterLimit(song.getTitle(), 20));
        declareAsSong.setFont(thisFont);
        declareAsSong.setLocation(190 - thisFontMetrics.stringWidth(declareAsSong.getText()) / 2, 20);
        declareAsSong.setSize(thisFontMetrics.stringWidth(declareAsSong.getText()) + 10, 30);
        declareAsSong.setForeground(Color.decode(MainWindow.DARKEST));
        declareAsSong.setBackground(Color.decode(MainWindow.DAIKON));
        declareAsSong.setHorizontalAlignment(SwingConstants.CENTER);
        declareAsSong.setOpaque(true);
    }

    // MODIFIES: this
    // EFFECTS: set up the label for the song duration
    private void songDurationLabel() {
        Font thatFont = new Font("Comic Sans MS", Font.BOLD, 12);
        FontMetrics thatFontMetrics = getFontMetrics(thatFont);

        declareAsSeconds = new JLabel(Integer.toString(song.getDuration()) + " seconds");
        declareAsSeconds.setFont(thatFont);
        declareAsSeconds.setLocation(190 - thatFontMetrics.stringWidth(declareAsSeconds.getText()) / 2, 55);
        declareAsSeconds.setSize(thatFontMetrics.stringWidth(declareAsSeconds.getText()) + 10, 15);
        declareAsSeconds.setForeground(Color.decode(MainWindow.DARKEST));
        declareAsSeconds.setBackground(Color.decode(MainWindow.DAIKON));
        declareAsSeconds.setHorizontalAlignment(SwingConstants.CENTER);
        declareAsSeconds.setOpaque(true);
    }

    // EFFECTS: returns truncated version of passed string if the string is longer
    // or equal to the limit
    private String letterLimit(String str, int limit) {
        if (str.length() >= limit) {
            return str.substring(0, limit - 3) + "...";
        } else {
            return str;
        }
    }

    // MODIFIES: this
    // EFFECTS: sets up the buttons
    private void setUpButtons() {
        addToPlaylistNew = new ButtonStyle("Add to new playlist +", 30, 190, 15, 270, 30);
        addToPlaylistNew.setBackground(Color.decode(MainWindow.DARKEST));
        addToPlaylistNew.setEnabled(false);
        addToPlaylistOld = new ButtonStyle("Add to existing playlist...", 30, 230, 15, 270, 30);
        addToPlaylistOld.setBackground(Color.decode(MainWindow.DARKEST));
        addToPlaylistOld.setEnabled(false);

        playNow = new ButtonStyle("Play song", 30, 320, 15, 270, 30);
        playNow.setBackground(Color.decode(MainWindow.DARKEST));
        playInNext = new ButtonStyle("Play next", 30, 360, 15, 270, 30);
        playInNext.setBackground(Color.decode(MainWindow.DARKEST));
        playInQueue = new ButtonStyle("Queue song", 30, 400, 15, 270, 30);
        playInQueue.setBackground(Color.decode(MainWindow.DARKEST));

        queueTypesLook.add(addToPlaylistNew);
        queueTypesLook.add(addToPlaylistOld);
        playButtonAction();
        playNextButtonAction();
        queueSongButtonAction();
    }

    // MODIFIES: this
    // EFFECTS: adds functionality to queue replacement playNow button
    private void playButtonAction() {
        playNow.addActionListener(new ActionListener() {
            @ExcludeFromJacocoGeneratedReport
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getPlayHandler().playSongNow(song);
                MainWindow.disPlay.updateQueue();
            }
        });
        queueTypesLook.add(playNow);
    }

    // MODIFIES: this
    // EFFECTS: adds functionality to song append to front of queue button
    private void playNextButtonAction() {
        playInNext.addActionListener(new ActionListener() {
            @ExcludeFromJacocoGeneratedReport
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getPlayHandler().nextAddSong(song);
                MainWindow.disPlay.updateQueue();
            }
        });
        queueTypesLook.add(playInNext);
    }

    // MODIFIES: this
    // EFFECTS: adds functionality to song append to back of queue button
    private void queueSongButtonAction() {
        playInQueue.addActionListener(new ActionListener() {
            @ExcludeFromJacocoGeneratedReport
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getPlayHandler().queueAddSong(song);
                MainWindow.disPlay.updateQueue();
            }
        });
        queueTypesLook.add(playInQueue);
    }
}
