

Here’s the classic **Java Operator Precedence Table** (works similarly for C, C++, etc.) —

| Precedence | Operator(s)                | Description                        | Associativity   |
|:-----------|:----------------------------|:-----------------------------------|:----------------|
| 1 (Highest) | `()`, `[]`, `.`, `::`       | Method call, array access, member access, method reference | Left to Right |
| 2           | `++`, `--`, `+`(unary), `-`(unary), `!`, `~`, `new`, `cast` `(type)` | Unary operators, object creation, type cast | Right to Left |
| 3           | `*`, `/`, `%`               | Multiplication, division, modulo   | Left to Right  |
| 4           | `+`, `-`                    | Addition, subtraction              | Left to Right  |
| 5           | `<<`, `>>`, `>>>`            | Bitwise shift operators            | Left to Right  |
| 6           | `<`, `<=`, `>`, `>=`, `instanceof` | Relational operators | Left to Right  |
| 7           | `==`, `!=`                  | Equality operators                 | Left to Right  |
| 8           | `&`                         | Bitwise AND                        | Left to Right  |
| 9           | `^`                         | Bitwise XOR                        | Left to Right  |
| 10          | `|`                         | Bitwise OR                         | Left to Right  |
| 11          | `&&`                        | Logical AND                        | Left to Right  |
| 12          | `||`                        | Logical OR                         | Left to Right  |
| 13          | `?:`                        | Ternary conditional operator       | Right to Left  |
| 14          | `=`, `+=`, `-=`, `*=`, `/=`, `%=`<br>`&=`, `|=`, `^=`, `<<=`, `>>=`, `>>>=` | Assignment operators | Right to Left  |
| 15 (Lowest) | `,`                         | Comma operator (separates expressions) | Left to Right |

---

🌟 **Quick beautiful observations:**
- **Highest precedence**: **`()`** — function calls, array access, etc., are performed first.
- **Lowest precedence**: **`,`** — used when you want to evaluate multiple expressions in a sequence.
- **Assignment operators** like `=`, `+=`, etc., always associate **right to left** because the right-hand side must fully evaluate before assigning.
