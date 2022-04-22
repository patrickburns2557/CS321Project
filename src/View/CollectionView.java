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
    private static CollectionView collectionView;
    private static ArrayList<CollectionPeekView> collections;

    static {
        collectionView = new CollectionView();
    }
    /**
     * Constructor for collection view
     */
    private CollectionView() {
        // Reference to the user's current collections list
        this.setLayout(new BorderLayout());
        collections = new ArrayList<>();
        list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
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
                    view.ShowCollection(collection, true);
                }
            }

        });

        topBar.add(backButton);
        topBar.add(addButton);
        this.add(topBar, BorderLayout.NORTH);
        JScrollPane jp = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jp.getVerticalScrollBar().setUnitIncrement(20);
        JPanel collectionsPanel = new JPanel();
        collectionsPanel.setLayout(new BorderLayout());
        collectionsPanel.add(jp, BorderLayout.CENTER);
        this.add(collectionsPanel, BorderLayout.CENTER);
    }

    /**
     * Gets the singleton of CollectionView
     * @return singleton
     */
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
        for (var collection : userCollections) {
            addCollection(collection);
        }

        for (var collection : collections) {
            collection.refresh();
        }
    }

    /**
     * Adds a CollectionPeekView to the view
     * @param collection collection to be added
     */
    private void addCollection(Collection collection) {
        collections.add(new CollectionPeekView(this, collection));
        list.add(collections.get(collections.size() - 1));
    }

    /**
     * Removes a CollectionPeekView from the view
     * @param collection collection to be removed
     */
    public void removeCollection(Collection collection) {
        list.remove(Model.System.getInstance().getCurrentUser().getCollections().indexOf(collection));
        collections.remove(collection);
    }

    /**
     * Retrieves the CollectionPeekView
     * @param collection collection to be retrieved
     * @return CollectionPeekView that's associated with the collection
     */
    public CollectionPeekView getCollectionPeekView(Collection collection) {
        return collections.get(Model.System.getInstance().getCurrentUser().getCollections().indexOf(collection));
    }

}
