package raig.org;

import org.apache.log4j.Logger;

public class OutController {

  private static Logger logger = Logger.getLogger(OutController.class);

  public void turnsOnLightOutOfGumballs() {
    logger.info("Turning ON out of gumballs");
  }

  public void turnsOffLightOutOfGumballs() {
    logger.info("Turning OFF out of gumballs");
  }

  public void dispenseGumball() {

    logger.info("dispenseGumball");

  }
}
