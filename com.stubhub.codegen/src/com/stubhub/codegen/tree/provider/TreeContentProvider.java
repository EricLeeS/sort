/**
 * 
 */
package com.stubhub.codegen.tree.provider;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.stubhub.codegen.tree.treeInterface.ITree;

/**
 * @author huanli2
 *
 */
public class TreeContentProvider implements IStructuredContentProvider,ITreeContentProvider{

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(Object arg0) {
		// TODO Auto-generated method stub
		 ITree tree=(ITree)arg0;
	        List list=tree.getChildren();
	        if(list!=null){
	            return list.toArray();
	        }
	        return new Object[0];
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	@Override
	public Object getParent(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(Object arg0) {
		// TODO Auto-generated method stub
		 ITree tree=(ITree)arg0;
	     List list=tree.getChildren();
	        
	     return !(list==null || list.isEmpty());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object arg0) {
		// TODO Auto-generated method stub
		  if(arg0 instanceof List){
	            List list=(List)arg0;
	            return list.toArray();
	        }
	        return new Object[0];
	}

}
