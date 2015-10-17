package raig.org;

import org.apache.log4j.Logger;

import java.util.Observable;
import java.util.Observer;


public class GumballStateMachine implements Observer {

  private static Logger logger = Logger.getLogger(GumballStateMachine.class);

  private OutController outController;
  private InController inController;

  static final  int INITIAL_STATE = 0;

  private int state;

  public GumballStateMachine(OutController outController,InController inController) {

    this.inController = inController;
    this.outController = outController;
    this.inController.addObserver(this);
    state = INITIAL_STATE;

  }

  @Override
  public void update(Observable observable, Object arg) {

  }

  int getState() {
    return state;
  }
}
