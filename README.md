# Brainfuck language translator

This project was created for solving [issue at codewars](https://www.codewars.com/kata/58924f2ca8c628f21a0001a1).
This program translates typed code in Brainfuck into other programming languages.

Languages available:
- Python
- Python with debug assertions
- C

## Example

For simple Brainfuck programme writing "Hello": 
```
-[------->+<]>-.-[->+++++<]>++.+++++++..+++.
```

Here's the translated code in Python syntax:
```python
import sys # for reading from stdin

memory = [0] * 30000
p = 0
memory[p] = (memory[p] + 1) % 256
while memory[p] != 0:
    memory[p] = (memory[p] + 256 - 5) % 256
    p += 1
    memory[p] = (memory[p] + 3) % 256
    p -= 1
p += 1
memory[p] = (memory[p] + 1) % 256
print(chr(memory[p]), end='')
memory[p] = (memory[p] + 256 - 3) % 256
print(chr(memory[p]), end='')
memory[p] = (memory[p] + 7) % 256
print(chr(memory[p]), end='')
print(chr(memory[p]), end='')
memory[p] = (memory[p] + 3) % 256
print(chr(memory[p]), end='')
```