package logback.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackDemo {
	//logger的命名是大小写敏感的，logger的命名一般都是取“类名.class”，这样命名在日志输出中也可看出其来源。则对应的Logback.xml中的logger
	//name属性值为类的全路径名比如logback.test.LogbackDemo
	//此外logger的命名可以写成一个固定的字符串比如busiAop，如下所示:
	// private static final Logger kqLogger = LoggerFactory.getLogger("busiAop");则对应的Logback.xml中的logger
	//name属性值为此字符串比如busiAop
	private final static Logger logger = LoggerFactory.getLogger(LogbackDemo.class);
     public static void main(String[] args) {
    	 //Log entry to a method
    	 for(int i=0;i<10;i++){
    	 logger.error("********error**************logback 成功了");
    	 logger.warn("********warn**************logback 成功了");
    	 logger.info("********info**************logback 成功了");
    	 logger.debug("********debug**************logback 成功了");
	}
  }

}
