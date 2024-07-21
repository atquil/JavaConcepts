# What is Factory Method Design Pattern ?

The singleton pattern is used to ensure that a class has only one instance, and provides a single point of access to it. This pattern is useful when we want to limit the number of objects that can be created, and ensure that there is only one instance of a class in the entire system.


<details>
  <summary>
    <span style="font-size: x-large;">Intent : What it does?</span>
  </summary>
  <p>
  The intent of the Singleton pattern is to ensure that a class has only one instance and to provide a single point of access to this instance for all other objects.
  </p>
</details>
<br>
<details>
  <summary>
    <span style="font-size: x-large;">Problem</span>
  </summary>
  <p>

1. **Single Instance of Class**: Sometimes it is necessary to have only one instance of a class in a system. This is the case when you need to ensure that there is only one instance of a shared resource, such as a **database connection, a network socket, or a logging service.**
    - Note that this behavior is impossible to implement with a regular constructor since a constructor call must always return a new object by design

2. **Global Access Point to Instance**: Global variable storing essential object are very unsafe , since any code can potentially overwrite the contents and crash the app. Thus, singleton pattern let's you access the object but protects from being overwritten by other code.

  </p>
</details>
<br>
<details>
  <summary>
    <span style="font-size: x-large;">Solution</span>
  </summary>
  <p>
All implementations of the Singleton have these two steps in common:

1. **Make the default constructor private**, to prevent other objects from using the new operator with the Singleton class.
2. **Create a static creation method that acts as a constructor**. Under the hood, this method calls the private constructor to create an object and saves it in a static field. All following calls to this method return the cached object.
  </p>
</details>
<br>
<details>
  <summary>
    <span style="font-size: x-large;">Use Case</span>
  </summary>
  <p>
The Singleton design pattern is commonly used in the following use cases:

1. **Logging Services**: To ensure that there is only one instance of a logging service that is used by multiple objects in a system.
2. **Database Connections**: To ensure that there is only one instance of a database connection that is used by multiple objects in a system.
3. **Configuration Management**: To ensure that there is only one instance of a configuration manager that is used by multiple objects in a system.
4. **Thread Pooling**: To ensure that there is only one instance of a thread pool that is used by multiple objects in a system.
5. **Cache Management**: To ensure that there is only one instance of a cache manager that is used by multiple objects in a system.
6. **Factory Method**: To ensure that there is only one instance of a factory that is used by multiple objects in a system.
7. Singleton is also useful in situations where it is necessary to limit the number of instances of a class that can be created, such as with a license manager or a security manager.

These are just a few examples of the use cases for the Singleton design pattern. The pattern can be applied in any situation where it is necessary to ensure that there is only one instance of a class in a system and to provide a single point of access to this instance for all other objects.
  </p>
</details>
<br>
<details>
  <summary>
    <span style="font-size: x-large;">How to Implement</span>
  </summary>
  <p>
1. Define a **private static instance variable** that will store the single instance of the class.

`
```java
public class Singleton {
   // private static instance variable to store the single instance of the class
   private static Singleton instance;
   ...
   }
```
2. Define a private constructor to prevent the creation of instances from outside the class.
```java
public class Singleton {
   private static Singleton instance;
   // private constructor to prevent the creation of instances from outside the class
   private Singleton() {}
   ...
}

```
3. Define a public static method that returns the single instance of the class. If the instance does not exist, the method should create it.
```java
public class Singleton {
   private static Singleton instance;
   private Singleton() {}
   // public static method to return the single instance of the class
   public static Singleton getInstance() {
      // if the instance does not exist, create it
      if (instance == null) {
         instance = new Singleton();
      }
      // return the instance
      return instance;
   }
}
```
4. Ensure that the single instance is thread-safe by using the synchronized keyword in the static method that returns the single instance.

```java
public class Singleton {
   private static Singleton instance;
   private Singleton() {}
   // synchronized method to ensure that the single instance is thread-safe
   public static synchronized Singleton getInstance() {
      if (instance == null) {
         instance = new Singleton();
      }
      return instance;
   }
}
```

  </p>
</details>
<br>
<details>
  <summary>
    <span style="font-size: x-large;">Pros and Cons</span>
  </summary>
  <p>

* Pros:
    * You can be sure that a class has only a single instance.
    * You gain a global access point to that instance.
    * The singleton object is initialized only when it’s requested for the first time
    * It reduces the overhead of creating multiple instances of a class, which can improve performance

* Cons:
    * It can make the code difficult to test, as it is tightly coupled to the singleton instance.
    * It can make the code difficult to modify, as changes to the singleton instance can have a ripple effect throughout the system.
  </p>
</details>
<br>
<details>
  <summary>
    <span style="font-size: x-large;">Relation with Other Patterns</span>
  </summary>
  <p>

- The Singleton pattern is related to the **Factory Method pattern**, as it can be used to create a single instance of a class.
- Abstract Factories, Builders and Prototypes can all be implemented as Singletons.

  </p>
</details>
<br>

