Assignment 2 - Physical & Logical Data Structures 
Student: Ilyas Amangeldiyev
Group: IT-2504

All my codes was wrote in Main.java used principles of OOP.

Task 1: Bank Account Storage In this task, I created a BankAccount class to represent a user with fields for account number, name, and balance. I used a LinkedList to store these objects. This choice is based on the fact that a LinkedList is a logical data structure that allows for dynamic memory allocation, making it easy to add new accounts. I also implemented a search function to find users in the list and a display function to print all active accounts.

Task 2: Deposit and Withdraw Operations I implemented financial logic to modify the data within the LinkedList. The program allows the user to select an account and perform a deposit or withdrawal. The system updates the balance field of the specific BankAccount object directly in memory. This demonstrates how data in a logical structure can be updated dynamically during program execution.

Task 3: Transaction History For this task, I used a Stack to track every transaction. This follows the LIFO (Last-In-First-Out) principle, which is ideal for an undo feature. Each transaction is pushed onto the stack as a string record. I implemented the pop method to remove the most recent transaction from the history and the peek method to allow the user to see the last action without deleting it.

Task 4: Bill Payment Queue I used a Queue to simulate a bill payment system. This follows the FIFO (First-In-First-Out) principle, meaning that bills are processed in the exact order they were added. Users can add bills to the queue, and the system processes them one by one, ensuring a fair and organized payment sequence.

Task 5: Account Opening Queue I implemented another Queue to handle requests for opening new accounts. When a user submits their details, the request is placed in this queue. An administrator can then process these requests. Once processed, the account is moved from the queue into the main LinkedList of active accounts. This shows how multiple logical structures can interact with each other.

Task 6: Physical Data Structure (Array) To demonstrate a physical data structure, I created a standard Java array of BankAccount objects with a fixed size of 3. I initialized the array with predefined data. This task highlights the difference between an array, which has a static size and contiguous memory allocation, and a LinkedList, which is more flexible for growing data sets.

Brief summary of work process The work process involved setting up the basic class structure and then implementing each logical data structure one by one. I focused on making sure that the stack and queues handle data correctly without causing errors. I faced a minor issue with the scanner skipping lines when switching between numbers and strings, but I fixed it by using the parse method. The final step was creating a menu that integrates all these functions into a single banking application.
