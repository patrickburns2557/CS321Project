package View;

import Model.Collection;

import javax.swing.*;
import java.awt.*;

public class CollectionDetailView extends JPanel {
    //private Collection collection;
    public CollectionDetailView(Collection collection) {
        MovieGrid grid = new MovieGrid(collection);
        this.add(grid, BorderLayout.CENTER);
    }
}
