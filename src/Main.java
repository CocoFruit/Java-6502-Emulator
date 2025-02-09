import cpu.CPU;
import cpu.Opcode;
import memory.Mem;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\n");
        // Create a new CPU and Memory instance
        CPU cpu = new CPU();
        Mem memory = new Mem();

        cpu.reset(memory);

        // test LDA Immediate
        memory.setByte((char)0xFFFC, Opcode.LDA_IM.getCode());
        memory.setByte((char)0xFFFD, (byte)0x84);
        cpu.execute(2, memory);

        cpu.print_registers();
        cpu.print_status();
        System.out.println("\n\n");
    }
}
