package com.babu.practice.udemy.design_patterns.structural.proxy;

class Person
{
  private int age;

  public Person(int age)
  {
    this.age = age;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public String drink() { return "drinking"; }
  public String drive() { return "driving"; }
  public String drinkAndDrive() { return "driving while drunk"; }
}

class ResponsiblePerson
{
  private Person person;

  public ResponsiblePerson(Person person)
  {
    this.person = person; 
  }
  
  public int getAge()
  {
    return person.getAge();
  }

  public void setAge(int age)
  {
    person.setAge(age);
  }
  
  public String drink() { 
	  if(person.getAge() < 18) {
		  return "too young";
	  } else {
		  return person.drink();
	  }
  }
  
  public String drive() { 
	  if(person.getAge() < 16) {
		  return "too young";
	  } else {
		  return person.drive();
	  }
  }
  
  public String drinkAndDrive() { 
	  return "dead";
  }
}

public class Demo {
	public static void main(String [] args) {
		ResponsiblePerson resp = new ResponsiblePerson(new Person(18));
		System.out.println(resp.drink());
		System.out.println(resp.drive());
		System.out.println(resp.drinkAndDrive());
	}
}
