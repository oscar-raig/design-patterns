package raig.org.states;

import raig.org.GumballStateMachine;

public class SoldOutState implements State {


  GumballStateMachine gumballStateMachine;

  public SoldOutState(GumballStateMachine gumballStateMachine) {
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
    return "OUT_OF_GUMBALLS";
  }

  @Override
  public void gumballsNotFinished() {

  }
}
