public class Mem {
    // Define maximum memory size (64K) as a constant.
    private static final int MAX_MEM = 1024 * 64;
    
    // The data array holds 64K UByte values.
    private final UByte[] data = new UByte[MAX_MEM];

    /**
     * Constructs a new memory object and initializes it.
     */
    public Mem() {
        initialize();
    }

    /**
     * Initializes the memory by setting every byte to 0.
     */
    public void initialize() {
        for (int i = 0; i < MAX_MEM; i++) {
            data[i] = new UByte(0);
        }
    }

    /**
     * Retrieves a byte from memory at the given int address.
     *
     * @param address an integer address (0 to MAX_MEM - 1)
     * @return the UByte stored at that address
     * @throws IndexOutOfBoundsException if the address is out of bounds
     */
    public UByte getByte(int address) {
        if (address < 0 || address >= MAX_MEM) {
            throw new IndexOutOfBoundsException("Memory out of bounds: " + address);
        }
        return data[address];
    }

    /**
     * Retrieves a byte from memory using a UWord address.
     *
     * @param address a UWord representing the address
     * @return the UByte stored at that address
     */
    public UByte getByte(UWord address) {
        return getByte(address.getValue());
    }

    /**
     * Retrieves a byte from memory using a UByte address.
     *
     * @param address a UByte representing the address
     * @return the UByte stored at that address
     */
    public UByte getByte(UByte address) {
        return getByte(address.getValue());
    }

    /**
     * Sets a byte in memory at the given int address.
     *
     * @param address an integer address (0 to MAX_MEM - 1)
     * @param value the UByte value to store
     * @throws IndexOutOfBoundsException if the address is out of bounds
     */
    public void setByte(int address, UByte value) {
        if (address < 0 || address >= MAX_MEM) {
            throw new IndexOutOfBoundsException("Memory out of bounds: " + address);
        }
        data[address] = value;
    }

    /**
     * Sets a byte in memory using a UWord address.
     *
     * @param address a UWord representing the address
     * @param value the UByte value to store
     */
    public void setByte(UWord address, UByte value) {
        setByte(address.getValue(), value);
    }

    /**
     * Sets a byte in memory using a UByte address.
     *
     * @param address a UByte representing the address
     * @param value the UByte value to store
     */
    public void setByte(UByte address, UByte value) {
        setByte(address.getValue(), value);
    }

    /**
     * Sets a 16-bit word in memory at the given UWord address.
     * This method stores the low byte at the specified address and the high byte at the next address.
     *
     * @param address the starting address where the word will be stored
     * @param value the UWord value to store
     * @throws IndexOutOfBoundsException if the word does not fit in memory
     */
    public void setWord(UWord address, UWord value) {
        int addr = address.getValue();
        if (addr < 0 || addr >= MAX_MEM - 1) {
            throw new IndexOutOfBoundsException("Memory out of bounds: " + addr);
        }
        setByte(addr, value.getLowByte());
        setByte(addr + 1, value.getHighByte());
    }

    /**
     * Prints the entire memory contents in hexadecimal, 16 bytes per line.
     */
    public void printMemory() {
        for (int i = 0; i < MAX_MEM; i++) {
            System.out.printf("0x%04X: 0x%02X  ", i, data[i].getValue());
            if ((i + 1) % 16 == 0) {
                System.out.println();
            }
        }
    }
}
