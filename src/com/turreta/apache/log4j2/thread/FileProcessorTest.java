package com.turreta.apache.log4j2.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class FileProcessorTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		List<FileProcessor> tasks = new ArrayList<FileProcessor>();
		tasks.add(new FileProcessor("CN", "2014-11-01_01-01-01-ZYX-dRruwpxCxG.dat"));
		tasks.add(new FileProcessor("CN", "2014-10-01_01-01-02-ZYX-Rh3rf3rt23.dat"));
		tasks.add(new FileProcessor("JP", "2014-10-01_01-01-02-ABC-Rh9J43hVrn.dat"));
		tasks.add(new FileProcessor("PH", "2014-10-02_01-02-01-WER-CNgNPcAjhw.dat"));
		tasks.add(new FileProcessor("MY", "2014-10-10_15-01-01-YYY-msjhuJc0YE.dat"));
		tasks.add(new FileProcessor("CN", "2014-10-01_18-11-01-ERR-1cwfPhDtji.dat"));
		
		// WARNING: This is not Thread-safe.
		for(FileProcessor t: tasks) {
			t.process();
		}
	}
}

class FileProcessor {
	
	private final static Logger log = LogManager.getLogger(FileProcessor.class);
	private String interfaceFile;
	private String countryCode;
	
	public void process() {			
			ThreadContext.put("countryCode", this.countryCode);
			ThreadContext.put("interfaceFile", this.interfaceFile);
			
		    log.debug("Parsing file " + this.interfaceFile + " from " + this.countryCode);
		    log.debug("Uploading data from " + this.interfaceFile + " from " + this.countryCode);
		    log.debug("Generating invoices from " + this.interfaceFile + " from " + this.countryCode);
		    log.debug("Processing completed **** " + this.interfaceFile + " from " + this.countryCode);
		    ThreadContext.remove("countryCode");
		    ThreadContext.remove("interfaceFile");
	}
	
	public FileProcessor(String countryCode, String interfaceDataFile) {
		this.countryCode = countryCode;
		this.interfaceFile = interfaceDataFile;
	}
}