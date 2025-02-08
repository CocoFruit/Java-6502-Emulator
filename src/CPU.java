public class CPU {
    private UWord PC; // program counter
    private UWord SP; // stack pointer

    private UByte A, X, Y; // registers
    
    //my implementation instead of bit fields
    ProcessorStatus status = new ProcessorStatus();

    public void Reset(Mem memory){
        this.PC = 0xFFFC;
        this.SP = 0x00FF;
        status.set_flags("CZIDBVN".toCharArray(), false);
        memory.Initialize();
    }

    public void Execute(int Cycles, Mem memory){

    }


}
