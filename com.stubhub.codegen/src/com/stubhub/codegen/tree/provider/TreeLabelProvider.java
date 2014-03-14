/**
 * 
 */
package com.stubhub.codegen.tree.provider;



import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.stubhub.codegen.tree.treeInterface.ITree;

/**
 * @author huanli2
 *
 */
public class TreeLabelProvider extends LabelProvider implements ILabelProvider{
	public String getText(Object element){
        ITree node=(ITree)element;
        return node.getName();
    }
    public Image getImage(Object element){
        return null;
    }
}
