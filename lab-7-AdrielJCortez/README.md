# Exceptions lab

This lab explores *Exceptions* through the implementation of a program to handle exceptions when creating an object that represents a circle.

## Objectives

* To be able to develop your test own Exception class.
* To be able to add an Exception mechanism to an existing class.
* To explore the differences between checked and unchecked Exceptions.
* To be able to write code that uses a try-catch-finally block.

## Overview

You will be given code implementing a `Circle` class and will add functionality to create and throw your own exceptions given "bad" data in the `Circle` constructor.
You will then write a `CircleTest` class to practice using a `try-catch` block.

Github classroom link: **LINK IN CANVAS**

## Exploration

First we'll write some code to explore creating and using `Exception` classes.
Follow the steps below.
You do not need to formally answer the questions, but make sure you know what the answers are!

Use the `Circle.java` code as a basis for the lab. Do not make any changes to this file other than the ones described below in Steps 4 and 5.

### Complete the rest of these steps in order.

1. Create a new called `CircleException` that extends `Exception`.
  - Create one constructor that accepts a `String` message and passes that on to the parent constructor.

2. Write a class called `ZeroRadiusException` that extends `CircleException`.
  - Create a default constructor that calls the parent constructor with the message `"zero radius"`. A "default constuctor" is one that takes zero parameters.

3. Write a class called `NegativeRadiusException` that extends `CircleException`.
  - Create a `private double` instance variable to store the radius.
  - Create a single constructor that accepts a `radius` as a `double`. - Call the parent constructor with the message `"negative radius"`.
  - Update the instance variable with the value passed to the constructor.
  - Create a `public` method `radius()` that returns the radius.

4. Modify the Circle class such that it examines the `radius` given in the non-default constructor (i.e., the constructor that takes a parameter). Throw a `ZeroRadiusException` if the given radius is 0. **Observe that this gives you a compiler error.**
  - Fix your error by having `CircleException` extend `RuntimeException` instead of `Exception`. Why did this fix the error? What else could you have done to fix the error?

5. Modify the `Circle` class such that it throws a `NegativeRadiusException` if a negative radius is given to the constructor.

6. Create a `CircleTest` class using the code shown below. Compile and run the code.
The `Circle` should only get printed if the `Circle` constructor is successful. Why?
  - Change the value given to your `Circle` constructor such that you try it with a valid radius, a zero radius, and a negative radius. When does the Circle get printed? When does the `"In finally"` get printed? When does the `"Done"` get printed?

```java
public class CircleTest 
{
   public static void main(String[] args)
   {
      try
      {
         Circle c1 = new Circle(0);
         System.out.println(c1);
      } catch (CircleException e) {
         System.out.println(e.getMessage());
      } finally {
         System.out.println("In finally.");
      }
      System.out.println("Done.");
   }
}
```

Then change your catch block so you specifically catch `NegativeRadiusExceptions` and `ZeroRadiusExceptions`.
In the `NegativeRadiusException` handling code, additionally print out the radius.

```java
System.out.println(e.getMessage() + ": " + e.radius());
```

Experiment again with constructing various valid and invalid `Circle`s.

## Submission

Demonstrate your lab during class and submit to GitHub classroom.
