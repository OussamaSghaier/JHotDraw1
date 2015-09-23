/* @(#)AbstractAction.java
 * Copyright (c) 2015 by the authors and contributors of JHotDraw.
 * You may only use this file in compliance with the accompanying license terms.
 */
package org.jhotdraw.draw.tool;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import org.jhotdraw.app.AbstractDisableable;

/**
 * AbstractAction.
 * @author Werner Randelshofer
 */
public abstract class AbstractTracker extends AbstractDisableable implements Tracker {
    // ---
    // Fields
    // ---
    protected final BorderPane node = new BorderPane();

    // ---
    // Constructors
    // ---
    /** Creates a new instance.
     */
    public AbstractTracker() {

    }

    // ---
    // Properties
    // ---

    // ---
    // Behaviors
    // ---

    @Override
    public Node getNode() {
        return node;
    }
}
