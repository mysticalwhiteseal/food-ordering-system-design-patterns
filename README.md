# Project Overview  
The Sapori d’Italia Food Ordering System is a point-of-sale system developed for staff of a fictitious restaurant -- Sapori d’Italia to manage orders for day-to-day operations. It allows staff to view the restaurant menu, add items to customer orders, review customer orders, submit orders to the kitchen, and save order history to the database. Designed with a user-friendly interface and robust backend functionality, the food ordering system seeks to enhance efficiency, accuracy, and customer satisfaction while ensuring a smooth ordering process.  

# References & Acknowledgements  
The implementation of this system is an adaptation of code bases sourced from the following repositories, with frontend elements preserved but backend modules reworked:  
1. Login GUI - https://github.com/codingWithElias/Login-SignUp-java-gui
2. Base Restaurant Ordering System - https://github.com/codingWithElias/Login-SignUp-java-gui

# Learning Objectives  
This was a learning project at integrating backend and frontend components in Java using Swing and SQLite. The design decisions were made around the MVC (Model-View-Controller) architecture for better code organisation, modularity, and interface isolation. Design patterns were applied, like the Singleton pattern (used in database connection), Observer pattern (used for login-event listeners), and State pattern (for order cart state management).  

The UI was adapted from existing projects, but all data logic and integration were reworked and self-implemented. The learning outcomes included: separation of concerns, state control, and software design decisions.    

# Technology Stacks  
- Java Swing.
- SQLite, connected through the JDBC API.

# How to Run  
Download the `.jar` file from the Releases tab and follow the instructions stated on the release notes.