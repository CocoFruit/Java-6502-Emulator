public class CPU {
    private UWord PC; // program counter
    private UWord SP; // stack pointer

    private UByte A, X, Y; // registers
    private int cycles; 

    // my implementation instead of bit fields
    ProcessorStatus status = new ProcessorStatus();

    // opcodes
    public final UByte 
        INS_LDA_IM = new UByte(0xA9),
        INS_LDA_ZP = new UByte(0xA5);

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

    public void Reset(Mem memory){
        this.PC = new UWord(0xFFFC);
        this.SP = new UWord(0x0100);
        status.set_flags("CZIDBVN".toCharArray(), false);
        memory.Initialize();
    }

    private UByte FetchByte(Mem memory){
        UByte Data = memory.get_byte(PC);
        this.PC.add(new UWord(1));
        this.cycles--;
        return Data;
    }

    public void Execute(int cycles_set, Mem memory){
        this.cycles = cycles_set;
        while(this.cycles > 0){
            UByte instruction = FetchByte(memory);
            
            if(instruction.equals(INS_LDA_IM)){
                UByte value = FetchByte(memory);
                A = value;

                // Debug: print bitstring of A
                // System.out.println("A: " + Integer.toBinaryString(A.getValue()));

                // Set Z flag if A is zero
                status.set_flag('Z',A.equals(new UByte(0x00)));
                
                // Isolate bit 7 using bitwise AND
                UByte result = A.and(new UByte(0x80));
                // Set N flag if bit 7 is set
                status.set_flag('N', result.getValue() == 0x80);
            } 
            else{
                System.out.println("Instruction not handled: " + instruction);
            }
        
        }
    }

}
