package cpu;

import memory.Mem;
import cpu.Opcode;

public class CPU {
    private char PC; // program counter
    private byte SP; // stack pointer
    private byte A, X, Y; // registers
    private int cycles;

    private static final byte C  = 1 << 0; // carry flag
    private static final byte Z  = 1 << 1; // zero flag
    private static final byte I  = 1 << 2; // interrupt disable flag
    private static final byte D  = 1 << 3; // decimal mode flag
    private static final byte B  = 1 << 4; // break command flag
    private static final byte V  = 1 << 5; // overflow flag
    private static final byte N  = 1 << 6; // negative flag

    private byte flags;

    public void print_status(){
        System.out.println("\nCZIDBVN ");
        for(int i = 0; i < 8; i++){
            System.out.print((flags & (1 << i)) == 0 ? '0' : '1');
        }
    }

    public void print_registers(){
        // print in hex and add 0x and unsigned hex value
        System.out.println("    0x     | Dec");
        System.out.println(" A: 0x" + Integer.toHexString(A & 0xFF) + "   | " + (A & 0xFF));
        System.out.println(" X: 0x" + Integer.toHexString(X & 0xFF) + "    | " + (X & 0xFF));
        System.out.println(" Y: 0x" + Integer.toHexString(Y & 0xFF) + "    | " + (Y & 0xFF));
        System.out.println("PC: 0x" + Integer.toHexString(PC & 0xFFFF) + " | " + (PC & 0xFFFF));
        System.out.println("SP: 0x" + Integer.toHexString(SP & 0xFF) + "   | " + (SP & 0xFF));
    }

    public void reset(Mem memory){
        PC = (char) 0xFFFC;
        SP = (byte) 0xFD;
        flags = 0b0000000;
    }

    private byte fetchByte(Mem memory){
        byte data = memory.getByte(PC);
        PC += 1;
        this.cycles -= 1;
        return data;
    }

    private void updateLDAFlags() {
        // set Z flag if A = 0
        if (A == 0)
            flags |= Z;
        else
            flags &= ~Z;
        // set N flag if A has bit 7 set
        if ((A & 0x80) == 0x80)
            flags |= N;
        else
            flags &= ~N;
    }

    private void handleLDAImmediate(Mem memory){
        A = fetchByte(memory);
        updateLDAFlags();
    }
    public void execute(int cyclesSet, Mem memory) throws IllegalStateException {
        this.cycles = cyclesSet;
        while(this.cycles > 0){
            byte instruction = fetchByte(memory);
            Opcode opcode = Opcode.fromByte(instruction);

            if (opcode == null) {
                throw new IllegalStateException("Instruction not recognized: 0x" + Integer.toHexString(instruction & 0xFF));
            }

            switch (opcode) {
                case LDA_IM:
                    handleLDAImmediate(memory);
                    break;
                
                

                default:
                    throw new IllegalStateException("Instruction not recognized: " + instruction);
            }
        }
    }
    
     
}
