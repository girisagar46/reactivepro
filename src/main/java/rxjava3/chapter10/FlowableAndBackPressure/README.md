### What is Backpressure?

In observer chain, if producer emits faster than the consumer can consume it is called Backpressure.

- Flowable.subscribe() is a subscriber
- Observable.subscribe() is a observer

### When to use?

- Flowable:
    - when source is emitting large amount of data
    - hot observables emitting data endlessly
    - An asynchronous source | concurrent and parallel programming
    - to handle emissions from IO operations

- Observable:
    - in case of fewer, steady, continuous emissions
    - quick, less overhead
    - synchronous and limited chain
    - user events or time events

Flowable and Observable is inter-convertible. i.e. Flowable can be converted to Observable and vice
versa.