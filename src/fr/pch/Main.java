package fr.pch;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	private static Logger LOG = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		try {
			new AsteriskPrinter(new AsteriskPrinterParams(args));
		} catch (AsteriskPrinterException e) {
			LOG.log(Level.WARNING, e.getMessage());
		}
	}

}
