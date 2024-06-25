# Mini-Project 2: Library Management System (Basic Version)

README and documentation is still a work in progress...

This program provides a simple console-based library management system.
It allows users to add books, display a list of books, remove books,
search for books, and exit the system. The program includes input validation,
including ISBN validation for book entries.

The main menu offers the following options:

  <ul>
  <li>[1] Add Book: Prompts the user to enter details of a new book and adds it
  to the library.
  <li>[2] Book List: Displays all the books currently in the library.
  <li>[3] Remove Books: Prompts the user to enter a search term and removes
  matching books from the library.
  <li>[4] Search Books: Prompts the user to enter a search term and displays
  matching books from the library.
  <li>[5] Exit: Exits the application with a thank you message.
  </ul>

Input validation includes:

  <ul>
  <li>ISBN: Ensures that the ISBN is either a valid 10-digit or 13-digit
  number.
  <li>Published Year: Ensures that the published year is a valid integer.
  <li>Availability: Ensures that the availability status is either 'true' or
  'false'.
  </ul>
