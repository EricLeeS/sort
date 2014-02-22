/**
 * 
 */
package com.stubhub.codegen.tree.treeInterface;

import java.util.List;

/**
 * @author huanli2
 *
 */
public interface ITree {
	   public String getName();
	   public void setName(String name);
	   public List getChildren();
	   public void setChildren(List children);
	   public void setParent(String parent);
	   public String getParent();
	}