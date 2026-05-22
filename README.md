# BonusProject
# Dijkstra Bonus Task

This project contains the implementation of Dijkstra’s Algorithm in Java.
For this bonus task, I updated the graph to support weighted edges and implemented the shortest path algorithm.

## What was added

- Edge weights
- Updated Edge class with weight field
- Adjacency list with weights
- `dijkstra(int start)` method

## How it works

The algorithm takes a starting vertex and finds the shortest distance to all other vertices in the graph.

It uses:
- distance array
- visited array
- loops

## Example Output

```text
Shortest distances from vertex 0:

0 -> 0 = 0
0 -> 1 = 3
0 -> 2 = 1
0 -> 3 = 4
0 -> 4 = 7
