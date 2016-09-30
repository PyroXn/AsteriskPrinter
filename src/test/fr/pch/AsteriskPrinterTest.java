package test.fr.pch;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.pch.AsteriskPrinter;
import fr.pch.AsteriskPrinterException;
import fr.pch.AsteriskPrinterParams;

public class AsteriskPrinterTest {

	@Test
	public void test() {
		try {
			new AsteriskPrinter(new AsteriskPrinterParams(new String[]{"TEST", "t10"}));
		} catch (AsteriskPrinterException e) {
			fail(e.getMessage());
		}
	}

}
