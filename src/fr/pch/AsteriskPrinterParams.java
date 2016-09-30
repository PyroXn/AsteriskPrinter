package fr.pch;

public class AsteriskPrinterParams {

	private final String text;
	private final int size;
	
	public AsteriskPrinterParams(String[] args) throws AsteriskPrinterException {
		if (args != null && args.length == 2) {
			this.text = args[0].toUpperCase();
			try {
				this.size = Integer.valueOf(args[1]);
			} catch (NumberFormatException nfe) {
				throw new AsteriskPrinterException("Le param args[1] devrait être un int");
			}
		} else {
			throw new AsteriskPrinterException("Le nombres de paramètre est incorrect");
		}
	}

	public String getText() {
		return text;
	}

	public int getSize() {
		return size;
	}
	
}
