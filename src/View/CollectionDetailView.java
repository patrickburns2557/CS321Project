package View;

import Model.Collection;
import Model.Movie;
import Model.System;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Allows the user to view their collection in full, edit the list, edit the name, and delete it
 */
public class CollectionDetailView extends JPanel {
    private JPanel mainPanel;
    private CollectionTraverser collectionPanel;
    private MasterListTraverser masterListPanel;
    private JPanel topBar;
    private boolean currentlyEditing = false;

    /**
     * The view that displays what's in a collection and gives the user a way to edit it
     * @param collection collection associated with the view
     */
    public CollectionDetailView(Collection collection, boolean currentlyEditing) {
        this.currentlyEditing = currentlyEditing;
        this.setLayout(new BorderLayout());

        mainPanel = new JPanel();
        //mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.LINE_AXIS));
        mainPanel.setLayout(new GridLayout(1, 2));

        collectionPanel = new CollectionTraverser(collection, this.currentlyEditing);
        masterListPanel = new MasterListTraverser(collectionPanel);

        topBar = new JPanel();
        topBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("Back");
        JButton editButton = new JButton("Edit Collection");
        JButton editNameButton = new JButton("Change Collection Name");
        JButton deleteButton = new JButton("Delete Collection");

        topBar.add(backButton);
        topBar.add(editButton);
        topBar.add(editNameButton);
        topBar.add(deleteButton);

        if (this.currentlyEditing)
            mainPanel.add(masterListPanel);
        mainPanel.add(collectionPanel);
        this.add(topBar, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);

        backButton.addActionListener(e -> {
            // Go back to collection view
            MainWindow.getInstance().ShowCollectionList();
        });

        editNameButton.addActionListener(e -> {
            MainWindow view = MainWindow.getInstance();
            User user = Model.System.getInstance().getCurrentUser();

            JPanel newCollection = new JPanel();
            newCollection.setLayout(new GridLayout(1, 2));
            newCollection.add(new JLabel("Enter a collection name: ", JLabel.RIGHT));
            JTextField collectionName = new JTextField("Name");
            newCollection.add(collectionName);
            int result = JOptionPane.showOptionDialog(
                    view,
                    newCollection,
                    "Add Collection",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    null
            );

            if (result == JOptionPane.OK_OPTION) {
                String collectionNameString = collectionName.getText();
                boolean add = true;
                if (collectionNameString.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Collection name can't be blank");
                    add = false;
                }
                for (Collection c : user.getCollections()) {
                    if (collectionNameString.equals(c.getName())) {
                        JOptionPane.showMessageDialog(view, "Collection already exists");
                        add = false;
                    }
                }
                if (add) {
                    for (Collection c : user.getCollections()) {
                        if (c == collection) {
                            c.setName(collectionNameString);
                            CollectionView.getInstance().getCollectionPeekView(collection).refreshBorder();
                        }
                    }
                }
            }
        });

        editButton.addActionListener(e -> {
            if (this.currentlyEditing) {
                this.currentlyEditing = false;
                mainPanel.remove(masterListPanel);
                mainPanel.remove(collectionPanel);
                mainPanel.add(collectionPanel);
                this.repaint();
                MainWindow.getInstance().setVisible(true);
            }
            else {
                this.currentlyEditing = true;
                mainPanel.remove(collectionPanel);
                mainPanel.add(masterListPanel);
                mainPanel.add(collectionPanel);
                this.repaint();
                MainWindow.getInstance().setVisible(true);
            }

            collectionPanel.setDeleteMode(this.currentlyEditing);
            collectionPanel.RefreshGrid();
        });

        deleteButton.addActionListener(e -> {
            // Deletes the collection and returns to collection view
            int result = JOptionPane.showConfirmDialog(MainWindow.getInstance(), "Are you sure?");
            if (result == JOptionPane.YES_OPTION) {
                CollectionView.getInstance().removeCollection(collection);
                System.getInstance().getCurrentUser().removeCollection(collection);
                MainWindow.getInstance().ShowCollectionList();
            }
        });
    }
}
