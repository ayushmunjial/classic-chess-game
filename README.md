# Classic Chess Game

**Developer:** Ayush Munjial, Hein Min Thu  
**Technologies:** Java · Object-Oriented Programming (OOP) · Visual Studio Code  
**Project Duration:** Feb 2024 – Mar 2024

---

## 📌 Overview

This is a fully functional, terminal-based **multiplayer chess game** developed in Java, simulating a traditional two-player chess experience. It models real-world chess rules and behaviors with accuracy, including move validation, turn-based logic, and specialized actions like castling and en passant.

With a clean object-oriented design and efficient data handling, this game offers a foundational base for further enhancements, including AI, GUI integration, or online play.

---

## ✅ Features

- ♟ **Complete Rule Enforcement**  
  Validates all legal moves, including complex logic for check, checkmate, and stalemate detection.

- ♞ **Special Moves Supported**  
  Fully functional implementation of **castling**, **en passant**, and **pawn promotion**.

- ♜ **Multiplayer Gameplay**  
  Two-player alternating system via command-line interface.

- ♛ **Text-Based Interface**  
  Clean and responsive CLI to track the board and submit moves using standard algebraic notation.

- ⚙️ **Performance-Oriented Design**  
  Efficient use of Java data structures for fast move validation and board state management.

- 🧹 **Object-Oriented Architecture**  
  Uses design patterns and clean abstractions to organize game logic and piece behaviors.

---

## ⌗ ASCII Board Preview

```plaintext
   a  b  c  d  e  f  g  h
8 [r][n][b][q][k][b][n][r] 8🎲
7 [p][p][p][p][p][p][p][p] 7
6 [ ][ ][ ][ ][ ][ ][ ][ ] 6
5 [ ][ ][ ][ ][ ][ ][ ][ ] 5
4 [ ][ ][ ][ ][ ][ ][ ][ ] 4
3 [ ][ ][ ][ ][ ][ ][ ][ ] 3
2 [P][P][P][P][P][P][P][P] 2
1 [R][N][B][Q][K][B][N][R] 1
   a  b  c  d  e  f  g  h
```

---

## 🧪 How to Run

1. **Clone the repository**:  
   ```bash
   git clone https://github.com/ayushmunjial/classic-chess-game.git
   cd classic-chess-game
   ```
2. **Compile & Run**:  
   ```bash
   javac Chess.java
   java Chess
   ```
3. **Play** by entering moves in the format `source destination` (e.g., `e2 e4`).

---

## 📚 References

All chess rules and mechanics were implemented following the official documentation on  
👉 _[Wikipedia – Chess Rules](https://en.wikipedia.org/wiki/Chess)_
