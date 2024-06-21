# Simple Java Calculator

This is a basic command-line calculator application written in Java. It performs simple arithmetic operations on two integers.

## Features

- Addition
- Subtraction
- Multiplication
- Division
- Error handling for invalid inputs
- Option to perform multiple calculations in one session

## How to Use

1. Run the program.
2. Enter the first number when prompted.
3. Enter the second number when prompted.
4. Choose an operation by entering one of the following symbols:
   - `+` for addition
   - `-` for subtraction
   - `*` for multiplication
   - `/` for division
5. The result will be displayed.
6. You will be asked if you want to perform another calculation.
   - Enter 'Y' or press Enter to continue
   - Enter 'n' to exit the program

## Error Handling

The program handles the following errors:
- Invalid number inputs
- Division by zero
- Invalid operator

When an error occurs, an appropriate message will be displayed.

## Code Structure

The `Calculator` class contains the following methods:
- `addition(int, int)`: Performs addition
- `subtraction(int, int)`: Performs subtraction
- `multiplication(int, int)`: Performs multiplication
- `division(int, int)`: Performs division
- `calculate(int, int, String)`: Selects the appropriate operation based on the operator
- `main(String[])`: Handles user input and program flow

## Notes

- This calculator only works with integers.
- Division results are truncated (rounded down) as integer division is used.
