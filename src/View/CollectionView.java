package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class CollectionView extends JPanel {
    public CollectionView() {
        ArrayList<CollectionPeekView> collections = new ArrayList<CollectionPeekView>();
        JPanel list = new JPanel();
        collections.add(new CollectionPeekView(this));
        collections.add(new CollectionPeekView(this));
        collections.add(new CollectionPeekView(this));
        collections.add(new CollectionPeekView(this));
        collections.add(new CollectionPeekView(this));
        collections.add(new CollectionPeekView(this));
        collections.add(new CollectionPeekView(this));

        setLayout(new BorderLayout());
        list.setLayout(new GridLayout(collections.size(), 0, 5, 5));
        for (var collection : collections) {
            list.add(collection, BorderLayout.CENTER);
        }
        JScrollPane jp = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jp.getVerticalScrollBar().setUnitIncrement(20);
        this.add(jp, BorderLayout.CENTER);
    }
}
