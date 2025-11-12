package ui.gui;


import javax.swing.JButton;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.handlers.PlayHandler;
import ui.gui.components.*;

@ExcludeFromJacocoGeneratedReport
public class DisPlay extends PanelStyle {
    private final String unLiked = "☆";
    private final String liked = "★";
    private final String playing = "||";
    private final String next = "▷▷";
    private PlayHandler queue;
    private JButton likeButton;
    private JButton unLikeButton;
    private JButton playButton;
    private JButton nextButton;

    // ▐ ▌ ▶ ☰ 𝘁𝗮𝗵𝗼𝗺𝗮 sans serif bold
    // ▷ ↺

    // EFFECTS: a constructor for the current behaviour of the display panel
    // based on the song queue. Starts out empty
    public DisPlay() {
        super(MainWindow.DARKEST, 7, 500, 973, 60);
        setUpButtons();
        emptyState();
    }

    // EFFECTS: set up the play/next on/off button behaviours
    private void setUpButtons() {
        unLikeButton = new ButtonStyle(unLiked, 37, 3, 30, 50, 50);
        playButton = new ButtonStyle(playing, 97, 15, 25, 25, 25);
        nextButton = new ButtonStyle(next, 132, 8, 20, 60, 40);
    }

    // MODIFIES: this
    // EFFECTS: load the no-song state of the display menu, with
    // greyed out play and next buttons
    private void emptyState() {
        unLikeButton.setEnabled(false);
        playButton.setEnabled(false);
        nextButton.setEnabled(false);
        add(unLikeButton);
        add(playButton);
        add(nextButton);
    }

    // MODIFIES: this
    // EFFECTS: load the song state of the display menu, with clickable
    // play and next buttons
    private void songState() {

    }

    // MODIFIES: this
    // EFFECTS: load the next state of the display menu, depending on
    // the following state of the queue
    // when play/next is pressed, queue is empty -> emptyState()
    // when play/next is pressed, queue is not empty -> songState()
    // when a song is added to the queue -> songState()
    public void updateQueue(PlayHandler queue) {
    }

    // setEnabled(false);
    // jbutton.setFocusPainted(false);
    // .ılılılllıılılıllllıılılllıllı.
    // ...............................
}
