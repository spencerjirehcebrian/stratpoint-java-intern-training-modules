# Library Management System

## Table of Contents

1. [Overview](#overview)
2. [Features](#features)
3. [System Architecture](#system-architecture)
4. [Class Descriptions](#class-descriptions)
5. [Data Model](#data-model)
6. [Interfaces](#interfaces)
7. [Algorithms and Data Structures](#algorithms-and-data-structures)
8. [Input Validation](#input-validation)
9. [Error Handling](#error-handling)
10. [Performance Considerations](#performance-considerations)
11. [Testing](#testing)

## Overview

The Library Management System is a sophisticated, console-based Java application designed for efficient management of a book collection. It provides a comprehensive set of features for librarians and users to interact with the library's inventory, utilizing a modular and extensible architecture.

[LINK TO JAVADOCS](https://docshoster.org/p/spencerjirehcebrian/stratpoint-java-intern-training-modules/latest/com/miniproject/two/package-summary.html)

## Features

- Comprehensive Book Management
- Advanced Search Functionality
- Borrowing and Return System
- Detailed Inventory Display
- User-Friendly Console Interface

## System Architecture

The system follows a modular architecture with the following key components:

1. User Interface Layer (`Main.java`)
2. Business Logic Layer (`Library.java`)
3. Data Model Layer:
   - `Book.java`
   - `BookData.java`
   - `AuthorData.java`
   - `LiteratureData.java`
   - `PublisherData.java`
   - `ManagementData.java`
4. Interface Layer:
   - `DataInterface.java`
5. Utility Classes (e.g., `RandomIdGenerator`)

## Class Descriptions

- `Main`: Entry point of the application, handles user interaction.
- `Library`: Manages the collection of books and provides core functionality.
- `Book`: Represents a book entity, extending `BookData`.
- `BookData`: Abstract base class for `Book`, containing common fields and methods.
- `AuthorData`: Manages author-related information.
- `LiteratureData`: Handles literature-specific data (title, genre, subgenre).
- `PublisherData`: Manages publisher-related information.
- `ManagementData`: Handles library management data (Dewey decimal, availability, borrower).

## Data Model

The system uses a composite data model to represent books:

- `BookData` (abstract):
  - Aggregates `LiteratureData`, `AuthorData`, `PublisherData`, and `ManagementData`
  - Provides common methods for all book-related operations
- `Book` (concrete):
  - Extends `BookData`
  - Implements specific book behaviors

This design allows for flexible extension and modification of book attributes and behaviors.

## Interfaces

- `DataInterface`: Defines methods for data printing operations (printData, printHeader, printRow, printFooter).
  - Implemented by: `BookData`, `AuthorData`, `LiteratureData`, `PublisherData`, `ManagementData`

## Algorithms and Data Structures

- Book Collection: `ArrayList<Book>` in `Library` class
- Search Algorithm: Java Stream API for multi-criteria filtering
- Random ID Generation: Custom algorithm in `RandomIdGenerator` inner class

## Input Validation

- ISBN: Apache Commons Validator library
- Published Year: Integer parsing with error handling
- Availability Status: Boolean parsing with error handling
- Empty Input: Prevents empty input except for Borrower Name

## Error Handling

- Invalid user inputs
- Book not found scenarios
- Duplicate ISBN entries
- Data parsing errors

## Performance Considerations

- Efficient searching using Java Stream API
- Modular data structure for quick access and modification of book components

## Testing

The testing strategy for the Library Management System includes:

1. Unit tests for the Book and Library classes, covering all basic operations and data management.
2. Integration tests simulating user interactions through the Main class interface.
3. Test coverage for CRUD operations, book borrowing/returning, searching, and user interface interactions.
4. Use of JUnit assertions to verify expected outcomes.
5. Input simulation for testing user interface methods.
6. Output verification for user-facing information.
