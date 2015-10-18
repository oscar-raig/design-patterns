package raig.org;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;




public class GumballStateMachineTest {

  @Test
  public void first_State_Should_be_Initial() {

    InController inController = new InController();
    OutController outController = new OutController();

    GumballStateMachine gumballStateMachine = new GumballStateMachine(outController,inController);
    Assert.assertEquals(gumballStateMachine.getState().statetoString(), "NO_QUARTER");


  }

  @Test
  public void when_a_coin_is_Inserted_State_should_be_Quarted_Inserted() {
    InController inController = new InController();
    OutController outController = new OutController();

    GumballStateMachine gumballStateMachine =
        new GumballStateMachine(outController,inController);
    inController.quarterInsered();

    Assert.assertEquals(gumballStateMachine.getState().statetoString(), "QUARTER_INSERTED");
  }

  @Test
  public void when_crank_is_truned_state_should_be_Gumball_sold() {
    InController inController = new InController();
    OutController outController = new OutController();

    GumballStateMachine gumballStateMachine =
        new GumballStateMachine(outController,inController);
    inController.quarterInsered();
    inController.turnsCrank();

    Assert.assertEquals(gumballStateMachine.getState().statetoString(),"GUMBALL_SOLD");
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

    Assert.assertEquals(gumballStateMachine.getState().statetoString(), "NO_QUARTER");

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

    Assert.assertEquals(gumballStateMachine.getState().statetoString(),"OUT_OF_GUMBALLS");

  }



  @Test
  public void when_crank_is_truned_should_call_dispense() {
    InController inController = new InController();
    OutController outController = Mockito.mock(OutController.class);

    GumballStateMachine gumballStateMachine =
          new GumballStateMachine(outController,inController);
    inController.quarterInsered();
    inController.turnsCrank();

    verify(outController,times(1)).dispenseGumball();
  }

  @Test
  public void when_sold_state_and_no_gumballs_should_call_turn_on_light_out_of_order() {
    InController inController = new InController();
    OutController outController = Mockito.mock(OutController.class);

    GumballStateMachine gumballStateMachine =
        new GumballStateMachine(outController,inController);
    inController.quarterInsered();
    inController.turnsCrank();
    inController.gumballsFinished();

    verify(outController,times(1)).turnsOnLightOutOfGumballs();
  }

}
