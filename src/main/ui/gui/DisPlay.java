package ui.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.data.plain.Song;
// import model.handlers.Library;
import model.handlers.PlayHandler;
import ui.gui.components.*;

@ExcludeFromJacocoGeneratedReport
public class DisPlay extends PanelStyle {
    private final String unLiked = "☆";
    private final String liked = "★";
    private final String playing = "||";
    private final String next = "▷▷";
    private PlayHandler queue;
    private Song currentlyPlaying;
    private JButton likeButton;
    private JButton unLikeButton;
    private JButton playButton;
    private JButton nextButton;
    private JLabel playStatus;
    private JLabel songTitle;
    private JLabel songCreator;

    // ▐ ▌ ▶ ☰ 𝘁𝗮𝗵𝗼𝗺𝗮 sans serif bold
    // ▷ ↺

    // EFFECTS: a constructor for the current behaviour of the display panel
    // based on the song queue. Starts out empty
    public DisPlay() {
        super(MainWindow.DARKEST, 7, 500, 973, 60);
        setUpLabels();
        setUpButtons();
        emptyState();
        // Library.defaultValues();
        // queue = new PlayHandler();
        // queue.playSongNow(new Song("a", "b"));
        // queue.nextAddSong(new Song("c", "d"));
        // updateQueue(queue);
    }

    // MODIFIES: this
    // EFFECTS: set up the labels
    private void setUpLabels() {
        playStatus = new LabelStyle("Now playing...", 13, 255, 10, 100, 20);
        songTitle = new LabelStyle("Nothing", 23, 350, -30);
        songCreator = new LabelStyle("By " + "Nobody", 13, 350, -6);
        add(playStatus);
        add(songTitle);
        add(songCreator);
    }

    // MODIFIES: this
    // EFFECTS: set up the play/next on/off button behaviours
    // NOTE: code in helpers learned from ActionListener video tutorial on
    // https://www.youtube.com/watch?v=ObVnyA8ar6Q&list=PL3bGLnkkGnuV699lP_f9DvxyK5lMFpq6U&index=10
    private void setUpButtons() {
        likeButton = new ButtonStyle(liked, 37, 3, 30, 50, 50);
        unLikeButton = new ButtonStyle(unLiked, 37, 3, 30, 50, 50);
        playButton = new ButtonStyle(playing, 97, 15, 25, 25, 25);
        nextButton = new ButtonStyle(next, 132, 8, 20, 60, 40);
        setUpLikeUnlike();
        setUpPlay();
        setUpNext();
    }

    // MODIFIES: this
    // EFFECTS: adds functionality to like/unlike buttons
    private void setUpLikeUnlike() {
        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentlyPlaying.switchLikedStatus(false);
                buttonState(true, false);
            }
        });
        unLikeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentlyPlaying.switchLikedStatus(true);
                buttonState(true, true);
            }
        });
        add(likeButton);
        add(unLikeButton);
    }

    // MODIFIES: this
    // EFFECTS: adds functionality to play button
    // NOTE: time delay code taken from stackexchange forum
    // https://stackoverflow.com/questions/16596428/removing-a-jlabel-after-10-seconds?rq=3
    private void setUpPlay() {
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                songTitle.setText(queue.playSongQueue());
                songCreator.setText("Played for " + currentlyPlaying.getDuration() + " seconds.");
                int delay = 800;
                ActionListener taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        updateQueue(queue);
                    }
                };
                new javax.swing.Timer(delay, taskPerformer).start();
            }
        });
        add(playButton);
    }

    // MODIFIES: this
    // EFFECTS: adds functionality to next button
    // NOTE: time delay code taken from stackexchange forum
    // https://stackoverflow.com/questions/16596428/removing-a-jlabel-after-10-seconds?rq=3
    private void setUpNext() {
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queue.playSongQueue();
                songTitle.setText("Skipping...");
                int delay = 500;
                ActionListener taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        updateQueue(queue);
                    }
                };
                new javax.swing.Timer(delay, taskPerformer).start();
            }
        });
        add(nextButton);
    }

    // MODIFIES: this
    // EFFECTS: load the no-song state of the display menu, with
    // greyed out buttons and information
    private void emptyState() {
        buttonState(false, false);
        playButton.setEnabled(false);
        nextButton.setEnabled(false);
        songTitle.setText("Nothing");
        songCreator.setText("By " + "Nobody");
        playStatus.setEnabled(false);
        songTitle.setEnabled(false);
        songCreator.setEnabled(false);
    }

    // MODIFIES: this
    // EFFECTS: load the song state of the display menu, with clickable
    // buttons and information
    private void songState() {
        playButton.setEnabled(true);
        nextButton.setEnabled(true);
        if (currentlyPlaying.getLikedStatus()) {
            buttonState(true, true);
        } else {
            buttonState(true, false);
        }
        playStatus.setEnabled(true);
        songTitle.setText(currentlyPlaying.getTitle());
        songTitle.setEnabled(true);
        songCreator.setText("By " + currentlyPlaying.getCreator().getName());
        songCreator.setEnabled(true);
    }

    // MODIFIES: this
    // EFFECTS: load the next state of the display menu, depending on
    // the following state of the queue
    // when play/next is pressed, queue is empty -> emptyState()
    // when play/next is pressed, queue is not empty -> songState()
    // when a song is added to the queue -> songState()
    public void updateQueue(PlayHandler queue) {
        this.queue = queue;
        if (queue.getSongs().isEmpty()) {
            emptyState();
        } else {
            currentlyPlaying = queue.getSongs().get(0);
            songState();
        }
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
            unLikeButton.setVisible(true);
            unLikeButton.setEnabled(false);
        }
    }
}
