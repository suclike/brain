This page lists various utility operators for working with Observables.

* [**`materialize( )`**](http://reactivex.io/documentation/operators/materialize-dematerialize.html) — convert an Observable into a list of Notifications
* [**`dematerialize( )`**](http://reactivex.io/documentation/operators/materialize-dematerialize.html) — convert a materialized Observable back into its non-materialized form
* [**`timestamp( )`**](http://reactivex.io/documentation/operators/timestamp.html) — attach a timestamp to every item emitted by an Observable
* [**`serialize( )`**](http://reactivex.io/documentation/operators/serialize.html) — force an Observable to make serialized calls and to be well-behaved
* [**`cache( )`**](http://reactivex.io/documentation/operators/replay.html) — remember the sequence of items emitted by the Observable and emit the same sequence to future Subscribers
* [**`observeOn( )`**](http://reactivex.io/documentation/operators/observeon.html) — specify on which Scheduler a Subscriber should observe the Observable
* [**`subscribeOn( )`**](http://reactivex.io/documentation/operators/subscribeon.html) — specify which Scheduler an Observable should use when its subscription is invoked
* [**`doOnEach( )`**](http://reactivex.io/documentation/operators/do.html) — register an action to take whenever an Observable emits an item
* [**`doOnCompleted( )`**](http://reactivex.io/documentation/operators/do.html) — register an action to take when an Observable completes successfully
* [**`doOnError( )`**](http://reactivex.io/documentation/operators/do.html) — register an action to take when an Observable completes with an error
* [**`doOnTerminate( )`**](http://reactivex.io/documentation/operators/do.html) — register an action to take when an Observable completes, either successfully or with an error
* [**`doOnSubscribe( )`**](http://reactivex.io/documentation/operators/do.html) — register an action to take when an observer subscribes to an Observable
* [**`doOnUnsubscribe( )`**](http://reactivex.io/documentation/operators/do.html) — register an action to take when an observer unsubscribes from an Observable
* [**`finallyDo( )`**](http://reactivex.io/documentation/operators/do.html) — register an action to take when an Observable completes
* [**`delay( )`**](http://reactivex.io/documentation/operators/delay.html) — shift the emissions from an Observable forward in time by a specified amount
* [**`delaySubscription( )`**](http://reactivex.io/documentation/operators/delay.html) — hold an Subscriber's subscription request for a specified amount of time before passing it on to the source Observable
* [**`timeInterval( )`**](http://reactivex.io/documentation/operators/timeinterval.html) — emit the time lapsed between consecutive emissions of a source Observable
* [**`using( )`**](http://reactivex.io/documentation/operators/using.html) — create a disposable resource that has the same lifespan as an Observable
* [**`single( )`**](http://reactivex.io/documentation/operators/first.html) — if the Observable completes after emitting a single item, return that item, otherwise throw an exception
* [**`singleOrDefault( )`**](http://reactivex.io/documentation/operators/first.html) — if the Observable completes after emitting a single item, return that item, otherwise return a default item
