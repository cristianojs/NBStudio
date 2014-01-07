/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.explorer;

import com.intersys.objects.Database;
import java.awt.Image;
import java.beans.IntrospectionException;
import org.nbstudio.core.Connection;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.ImageUtilities;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author daimor
 */
public class ConnectionFolderNode  extends AbstractNode {

    private Connection conn;

    public ConnectionFolderNode(Connection conn, String name) throws IntrospectionException {
        super(Children.LEAF, Lookups.fixed(conn));
        setDisplayName(name);
        this.conn = conn;
    }
    
    public final Database getAssocatedConnection()
    {
        return conn.getAssociatedConnection();
    }
    
    @Override
    public Image getIcon(int type) {
        return ImageUtilities.loadImage("org/nbstudio/core/folderClosed.gif");
    }

    @Override
    public Image getOpenedIcon(int type) {
        return ImageUtilities.loadImage("org/nbstudio/core/folderOpened.gif");
    }

}
