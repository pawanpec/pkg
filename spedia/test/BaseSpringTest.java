/**
 * 
 */


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author P.GHOSHAL
 *
 */
public class BaseSpringTest  {
	
	private static BaseSpringTest testContext = null;
	 
    ApplicationContext context = null;
 
    private BaseSpringTest() {
    }
 
    public static BaseSpringTest getInstance()
    {
        if (testContext == null) {
            testContext = new BaseSpringTest();
            testContext.initialise();
        }
        return testContext;
    }
 
    public void initialise() {
    	String[] paths = { 
		"src/main/webapp/WEB-INF/spring-database.xml"
		};
    	context = new FileSystemXmlApplicationContext(paths);
    }
 
    public Object getBean(String name) {
        return context.getBean(name);
    }
 
    public ApplicationContext getSpringContext() {
        return context;
    }
    
}
