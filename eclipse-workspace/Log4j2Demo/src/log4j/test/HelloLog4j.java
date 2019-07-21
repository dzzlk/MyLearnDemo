package log4j.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * 备注:Log4j最好放在src目录下，这样就能自动找到，避免人为指定它的位置让系统识别
 * @author Administrator
 *
 */
public class HelloLog4j {

	private static Logger logger = LogManager.getLogger("HelloLog4j");

	public static void main(String[] args) {
		MyApplication myApplication = new MyApplication();
       for (int i = 0; i < 1000000; i++) {
    	logger.entry();
   		logger.info("Hello, World!");
   		myApplication.doIt();
   		logger.error("Hello, World!");
   		logger.exit();
		
	    }
	}

}
