package ui.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import javax.swing.JLabel;

import model.data.plain.Song;
import ui.Main;
import ui.gui.components.ButtonStyle;
import ui.gui.components.LabelStyle;

@ExcludeFromJacocoGeneratedReport
public class SongPanel extends JPanel {
    private Song song;
    private JButton playButton;
    private JButton moreButton;
    private JButton likeButton;
    private JButton unLikeButton;

    public SongPanel(Song song) {
        this.song = song;
        setMaximumSize(new Dimension(690, 50));
        setBackground(Color.decode(MainWindow.DARKER));
        setAlignmentX(CENTER_ALIGNMENT);
        setLayout(null);

        displayInfo();
        displayButtons();
    }

    // MODIFIES: this
    // EFFECTS: display information about the song
    private void displayInfo() {
        add(new LabelStyle(letterLimit(song.getTitle(), 75), 13, 50, -18, 500, 100));
        JLabel creatorAndAlbum = new LabelStyle(
                letterLimit(song.getCreator().getName(), 30) + letterLimit("   |   " + song.getAlbum().getName(), 40),
                10, 50, -11, 500, 50);
        creatorAndAlbum.setEnabled(false);
        add(creatorAndAlbum);
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
    // EFFECTS: set up the buttons
    private void displayButtons() {
        playButton = new ButtonStyle("▶", 1, -1, 20, 50, 50);
        likeButton = new ButtonStyle(DisPlay.LIKED, 630, 9, 22, 26, 26);
        likeButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
        unLikeButton = new ButtonStyle(DisPlay.UNLIKED, 630, 9, 22, 26, 26);
        unLikeButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
        moreButton = new ButtonStyle("⋮", 653, -2, 25, 25, 50);

        playButton.setContentAreaFilled(false);
        likeButton.setContentAreaFilled(false);
        unLikeButton.setContentAreaFilled(false);
        moreButton.setContentAreaFilled(false);

        setUpPlay();
        if (song.getLikedStatus()) {
            buttonState(true);
        } else {
            buttonState(false);
        }
        setUpLikeUnlike();
        setUpMoreMenuOpen();
    }

    // MODIFIES: this
    // EFFECTS: adds functionality to play button
    private void setUpPlay() {
        playButton.addActionListener(new ActionListener() {
            @ExcludeFromJacocoGeneratedReport
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getPlayHandler().playSongNow(song);
                MainWindow.disPlay.updateQueue();
            }
        });
        add(playButton);
    }

    // MODIFIES: this
    // EFFECTS: adds functionality to like/unlike buttons
    private void setUpLikeUnlike() {
        likeButton.addActionListener(new ActionListener() {
            @ExcludeFromJacocoGeneratedReport
            @Override
            public void actionPerformed(ActionEvent e) {
                song.switchLikedStatus(false);
                buttonState(false);
                MainWindow.disPlay.updateQueue();
            }
        });
        unLikeButton.addActionListener(new ActionListener() {
            @ExcludeFromJacocoGeneratedReport
            @Override
            public void actionPerformed(ActionEvent e) {
                song.switchLikedStatus(true);
                buttonState(true);
                MainWindow.disPlay.updateQueue();
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

    // MODIFIES: this
    // EFFECTS: add the more menu button functionality. Opens a window
    // that gives queue options, as well as playlist options
    private void setUpMoreMenuOpen() {
        moreButton.addActionListener(new ActionListener() {
            @ExcludeFromJacocoGeneratedReport
            @Override
            public void actionPerformed(ActionEvent e) {
                new QueueOptionWindow(song);
            }
        });
        add(moreButton);
    }
}
