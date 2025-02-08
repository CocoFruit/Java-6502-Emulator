class Main{
    public static void main(String[] args){
        CPU cpu = new CPU();
        Mem memory = new Mem();
        cpu.Reset(memory);
    
        // load in test program
        memory.set_byte(0xFFFC, cpu.INS_LDA_IM);
        memory.set_byte(0xFFFD, new UByte(0x42));
        cpu.Execute(2, memory);
    
        // memory.print_memory();

        cpu.print_status();
        cpu.print_registers();
    }
}