package raig.org;

import org.apache.log4j.Logger;
import raig.org.states.HasQuarterState;
import raig.org.states.NoQuarterState;
import raig.org.states.SoldOutState;
import raig.org.states.SoldState;
import raig.org.states.State;


import java.util.Observable;
import java.util.Observer;


public class GumballStateMachine implements Observer {

  private static Logger logger = Logger.getLogger(GumballStateMachine.class);

  private OutController outController;
  private InController inController;
  private State noQuarterState;
  private State hasQuarterState;

  private   State state = noQuarterState;

  public State getSoldState() {
    return soldState;
  }

  public State getSoldOutSate() {
    return soldOutSate;
  }

  State soldState;
  State soldOutSate;

  public State getState() {
    return state;
  }





  public State getNoQuarterState() {
    return noQuarterState;
  }

  public State getHasQuarterState() {
    return hasQuarterState;
  }

  public GumballStateMachine(OutController outController,InController inController) {

    this.inController = inController;
    this.outController = outController;
    this.inController.addObserver(this);

    noQuarterState = new NoQuarterState(this);
    hasQuarterState = new HasQuarterState(this);
    soldOutSate = new SoldOutState(this);
    soldState = new SoldState(this);

    state = noQuarterState;

  }

  @Override
  public void update(Observable observable, Object arg) {

    int event = (int)arg;
    switch (event) {
      case InController.EVENT_QUARTER_INSERTED:
        state.quarterInserted();
        outController.turnsOffLightOutOfGumballs();
        break;
      case InController.EVENT_TURNS_CRANK:
        state.turnsCrank();
        outController.dispenseGumball();
        break;
      case InController.EVENT_GUMBALLS_FINISHED:
        state.gumballsFinished();
        outController.turnsOnLightOutOfGumballs();
        break;
      case InController.EVENT_GUMBALLS_NOT_FINISHED:
        state.gumballsNotFinished();
        break;
      default:
        logger.error("Unexpected state" + state.statetoString());
        setState(noQuarterState);
    }

  }


  public void setState(State stateNew) {
    state = stateNew;
  }

  public String stateToString() {
    return state.statetoString();
  }
}
