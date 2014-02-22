package com.stubhub.codegen.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.layout.grouplayout.GroupLayout;
import org.eclipse.swt.widgets.List;
import org.eclipse.wb.swt.layout.grouplayout.LayoutStyle;
import org.eclipse.swt.widgets.Label;

import com.stubhub.codegen.util.constantHelper;

public class TheLastPage extends WizardPage {

	private List warnList;
	private List errorList;
	/**
	 * Create the wizard.
	 */
	public TheLastPage() {
		super("wizardPage");
		setTitle("Wizard Page title");
		setDescription("Wizard Page description");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		
		warnList = new List(container, SWT.BORDER);
		
		errorList = new List(container, SWT.BORDER);
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setText("warnList");
		
		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setText("ErrorList");
		GroupLayout gl_container = new GroupLayout(container);
		gl_container.setHorizontalGroup(
			gl_container.createParallelGroup(GroupLayout.LEADING)
				.add(gl_container.createSequentialGroup()
					.addContainerGap()
					.add(gl_container.createParallelGroup(GroupLayout.LEADING)
						.add(errorList, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
						.add(GroupLayout.TRAILING, warnList, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
						.add(lblNewLabel)
						.add(lblNewLabel_1))
					.addContainerGap())
		);
		gl_container.setVerticalGroup(
			gl_container.createParallelGroup(GroupLayout.LEADING)
				.add(GroupLayout.TRAILING, gl_container.createSequentialGroup()
					.add(lblNewLabel)
					.add(6)
					.add(warnList, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.RELATED)
					.add(lblNewLabel_1)
					.addPreferredGap(LayoutStyle.RELATED, 10, Short.MAX_VALUE)
					.add(errorList, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		container.setLayout(gl_container);
		init();
	}
	
	public void init(){
		
		for(int i=0;i<constantHelper.getWarnList().size();i++){
			warnList.add((String) constantHelper.getWarnList().get(i));
		}
		
		for (int j=0;j<constantHelper.getErList().size();j++){
			errorList.add((String) constantHelper.getErList().get(j));
		}
	}
}
