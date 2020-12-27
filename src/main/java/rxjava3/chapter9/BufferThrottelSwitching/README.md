For those cases when the Observable emit faster than the Observer can consume
We can handle such events using Flowable (Flowable are just Observables with the concept called Backpressure)
But, not all cases can be handled by Flowable such as user inputs. In this case we can batch the emission or time the emission so that there's no pressure to Observer.

Types of operators:
buffer()
    - gather emissions in specified scope
    - emit each batch or group as a collection type
window()
    - similar to buffer()
    - buffer into other observables rather than collections
    - yields Observable of Observables
    - emits emissions as soon as they are available
throttle
    - throttleFirst(1000, TimeUnit.MILLISECONDS)
        - get the first element on each 1000ms
    - throttleLast(1000, TimeUnit.MILLISECONDS)
        - can be aliased as sample(1000, TimeUnit.MILLISECONDS)
        - get last element after each 1000ms
    - throttleWithTimeout(1000, TimeUnit.MILLISECONDS)
        - can be aliased as debounce(1000, TimeUnit.MILLISECONDS)
        - emit if source is not emitting after a timeout
        - if source emits within the timeout period, the timer resets, and it waits for the source to be silence
switchMap()
    - similar to flatMap()
    - it only subscribes to the last emitted observable, and dispose the previous ones
    - useful when we get too many request
