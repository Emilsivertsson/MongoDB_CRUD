# MongoDB_CRUD
School weekly challenge to practice using a MongoDBserver.<br>
The program has a very simple menu that allows the user to create, read, update, and delete documents from a MongoDB database.

### To use this program you will need to install the following libraries:
+ [slf4j-api-2.0.7.jar](https://mvnrepository.com/artifact/org.slf4j/slf4j-api/2.0.7)
+ [mongodb-jdbc-2.0.2-all.jar](https://jar-download.com/?search_box=mongodb-jdbc)


### Program functionality:
The program prints a meny for the user, and asks for input. 
The user can choose to create, read, update, or delete documents from the database.
The user can also choose to exit the program.
The program creates new instances of the different classes in the program, and uses them to 
send commands to the database class where they are converted to Document objects and sent to the database.


### Explaination for used MongoDB commands:
+ collection.insertOne() - Inserts a single document into a collection.

+ collection.find() - Returns all documents in a collection.

+ collection.replaceOne() - takes a filter object and replaces the matching document with a replacement object.

+ collection.findOneAndDelete() - takes a filter object and deletes its matching document.

+ getCollection('collectionName') - Gets a collection from the database.


