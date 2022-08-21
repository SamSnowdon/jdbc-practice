Lazy Loading

Lazy loading is the practice of preventing/delaying the initialization of certain resources or objects until they 
will actually be needed. This can help improve performance and save system resources. The benefits of lazy loading
are: it can reduce initial load time, it helps conserve bandwidth, and has more system resource conservation. Times
to use Lazy Loading are usually when you would be using a OntToMany or ManyToMany relationship, or when you know for
certain that you are not using certain entities.


Eager Loading

Unlike Lazy Loading, Eager Loading will initialize a resource as soon as the code is executed. It makes more sense
to use Lazy Loading when there is a need to load all the resources in the background. Usually when this happens you 
will see a loading screen to give enough time to be able to initialize all of these resources seamlessly. Good times
to use eager loading is when the relations are not too much to handle, which in turn makes Eager Loading a good tool
to reduce further queries on the server. It is also a good idea to use Eager Loading when you know for sure that you
will be using related entities with the main entity everywhere. As we are loading all the data at once, performance 
may be impacted using Eager Loading. ManyToOne and OneToOne relationships are usually associated with Eager Loading.

