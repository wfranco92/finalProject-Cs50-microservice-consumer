#Get rich by buying and selling Crypto
####`Video Demo:` https://youtu.be/iMypnt1OQWE
####`Description:` In this project the initial idea was to build a web application
####that allowed the user to interact with cryptocurrencies, that way the person that is into this practice
####would be able to increase their ability to invest into the raising world of cryptos.
####In this project i am just sending the back end part of it that is divided en two
####microservices, the purpose of dividing this into two microservices was to practice
####the concepts of the AMQP protocol through Rabbit mq.

----

##Setup
For you to be able to run this project locally you will have to open the /src folder
the /resources folder. and in there change the credentials of your own remote AMQP service
or delete the personalized configuration, so that it runs with the default credentials,
that are localhost as host of the rabbit mq service, with the username and password of guest.

I would recommend to you that you use IntelliJ so that it by its own downloads the project
dependencies, and finally you fill by able to execute the service by running the spring application
in the /src folder and in the class, `MicroServiceReceiverPublisherApplication`.

##Project structure:
`Collections` Here we will have the same data structures tha appears on /dtos, but this ones are going to 
be set up to be a Document that will be injected into a noSql database into a collection, differenciated by
the type of action

`Config`Here you will find the configuration class where i set up everything related
with rabbit mq, the three different rabbit mq listeners, that will be listening to the 
three different queues, and after receiving a message it will execute a use case that will
convert the string that comes in the message to a Java Class, and after it it will be saved 
into its corresponding database based on the type of action.

`dto`Here is the data structure that contains all the information of the cryptocurrency and
the action associated with the user that executed the action

`Helpers` here we will have our mapper that will be the mechanism to convert between an entity and a 
data transfer object DTO, that is the one that is sent to the client when is requested.

`Repository` here is the instance as an interface of the three different collections that are going to be 
included in the mongoDb database.

`Routers` Here i expose three different entry points the will accept get request, this entry points are the ones that 
will allow the client to request the information related to a user based on its Id, and also based on the type of action,
general, buy or selling action.

`UseCases` Here you will find the 6 different use cases, that can be grouped in two major actions, 3 actions are the ones that
receives the messages from the three different queues and convert it to the three different data structures and save it into the data 
base, and the other three are the ones that requests the information from the different collections and send it to the client.

#I hope that you find this project useful somehow and here i leave the link that will take you to the other microservice


##Publisher MicroService: https://github.com/santiagoposadag/finalProject-Cs50-microservice-publisher