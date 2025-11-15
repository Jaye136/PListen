package ui.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import ui.Main;
import ui.gui.components.ButtonStyle;
import ui.gui.components.PanelStyle;

@ExcludeFromJacocoGeneratedReport
public class InfoPanel extends PanelStyle {
    private JPanel infoPart;
    private JScrollPane scrollPart;

    // EFFECTS: construct a panel to display the songs in the library,
    // as well as giving the user editing access to existing songs
    public InfoPanel() {
        super(MainWindow.DARK, 247, 15, 733, 485);
        infoPart = new JPanel();
        infoPart.setBackground(Color.decode(MainWindow.DARK));
        // JPanel dajsdji = new JPanel();
        // dajsdji.setPreferredSize(new Dimension(500, 100));
        // dajsdji.setBackground(Color.decode("#000000"));
        // infoPart.add(dajsdji);
        // infoPart.add(new ButtonStyle("asndadhjjh", 1, 2, 50, 400, 100));
        infoPart.setLayout(new BoxLayout(infoPart, BoxLayout.PAGE_AXIS));

        scrollPart = new JScrollPane(infoPart);
        scrollPart.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPart.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPart.setBounds(-1, -1, 736, 488);
        add(scrollPart);
    }

    // MODIFIES: this
    // EFFECTS: reload the library following a change (eg. song is added)
    public void updateShown() {

    }

    // MODIFIES: this
    // EFFECTS: display the current queue
    public void currentQueue() {

    }

    // private void playSong() {
    // newSong.addActionListener(new ActionListener() {
    // @Override
    // public void actionPerformed(ActionEvent e) {
    // Main.getPlayHandler().playSongNow(new Song("a", "b"));
    // MainWindow.disPlay.updateQueue();
    // }
    // });
    // add(newSong);
    // }
}
