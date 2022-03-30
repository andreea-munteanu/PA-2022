import javax.swing.*;

import static java.awt.BorderLayout.CENTER;

/**
 * @author: Andreea Munteanu, group X
 */
public class MainFrame extends JFrame {
    ConfigurationPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        canvas = new DrawingPanel(this);
        //TODO

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, CENTER);
        //TODO

        //invoke the layout manager
        pack();
    }
}

