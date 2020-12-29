# Reactive Programming

## What is it?
Another programming paradigm just like Procedural, Object-Oriented, Functional

The https://www.reactivemanifesto.org/ says:

For modern systems, it should be:

1. Responsive
    - The system responds in a timely manner if at all possible.
    
2. Resilient
    - The system stays responsive in the face of failure.

3. Elastic
    - The system stays responsive under varying workload.

4. Message Driven
    - Loose coupling between systems
    - Components of system should communicate with each other asynchronously
    - Non-Blocking vs Blocking (Line vs PhoneCall)

**Reactive programming != Reactive system**
Reactive systems, as defined in the reactive manifesto, are an architectural style to build responsive distributed systems.

## ReactiveX

http://reactivex.io/

> ReactiveX is a combination of the best ideas from
the Observer pattern, the Iterator pattern, and functional programming


Support for many programming language: http://reactivex.io/languages.html

### Observer Pattern

REF: https://refactoring.guru/design-patterns/observer

![Observer pattern](https://upload.wikimedia.org/wikipedia/commons/a/a8/Observer_w_update.svg)

## RxJava

https://github.com/ReactiveX/RxJava

>  Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM.