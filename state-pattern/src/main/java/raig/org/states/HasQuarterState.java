package raig.org.states;

import raig.org.GumballStateMachine;

public class HasQuarterState implements GumballState {

  GumballStateMachine gumballStateMachine;

  public HasQuarterState(GumballStateMachine gumballStateMachine) {
    this.gumballStateMachine = gumballStateMachine;
  }

  @Override
  public void quarterInserted() {

  }

  @Override
  public void turnsCrank() {

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
}
