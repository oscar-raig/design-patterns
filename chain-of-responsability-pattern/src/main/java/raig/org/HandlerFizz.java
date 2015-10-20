package raig.org;

public class HandlerFizz implements Handler {
  Handler successor;

  HandlerFizz(Handler successor) {
    this.successor = successor;
  }
  @Override
  public String handleRequest(int number) {
    String resultSuccessor = successor.handleRequest(number);
    String resultFizz = "";

    if ( number % 3 == 0) {
      resultFizz =  "Fizz";
    }
    return resultFizz + resultSuccessor;
  }
}
