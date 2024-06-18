import org.example.RegularExpressions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegularExpressionsTest {

    @Test(dataProvider = "task1dp")
    public void testTask1(String s, boolean expectedResult) {
        Assert.assertEquals(RegularExpressions.task1(s),expectedResult);
    }

    @DataProvider(name = "task1dp")
    public Object[][] dataProviderTask1() {
        return new Object[][] {
                {"automation_20240325_a1b2c3@solvd.com",true},
                {"automation_test_email@solvd.com",false},
                {"automation_20240325_a1b2c3@solvd.comm",false},
                {"automation_2024032e_a1b2c3@solvd.com",false}
        };
    }
}
