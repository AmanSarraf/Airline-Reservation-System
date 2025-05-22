
# ✈️ Airline Reservation System

A Java desktop application that streamlines airline ticket bookings, cancellations, and administrative tasks with a user-friendly GUI and secure database integration.
## Features

- Real-Time Booking: Search flights, check seat availability, and book tickets instantly.
- Role-Based Access: Secure login for admins and customers with tailored functionalities.
- Admin Dashboard: Manage flights, monitor bookings, and oversee user accounts efficiently.
## Tech Stack

**Client:** Java Swing
**Server:** Java, Maven, MySQL with JDBC
## Installation

### 1. Clone the Repository
```bash
  git clone https://github.com/AmanSarraf/Airline-Reservation-System.git
  cd Airline-Reservation-System
```
### 2. Configure the Database

- Ensure MySQL is installed and running.
- Create a database named airline_reservation.
- Import the provided SQL schema to set up necessary tables.
- Update database credentials in the application's configuration file.

### 3. Build and Run the Application
- Use Maven to build the project
```bash
  mvn clean install
```
```bash
  java -jar target/AirlineReservationSystem.jar
```
