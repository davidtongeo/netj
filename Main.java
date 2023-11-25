import httpClass.httpClass;
import cliClass.manual;
import cliClass.parseClass;

class Main {
	public static void main(String[] a) {

		// Parsing the arguments.
		if (a.length < 1) {
			System.err.println("[ERROR] No arguments provided.");
			return;
		}
		parseClass Args = null;
		try {
			Args = new parseClass(a);
		} catch (Exception e) {
			System.err.println("[ERROR] Couldn't make the url: " + e);
		}

		// Show manual if provided.
		if (Args.getHelp()) {
			manual.PrintManual();
			return;
		}

		httpClass instance = new httpClass(Args.getUrl());
		instance.makeRequest(Args.getVerb(), Args.getHeaders(), Args.getbody(), Args.GetShowBody());
	}
}
