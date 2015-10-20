package raig.org;

public class HandlerInteger implements Handler {

  Handler successor;

  HandlerInteger( Handler successor) {
    this.successor = successor;
  }

  @Override
  public String handleRequest(int number) {
    String result = successor.handleRequest(number);
    if (result.length() != 0 ){
      return result;
    }
    return Integer.toString(number);
  }
}
