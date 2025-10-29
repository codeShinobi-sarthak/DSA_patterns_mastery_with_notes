# 📚 Representing Integers in Computer

---

## 🔹 Binary System in Computers

- **Binary**: Computers speak in *two symbols*: `0` and `1`.
- A binary number of `k` digits can represent exactly `2^k` different values.

| Bytes | Bits | Possible Values |
|:-----:|:----:|:---------------:|
| 1 byte | 8 bits | 2⁸ = 256 values |
| 2 bytes | 16 bits | 2¹⁶ = 65,536 values |
| 4 bytes | 32 bits | 2³² = 4,294,967,296 values |
| 8 bytes | 64 bits | 2⁶⁴ = 18,446,744,073,709,551,616 values |

---

## 🔹 Signed vs Unsigned Integers

- **Unsigned Integer**: Only positive numbers and zero (`0 ➔ 2^k - 1`).
- **Signed Integer**: Positive *and* negative numbers.

> **In signed integers,**
> - Highest bit (leftmost) ➔ *sign bit* (0 = positive, 1 = negative).
> - Rest of the bits ➔ magnitude (size) of the number.

---
### 📏 Ranges:

- **1-Byte (8-bit) Signed**:  
  ➔ `-2⁷` to `2⁷ - 1`  
  ➔ `-128 to 127`

- **1-Byte (8-bit) Unsigned**:  
  ➔ `0 to 2⁸ - 1`  
  ➔ `0 to 255`

---
### 📜 Quick Takeaways:

- **Signed integers** can represent both negatives and positives.
- **Unsigned integers** cannot represent negative numbers.
- **Signed max** ≈ Half of **unsigned max**.

---
## 🔹 Machine Number and Truth Value

- **Machine Number**: How the computer *actually* stores the binary.
- **Truth Value**: The *real-world* meaning (including sign).

Example:
- `10001010` (machine number) ➔ Truth Value: `-10`
- `00001010` (machine number) ➔ Truth Value: `+10`

---

# 🛡️ The Three Legendary Codes (Simply Explained)

## ⚔️ 1. Original Code

**💬 Think of it like:**  
➔ "Just store the number exactly as it is, but add a sign bit in front."

- **First bit** = sign (0 for positive, 1 for negative).
- **Rest of the bits** = the normal binary value (absolute value).

**Example: Represent +5 and -5 with 8 bits.**

| Number | Original Code (8 bits) |
|:------:|:---------------------:|
| +5 | `00000101` |
| -5 | `10000101` |

🧠 **Problem:**
- Two ways to write 0: `00000000` (+0) and `10000000` (-0).
- That’s weird and wastes memory!

---

## ⚔️ 2. Inverse Code 

**💬 Think of it like:**  
➔ "For negative numbers, flip all the value bits. Sign bit stays."

- Positive numbers ➔ Same as original code.
- Negative numbers ➔ Flip every bit except the sign bit.

**Example: Represent +5 and -5**

| Number | Inverse Code (8 bits) |
|:------:|:--------------------:|
| +5 | `00000101` |
| -5 | `11111010` |

How to get `-5`:
- Start with +5 → `00000101`
- Flip every bit (except sign bit) → `11111010`

🧠 **Problem:**
- Still two zeros! (+0 and -0)

---

## ⚔️ 3. Complement Code

**💬 Think of it like:**  
➔ "Take the inverse code and add 1 to it."

- Positive numbers ➔ Same as original and inverse code.
- Negative numbers ➔ (Inverse code) + 1

**Example: Represent +5 and -5**

| Number | Complement Code (8 bits) |
|:------:|:------------------------:|
| +5 | `00000101` |
| -5 | `11111011` |

How to get `-5`:
- Inverse code for -5 = `11111010`
- Add 1 ➔ `11111010 + 1 = 11111011`

**✨ Magic:**
- Only *one* representation of 0.
- Easy to do addition and subtraction.
- Computers love this format, so they use complement code everywhere!

---

# 📜Simplified Memory Tip:

| What it does? | How it works? |
|:------------|:-------------|
| Original Code | Just add sign bit. |
| Inverse Code | Flip bits for negatives. |
| Complement Code | Flip + add 1 for negatives. |

---

# 📣 **Key Intuition**

- Positive numbers? Easy — no changes needed.
- Negative numbers?
  - Flip bits (Inverse Code)
  - Add 1 (Complement Code)
- Computers always use **Complement Code** to avoid messy double zeros and messy operations!

---

# 🌟 Visual Story:

👉 Think of **Original Code** as "the photo" 📷  
👉 Think of **Inverse Code** as "the photo in negatives" 🖤  
👉 Think of **Complement Code** as "negative photo + tiny flash of light" ⚡ (adding 1)!

---



