package memory;

public class Mem {
    private static final int MAX_MEM = 1024 * 64;
    private final byte[] data = new byte[MAX_MEM];

    public Mem(){
        initialize();
    }

    public void initialize(){
        for(int i = 0; i < MAX_MEM; i++){
            data[i] = (byte) 0;
        }
    }

    public byte getByte(char address){
        return data[address];
    }

    public void setByte(char address, byte value){
        data[address] = value;
    }
}
