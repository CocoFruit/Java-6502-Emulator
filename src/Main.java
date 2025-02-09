public class Main {
    public static void main(String[] args) {
        // Create a new CPU and Memory instance
        CPU cpu = new CPU();
        Mem memory = new Mem();

        // Reset the CPU and initialize memory.
        cpu.reset(memory);

        /*
         * Load the test program:
         *  - At address 0xFFFC, store the LDA Zero Page opcode.
         *  - At address 0xFFFD, store the operand (zero-page address 0x42).
         *  - At zero-page address 0x0042, store the value 0x84, 
         *    which should be loaded into the A register.
         */
        memory.setByte(0xFFFC, cpu.INS_LDA_ZP);
        memory.setByte(0xFFFD, new UByte(0x42));
        memory.setByte(0x0042, new UByte(0x84));

        // Execute the program for a given number of cycles.
        // (3 cycles should be enough to execute the LDA Zero Page instruction.)
        cpu.execute(3, memory);

        // Print the CPU status and registers to verify the outcome.
        // Expected outcome:
        //  - Register A should contain 0x84.
        //  - The status flags should be updated accordingly (e.g., Negative flag set if 0x84 has bit 7 set).
        //  - The Program Counter (PC) will have advanced past the instruction.
        cpu.print_status();
        cpu.print_registers();
    }
}
