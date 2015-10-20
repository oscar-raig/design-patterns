package raig.org;

public class HandlerBuzz implements Handler {

  Handler successor;

  HandlerBuzz(Handler successor) {
    this.successor = successor;
  }


  @Override
  public String handleRequest(int number) {

    String resultSuccessor = "";
    if ( successor != null ) {
      resultSuccessor = successor.handleRequest(number);
    }
    if ( number % 5 == 0) {
      return "Buzz" +  resultSuccessor;
    }
    return "" + resultSuccessor;
  }
}
