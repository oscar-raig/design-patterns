package raig.org;

import org.apache.log4j.Logger;


import java.util.Observable;
import java.util.Observer;


public class GumballStateMachine implements Observer {

  private static Logger logger = Logger.getLogger(GumballStateMachine.class);

  private OutController outController;
  private InController inController;

  static final  int INITIAL_STATE = 0;
  static final  int QUARTER_INSERTED = 1;
  static final int GUMBALL_SOLD = 2;
  static final int OUT_OF_GUMBALLS = 3;

  private int state;

  public GumballStateMachine(OutController outController,InController inController) {

    this.inController = inController;
    this.outController = outController;
    this.inController.addObserver(this);
    state = INITIAL_STATE;

  }

  @Override
  public void update(Observable observable, Object arg) {

    int event = (int)arg;
    switch (state) {
      case INITIAL_STATE:
        if (event == InController.EVENT_QUARTER_INSERTED) {
          state = QUARTER_INSERTED;
          outController.turnsOffLightOutOfGumballs();
        } else {
          logger.error("INITIAL_STATE error unexpected event");
        }
        break;
      case QUARTER_INSERTED:
        if ( event == InController.EVENT_TURNS_CRANK) {
          state = GUMBALL_SOLD;
          outController.dispenseGumball();
        } else {
          logger.error("QUARTER_INSERTED error unexpected event");
        }
        break;
      case GUMBALL_SOLD:
        if ( event == InController.EVENT_GUMBALLS_FINISHED) {
          state = OUT_OF_GUMBALLS;
          outController.turnsOnLightOutOfGumballs();
        } else if ( event == InController.EVENT_GUMBALLS_NOT_FINISHED) {
          state = INITIAL_STATE;
        }  else {
          logger.error("GUMBALL_SOLD error unexpected event");
        }
        break;
      default:
        logger.error("Unexpected state" + state);
        state = INITIAL_STATE;
    }

  }

  public int getState() {
    return state;
  }

  public String stateToString() {
    switch (state) {
      case INITIAL_STATE:
        return "INITIAL_STATE";
      case QUARTER_INSERTED:
        return "QUARTER_INSERTED";
      case GUMBALL_SOLD:
        return "GUMBALL_SOLD";
      case OUT_OF_GUMBALLS:
        return "OUT_OF_GUMBALLS";
      default:
        return "ERROR";
    }
  }
}
