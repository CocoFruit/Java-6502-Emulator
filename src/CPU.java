public class CPU {
    private UWord PC; // program counter
    private UByte SP; // stack pointer
    private UByte A, X, Y; // registers
    private int cycles;
    ProcessorStatus status = new ProcessorStatus();

    // opcodes
    public final UByte 
        INS_LDA_IM = new UByte(0xA9),
        INS_LDA_ZP = new UByte(0xA5),
        INS_LDA_ZPX = new UByte(0xB5),
        INS_JSR   = new UByte(0x20);

    public void print_status(){
        status.prettyPrint();
    }

    public void print_registers(){
        System.out.println("A: " + A);
        System.out.println("X: " + X);
        System.out.println("Y: " + Y);
        System.out.println("PC: " + PC);
        System.out.println("SP: " + SP);
    }

    public void reset(Mem memory){
        PC = new UWord(0xFFFC);
        SP = new UByte(0xFD);
        status.setFlags("CZIDBVN".toCharArray(), false);
        memory.initialize();
    }

    // fetch byte and increment PC
    private UByte fetchByte(Mem memory){
        UByte data = memory.getByte(PC);
        PC.setValue(PC.getValue() + 1);
        cycles--;
        return data;
    }

    // fetch word (little endian) and increment PC by 2
    private UWord fetchWord(Mem memory){
        UByte low  = fetchByte(memory);
        UByte high = fetchByte(memory);
        // Combine bytes into a word (little endian)
        return new UWord((high.getValue() << 8) | low.getValue());
    }

    // read byte from memory without changing PC
    private UByte readByte(UByte address, Mem memory){
        cycles--;
        return memory.getByte(address.getValue());
    }

    private void updateLDAFlags() {
        status.setFlag('Z', A.equals(new UByte(0x00)));
        UByte result = A.and(new UByte(0x80));
        status.setFlag('N', result.getValue() == 0x80);
    }

    // Push a byte onto the stack
    private void pushByte(UByte value, Mem memory) {
        int addr = 0x0100 + SP.getValue();
        memory.setByte(addr, value);
        SP.setValue(SP.getValue() - 1);
        cycles--;
    }

    // Pop a byte from the stack
    private UByte popByte(Mem memory) {
        SP.setValue(SP.getValue() + 1);
        cycles--;
        int addr = 0x0100 + SP.getValue();
        return memory.getByte(addr);
    }

    // Instruction handlers
    private void handleLDAImmediate(Mem memory) {
        A = fetchByte(memory);
        updateLDAFlags();
    }

    private void handleLDAZeroPage(Mem memory) {
        UByte zpAddr = fetchByte(memory);
        A = readByte(zpAddr, memory);
        updateLDAFlags();
    }

    private void handleLDAZeroPageIndexed(Mem memory) {
        UByte zpAddr = fetchByte(memory);
        zpAddr = zpAddr.add(X);
        A = readByte(zpAddr, memory);
        updateLDAFlags();
    }

    private void handleJSR(Mem memory) {
        UWord targetAddress = fetchWord(memory);
        // Return address is (PC - 1)
        int returnAddr = PC.getValue() - 1;
        pushByte(new UByte((returnAddr >> 8) & 0xFF), memory); // push high byte
        pushByte(new UByte(returnAddr & 0xFF), memory);        // push low byte
        PC = targetAddress;
        // Additional cycle adjustments if needed
    }

    public void execute(int cyclesSet, Mem memory) {
        cycles = cyclesSet;
        while (cycles > 0) {
            UByte instruction = fetchByte(memory);
            if (instruction.equals(INS_LDA_IM)) {
                handleLDAImmediate(memory);
            } else if (instruction.equals(INS_LDA_ZP)) {
                handleLDAZeroPage(memory);
            } else if (instruction.equals(INS_LDA_ZPX)) {
                handleLDAZeroPageIndexed(memory);
            } else if (instruction.equals(INS_JSR)) {
                handleJSR(memory);
            } else {
                throw new IllegalStateException("Instruction not handled: " + instruction);
            }
        }
    }
}
