package com.stubhub.codegen.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;

import com.stubhub.codegen.dialog.selectFolderDialog;

import com.stubhub.codegen.dialog.selectFolderDialog;
import com.stubhub.codegen.wizards.*;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class CodeGenHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public CodeGenHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		MainWizard wizard = new MainWizard();
		wizard.init(window.getWorkbench(), selection instanceof IStructuredSelection ?(IStructuredSelection) selection:StructuredSelection.EMPTY );
		
		WizardDialog dialog = new WizardDialog(window.getShell(),wizard);
		dialog.open();
		return null;
	}
}
