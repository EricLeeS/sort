package com.stubhub.codegen.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.core.runtime.*;
import org.eclipse.jface.operation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.CoreException;

import java.io.*;

import org.eclipse.ui.*;

import com.stubhub.codegen.fileparser.FileParser;
import com.stubhub.codegen.util.constantHelper;

/**
 * This is a sample new wizard. Its role is to create a new file 
 * resource in the provided container. If the container resource
 * (a folder or a project) is selected in the workspace 
 * when the wizard is opened, it will accept it as the target
 * container. The wizard creates one file with the extension
 * "mpe". If a sample multi-page editor (also available
 * as a template) is registered for the same extension, it will
 * be able to open it.
 */

public class MainWizard extends Wizard implements INewWizard {
	
	private ISelection selection;
	private IStructuredSelection initialSelection;
	private SecondWizardPage secondWizardPage;
	private SelectPackage selectPackage;
	private ThirdWizardPage thirdWizardPage;
	private FinalWizardPage finalWizardPage;
	private TheLastPage theLastPage;

	/**
	 * Constructor for SampleNewWizard.
	 */
	public MainWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {

		selectPackage = new SelectPackage();
		
		
		addPage(selectPackage);
		selectPackage.init((IStructuredSelection) selection);
//		secondWizardPage = new SecondWizardPage();
//		addPage(secondWizardPage);
//		thirdWizardPage = new ThirdWizardPage();
//		addPage(thirdWizardPage);
		
		finalWizardPage = new FinalWizardPage();
		addPage(finalWizardPage);
		
//		theLastPage = new TheLastPage();
//		addPage(theLastPage);
	}
	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	public boolean performFinish() {
		
		
		//warnlist = parser.getWarnList();
		return true;
	}
	




	/**
	 * We will accept the selection in the workbench to see if
	 * we can initialize from it.
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
}