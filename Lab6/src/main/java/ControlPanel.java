import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author: Andreea Munteanu, group X
 */
public class ControlPanel extends JPanel {
    final MainFrame frame;
    // buttons:
    JButton exitButton = new JButton("Exit");
    JButton loadButton = new JButton("Load");
    JButton saveButton = new JButton("Save");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons ...TODO
        //configure listeners for all buttons
        exitButton.addActionListener(this::exitGame);
        //
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

}
