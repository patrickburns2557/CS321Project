package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Model.Collection;

public class CollectionView extends JPanel implements ActionListener {
    private ArrayList<Collection> userCollections;
    public CollectionView(ArrayList<Collection> userCollections) {
        // Reference to the user's current collections list
        this.userCollections = userCollections;
        setLayout(new BorderLayout());
    }

    /**
     * Anytime the collection list is changed, then the CollectionView needs to be refreshed
     * @param actionEvent
     */
    public void actionPerformed(ActionEvent actionEvent) {
        refresh();
    }

    /**
     * Updates the collection view
     */
    public void refresh() {
        // Clear all components
        this.removeAll();
        if (!userCollections.isEmpty()) {
            // Add all user collections
            JPanel list = new JPanel();

            list.setLayout(new GridLayout(userCollections.size(), 0, 5, 5));
            for (var collection : userCollections) {
                list.add(new CollectionPeekView(this, collection), BorderLayout.CENTER);
            }
            JScrollPane jp = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            jp.getVerticalScrollBar().setUnitIncrement(20);
            this.add(jp, BorderLayout.CENTER);
        }
        else {
            // If the user collection list is empty then display text
            JLabel noCollections = new JLabel("No collections to view");
            this.add(noCollections);
        }
    }
}
