package raig.org;

import org.apache.log4j.Logger;

import java.util.Observable;

public class InController extends Observable {
  private static Logger logger = Logger.getLogger(InController.class);
  public static final int EVENT_QUARTER_INSERTED = 0;
  public static final int EVENT_TURNS_CRANK = 1;
  public static final int EVENT_GUMBALLS_FINISHED = 2;
  public static final int EVENT_GUMBALLS_NOT_FINISHED = 3;

  public void quarterInsered() {
    logger.info("quarter Inserted");
    setChanged();
    notifyObservers(EVENT_QUARTER_INSERTED);
  }

  public void turnsCrank() {
    logger.info("Crank had been trunked");
    setChanged();
    notifyObservers(EVENT_TURNS_CRANK);
  }

  public void gumballsFinished() {
    logger.info("The Gumball has finished");
    setChanged();
    notifyObservers(EVENT_GUMBALLS_FINISHED);
  }

  public void gumballsNotFinished() {
    logger.info("The Gumball NOT finished");
    setChanged();
    notifyObservers(EVENT_GUMBALLS_NOT_FINISHED);
  }

}
