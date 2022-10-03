package alpha;
import org.apache.logging.log4j.*;



public class Demo {
	private static Logger log = LogManager.getLogger(Demo.class.getName());
	public static void main(String[] args) {
		log.error("log is success");
		System.out.println("checking git");
		System.out.println("added 2nd line");
		System.out.println("added 3rd line");
	}

}
