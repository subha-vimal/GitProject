package org.helper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Jvm {

	public static void generatedJvmReport(String jsonPath) {

		File f = new File("target/Reports/JvmReport");
		Configuration configuration = new Configuration(f, "Facebook");
		configuration.addClassifications("Windows", "10");
		configuration.addClassifications("jdk", "11");
		configuration.addClassifications("tool", "Ecllipse");
		configuration.addClassifications("application", "facebook");

		List<String> l = new ArrayList<String>();
		l.add(jsonPath);

		ReportBuilder builder = new ReportBuilder(l, configuration);
		builder.generateReports();

	}

}
