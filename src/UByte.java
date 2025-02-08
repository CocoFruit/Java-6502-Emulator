// this byte is unsigned and 8 bits
public class UByte{
    private int value;

    public UByte(int value) {
        // ensure the value is between 0-255
        this.value = value & 0xFF;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value){
        this.value = value & 0xFF; // make sure in bounds
    }

    public UByte add(UByte other){
        return new UByte((this.value + other.value) & 0xFF);
    }

    public UByte subtract(UByte other){
        return new UByte((this.value - other.value) & 0xFF);
    }

    public UByte and(UByte other){
        return new UByte(this.value & other.value);
    }

    public UByte or(UByte other){
        return new UByte(this.value | other.value);
    }

    public UByte xor(UByte other){
        return new UByte(this.value ^ other.value);
    }

    public UByte not(){
        return new UByte(~this.value & 0xFF);
    }

    public UByte shiftLeft(){
        return new UByte((this.value << 1) & 0xFF);
    }

    public UByte shiftRight(){
        return new UByte((this.value >> 1) & 0xFF);
    }

    public boolean equals(UByte other){
        return this.value == other.value;
    }


    // Display the value as an unsigned short
    @Override
    public String toString() {
        return Integer.toString(value);  // Prints as an unsigned integer
    }
}
