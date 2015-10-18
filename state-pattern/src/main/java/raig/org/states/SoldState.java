package raig.org.states;


import raig.org.GumballStateMachine;

public class SoldState implements State {

  GumballStateMachine gumballStateMachine;

  public SoldState(GumballStateMachine gumballStateMachine) {
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
    gumballStateMachine.setState(gumballStateMachine.getSoldOutSate());
  }

  @Override
  public void dispense() {

  }

  @Override
  public String statetoString() {
    return "GUMBALL_SOLD";
  }

  @Override
  public void gumballsNotFinished() {
    gumballStateMachine.setState(gumballStateMachine.getNoQuarterState());
  }
}
