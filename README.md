# Oddonacci Sequence

## Description

This project calculates the Oddonacci sequence using two different methods:

- **Multiple Recursion**: An exponential time complexity approach.
- **Linear Recursion**: A much more efficient linear time complexity approach.

It also measures and compares execution times for both implementations and saves the results in `OddoOut.txt`.

## Oddonacci Sequence Definition

The Oddonacci sequence is similar to the Fibonacci sequence but sums the last three terms instead of two:

\[
O(n) = O(n-1) + O(n-2) + O(n-3)
\]

With the base cases:

\[
O(1) = 1, \quad O(2) = 1, \quad O(3) = 1
\]

## Files

- `oddonacciSequence.java` - The main Java program that implements both methods.
- `OddoOut.txt` - Output file containing computed Oddonacci values and execution times.

## Algorithm Explanation

### 1. Multiple Recursion

- Calls itself recursively for `O(n-1)`, `O(n-2)`, and `O(n-3)`.
- **Time Complexity**: \(O(2^n)\) (exponential).
- **Efficiency**: Very inefficient for large values of `n`.

### 2. Linear Recursion

- Uses three parameters to carry results forward.
- **Time Complexity**: \(O(n)\) (linear).
- **Efficiency**: Much more efficient for large values of `n`.

### Compilation

```sh
javac oddonacciSequence.java
