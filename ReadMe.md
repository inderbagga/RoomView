# RoomView Kotlin Application

Here is a short diagram to introduce you to the **Architecture Components**

[https://developer.android.com/codelabs/android-room-with-a-view-kotlin/img/8e4b761713e3a76b.png]

***LiveData***: A data holder class that can be observed. Always holds/caches the latest version of data, and notifies its observers when data has changed. LiveData is lifecycle aware. UI components just observe relevant data and don't stop or resume observation. LiveData automatically manages all of this since it's aware of the relevant lifecycle status changes while observing.

***ViewModel***: Acts as a communication center between the Repository (data) and the UI. The UI no longer needs to worry about the origin of the data. ViewModel instances survive Activity/Fragment recreation.

***Repository***: A class that you create that is primarily used to manage multiple data sources.

***Entity***: Annotated class that describes a database table when working with Room.

***Room database***: Simplifies database work and serves as an access point to the underlying SQLite database (hides SQLiteOpenHelper). The Room database uses the DAO to issue queries to the SQLite database.

***SQLite database***: On device storage. The Room persistence library creates and maintains this database for you.

***DAO***: Data access object. A mapping of SQL queries to functions. When you use a DAO, you call the methods, and Room takes care of the rest.

## Application Overview

The following diagram shows how all of the pieces of the app should interact. Each of the rectangular boxes (not the SQLite database) represents a class that you will create.

[https://developer.android.com/codelabs/android-room-with-a-view-kotlin/img/a70aca8d4b737712.png]

## 1. Create an Entity

The data for this app is words, and you will need a simple table to hold those values:
[https://developer.android.com/codelabs/android-room-with-a-view-kotlin/img/3821ac1a6cb01278.png]

Room allows you to create tables via an Entity. Let's do this now.

1. Create a new Kotlin class file called Word containing the Word data class. This class will describe the Entity (which represents the SQLite table) for your words. Each property in the class represents a column in the table. Room will ultimately use these properties to both create the table and instantiate objects from rows in the database.

Here is the code:

```kotlin
data class Word(val word: String)
```

To make the Word class meaningful to a Room database, you need to create an association between the class and the database using Kotlin annotations. You will use specific annotations to identify how each part of this class relates to an entry in the database. Room uses this extra information to generate code.

If you type the annotations yourself (instead of pasting), Android Studio will auto-import the annotation classes.

2. Update your Word class with annotations as shown in this code:

```kotlin
@Entity(tableName = "words_table")
class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)
```

Let's see what these annotations do:

***@Entity(tableName = "word_table")*** Each @Entity class represents a SQLite table. Annotate your class declaration to indicate that it's an entity. You can specify the name of the table if you want it to be different from the name of the class. This names the table "word_table".

***@PrimaryKey*** Every entity needs a primary key. To keep things simple, each word acts as its own primary key.

***@ColumnInfo(name = "word")*** Specifies the name of the column in the table if you want it to be different from the name of the member variable. This names the column "word".

Every property that's stored in the database needs to have public visibility, which is the Kotlin default.

## 2. Create the DAO

**What is the DAO?**
In the DAO (data access object), you specify SQL queries and associate them with method calls. The compiler checks the SQL and generates queries from convenience annotations for common queries, such as @Insert. Room uses the DAO to create a clean API for your code.

The DAO must be an interface or abstract class.

By default, all queries must be executed on a separate thread.

Room has Kotlin coroutines support. This allows your queries to be annotated with the suspend modifier and then called from a coroutine or from another suspension function.

## Implement the DAO

Let's write a DAO that provides queries for:

Getting all words ordered alphabetically
Inserting a word
Deleting all words