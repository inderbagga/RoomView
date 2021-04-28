#RoomVIew Application

Here is a short diagram to introduce you to the **Architecture Components**

[https://developer.android.com/codelabs/android-room-with-a-view-kotlin/img/8e4b761713e3a76b.png]

***LiveData***: A data holder class that can be observed. Always holds/caches the latest version of data, and notifies its observers when data has changed. LiveData is lifecycle aware. UI components just observe relevant data and don't stop or resume observation. LiveData automatically manages all of this since it's aware of the relevant lifecycle status changes while observing.

***ViewModel***: Acts as a communication center between the Repository (data) and the UI. The UI no longer needs to worry about the origin of the data. ViewModel instances survive Activity/Fragment recreation.

***Repository***: A class that you create that is primarily used to manage multiple data sources.

***Entity***: Annotated class that describes a database table when working with Room.

***Room database***: Simplifies database work and serves as an access point to the underlying SQLite database (hides SQLiteOpenHelper). The Room database uses the DAO to issue queries to the SQLite database.

***SQLite database***: On device storage. The Room persistence library creates and maintains this database for you.

***DAO***: Data access object. A mapping of SQL queries to functions. When you use a DAO, you call the methods, and Room takes care of the rest.

##Application Overview

The following diagram shows how all of the pieces of the app should interact. Each of the rectangular boxes (not the SQLite database) represents a class that you will create.

[https://developer.android.com/codelabs/android-room-with-a-view-kotlin/img/a70aca8d4b737712.png]

