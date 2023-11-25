package cliClass;

public class manual {
	public static void PrintManual() {
		System.out.println("[HELP OPTION]");

		System.out.println("");
		System.out.println("Usage: netj <URL> <OPTIONS>    Example: netj https://www.google.com -html");
		System.out.println("Defaults: The default request verb is GET");
		System.out.println("");

		System.out.println("[OPTIONS]");
		System.out.println("");
		System.out.println("-post: Sends a POST request.");
		System.out.println("-body <body content>: Set the body for the request.");
		System.out.println("-headers <arg1> <arg2>: Sets the headers for the request.");
		System.out.println("-help: Show this message (who would know right?)");
	}
}
