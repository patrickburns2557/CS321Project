package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;

import Model.Collection;
import Model.User;

/**
 * Lists the user's collections as CollectionPeekView(s)
 */
public class CollectionView extends JPanel implements ActionListener {
    private static JPanel list;
    private static GridLayout listLayout;
    private static CollectionView collectionView;

    /**
     *
     */
    static {
        collectionView = new CollectionView();
    }
    private CollectionView() {
        // Reference to the user's current collections list
        this.setLayout(new BorderLayout());
        list = new JPanel();
        listLayout = new GridLayout(0, 1);
        list.setLayout(listLayout);
        JPanel topBar = new JPanel();
        topBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("Back");
        JButton addButton = new JButton("Create New Collection");

        backButton.addActionListener(e -> {
            MainWindow view = MainWindow.getInstance();
            view.ShowHome();
        });

        addButton.addActionListener(e -> {
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
                    Collection collection = new Collection(collectionNameString);
                    user.addCollection(collection);
                    addCollection(collection);
                    view.ShowCollection(collection);
                }
            }

        });

        topBar.add(backButton);
        topBar.add(addButton);
        this.add(topBar, BorderLayout.NORTH);
        JScrollPane jp = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jp.getVerticalScrollBar().setUnitIncrement(20);
        JPanel collectionsPanel = new JPanel();
        collectionsPanel.setLayout(new BorderLayout());
        collectionsPanel.add(jp, BorderLayout.CENTER);
        this.add(collectionsPanel, BorderLayout.CENTER);
    }

    public static CollectionView getInstance() {
        return collectionView;
    }

    /**
     * Anytime the collection list is changed, then the CollectionView needs to be refreshed
     * @param actionEvent
     */
    public void actionPerformed(ActionEvent actionEvent) {
        //refresh();
    }

    /**
     * Updates the collection view
     */
    public void refresh() {
        // Clear all components
        list.removeAll();

        ArrayList<Collection> userCollections = Model.System.getInstance().getCurrentUser().getCollections();
        if (!userCollections.isEmpty()) {
            for (var collection : userCollections) {
                addCollection(collection);
            }
        }
        else {
            // If the user collection list is empty then display text
            JLabel noCollections = new JLabel("No collections to view");
            list.add(noCollections);
        }
    }

    private void addCollection(Collection collection) {
        listLayout.setRows(listLayout.getRows() + 1);
        list.add(new CollectionPeekView(this, collection), BorderLayout.CENTER);
    }

    public void removeCollection(int index) {
        listLayout.setRows(listLayout.getRows() - 1);
        list.remove(index);
    }
}
