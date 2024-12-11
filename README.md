# Data-Processing-and-Storage-Assignment
# *In-Memory Database with Transaction Support*

## **Overview**
This project implements an in-memory key-value database in Java that supports transaction management. It ensures atomic updates, maintaining data integrity. Key features include:
- Managing transactions (begin, commit, rollback).
- Atomic updates to key-value pairs.
- Support for querying data even outside transactions.

The project simulates real-world scenarios like banking applications, where transactional integrity is crucial.

---

## **Features**
- **`beginTransaction`**: Starts a new transaction. Only one transaction can be active at a time.
- **`put(key, value)`**: Adds or updates a key-value pair within an active transaction. Throws an error if no transaction is active.
- **`get(key)`**: Retrieves the value of a key. Shows committed values or `null` if the key doesn't exist.
- **`commit`**: Finalizes the active transaction, making changes visible.
- **`rollback`**: Reverts all changes made during the active transaction.

---

## **How to Run**

### **Requirements**
- Java Development Kit (JDK)
- Command-line tools (`javac` and `java`)

### **Steps**
1. **Clone or Download the Repository**  
   Download the project files or clone the repository to your local machine.

2. **Compile the Code**\
   Compile and run the following command in your terminal to compile the code:
    ``` bash
    javac -d build src/*.java
    ```
3. **Run the Test Program**
   Copy and run this command in your terminal to execute the program:
   ``` bash
   java -cp build InMemoryDBTest
   ```

## **Example Usage**

**Heres how the program works:**
  ``` bash
  InMemoryDB db = new InMemoryDBImpl();
  
  // Attempt to get a non-existent key
  System.out.println(db.get("A")); // Output: null
  
  // Begin a transaction
  db.begin_transaction();
  db.put("A", 5);
  
  // Get value of "A" within a transaction (not committed yet)
  System.out.println(db.get("A")); // Output: null
  
  // Commit the transaction
  db.commit();
  
  // Get value of "A" after commit
  System.out.println(db.get("A")); // Output: 5
  
  // Begin another transaction
  db.begin_transaction();
  db.put("B", 10);
  
  // Rollback the transaction
  db.rollback();
  
  // Get value of "B" after rollback
  System.out.println(db.get("B")); // Output: null
  ```

## **Suggested Improvements**
1. Nested Transactions: Add support for nested transactions and clarify how they should behave.
2. Additional Methods: Consider adding methods like delete(key) or listKeys() for enhanced functionality.
3. Edge Cases: Handle scenarios like empty strings as keys or null values more explicitly.
4. Automated Grading: Use unit tests and continuous integration pipelines for evaluating submissions more effectively.

## **Assignment Improvement Suggestions**
1. Clarify the expected behavior for corner cases such as handling null or empty strings as keys and values.
2. Add explicit guidelines for nested transaction support and describe how conflicting updates should be managed.
3. Provide example test cases to reduce ambiguity and help students verify their solutions.
4. Enhance grading criteria by incorporating automated unit tests to evaluate code correctness and edge case handling.
5. Include optional bonus tasks, like implementing multi-threaded transaction support, to challenge advanced students.
