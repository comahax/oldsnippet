
import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 * 
 * @author liangwm
 * 
 */
public class JettyServer {
	public static void main(String[] args) throws Exception {
		start(args);
	}

	public static void usage() {
		System.err.println("\nUsage: JettyServer [-h] [-p] [-d] [-m]\n"
				+ "    -h[elp]\tPrint this usage message and exit\n"
				+ "    -p[ort]\tRequest listen port, default to 8080\n"
				+ "    -m[ap]\tMap virule directory path\n"
				+ "    -d[irectory]\tWeb application path\n"
				+ "\n\tExample command lines:\n"
				+ "    java JettyServer -p 8088 -d ./web -m /oam\n"
		);
	}
	
	/**
	 * @param args
	 * @throws Exception
	 */
	private static void start(String[] args) throws Exception{
		//default port
		int port = 9083;//2011
		
		//default is classes path   e.g D:/workspace/wscxf/WEB-INF/classes/../../
		String webpath = getAppWebRoot() + "../../";
		
		//default service map rootpath url 
		String mappath = "/";
		int argInd = 0;

		//argument parsing
		// Iterate over all of the arguments
		for (argInd = 0; argInd < args.length; argInd++) {

			System.out.println("1");
			// Break out if argument does not start with '-'
			if (args[argInd].charAt(0) != '-') {//argument must start with "-"
				break;
			}

			if (args[argInd].equalsIgnoreCase("-h")//help
					|| args[argInd].equalsIgnoreCase("-help")) {
				usage();
				System.exit(0);

			} else if (args[argInd].equalsIgnoreCase("-p")//set server port
					|| args[argInd].equalsIgnoreCase("-port")) {
				argInd++;
				if (argInd >= args.length) {
					System.err.println("Error: -port option requires an argument.");
					usage();
					System.exit(1);
				}
				port = new Integer(args[argInd]);

			} else if (args[argInd].equalsIgnoreCase("-d")//set web path
					|| args[argInd].equalsIgnoreCase("-directory")) {

				argInd++;
				if (argInd >= args.length) {
					System.err.println("Error: -directory option requires an argument.");
					usage();
					System.exit(1);
				}
				webpath = args[argInd];
			} else if (args[argInd].equalsIgnoreCase("-m")//set service url path
					|| args[argInd].equalsIgnoreCase("-map")) {

				argInd++;
				if (argInd >= args.length) {
					System.err.println("Error: -map option requires an argument.");
					usage();
					System.exit(1);
				}
				mappath = args[argInd];

			} else {//unknow argument
				System.err.println("Error: unknown argument " + args[argInd]);
				usage();
				System.exit(1);
			}
		}

		// If there are any left over arguments, it is an error at this point.
		// may be cause by argument not start with "-"
		if (argInd < args.length) {
			System.err.println("Error: too many arguments. Parsing stopped at "
					+ args[argInd]);
			usage();
			System.exit(1);
		}
		
		System.out.println("2");
        Server server = new Server(port);
        //server.setHandler(new DefaultHandler());
        server.setHandler(new WebAppContext(webpath, mappath));
		server.setStopAtShutdown(true);
		server.setSendServerVersion(true);
		server.start();
        server.join();
        System.out.println("3");

	}
	
	public static String getAppWebRoot(){
		//get class path.  e.g file:/D:/workspace/hsc_main/web/WEB-INF/classes/
		String s = Thread.currentThread().getContextClassLoader().getResource("").toString();
		
		if(s.startsWith("file://")){
			return s.substring(6);
		}else if(s.startsWith("file:/")){
			return s.substring(6);
		}else{
			return s;
		}
	}
}
