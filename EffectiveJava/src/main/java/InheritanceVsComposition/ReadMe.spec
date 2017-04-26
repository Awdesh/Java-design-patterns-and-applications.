Abstract Class Vs Interface
=====================
Created by awdesh on 7/25/16

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
Abstract Class
----------------

1) There can be implementation inside abstract class.
2) Abstract class can have constructors.
3) Abstract class purposes the idea of inheritance.
4) Class members can have any access level inside abstract class.
5) An abstrach class should have non-static fields.
 
Interface
----------------

1) All the methods inside an interface should be public so they can be implemented.
2) Interface must not have data members.
3) There should only be definition of the methods inside an Interface.
4) Interface may nly contain static fields which is not the case with abstract class.
5) A class can extend a single class but can implement many interfaces.

Final
------------

1) A Class that's been made final can't be inherited/subclassed.
2) Please do not creata a class final unless you have a strong reason to do that.
3) Final classes are difficult to test for mocking frameworks like mockito.

Other Notes
----------------
Don't use static members inside Abstract class since they can't be overridden by the child
class so it ruins the purpose of having a abstract class.