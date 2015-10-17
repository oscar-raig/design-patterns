package raig.org;

import org.junit.Assert;
import org.junit.Test;

public class GumballStateMachineTest {

  @Test
  public void first_State_Should_be_Initial() {

    InController inController = new InController();
    OutController outController = new OutController();

    GumballStateMachine gumballStateMachine = new GumballStateMachine(outController,inController);
    Assert.assertEquals(gumballStateMachine.getState(), GumballStateMachine.INITIAL_STATE);


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




}
