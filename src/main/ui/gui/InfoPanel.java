package ui.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.data.plain.Song;
import model.handlers.Library;
import model.handlers.PlayHandler;
import ui.Main;
import ui.gui.components.LabelStyle;
import ui.gui.components.PanelStyle;

@ExcludeFromJacocoGeneratedReport
public class InfoPanel extends PanelStyle {
    private boolean inQueueMode;
    private Library library;
    private PlayHandler queue;
    private JPanel queueStatus;
    private JLabel queueEmpty;
    private JPanel whatMenu;
    private JLabel thisMenu;
    private JLabel menuLine;
    private JPanel infoPart;
    private Dimension infoPartSize;
    private JScrollPane scrollPart;

    // EFFECTS: construct a panel to display the songs in the library,
    // as well as giving the user editing access to existing songs
    public InfoPanel() {
        super(MainWindow.DARK, 247, 15, 733, 485);
        infoPartSize = new Dimension();
        infoPart = new JPanel();
        infoPart.setBackground(Color.decode(MainWindow.DARK));
        infoPart.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        infoPart.setLayout(new BoxLayout(infoPart, BoxLayout.Y_AXIS));
        resetOrUpdateSize(true, 0);

        scrollPart = new JScrollPane(infoPart);
        scrollPart.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPart.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPart.getVerticalScrollBar().setUnitIncrement(10);
        scrollPart.setBounds(-1, -1, 736, 488);
        add(scrollPart);

        noteScreen();
        nothingQueue();
        updateShown();
    }

    // MODIFIES: this
    // EFFECTS: set the infoPart's size. If true is passed, reset to default,
    // if false is passed, update using given height
    private void resetOrUpdateSize(Boolean reset, int height) {
        if (reset) {
            infoPartSize.setSize(715, 43);
            infoPart.setPreferredSize(infoPartSize);
        } else {
            infoPartSize.setSize(715, infoPartSize.getHeight() + height);
        }
    }

    // MODIFIES: this
    // EFFECTS: set up the display that tells the user what menu they're in
    private void noteScreen() {
        whatMenu = new JPanel();
        whatMenu.setLayout(null);
        whatMenu.setMaximumSize(new Dimension(690, 43));
        whatMenu.setBackground(Color.decode(MainWindow.DARK));
        whatMenu.setAlignmentX(CENTER_ALIGNMENT);

        thisMenu = new LabelStyle("Viewing library...", 20, 10, 3, 200, 25);
        menuLine = new LabelStyle("________________________________________", 20, 7, 14, 500, 21);

        whatMenu.add(thisMenu);
        whatMenu.add(menuLine);
        infoPart.add(whatMenu);
    }

    // MODIFIES: this
    // EFFECTS: sets up the display that informs the user if 'view queue' is pressed
    // and queue is empty
    private void nothingQueue() {
        queueStatus = new JPanel();
        queueStatus.setLayout(null);
        queueStatus.setMaximumSize(new Dimension(690, 50));
        queueStatus.setBackground(Color.decode(MainWindow.DARKER));
        queueStatus.setAlignmentX(CENTER_ALIGNMENT);

        queueEmpty = new LabelStyle("Queue is currently empty", 17, 25, -27, 500, 100);
        queueEmpty.setEnabled(false);

        queueStatus.add(queueEmpty);
    }

    // MODIFIES: this
    // EFFECTS: update the library display following a change (eg. song is added)
    public void updateShown() {
        resetOrUpdateSize(true, 0);
        infoPart.removeAll();
        infoPart.repaint();
        infoPart.revalidate();
        thisMenu.setText("Viewing library...");
        menuLine.setText("________________________________________");
        infoPart.add(whatMenu);
        this.library = Main.getLibrary();
        for (Song toShow : library.getSongLibrary()) {
            infoPart.add(Box.createRigidArea(new Dimension(10, 2)));
            infoPart.add(new SongPanel(toShow));
            resetOrUpdateSize(false, 52);
        }
    }

    // MODIFIES: this
    // EFFECTS: flag that the info panel is currently displaying the queue
    // and should update the display if play/next is pressed
    public void inQueue(Boolean status) {
        this.inQueueMode = status;
    }

    // MODIFIES: this
    // EFFECTS: update the queue display following a change (eg. song is played)
    public void currentQueue() {
        if (inQueueMode) {
            resetOrUpdateSize(true, 0);
            infoPart.removeAll();
            infoPart.repaint();
            infoPart.revalidate();
            thisMenu.setText("Viewing queue...");
            menuLine.setText("________________________________________");
            infoPart.add(whatMenu);
            this.queue = Main.getPlayHandler();
            if (queue.getSongs().isEmpty()) {
                infoPart.add(Box.createRigidArea(new Dimension(10, 2)));
                infoPart.add(queueStatus);
                resetOrUpdateSize(false, 52);
            } else {
                for (Song toShow : queue.getSongs()) {
                    infoPart.add(Box.createRigidArea(new Dimension(10, 2)));
                    infoPart.add(new SongPanel(toShow));
                    resetOrUpdateSize(false, 52);
                }
            }
        }
    }
}
