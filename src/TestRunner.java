import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	
	public static void main(String args[])
	{
		Result resultApp = JUnitCore.runClasses(TestRunApplication.class);
		
		for (Failure failure : resultApp.getFailures())
		{
			System.out.println(failure.toString());
		}
		System.out.println(resultApp.wasSuccessful());
	}

}
