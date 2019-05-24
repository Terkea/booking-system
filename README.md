Introduction

Vikings Global Music Concerts & Festivals Booking Agency – booking system – has been designed using Model View Controller (MVC), nowadays, commonly used in Java as an architecture for creating applications.
The Data Access Object (DAO) has been implemented to dissociate its components form each other, for the operations to be performed on the objects in order to easily manipulate the data.

UML
![uml](https://raw.githubusercontent.com/Terkea/booking-system/master/images/uml.jpg "UML")

Privileges
Admin
The administrators are created within MYSQL database by the Agency administrator thus, they can login and have the full access to: manage accounts, events and bookings.
![admin](https://raw.githubusercontent.com/Terkea/booking-system/master/images/admin.png "UML")

Customer
A Customer can register, login, edit their account, view events, make booking, view booking and in addition download their receipt, as shown in the customer booking process.
![customer](https://raw.githubusercontent.com/Terkea/booking-system/master/images/customer.png "UML")

Corporate Organisation
The Corporate Organisations have the same privileges as the customers with an additional interface features of making monthly payment or pay now, and 20% discount on all tickets sales from the Vikings  booking-system. Additionally, The Make a Payment interface allows a corporative organisation to download an invoice in a format of PDF file, to action this feature the user has to check “Pay at the end of the month” and click Pay button to confirm the request , this feature issues an invoice which can be paid at the end of the month or if they wish, pay now.
![corporate](https://raw.githubusercontent.com/Terkea/booking-system/master/images/corporate.png "UML")

Event Festival Organisers
The Concert Festival Organisers registration is made by the administrator. The Organisers can add, edit and cancel events. The codes are like the one being used for the administrator/users.
![corporate](https://raw.githubusercontent.com/Terkea/booking-system/master/images/organiser.png "UML")


All passwords are encrypted using the BCrypt algorithm
The main window has a minimum resolution of 800x600 in order to preserve all the components and avoid the case when the User wants to go below that size. In order to make it responsive I used the following components: VBox, HBox, GridPane and AnchorPane alongside the AnchorPane Constraints offered by JavaFx which allowed me to set the relative position (top, bottom, left and right) to the parent pane. The only issue that I got was that I couldn’t modify the behaviour of certain components such as: Label, TextArea, TextField, ComboBox and so on. What I mean by that is that at one stage I tried to assign them a behaviour similar to responsive websites where the text size scales alongside the size of the component but I gave up on that idea.

Libraries used throughout the project:

mysql:mysql-connector-java:8.0.13

org.springframework.security:spring-security-crypto:3.2.7.RELEASE

com.jfoenix:jfoenix:8.0.8

ch.codeblock.qrinvoice.itext5:qrinvoice-itext5:1.3

com.lgou2w:ldk-fx-fontawesomefx:0.1.8-beta12-hotfix1


