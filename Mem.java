public class Mem {
    final int MAX_MEM = 1024 * 64;
    UByte[] Data = new UByte[MAX_MEM];

    public void Initialize(){
        for(int i = 0; i < MAX_MEM; i++){
            Data[i] = new UByte(0);
        }
    }

}
