package raig.org;

import org.junit.Assert;
import org.junit.Test;

public class GumballStateMachineTest {

  @Test
  public void first_State_Should_be_Initial() {

    InController inController = new InController();
    OutController outController = new OutController();

    GumballStateMachine gumballStateMachine = new GumballStateMachine(outController,inController);
    Assert.assertEquals(gumballStateMachine.getActualState().statetoString(), "NO_QUARTER");


  }

  @Test
  public void when_a_coin_is_Inserted_State_should_be_Quarted_Inserted() {
    InController inController = new InController();
    OutController outController = new OutController();

    GumballStateMachine gumballStateMachine =
      new GumballStateMachine(outController,inController);
    inController.quarterInsered();

    Assert.assertEquals(gumballStateMachine.getState(), GumballStateMachine.QUARTER_INSERTED);
  }

  @Test
  public void when_crank_is_truned_state_should_be_Gumball_sold() {
    InController inController = new InController();
    OutController outController = new OutController();

    GumballStateMachine gumballStateMachine =
      new GumballStateMachine(outController,inController);
    inController.quarterInsered();
    inController.turnsCrank();

    Assert.assertEquals(gumballStateMachine.getState(), GumballStateMachine.GUMBALL_SOLD);
  }

  @Test
  public void when_Gamble_is_sold_and_there_are_Gumballs_state_should_be_No_Quarter() {
    InController inController = new InController();
    OutController outController = new OutController();

    GumballStateMachine gumballStateMachine =
      new GumballStateMachine(outController,inController);
    inController.quarterInsered();
    inController.turnsCrank();
    inController.gumballsNotFinished();

    Assert.assertEquals(gumballStateMachine.getState(), GumballStateMachine.NO_QUARTER);

  }

  @Test
  public void when_Gamble_is_sold_and_there_are_Gumballs_state_should_be_Out_of_Gumballs() {
    InController inController = new InController();
    OutController outController = new OutController();

    GumballStateMachine gumballStateMachine =
      new GumballStateMachine(outController,inController);
    inController.quarterInsered();
    inController.turnsCrank();
    inController.gumballsFinished();

    Assert.assertEquals(gumballStateMachine.getState(), GumballStateMachine.OUT_OF_GUMBALLS);

  }




}
