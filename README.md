

# Customized Database Management System

This project is a customized database management system that allows users to perform various database operations such as inserting, querying, and deleting records in a simple and user-friendly manner. This README provides an overview of the project, how to use it, and its key features.

## Table of Contents
- [Project Overview](#project-overview)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Commands](#commands)
- [Contributing](#contributing)
- [License](#license)

## Project Overview

The Customized Database Management System (DBMS) is an application that simulates a basic database system. It allows users to perform the following operations:

- Insert records into the database.
- Display all records in the database.
- Display specific records by Record ID (RID) or Name.
- Delete specific records by RID or Name.
- Aggregate functions: Maximum, Minimum, Summation, Average, and Count.

## Getting Started

To run this project on your local machine, you need to follow these steps:

1. Clone the project repository from GitHub.
2. Set up the required development environment.
3. Build and run the project.

## Usage

Once you have the project running, you can interact with the Customized DBMS through the console. Here are some basic commands to get you started:

### Commands

- `help`: Display a list of available commands and their descriptions.
- `exit`: Terminate the DBMS application.

#### Insert Data
To insert data into the database, use the following command:
```
insert into Student Name Salary
```
Replace `Name` and `Salary` with the desired values.

#### Display Data
To display all data in the database, use the following command:
```
select * from student
```

#### Display Specific Data
To display specific data by RID or Name, use one of the following commands:

To display by RID:
```
select * from student where RID = Student_RID
```

To display by Name:
```
select * from student where Name = Student_Name
```

#### Delete Specific Data
To delete specific data by RID or Name, use one of the following commands:

To delete by RID:
```
delete from student where RID = RID_Number
```

To delete by Name:
```
delete from student where name = Student_Name
```

#### Aggregate Functions
To perform aggregate functions, use the following commands:

- `Select Max salary from student`: Display the record with the maximum salary.
- `Select Min salary from student`: Display the record with the minimum salary.
- `Select Summation salary from student`: Display the summation of all salaries.
- `Select Average salary from student`: Display the average salary.
- `Select student count from student`: Display the count of records in the database.

## Contributing

Contributions to this project are welcome. If you find any issues or have suggestions for improvements, please open an issue or submit a pull request on the GitHub repository.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
