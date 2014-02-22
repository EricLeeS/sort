/**
 * 
 */
package com.stubhub.codegen.dialog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.eclipse.core.resources.IBuildConfiguration;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.dom.Message;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.layout.grouplayout.GroupLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.views.navigator.ResourceNavigatorMessages;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.wb.swt.layout.grouplayout.LayoutStyle;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.TreeViewer;

import com.stubhub.codegen.tree.model.treeMember;
import com.stubhub.codegen.tree.model.treeParent;
import com.stubhub.codegen.tree.provider.TreeContentProvider;
import com.stubhub.codegen.tree.provider.TreeLabelProvider;
import com.stubhub.codegen.util.constantHelper;
import com.stubhub.codegen.util.readClasspath;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;

/**
 * @author huanli2
 *
 */
public class selectFolderDialog extends Dialog {
	private Label labelText;
	private TreeViewer treeViewer;
	private List<treeParent> treeList = new ArrayList<treeParent>();
	private Button okButton;
	private Button cancelButton;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public selectFolderDialog(Shell parentShell) {
		super(parentShell);
		
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		
		labelText = new Label(container, SWT.NONE);
		labelText.setText("Choose a source folder");
		
		treeViewer = new TreeViewer(container, SWT.BORDER);
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				selectedItemChanged();
			}
		});
		Tree tree = treeViewer.getTree();
		GroupLayout gl_container = new GroupLayout(container);
		gl_container.setHorizontalGroup(
			gl_container.createParallelGroup(GroupLayout.LEADING)
				.add(gl_container.createSequentialGroup()
					.addContainerGap()
					.add(gl_container.createParallelGroup(GroupLayout.LEADING)
						.add(tree, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
						.add(labelText))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_container.setVerticalGroup(
			gl_container.createParallelGroup(GroupLayout.LEADING)
				.add(gl_container.createSequentialGroup()
					.addContainerGap()
					.add(labelText)
					.addPreferredGap(LayoutStyle.RELATED)
					.add(tree, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
					.addContainerGap())
		);
		initTree();
		container.setLayout(gl_container);
		

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);

		cancelButton = createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}



	/**
	 * 
	 */
	public void initTree() {
		// TODO Auto-generated method stub
		//labelText.setText("this is a text");
		
		treeViewer.setContentProvider(new TreeContentProvider());
		treeViewer.setLabelProvider(new TreeLabelProvider());
		
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		
		for(int i =1;i<projects.length;i++){
			IFile classpathFile = projects[i].getFile(".classpath");
			
			treeParent parent = new treeParent();
			parent.setName(projects[i].getName());
			
			
			
			List<treeMember> childList = new ArrayList<treeMember>();
			readClasspath ReadClassPath = new readClasspath();
			List<?> list =	ReadClassPath.getSrcFolder(classpathFile);
			for(int j=0;j<list.size();j++){
				treeMember member = new treeMember();
				member.setName(list.get(j).toString());
				member.setParent(projects[i].getName());
				childList.add(member);
				//System.out.println(list.get(j));
			}
			
			parent.setChildren(childList);
			treeList.add(parent);
		
			
		}
		
		treeViewer.setInput(treeList);
	}
	
	
	public void selectedItemChanged(){
		ISelection selection = treeViewer.getSelection();
		if(selection instanceof IStructuredSelection){
			Object element = ((IStructuredSelection) selection).getFirstElement();
			if(element instanceof treeMember){
				okButton.setEnabled(true);
				System.out.println(((treeMember) element).getName());
				String parent = ((treeMember) element).getParent();
				String child = ((treeMember) element).getName();
				
				
				String src=parent+"/"+child;
				constantHelper.setSrcFolder(src);
				
				
				IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
				for(int i=0;i<projects.length;i++){
					if(projects[i].getProject().getName().equalsIgnoreCase(parent)){
						constantHelper.setProject(projects[i]);
					}
				}
				
				
				
				
			}else if(element instanceof treeParent){
				okButton.setEnabled(false);
			}
		}
	}
	

}
