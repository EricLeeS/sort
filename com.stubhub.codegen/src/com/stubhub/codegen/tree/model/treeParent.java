/**
 * 
 */
package com.stubhub.codegen.tree.model;

import java.util.ArrayList;
import java.util.List;

import com.stubhub.codegen.tree.treeInterface.ITree;

/**
 * @author huanli2
 *
 */
public class treeParent implements ITree{

	private String name;
	private List children = new ArrayList();
	private String parent;
	/* (non-Javadoc)
	 * @see com.stubhub.codegen.treeModel.ITree#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	/* (non-Javadoc)
	 * @see com.stubhub.codegen.treeModel.ITree#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see com.stubhub.codegen.treeModel.ITree#getChildren()
	 */
	@Override
	public List<treeMember> getChildren() {
		// TODO Auto-generated method stub
		return children;
	}

	/* (non-Javadoc)
	 * @see com.stubhub.codegen.treeModel.ITree#setChildren(java.util.List)
	 */
	@Override
	public void setChildren(List children) {
		// TODO Auto-generated method stub
		this.children = children;
	}

	/* (non-Javadoc)
	 * @see com.stubhub.codegen.tree.treeInterface.ITree#setParent(java.lang.String)
	 */
	@Override
	public void setParent(String parent) {
		// TODO Auto-generated method stub
		this.parent = parent;
	}

	/* (non-Javadoc)
	 * @see com.stubhub.codegen.tree.treeInterface.ITree#getParent()
	 */
	@Override
	public String getParent() {
		// TODO Auto-generated method stub
		return this.parent;
	}

}
