package appCommonClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.nitara.utils.DriverManager;
import com.nitara.utils.GlobalParams;
import com.nitara.utils.ServerManager;





public class GenericBase extends PageInitialiser{
	
	public static Properties prop;
	public GenericBase()
	{
		try 
		{
			prop=new Properties();
			FileInputStream fis=new FileInputStream("src\\main\\resources\\Config.properties");
			prop.load(fis);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	@BeforeMethod(alwaysRun=true)
	public static void initialize() throws Exception {
	
		GlobalParams params = new GlobalParams();
		params.initializeGlobalParams();

		ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_"
				+ params.getDeviceName());

		new ServerManager().startServer();
		new DriverManager().initializeDriver();
		
		PageInitialiser.initializeAllPages();
	}

	@AfterMethod(alwaysRun=true)
	public static void quit() throws InterruptedException{
		DriverManager driverManager = new DriverManager();
		if(driverManager.getDriver() != null){
			driverManager.getDriver().quit();
			driverManager.setDriver(null);
		}
		ServerManager serverManager = new ServerManager();
		if(serverManager.getServer() != null){
			serverManager.getServer().stop();
		}
	}

}
