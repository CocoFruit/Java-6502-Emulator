public class UWord {
    private int value;

    public UWord(int value) {
        // ensure the value is between 0-65535
        this.value = value & 0xFFFF;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value){
        this.value = value & 0xFFFF; // make sure in bounds
    }

    public UWord add(UWord other){
        return new UWord((this.value + other.value) & 0xFFFF);
    }

    public UWord subtract(UWord other){
        return new UWord((this.value - other.value) & 0xFFFF);
    }

    public UWord multiply(UWord other){
        return new UWord((this.value * other.value) & 0xFFFF);
    }

    // Display the value as an unsigned short
    @Override
    public String toString() {
        return Integer.toString(value);  // Prints as an unsigned integer
    }
}
