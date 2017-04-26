public class StringBuilderDemo{

  public void build(){
    // An example of Builder pattern.
    String ss = new StringBuilder("b").append("c").append("d").toString();
    System.out.println(ss);
  }

  public static void main(String[] args) {
    StringBuilderDemo db = new StringBuilderDemo();
    db.build();
  }
}
