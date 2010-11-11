/*
 * @(#)AWTClipboard.java
 * 
 * Copyright (c) 2009-2010 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 * 
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */

package org.jhotdraw_7_4_1.gui.datatransfer;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.util.Arrays;

/**
 * {@code AWTClipboard} acts as a proxy to an AWT {@code Clipboard} object.
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Proxy</em><br>
 * {@code AWTClipboard} acts as a proxy to an AWT {@code Clipboard} object.<br>
 * Proxy: {@link AWTClipboard}; Target: {@code java.awt.datatransfer.Clipboard}.
 * </hr>
 *
 * @author Werner Randelshofer
 * @version $Id: AWTClipboard.java 604 2010-01-09 12:00:29Z rawcoder $
 */
public class AWTClipboard extends AbstractClipboard {
    /** The proxy target. */
    private Clipboard target;

    /**
     * Creates a new proxy for the specified target object.
     *
     * @param target A Clipboard object.
     */
    public AWTClipboard(Clipboard target) {
        this.target = target;
    }

    /** Returns the proxy target. */
    public Clipboard getTarget() {
        return target;
    }

    public Transferable getContents(Object requestor) {
        return target.getContents(requestor);
    }

    /** Sets the current contents of the clipboard to the specified
     * {@code Transferable} object.
     *
     * @param contents The {@code Transferable} object representing clipboard
     * content.
     */
    @Override
    public void setContents(Transferable contents, ClipboardOwner owner) {
        target.setContents(contents, owner);
    }

}
