package View;

import Model.Collection;
import Model.System;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CollectionDetailView extends JPanel {
    private JPanel collectionPanel;
    private JPanel topBar;
    private boolean currentlyEditing = false;

    /**
     * The view that displays what's in a collection and gives the user a way to edit it
     * @param collection
     */
    public CollectionDetailView(Collection collection) {
        this.setLayout(new BorderLayout());

        collectionPanel = new JPanel();
        collectionPanel.setLayout(new BorderLayout());

        topBar = new JPanel();
        topBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            // Go back to collection view
            MainWindow.getInstance().ShowCollectionList();
        });
        JButton editButton = new JButton("Edit Collection");
        editButton.addActionListener(e -> {
            // Show home view on left panel
        });
        JButton editNameButton = new JButton("Change Collection Name");
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
        JButton deleteButton = new JButton("Delete Collection");
        deleteButton.addActionListener(e -> {
            // Deletes the collection and returns to collection view
            int result = JOptionPane.showConfirmDialog(MainWindow.getInstance(), "Are you sure?");
            if (result == JOptionPane.YES_OPTION) {
                CollectionView.getInstance().removeCollection(collection);
                System.getInstance().getCurrentUser().removeCollection(collection);
                MainWindow.getInstance().ShowCollectionList();
            }
        });
        topBar.add(backButton);
        topBar.add(editButton);
        topBar.add(editNameButton);
        topBar.add(deleteButton);

        MovieGrid grid = new MovieGrid(collection);

        for(int i = 0; i < collection.getMovies().size(); i++)
        {
            final int final_i = i;
            grid.addPosterListener(event ->
            {
                MainWindow view = MainWindow.getInstance();
                view.ShowMovie(collection.getMovies().get(final_i), e -> view.ShowCollection(collection));
            }, i);
        }

        collectionPanel.add(grid, BorderLayout.CENTER);
        this.add(topBar, BorderLayout.NORTH);
        this.add(collectionPanel, BorderLayout.CENTER);
    }
}
