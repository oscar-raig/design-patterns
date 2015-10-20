package raig.org;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.Test;


import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;


@RunWith(DataProviderRunner.class)
public class FizzBuzzTest {
  private static Logger logger = Logger.getLogger(FizzBuzzTest.class);


  private Handler createFizzBuzz() {

    HandlerBang handlerBang = new HandlerBang(null);
    HandlerBuzz handlerBuzz = new HandlerBuzz(handlerBang);
    HandlerFizz handlerFizz = new HandlerFizz(handlerBuzz);

    HandlerInteger handlerInteger = new HandlerInteger(handlerFizz);



    return handlerInteger;
  }

  @Test
  @UseDataProvider("dataProviderFizzBuzz")
  public void sayTest(int number, String expectedResult) {
    logger.info("Testing " + number );
    Handler handler = createFizzBuzz();
    String result = handler.handleRequest(number);
    Assert.assertEquals(expectedResult, result);

  }

  @DataProvider
  public  static Object[][] dataProviderFizzBuzz() {
    // @formatter:off
    return new Object[][]  {
      {1,  "1"},
      {2,  "2"},
      {3,  "Fizz"},
      {3 * 2,  "Fizz"},
      {7,  "Bang"},
      {5,  "Buzz"},
      {5 * 2,  "Buzz"},
      {7 * 2,  "Bang"},
      {5 * 3,  "FizzBuzz"},
      {7* 3 * 5,  "FizzBuzzBang"},
    };
    // @formatter:on
  }

}
