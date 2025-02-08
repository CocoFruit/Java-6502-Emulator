public class Mem {
    final int MAX_MEM = 1024 * 64;
    UByte[] Data = new UByte[MAX_MEM];

    public void Initialize(){
        for(int i = 0; i < MAX_MEM; i++){
            Data[i] = new UByte(0);
        }
    }

    public UByte get_byte(UWord address) throws IndexOutOfBoundsException{
        if (address.getValue() > MAX_MEM){
            throw new IndexOutOfBoundsException("Memory out of bounds");
        }
        return Data[address.getValue()];
    }

    public void set_byte(UWord address, UByte value) throws IndexOutOfBoundsException {
        if (address.getValue() > MAX_MEM) {
            throw new IndexOutOfBoundsException("Memory out of bounds");
        }
        Data[address.getValue()] = value;
    }
    
    public void set_byte(int address, UByte value) throws IndexOutOfBoundsException {
        if (address > MAX_MEM) {
            throw new IndexOutOfBoundsException("Memory out of bounds");
        }
        Data[address] = value;
    }
    
    public void print_memory() {
        // Print memory in chunks of 16 bytes per line
        for (int i = 0; i < MAX_MEM; i++) {
            // Print the memory address (in hexadecimal) and its corresponding byte value
            System.out.printf("0x%04X: 0x%02X\n", i, Data[i].getValue());
    
            // Group 16 bytes per line for better readability
            if ((i + 1) % 16 == 0) {
                System.out.println(); // Add a newline after every 16 bytes
            }
        }
    }
    


}
