/*
 * @(#)SelectAllAction.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */
package org.jhotdraw.app.action.edit;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import org.jhotdraw.util.*;
import org.jhotdraw.app.EditableComponent;

/**
 * Selects all items.
 * <p>
 * This action acts on the last {@link org.jhotdraw.app.EditableComponent} /
 * {@code JTextComponent} which had the focus when the {@code ActionEvent}
 * was generated.
 * <p>
 * This action is called when the user selects the Select All item in the
 * Edit menu. The menu item is automatically created by the application.
 * <p>
 * If you want this behavior in your application, you have to create an action
 * with this ID and put it in your {@code ApplicationModel} in method
 * {@link org.jhotdraw.app.ApplicationModel#initApplication}.
 *
 * @author Werner Randelshofer.
 * @version $Id$
 */
public class SelectAllAction extends AbstractAction {

    public final static String ID = "edit.selectAll";

    /** The target of the action or null if the action acts on the currently
     * focused component.
     */
    private JComponent target;

    /** Creates a new instance which acts on the currently focused component. */
    public SelectAllAction() {
        this(null);
    }

    /** Creates a new instance which acts on the specified component.
     *
     * @param target The target of the action. Specify null for the currently
     * focused component.
     */
    public SelectAllAction(JComponent target) {
        this.target = target;
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        labels.configureAction(this, ID);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        JComponent c = target;
        if (c == null && (KeyboardFocusManager.getCurrentKeyboardFocusManager().
                getPermanentFocusOwner() instanceof JComponent)) {
            c = (JComponent) KeyboardFocusManager.getCurrentKeyboardFocusManager().
                    getPermanentFocusOwner();
        }
        if (c != null) {
            if (c instanceof EditableComponent) {
                ((EditableComponent) c).selectAll();
            } else if (c instanceof JTextComponent) {
                ((JTextComponent) c).selectAll();
            } else {
                c.getToolkit().beep();
            }
        }
    }
}
