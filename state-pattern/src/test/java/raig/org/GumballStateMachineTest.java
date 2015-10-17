package raig.org;

import junit.framework.Assert;
import org.junit.Test;

public class GumballStateMachineTest {

  @Test
  public void first_State_Should_be_Initial(){

    InController inController = new InController();
    OutController outController = new OutController();

    GumballStateMachine gumballStateMachine = new GumballStateMachine(outController,inController);
    Assert.assertEquals(gumballStateMachine.getState(),GumballStateMachine.INITIAL_STATE);


  }

}
