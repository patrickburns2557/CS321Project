package View;

import Model.Collection;
import Model.System;

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
            // Create JOptionPane
        });
        JButton deleteButton = new JButton("Delete Collection");
        deleteButton.addActionListener(e -> {
            // Deletes the collection and returns to collection view
            ArrayList<Collection> collectionList = System.getInstance().getCurrentUser().getCollections();
            int i = 0;
            while (collection != collectionList.get(i++));
            System.getInstance().getCurrentUser().removeCollection(collection);
            CollectionView.getInstance().removeCollection(i - 1);
            MainWindow.getInstance().ShowCollectionList();
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
