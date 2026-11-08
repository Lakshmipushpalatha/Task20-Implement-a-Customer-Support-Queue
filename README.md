# Task20-Implement-a-Customer-Support-Queue
java calculation

## Project Description

The Customer Support Queue Management System is a Java-based application that manages customer support tickets.

Customers can create tickets by entering their name and describing their issues. The tickets are stored in a queue and processed in First-In-First-Out (FIFO) order.

This means the ticket created first will be processed first.

## Objective

The main objective of this project is to understand the Queue data structure and FIFO processing in Java.

## Technologies Used

- Java
- Queue Interface
- ArrayDeque
- LinkedHashMap
- Scanner Class
- Switch Statement

## Features

1. **Ticket Creation:** Customers can create support tickets by entering their name and issue.
2. **Queue Management:** All waiting tickets are stored in a queue.
3. **Next Ticket Processing:** Processes the oldest waiting ticket first.
4. **Ticket Status Tracking:** Users can check the status of a ticket using its ID.
5. **Ticket Resolution:** Support tickets can be marked as resolved.
6. **Display Waiting Queue:** Displays all tickets waiting for processing.
7. **Display All Tickets:** Displays all created tickets and their current statuses.

## How the Program Works

### 1. Ticket Class

The `Ticket` class stores the details of each customer support ticket.

It contains:
- Ticket ID
- Customer Name
- Issue
- Ticket Status

Each ticket is initially assigned the status `Waiting`.

### 2. Queue Interface

The Queue interface stores tickets in FIFO order.

```java
static Queue<Ticket> ticketQueue = new ArrayDeque<>();
```

It ensures that the first ticket added is the first ticket processed.

### 3. Creating a Ticket

The `createTicket()` method collects the customer's name and issue.

A unique ticket ID is generated, and the ticket is added to the queue using:

```java
ticketQueue.offer(ticket);
```

### 4. Processing the Next Ticket

The `processNextTicket()` method retrieves and removes the first ticket from the queue using:

```java
Ticket ticket = ticketQueue.poll();
```

The ticket status is changed to `In Progress`.

### 5. Resolving a Ticket

The `resolveTicket()` method allows the user to resolve a ticket by entering its ID.

The ticket status changes from `In Progress` to `Resolved`.

### 6. Tracking Ticket Status

The `trackTicket()` method searches for a ticket using its ID and displays its current status.

### 7. Displaying All Tickets

The `displayAllTickets()` method displays every ticket created in the system, including its current status.

## Menu Options

The program provides the following menu:

1. Create Ticket
2. Display Waiting Queue
3. Process Next Ticket
4. Resolve Ticket
5. Track Ticket Status
6. Display All Tickets
7. Exit

## Sample Output

```text
===== CUSTOMER SUPPORT SYSTEM =====

1. Create Ticket
2. Display Waiting Queue
3. Process Next Ticket
4. Resolve Ticket
5. Track Ticket Status
6. Display All Tickets
7. Exit

Enter your choice: 1

Enter Customer Name: Rahul
Enter Issue: Login problem

Ticket created successfully!
Your Ticket ID is: 1

Enter your choice: 3

Processing Next Ticket:

Ticket ID: 1
Customer Name: Rahul
Issue: Login problem
Status: In Progress
```

## Important Java Concepts Learned

- Queue Interface
- FIFO (First-In-First-Out)
- ArrayDeque
- LinkedHashMap
- Classes and Objects
- Constructors
- Methods
- Scanner for User Input
- Conditional Statements
- Switch Statement
- Exception Handling

## Advantages of ArrayDeque

- Efficient insertion and deletion.
- Supports queue operations.
- Generally preferred over LinkedList for queue operations.
- Provides methods such as `offer()` and `poll()`.

## Conclusion

Through this project, I learned how to implement a customer support ticket management system using the Queue interface in Java.

I understood how FIFO processing works and how to create, manage, process, resolve, and track customer support tickets.

This project improved my understanding of Java Collections Framework and Queue data structures.
