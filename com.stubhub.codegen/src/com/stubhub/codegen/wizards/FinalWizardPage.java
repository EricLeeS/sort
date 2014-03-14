/**
 * 
 */
package com.stubhub.codegen.wizards;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.layout.grouplayout.GroupLayout;
import org.eclipse.wb.swt.layout.grouplayout.LayoutStyle;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

import com.stubhub.codegen.fileparser.FileParser;
import com.stubhub.codegen.util.constantHelper;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.TreeViewer;

/**
 * @author huanli2
 *
 */
public class FinalWizardPage extends WizardPage {
	private Text RequestText;
	private Text ResponseText;
	private Text warnText;
	private Text errorText;

	/**
	 * Create the wizard.
	 */
	public FinalWizardPage() {
		super("wizardPage");
		setTitle("Stubhub");
		setDescription("Response and Request table");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.BORDER);

		setControl(container);
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setText("Request");
		
		RequestText = new Text(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL);
		RequestText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				constantHelper.setRequestText(RequestText.getText().trim());
			}
		});
		
		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setText("Response");
		
		ResponseText = new Text(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL);
		ResponseText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				constantHelper.setResponseText(ResponseText.getText().trim());
			}
		});
		
		final Button btnNewButton = new Button(container, SWT.NONE);
		btnNewButton.setTouchEnabled(true);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileParser parser = new FileParser();
				List errlist;
				List warnlist;
				if(!parser.analyse2()){
					errlist = parser.getErrorList();
					MessageDialog.openWarning(getShell(), "Error", "There exist errors!");
					
				}
				else{
					constantHelper.setWarnList(parser.getWarnList());
					errlist = parser.getErrorList();
					warnlist = parser.getWarnList();
					parser.generateCode();
					try {
						constantHelper.getProject().refreshLocal(IProject.DEPTH_INFINITE, null);
						MessageDialog.openConfirm(getShell(), "Code Generation", "Generate Success");
					} catch (CoreException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setText("Gen");
		
		Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		
		Button btnNewButton_1 = new Button(container, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileParser parser = new FileParser();
				warnText.setText("no warning");
				errorText.setText("no error");
				List<String> errlist;
				List<String> warnlist;
				if(!parser.analyse2()){
					errlist = parser.getErrorList();
					if(!errlist.isEmpty()){
						String str ="";
						for(String err : errlist){
							str=str + err.trim()+"\r\n";
						}
						errorText.setText(str.toString());
					}
					
				}else{
					warnlist = parser.getWarnList();
					if(!warnlist.isEmpty()){
						String str ="";
						for(String warn : warnlist){
							str=str + warn.trim()+"\r\n";
							
						}
						warnText.setText(str.toString());
					}
					btnNewButton.setEnabled(true);
				}
				
			}
		});
		btnNewButton_1.setText("Preview");
		
		Label label_1 = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		
		warnText = new Text(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL);
		warnText.setText("no warning");
		
		errorText = new Text(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL);
		errorText.setText("no error");
		
		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setText("Warn List");
		
		Label lblNewLabel_3 = new Label(container, SWT.NONE);
		lblNewLabel_3.setText("Error List");
		GroupLayout gl_container = new GroupLayout(container);
		gl_container.setHorizontalGroup(
			gl_container.createParallelGroup(GroupLayout.TRAILING)
				.add(gl_container.createSequentialGroup()
					.add(150)
					.add(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.add(133)
					.add(btnNewButton, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(153, Short.MAX_VALUE))
				.add(gl_container.createSequentialGroup()
					.addContainerGap()
					.add(gl_container.createParallelGroup(GroupLayout.TRAILING)
						.add(gl_container.createSequentialGroup()
							.add(lblNewLabel_2)
							.add(11)
							.add(warnText, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)
							.add(0, 0, Short.MAX_VALUE))
						.add(GroupLayout.LEADING, gl_container.createSequentialGroup()
							.add(6)
							.add(lblNewLabel_3)
							.addPreferredGap(LayoutStyle.RELATED)
							.add(errorText, GroupLayout.PREFERRED_SIZE, 515, GroupLayout.PREFERRED_SIZE)))
					.add(28))
				.add(GroupLayout.LEADING, gl_container.createSequentialGroup()
					.addContainerGap()
					.add(gl_container.createParallelGroup(GroupLayout.TRAILING, false)
						.add(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.add(GroupLayout.LEADING, gl_container.createSequentialGroup()
							.add(lblNewLabel)
							.add(14)
							.add(RequestText, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE))
						.add(GroupLayout.LEADING, gl_container.createSequentialGroup()
							.add(lblNewLabel_1)
							.addPreferredGap(LayoutStyle.RELATED)
							.add(ResponseText, GroupLayout.PREFERRED_SIZE, 515, GroupLayout.PREFERRED_SIZE))
						.add(GroupLayout.LEADING, label, GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_container.setVerticalGroup(
			gl_container.createParallelGroup(GroupLayout.LEADING)
				.add(gl_container.createSequentialGroup()
					.add(10)
					.add(gl_container.createParallelGroup(GroupLayout.LEADING)
						.add(lblNewLabel)
						.add(RequestText, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.add(21)
					.add(gl_container.createParallelGroup(GroupLayout.LEADING)
						.add(lblNewLabel_1)
						.add(ResponseText, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.UNRELATED)
					.add(label, GroupLayout.PREFERRED_SIZE, 7, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.UNRELATED)
					.add(gl_container.createParallelGroup(GroupLayout.BASELINE)
						.add(btnNewButton)
						.add(btnNewButton_1))
					.add(18)
					.add(label_1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.RELATED)
					.add(gl_container.createParallelGroup(GroupLayout.BASELINE)
						.add(lblNewLabel_2)
						.add(warnText, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.UNRELATED)
					.add(gl_container.createParallelGroup(GroupLayout.BASELINE)
						.add(errorText, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.add(lblNewLabel_3))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		container.setLayout(gl_container);
	}
}
