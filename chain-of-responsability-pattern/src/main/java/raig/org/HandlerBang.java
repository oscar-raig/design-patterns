package raig.org;

public class HandlerBang implements Handler {
  Handler successor;

  HandlerBang(Handler successor) {
    this.successor = successor;
  }


  @Override
  public String handleRequest(int number) {
    String resultSuccessor = "";
    if ( successor != null ) {
      resultSuccessor = successor.handleRequest(number);
    }
    String resultBang = "";

    if ( number % 7 == 0) {
      resultBang =  "Bang";
    }
    return resultBang + resultSuccessor;
  }
}
