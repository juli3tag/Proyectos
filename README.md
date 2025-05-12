# Java Projects

Welcome to my Java Projects repository! 👩🏻‍💻☕

Here you'll find a collection of small Java programs I've created while learning and practicing different programming concepts. These projects range from basic data structures like stacks, queues, and linked lists to simple applications and algorithm implementations like quicksort.

## 🧙‍♂️ Magic World Store – Java Console App

This is a simple Java console application that simulates a small store for Harry Potter-themed products. The main features include:

- Adding and managing magical articles (products)
- Registering customers
- Handling sales with optional fan discounts
- Viewing customer lists
- Upgrading regular customers to "fan" customers with special benefits

The app uses basic Java tools and OOP principles, including:

- Custom classes like Articulo, Cliente, ClienteFan, and ClienteNormal
- ArrayList and Hashtable for data storage
- Polymorphism and inheritance to handle different types of customers
- Simple input/output via Scanner for user interaction

The project runs entirely in the console and is great for practicing class structures, inheritance, and collection handling in Java.

[Ver código en GitHub](https://github.com/juli3tag/Proyectos/tree/main/java/TiendaHP)

## 🧱 Brick Factory - Java Console App

This is a simple Java console application that simulates a brick factory using a custom queue (cola) implemented with linked lists. Each brick order is represented by a Pedido object, and all orders are managed in a queue (Cola) to follow a First-In-First-Out (FIFO) workflow.

👩‍💻 How it works:

- Orders are created and enqueued using the encolar() method
- Orders are processed in the order they arrived using desencolar().
- The app displays the queue status throughout the process, and ensures all orders are processed by the end.

This project is great for practicing object-oriented programming, linked list-based data structures, and basic queue logic in Java — all with a clean, readable structure.

[Ver código en GitHub](https://github.com/juli3tag/Proyectos/tree/main/java/ColaListasEnlazadas)


## ⚽ Football Standings Sorted with Quicksort

This Java project demonstrates how to sort a list of football teams by their points using the Quicksort algorithm.

- The Equipo class represents a team with two attributes: nombre (name) and puntos (points).
- The sorting is handled in the Main class using a custom implementation of Quicksort that arranges the teams in descending order of points.
- Once sorted, the teams are displayed in a formatted standings table — just like you'd see in a real tournament!

Main Concepts Used:

- Custom object array sorting.
- Quicksort algorithm (recursive).
- Partition logic to organize elements around a pivot.
- Pretty console output using printf.

[Ver código en GitHub](https://github.com/juli3tag/Proyectos/blob/main/java/Quicksort/Main.java)


## 🔢 Sorting Algorithms

This folder contains two classic sorting algorithm implementations in Java: MergeSort and QuickSort. These are essential for understanding algorithmic thinking, recursion, and array manipulation.

🧩 Mergesort.

The MergeSort class uses the divide and conquer approach by recursively splitting the array into smaller subarrays, sorting them, and merging them back in order. It’s a stable sorting algorithm with a guaranteed time complexity of O(n log n), making it very efficient for large datasets.

[Ver código en GitHub](https://github.com/juli3tag/Proyectos/blob/main/java/Ordenamiento/MergeSort.java)

⚡Quicksort.

The QuickSort class also uses a divide and conquer strategy but works by selecting a pivot element and partitioning the array around it, so smaller elements go to the left and larger ones to the right. It’s an in-place, recursive algorithm with excellent average-case performance — also O(n log n) — and it’s widely used in practice.

[Ver código en GitHub](https://github.com/juli3tag/Proyectos/blob/main/java/Ordenamiento/QuickSort.java)

## Tree Structures Implementation

🌳 Binary Tree – Java Implementation

This project is a basic Binary Tree built in Java. It's a great starting point to understand how tree structures work — inserting nodes, traversing them (in-order, pre-order, post-order), and visualizing the overall structure.

Built using:
- Java, with no extra libraries
- A simple Node class to represent tree elements
- Recursive methods for traversal and tree construction

Everything runs from a basic main method. You can tweak the inserted values and test different tree operations. Super useful for learning recursion and tree logic.

[Ver código en GitHub](https://github.com/juli3tag/Proyectos/tree/main/java/Arboles/ArbolBinario)

🔍 Binary Search Tree (BST) – Java Implementation

This one is a classic Binary Search Tree (BST), where every node follows the "left < root < right" rule. It supports insertion, searching, and various tree traversals.

Main features:

- Written in Java, no frameworks
- Efficient insert() and search() methods
- In-order, pre-order, and post-order traversal
- Great for understanding how BSTs optimize data lookup

Run it through the main method, play around with different values, and see how the structure adjusts automatically!

[Ver código en GitHub](https://github.com/juli3tag/Proyectos/tree/main/java/Arboles/ABB)

🔤 Huffman Tree – Java Implementation

This is a simple Java implementation of the Huffman Coding algorithm, a classic technique used for lossless data compression. Basically, it builds a binary tree based on the frequency of characters in a given string and generates shorter binary codes for more frequent characters.

The project was built using:

- Java (no external libraries)
- PriorityQueue to organize the nodes by frequency
- A few custom classes like Node to store the tree structure
- Standard input/output for quick testing

You can run it from a simple main method — just change the input string and see the Huffman codes and encoded output. It's a cool way to learn about trees, heaps, and encoding techniques all in one go!

[Ver código en GitHub](https://github.com/juli3tag/Proyectos/tree/main/java/Arboles/Huffman)

## Stacks 📚

Pila (Linked List Implementation)

This is a simple implementation of a stack using a linked list structure. The stack follows the Last In, First Out (LIFO) principle. The stack allows us to push elements onto the top of the stack and pop elements from the top.

- Pushing: We create a new node and add it to the top of the stack. If the stack is empty, we set the new node as the root (top).
- Popping: Removes and returns the element at the top of the stack, adjusting the root pointer to the next node.
- Displaying Stack: The method verContenido() iterates through the stack and prints each element from top to bottom.

[Ver código en GitHub](https://github.com/juli3tag/Proyectos/tree/main/java/Pilas)

Pila con Arreglo (Array Implementation)

This implementation of the stack uses an array to store the elements. It provides basic stack operations like pushing and popping, but with a fixed array size.

- Pushing: When an element is pushed onto the stack, it's inserted at the next available position (the top index), if there's space available.
- Popping: Removes and returns the element at the top of the stack, and decrements the top index.
- Checking if Empty: The isEmpty() method checks if the stack is empty by verifying if the top index is -1.
- Displaying Stack: The method mostrarValores() shows all elements in the stack from top to bottom.

[Ver código en GitHub](https://github.com/juli3tag/Proyectos/tree/main/java/PilaconArreglo)

These two implementations demonstrate different ways to model a stack in Java: one using a dynamic linked list and the other using a fixed-size array.

## Linked Lists

🎀 Doubly Linked List

This project implements a doubly linked list that stores Producto objects sorted by their unique codigo (product code). It allows ordered insertion and prints the list in a nicely formatted way.

- Ordered Insertion: Every time a product is inserted, the code compares the codigo to existing ones in the list to maintain ascending order. If the code already exists, it throws a warning and skips the insertion.
- Doubly Linked Structure: Each node has a reference to both the next and previous nodes, allowing efficient traversal in both directions.
- Edge Cases Handled: The code correctly handles inserting at the beginning, middle, or end of the list—even if the list is empty.


[Ver código en GitHub](https://github.com/juli3tag/Proyectos/blob/main/java/Quicksort/Main.java)
