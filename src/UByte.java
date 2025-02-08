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

    public UByte multiply(UByte other){
        return new UByte((this.value * other.value) & 0xFF);
    }

    // Display the value as an unsigned short
    @Override
    public String toString() {
        return Integer.toString(value);  // Prints as an unsigned integer
    }
}
