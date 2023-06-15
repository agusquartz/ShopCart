<h1 align="center"> ShopCart </h1>
<p align="center">
   <img src="https://img.shields.io/badge/STATUS-%20FINISHED-blue">
   <img src="https://img.shields.io/badge/Maintained%3F-NO-red.svg">
   <img src="https://img.shields.io/badge/OS-%20Linux-green">
   <img src="https://img.shields.io/badge/OS-%20Windows-green">
   <img src="https://img.shields.io/badge/OS-%20MacOS-green">
   </p>
   
# DVD Shopping Cart Program
This is a Java program that simulates a shopping cart for DVDs. It allows to add DVDs to the cart, view the cart contents, remove DVDs from the cart, add and create clients, and calculate the total cost of the DVDs in the cart.

# Features
- `Add DVDs` New DVDs can be added by specifying their info in the Shop section.
- `View Cart` Users can view the current contents of their shopping cart.
- `Calculate Total` The program automatically calculates the total earned from all the DVDs in the summary based on their prices.
- `Add Clients` New clients can be created and added to the system.
- `Edit Clients` Clients information are easily editable except by the id number.
- `Return DVDs` The program count with a easy system to return DVDs.
- `DataBase` All the data from clients, DVDs and the summary can easily be stored and transported anywhere into .json format.

# Usage
- Execute Graddle Scripts as priming build.
- Compile the project if necessary.
- Run the App.java class to start the program.

# Program Rental Policy
- A client that've rented a DVD can have it as long as it want.
- Each client can rent just one DVD at time, it must return the last rented before can rent again.
- Each Movie has it's own rent cost.

# Requirements
- JDK 17
- [JSON-Simple v1.1.1.](https://code.google.com/archive/p/json-simple/)
- [flexmark-all v0.64.8](https://central.sonatype.com/artifact/com.vladsch.flexmark/flexmark-all/0.64.8/overview)
