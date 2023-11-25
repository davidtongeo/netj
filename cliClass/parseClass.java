package cliClass;

import httpClass.httpVerbs.Verbs;

public class parseClass {
	private Verbs verb = Verbs.GET;
	private String[] headers = { "Content-Type", "application/json" };
	private String body = "";
	private String url = "";
	private boolean help;
	private Boolean showBody = false;

	public Verbs getVerb() {
		return this.verb;
	}

	public boolean getHelp() {
		return this.help;
	}

	public boolean GetShowBody() {
		return this.showBody;
	}

	public String getUrl() {
		return this.url;
	}

	public String getbody() {
		return this.body;
	}

	public String[] getHeaders() {
		return this.headers;
	}

	public parseClass(String[] args) {

		if (args[0].startsWith("-help")) {
			this.help = true;
			return;
		}
		if (!args[0].startsWith("http")) {
			System.err.println("[ERROR] Not a valid URL");
			System.out.println("");
			this.help = true;
		} else {
			this.url = args[0];
		}

		for (int i = 0; i < args.length; i++) {
			switch (args[i].trim().toLowerCase()) {
				case "-post":
					this.verb = Verbs.POST;
					break;

				case "-body":
					// kinda a edge case. just in case the end user just forgets to put a actual
					// body and straight up just puts another option [expl1]
					if (i + 1 < args.length) {
						if (!args[i + 1].startsWith("-")) {
							this.body = args[i + 1];// next argument to the option. ej: `-body "foo"` `foo` being i+1
						} else {
							this.help = true;
							System.out.println("[WARNING] No body set");
						}
					} else {
						this.help = true;
						System.out.println("[WARNING] No body set");
					}
					break;

				case "-header":
					// same thing as explained in [expl1]
					if (i + 2 < args.length) {
						if (!args[i + 1].startsWith("-") && !args[i + 2].startsWith("-")) {
							this.headers[0] = args[i + 1];
							this.headers[1] = args[i + 2];
						} else {
							this.help = true;
							System.out.println("[WARNING] No headers set");
						}
					} else {
						this.help = true;
						System.out.println("[WARNING] No headers set");
					}
					break;

				case "-html":
					this.showBody = true;
					break;

				case "-help":
					this.help = true;
					break;

			}
		}
	}

}
