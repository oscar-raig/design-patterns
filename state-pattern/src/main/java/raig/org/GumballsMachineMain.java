package raig.org;

import org.apache.log4j.Logger;

public class GumballsMachineMain {

  private static Logger logger = Logger.getLogger(GumballsMachineMain.class);


  public static void main(String [] args) {


    logger.info("Hello World I am a gumball machine");
    InController inController = new InController();
    GumballStateMachine gumballStateMachine = new GumballStateMachine(new OutController(),
        inController);
    logger.info("Begining: State :" + gumballStateMachine.stateToString());
    inController.quarterInsered();
    logger.info("Quarter inserted: State :" + gumballStateMachine.stateToString());
    inController.turnsCrank();
    logger.info("Turns Crank: State :" + gumballStateMachine.stateToString());

    inController.gumballsNotFinished();
    logger.info("Turns Crank: State :" + gumballStateMachine.stateToString());

    inController.quarterInsered();
    logger.info("Quarter inserted: State :" + gumballStateMachine.stateToString());
    inController.turnsCrank();
    logger.info("Turns Crank: State :" + gumballStateMachine.stateToString());

    inController.gumballsFinished();
    logger.info("Turns Crank: State :" + gumballStateMachine.stateToString());





  }

}
