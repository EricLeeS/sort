/**
 * 
 */
package com.stubhub.codegen.wizards;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.JSpinner.DefaultEditor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.wb.swt.layout.grouplayout.GroupLayout;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.layout.grouplayout.LayoutStyle;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.jdt.internal.compiler.batch.FileSystem.Classpath;
import org.eclipse.jdt.internal.ui.packageview.PackageFragmentRootContainer;





import org.eclipse.jdt.ui.IJavaElementSearchConstants;
import org.eclipse.jdt.ui.JavaUI;

import com.stubhub.codegen.constant.EnvironmentConstant;
import com.stubhub.codegen.dialog.selectFolderDialog;
import com.stubhub.codegen.util.constantHelper;
import com.stubhub.codegen.util.readClasspath;

import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;

/**
 * @author huanli2
 *
 */
public class SelectPackage extends WizardPage {
	private Text SourceFolderText;
	private Text PackageText;
	private IPath initialSourceFolder;
	private Label sourceFileField;
	private Text URLText;
	
	/**
	 * Create the wizard.
	 */
	public SelectPackage() {
		super("wizardPage");
		setPageComplete(false);
		setTitle("STUBHUB");
		setDescription("Code Generation");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		
		Label SourceFolder = new Label(container, SWT.NONE);
		SourceFolder.setText("SourceFolder");
		
		SourceFolderText = new Text(container, SWT.BORDER);
		SourceFolderText.setText("");
		
		Button SelectFolder = new Button(container, SWT.NONE);
		SelectFolder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browseForSourceFile();
			}
		});
		SelectFolder.setText("Browse...");
		
		PackageText = new Text(container, SWT.BORDER);
		PackageText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				constantHelper.setPackageName(PackageText.getText().toString().trim());
				nextStatus();
			}
		});
		
		Label Package = new Label(container, SWT.NONE);
		Package.setText("Package");
		
		Button SelectPackage = new Button(container, SWT.NONE);
		SelectPackage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
 
                super.widgetSelected(e);  
               // IJavaProject javaProject = JavaCore.create(getCurrentProject());
                IJavaProject javaProject =JavaCore.create(constantHelper.getProject()); 
                if(javaProject!=null){
                SelectionDialog dialog = null;  
                try {  
                    dialog = JavaUI.createPackageDialog(  
                                    getShell(),javaProject,IJavaElementSearchConstants.CONSIDER_REQUIRED_PROJECTS);  
                    dialog.setTitle("Package Selection");  
                    dialog.setMessage("Choose a folder");  
                } catch (JavaModelException e1) {  
                    // ExceptionHandler.handleExceptionAndAbort(e1);  
                }  
                if (dialog.open() != Window.OK) {  
                    return;  
                }  
                IPackageFragment pck = (IPackageFragment) dialog.getResult()[0];  
                if (pck != null) {  
                	//System.out.println(pck.getElementName());
                	constantHelper.setPackageName(pck.getElementName());
                	PackageText.setText(pck.getElementName());
                	nextStatus();
                    //packageTxt.setText(pck.getElementName());  
                }  

			}else{
				System.out.println("Selectedproject is null");
			}
		}});
		SelectPackage.setText("Browse...");
		
		Label label_1 = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setText("URL");
		
		URLText = new Text(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
		URLText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				String str = URLText.getText().toString().trim();
				String[] url = str.split("\r\n");
				List list = new ArrayList();
				for(int i=0;i<url.length;i++){
					list.add(url[i]);
				}
				constantHelper.setUrlList(list);
				nextStatus();
				
			}
		});
		GroupLayout gl_container = new GroupLayout(container);
		gl_container.setHorizontalGroup(
			gl_container.createParallelGroup(GroupLayout.LEADING)
				.add(gl_container.createSequentialGroup()
					.add(gl_container.createParallelGroup(GroupLayout.LEADING)
						.add(gl_container.createSequentialGroup()
							.add(69)
							.add(gl_container.createParallelGroup(GroupLayout.LEADING)
								.add(gl_container.createSequentialGroup()
									.addPreferredGap(LayoutStyle.RELATED)
									.add(SourceFolder))
								.add(gl_container.createSequentialGroup()
									.add(9)
									.add(gl_container.createParallelGroup(GroupLayout.LEADING)
										.add(lblNewLabel)
										.add(Package))))
							.add(gl_container.createParallelGroup(GroupLayout.LEADING)
								.add(gl_container.createSequentialGroup()
									.add(18)
									.add(gl_container.createParallelGroup(GroupLayout.LEADING)
										.add(SourceFolderText, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
										.add(PackageText, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))
									.add(18)
									.add(gl_container.createParallelGroup(GroupLayout.TRAILING)
										.add(SelectFolder)
										.add(SelectPackage)))
								.add(gl_container.createSequentialGroup()
									.add(12)
									.add(URLText, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE))))
						.add(gl_container.createSequentialGroup()
							.add(44)
							.add(label_1, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		gl_container.setVerticalGroup(
			gl_container.createParallelGroup(GroupLayout.LEADING)
				.add(gl_container.createSequentialGroup()
					.add(gl_container.createParallelGroup(GroupLayout.LEADING)
						.add(gl_container.createSequentialGroup()
							.add(17)
							.add(gl_container.createParallelGroup(GroupLayout.BASELINE)
								.add(SourceFolder)
								.add(SourceFolderText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.RELATED)
							.add(gl_container.createParallelGroup(GroupLayout.BASELINE)
								.add(Package)
								.add(PackageText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.add(SelectPackage)))
						.add(gl_container.createSequentialGroup()
							.addContainerGap()
							.add(SelectFolder)))
					.add(37)
					.add(label_1)
					.add(gl_container.createParallelGroup(GroupLayout.LEADING)
						.add(gl_container.createSequentialGroup()
							.add(63)
							.add(lblNewLabel))
						.add(gl_container.createSequentialGroup()
							.add(40)
							.add(URLText, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		container.setLayout(gl_container);
		initContent();
	}
	//get the current project
	public void init(IStructuredSelection selection){
		 
		IProject project =getCurrentProject();
		
		if(project==null){
			System.out.println("Project is null");
		}else{
			String projectPath = project.getName().toString()+"/src";
			constantHelper.setProject(project);
			initialSourceFolder =Path.fromOSString(projectPath);
		}
	}
	

	//get the project
	public static IProject getCurrentProject(){   
        ISelectionService selectionService = Workbench.getInstance().getActiveWorkbenchWindow().getSelectionService();   
   
        ISelection selection = selectionService.getSelection();   
       
   
        IProject project = null;   
        if(selection instanceof IStructuredSelection) {   
            Object element = ((IStructuredSelection)selection).getFirstElement();   
            
            if (element instanceof IResource) {   
                project= ((IResource)element).getProject();   
            } else if (element instanceof PackageFragmentRootContainer) {  
            	//System.out.println(((PackageFragmentRootContainer)element).getPackageFragmentRoots().getClass().toString());
            	
                IJavaProject jProject = ((PackageFragmentRootContainer)element).getJavaProject();   
                project = jProject.getProject();   
            } else if (element instanceof IJavaElement) {
            	
                IJavaProject jProject= ((IJavaElement)element).getJavaProject();   
                project = jProject.getProject();   
            }  
        }    
        return project;   
    } 
	
	//init some parameter
	public void initContent(){
		if(initialSourceFolder==null){
			setPageComplete(false);
			return;
		}
		SourceFolderText.setText(initialSourceFolder.toString());
		nextStatus();
	}
	
	protected void browseForSourceFile(){

		selectFolderDialog dialog = new selectFolderDialog(getShell());
		
		if(dialog.open()==selectFolderDialog.OK){
			if(constantHelper.getSrcFolder()!=null){
				SourceFolderText.setText(constantHelper.getSrcFolder());
				nextStatus();
			}
			
		}	
	}
	
	public void nextStatus(){
		String sourceFolderText = SourceFolderText.getText().toString().trim();
		String packageText = PackageText.getText().toString().trim();
		String urlText = URLText.getText().toString().trim();
		if((sourceFolderText==null)||(sourceFolderText.equals(""))){
			setPageComplete(false);
		}else if((packageText==null)||(packageText.equals(""))){
			setPageComplete(false);
		}else if((urlText==null)||(urlText.equals(""))){
			setPageComplete(false);
		}else{
			constantHelper.setPackageName(packageText);
			String name = constantHelper.getPackageName();
			IPath path = ResourcesPlugin.getWorkspace().getRoot().getLocation();
			
			EnvironmentConstant.OUTPUT_DIR=path.toString()+"/"+constantHelper.getSrcFolder();
			
			//System.out.println(constantHelper.getProject());
			System.out.print(EnvironmentConstant.OUTPUT_DIR);
			setPageComplete(true);
		}
	}
}
