package net.leetcode.questions.stack;

public class Person {
  private String name;
  private int age;

  Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public int hashCode() {
    System.out.println(this.name + "....hashCode");
    return name.hashCode() + age * 37;
  }

  @Override

  public boolean equals(Object obj) {
    if (!(obj instanceof Person)) {
      return false;

    }
    Person p = (Person) obj;
    return this.name.equals(p.name) && this.age == p.age;
  }


  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
}