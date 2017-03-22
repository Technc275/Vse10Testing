import Keyboard.KeyboardTesting;
import LogIn.LogIn;
import RegistrationForm.NewUserRegistration;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by TechBook on 22.03.2017.
 */
public class TestRunner
{
    public  static  void main(String[] args){

        Result result = JUnitCore.runClasses(NewUserRegistration.class,LogIn.class, KeyboardTesting.class);

        for(Failure failure : result.getFailures()){


            System.out.println(failure.toString());

        }


        System.out.print("Suite complited");
    }
}
