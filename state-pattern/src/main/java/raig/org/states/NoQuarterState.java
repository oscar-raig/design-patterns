package raig.org.states;

import raig.org.GumballStateMachine;

public class NoQuarterState implements GumballState {

  GumballStateMachine gumballStateMachine;

  public NoQuarterState(GumballStateMachine gumballStateMachine) {
    this.gumballStateMachine = gumballStateMachine;
  }

  @Override
  public void quarterInserted() {
    gumballStateMachine.setState(gumballStateMachine.getHasQuarterState());

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
    return "NO_QUARTER";
  }
}
