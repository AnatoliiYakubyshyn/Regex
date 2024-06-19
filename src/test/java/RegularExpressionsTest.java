import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.example.RegularExpressions;

import java.util.List;

public class RegularExpressionsTest {

    @Test(dataProvider = "task1dp")
    public void testTask1(String s, boolean expectedResult) {
        Assert.assertEquals(RegularExpressions.task1(s), expectedResult);
    }

    @DataProvider(name = "task1dp")
    public Object[][] dataProviderTask1() {
        return new Object[][]{
                {"automation_20240325_a1b2c3@solvd.com", true},
                {"automation_test_email@solvd.com", false},
                {"automation_20240325_a1b2c3@solvd.comm", false},
                {"automation_2024032e_a1b2c3@solvd.com", false}
        };
    }

    @Test(dataProvider = "task2dp")
    public void testTask2(String s, List<String> expectedResult) {
        Assert.assertEquals(RegularExpressions.task2(s), expectedResult);
    }

    @Test
    public void testTask4() {
        Assert.assertEquals(RegularExpressions.task4("ignore me [extract:me] ignore me!"), "extract:me");
    }

    @Test(dataProvider = "dp3")
    public void testTask3(String s, String key, String expectedRes) {
        Assert.assertEquals(RegularExpressions.task3(s, key), expectedRes);
    }

    @DataProvider(name = "task2dp")
    public static Object[][] task2dp() {
        return new Object[][]{
                {"Contact us at +1 (123) 456-7890 or 1-777-123-4567",
                        List.of("11234567890", "17771234567")
                },
                {"Contact us at +1 (123) 456-7890 1-777-123-4567",
                        List.of("11234567890", "17771234567")
                }
        };
    }

    @DataProvider(name = "dp3")
    public Object[][] dataProviderTask3() {
        return new Object[][]{
                {"{\"key1\": 11, \"key2\": 'asd', \"key3\": 342}", "key3", "342"},
                {"{\"key1\": 11, \"key2\": 'asd', \"key3\": 342}", "key1", "11"},
                {"{\"key1\": 11, \"key2\": 'asd', \"key3\": 342}", "key2", "asd"},
        };
    }
}
