package raig.org;

public class Decorator implements FizzBuzzComponent {

  FizzBuzzComponent fizzBuzzComponent;

  public Decorator(FizzBuzzComponent fizzBuzzComponent){
    this.fizzBuzzComponent = fizzBuzzComponent;
  }
  @Override
  public String say(int number) {
    return fizzBuzzComponent.say(number);
  }
}
