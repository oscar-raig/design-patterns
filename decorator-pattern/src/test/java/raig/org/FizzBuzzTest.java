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


  private FizzBuzzComponent createFizzBuzz() {
    FbNumber fbNumber = new FbNumber();
    FizzDecorator fizzDecorator = new FizzDecorator(fbNumber,3,"Fizz");
    FizzDecorator buzzDecorator = new FizzDecorator(fizzDecorator,5,"Buzz");
    FizzDecorator fizzbuzzDecorator = new FizzDecorator(buzzDecorator,15,"FizzBuzz");

    return fizzbuzzDecorator;
  }

  @Test
  @UseDataProvider("dataProviderFizzBuzz")
  public void sayTest(int number, String expectedResult) {
    logger.info("Testing " + number );
    FizzBuzzComponent fizzBuzz = createFizzBuzz();
    String result = fizzBuzz.say(number);
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
      {5,  "Buzz"},
      {5 * 2,  "Buzz"},
      {5 * 3,  "FizzBuzz"},
    };
    // @formatter:on
  }

}
