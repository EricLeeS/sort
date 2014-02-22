package com.stubhub.codegen.format;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.formatter.DefaultCodeFormatter;
import org.eclipse.jdt.internal.formatter.DefaultCodeFormatterOptions;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

public class CodeFormatUtil {
	public static String format(String fileContent) throws Exception {
		String sourceCode = fileContent;
		// get default format for java
		Map options = DefaultCodeFormatterConstants.getEclipseDefaultSettings();
		
		DefaultCodeFormatterOptions preferences = new DefaultCodeFormatterOptions(options);
		preferences.comment_line_length=200;
		preferences.page_width=200;
		Document doc = new Document(sourceCode);

		Map compilerOptions = new HashMap();
		// confirm java source base on java 1.5
		compilerOptions.put(CompilerOptions.OPTION_Compliance, CompilerOptions.VERSION_1_5);
		compilerOptions.put(CompilerOptions.OPTION_TargetPlatform, CompilerOptions.VERSION_1_5);
		compilerOptions.put(CompilerOptions.OPTION_Source, CompilerOptions.VERSION_1_5);
		DefaultCodeFormatter codeFormatter = new DefaultCodeFormatter(preferences, compilerOptions);
		
		// format
		TextEdit edits = codeFormatter.format(CodeFormatter.K_COMPILATION_UNIT, sourceCode, 0, sourceCode.length(), 0, null);
		edits.apply(doc);

		sourceCode = doc.get();
		return sourceCode;
	}
}
