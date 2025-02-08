

class Main{
    public static void main(String[] args){
        CPU cpu = new CPU();
        Mem memory = new Mem();
        cpu.Reset(memory);
    }
}