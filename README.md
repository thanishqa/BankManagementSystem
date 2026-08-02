# 🏦 Bank Management System

A console-based **Bank Management System built using Java and Object-Oriented Programming (OOP)** concepts. The project is developed step-by-step to implement account management, authentication, banking transactions, exception handling, collections, and file-based data persistence.

---

## 📌 Project Overview

The Bank Management System allows users to create and manage bank accounts through a command-line interface.

The application supports different account types, secure PIN-based login, deposits, withdrawals, money transfers, transaction history, account details, and persistent storage of banking data.

The project is developed incrementally to demonstrate core Java, OOP, Collections Framework, Exception Handling, File Handling, and Git/GitHub practices.

---

## ✨ Features

* 🏦 Create bank accounts
* 🔐 PIN-based authentication
* 👤 Login and logout
* 💰 Deposit money
* 💸 Withdraw money
* 💳 Check account balance
* 🔄 Transfer money between accounts
* 📜 View transaction history
* 👤 View account details
* 🔑 Change account PIN
* 📋 Display all accounts
* 🏦 Savings Account support
* 💼 Current Account support
* ⚠️ Insufficient balance exception handling
* 💾 Save account data to a file
* 🔄 Load account data when the application restarts
* 📝 Persistent transaction history

---

## 🧠 OOP Concepts Used

### 1. Encapsulation

Account information such as account number, holder name, PIN, and balance is managed inside classes using appropriate access modifiers and methods.

### 2. Inheritance

The project uses inheritance to create specialized account types.

```text
BankAccount
    ├── SavingsAccount
    └── CurrentAccount
```

### 3. Polymorphism

Different account types can provide their own implementation for account-specific operations such as interest calculation and withdrawal rules.

### 4. Abstraction

Banking operations are organized into separate classes and methods, keeping the application modular and easier to maintain.

---

## 🗂️ Collections Used

### ArrayList

`ArrayList` is used to maintain transaction history for each account.

### HashMap

`HashMap` is used to store and quickly retrieve bank accounts using the account number as the key.

```text
HashMap<Integer, BankAccount>
```

---

## ⚠️ Exception Handling

The project contains a custom exception:

```text
InsufficientBalanceException
```

It is used when a user attempts to withdraw or transfer more money than the available account balance.

Example:

```text
Transaction failed: Insufficient balance.
```

---

## 💾 File Persistence

The application uses file handling to preserve banking information between program executions.

The `BankDataManager` class manages saving and loading account information.

The local data is stored in:

```text
data/bank_data.txt
```

The `data/` directory is excluded from Git using `.gitignore` because it contains local test banking data.

---

## 📁 Project Structure

```text
BankManagementSystem/
│
├── src/
│   ├── Main.java
│   ├── Bank.java
│   ├── BankAccount.java
│   ├── BankDataManager.java
│   ├── SavingsAccount.java
│   ├── CurrentAccount.java
│   └── InsufficientBalanceException.java
│
├── data/
│   └── bank_data.txt
│
├── .gitignore
└── README.md
```

---

## 🛠️ Technologies Used

* **Java**
* **Object-Oriented Programming**
* **ArrayList**
* **HashMap**
* **Exception Handling**
* **File Handling**
* **Command Prompt**
* **Git**
* **GitHub**

---

## ▶️ How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/thanishqa/BankManagementSystem.git
```

### 2. Navigate to the Project

```bash
cd BankManagementSystem
```

### 3. Navigate to Source Folder

```bash
cd src
```

### 4. Compile the Java Files

```bash
javac *.java
```

### 5. Run the Application

```bash
java Main
```

---

## 🖥️ Application Menu

### Main Menu

```text
=================================
       WELCOME TO MY BANK
=================================
1. Create Account
2. Login
3. Display All Accounts
4. Exit
=================================
```

### Bank Menu

```text
=================================
          BANK MENU
=================================
1. Deposit Money
2. Withdraw Money
3. Check Balance
4. Transfer Money
5. Transaction History
6. Account Details
7. Change PIN
8. Logout
=================================
```

---

## 🧪 Example Workflow

```text
Create Account
      ↓
Select Account Type
      ↓
Create 4-Digit PIN
      ↓
Login
      ↓
Deposit Money
      ↓
Withdraw Money
      ↓
Check Balance
      ↓
Transfer Money
      ↓
View Transaction History
      ↓
Logout
      ↓
Data remains available after restart
```

---

## 📈 Project Development Stages

### Task 1 — Basic Banking System

* Basic account creation
* Deposit
* Withdrawal
* Balance checking
* Display accounts

### Task 2 — Collections & Authentication

* HashMap-based account management
* PIN authentication
* Login/logout
* Money transfer
* Transaction history
* PIN change

### Task 3 — Advanced OOP & Exception Handling

* Savings Account
* Current Account
* Inheritance
* Polymorphism
* Account-specific behavior
* Custom `InsufficientBalanceException`

### Task 4 — File Persistence

* `BankDataManager`
* Save account data
* Load account data
* Persistent balance
* Persistent transaction history
* Restore account data after application restart

### Task 5 — Planned

* JDBC
* MySQL database
* Database-backed account management
* SQL CRUD operations

---

## 🔒 Data Privacy

The application's local banking data is stored inside:

```text
data/bank_data.txt
```

The `data/` folder is excluded from Git using `.gitignore` so that local account information and test data are not uploaded to GitHub.

---

## 🚀 Future Enhancements

Planned improvements include:

* 🗄️ MySQL database integration using JDBC
* 🖥️ Graphical User Interface (GUI)
* 📊 Admin dashboard
* 🔐 Improved authentication
* 📧 Email notifications
* 📱 Mobile-friendly version
* 📈 Account statements
* 🧾 Downloadable transaction reports
* ☁️ Cloud-based data storage
* 🔒 Stronger security and password/PIN protection

---

## 🎯 Learning Outcomes

Through this project, I gained practical experience in:

* Java programming
* Object-Oriented Programming
* Inheritance and Polymorphism
* Collections Framework
* Exception Handling
* File Handling
* Console-based application development
* Modular code organization
* Git and GitHub version control
* Incremental project development

---

## 👩‍💻 Author

**Thanishka Vinayagamoorthy**

Computer Science and Engineering Student

---

## ⭐ Repository

GitHub Repository:

https://github.com/thanishqa/BankManagementSystem

If you find this project useful, feel free to ⭐ the repository.
