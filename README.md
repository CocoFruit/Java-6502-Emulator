
# 6502 Emulator in Java

This project is an emulator for the **6502 microprocessor**, written in Java. It simulates the behavior of the 6502 CPU, its instructions, memory, and registers, allowing you to run assembly programs on a virtual machine. The goal of this emulator is to replicate the behavior of the 6502 processor as accurately as possible, enabling the execution of vintage software or providing a platform for educational purposes and research.

## Features

- Emulates the **6502 CPU** with its registers (A, X, Y, SP, PC, Status flags).
- Implements the **memory** and **addressing modes** of the 6502 processor.
- Supports **6502 instructions** such as ADC, SBC, LDA, STA, JMP, JSR, etc.
- Implements **interrupts** and **exceptions**, including IRQ and NMI.
- Allows running of simple **6502 assembly programs**.
- Implements **flag handling** for processor status (Zero, Carry, Interrupt Disable, etc.).
- Includes a basic debugger for stepping through the instructions.

## Requirements

- Java 8 or higher.
- IDE or text editor for editing Java files (e.g., IntelliJ IDEA, Eclipse, Visual Studio Code).
- Command line (Terminal) for building and running the project.

## Setup & Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/6502-emulator.git
   cd 6502-emulator
   ```

2. **Build the project** (if necessary):
   - If you're using an IDE like IntelliJ IDEA, you can simply open the project.
   - Alternatively, you can build the project manually by compiling all `.java` files:
     ```bash
     javac *.java
     ```

3. **Run the Emulator**:
   To run the emulator and execute a program (e.g., a 6502 assembly binary file), run the following command:
   ```bash
   java Emulator
   ```

4. **Running Programs**:
   You can load a 6502 binary program into the emulator, or use the built-in test programs. To load a program:
   ```bash
   java Emulator /path/to/your/program.bin
   ```

## Project Structure

```
6502-emulator/
├── src/
│   ├── Emulator.java         # Main emulator logic and entry point.
│   ├── CPU.java             # 6502 CPU class, emulates the CPU's operations and instructions.
│   ├── Memory.java          # Memory class, handles loading and accessing memory.
│   ├── InstructionSet.java  # Defines all 6502 instructions and their behavior.
│   ├── UByte.java           # UByte class to handle 8-bit unsigned byte values.
│   ├── Registers.java       # Class for CPU registers (A, X, Y, SP, PC, Status flags).
│   ├── Debugger.java        # Basic debugger for inspecting the state of the emulator.
│   └── Utils.java           # Utility methods for common tasks.
├── tests/                   # Contains unit tests for various parts of the emulator.
└── README.md                # This file.
```

## Usage

### Emulator

The `Emulator` class is the entry point for the project. It handles the execution of 6502 machine code and allows you to interact with the emulator through commands or a debugger.

You can start the emulator with:

```bash
java Emulator
```

To load a custom 6502 binary file:

```bash
java Emulator /path/to/program.bin
```

### Instructions and Addressing Modes

The 6502 supports a wide range of instructions and addressing modes. The emulator currently supports the following instruction types:
- **Load/Store Instructions**: LDA, LDX, LDY, STA, STX, STY.
- **Arithmetic Instructions**: ADC, SBC, AND, ORA, EOR, CMP, CPX, CPY.
- **Control Flow Instructions**: JMP, JSR, RTS, BEQ, BNE, BCS, BCC, BVS, BVC.
- **Shift and Rotate Instructions**: ASL, LSR, ROL, ROR.
- **Status Flag Instructions**: CLC, SEC, CLI, SEI, CLD, SED, CLV.

The 6502 supports various **addressing modes**:
- **Immediate**: Uses the next byte as the operand.
- **Zero Page**: Uses the next byte as a 8-bit address in the zero page.
- **Absolute**: Uses the next two bytes as a 16-bit address.
- **Indirect**: Uses a pointer in memory to point to the target address.
- **Indexed**: Uses an index register (X or Y) to modify the operand.

### Flags

The 6502 has a set of **status flags** that affect the behavior of the processor:
- **Carry (C)**: Set or cleared during arithmetic operations.
- **Zero (Z)**: Set when the result of an operation is zero.
- **Interrupt Disable (I)**: Prevents IRQ interrupts.
- **Decimal (D)**: Used in BCD (Binary-Coded Decimal) mode.
- **Break (B)**: Indicates a software interrupt (BRK instruction).
- **Overflow (V)**: Set if an arithmetic overflow occurs.
- **Negative (N)**: Set if the result is negative.

## Contributions

Contributions are welcome! If you would like to improve the emulator or fix a bug, feel free to fork the project, create a pull request, and submit it for review.

To contribute:

1. Fork the repository.
2. Create a new branch for your changes.
3. Commit your changes.
4. Push the changes to your forked repository.
5. Create a pull request to the main repository.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- This project was inspired by classic computing emulators and vintage 6502 software.
- Thanks to the open-source community for providing resources and documentation on 6502 programming and emulation.
