package raig.org.states;

import raig.org.GumballStateMachine;

public class HasQuarterState implements State {

  GumballStateMachine gumballStateMachine;

  public HasQuarterState(GumballStateMachine gumballStateMachine) {
    this.gumballStateMachine = gumballStateMachine;
  }

  @Override
  public void quarterInserted() {

  }

  @Override
  public void turnsCrank() {
    gumballStateMachine.setState(gumballStateMachine.getSoldState());
  }

  @Override
  public void gumballsFinished() {

  }

  @Override
  public void dispense() {

  }

  @Override
  public String statetoString() {
    return "QUARTER_INSERTED";
  }

  @Override
  public void gumballsNotFinished() {

  }
}
