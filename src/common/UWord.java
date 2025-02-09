package common;
/**
 * A class that represents a 16-bit unsigned word.
 * Values are stored in the range 0 to 0xFFFF.
 */
public class UWord {
    private int value;

    /**
     * Constructs a new UWord ensuring that the value is in the range 0 to 65535.
     *
     * @param value the initial value
     */
    public UWord(int value) {
        this.value = value & 0xFFFF;
    }

    /**
     * Returns the integer value of this UWord.
     *
     * @return the value in the range 0 to 65535
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of this UWord.
     *
     * @param value the new value (will be masked to 16 bits)
     */
    public void setValue(int value) {
        this.value = value & 0xFFFF;
    }

    /**
     * Adds another UWord to this one.
     *
     * @param other the UWord to add
     * @return a new UWord representing the sum
     */
    public UWord add(UWord other) {
        return new UWord((this.value + other.value) & 0xFFFF);
    }

    /**
     * Subtracts another UWord from this one.
     *
     * @param other the UWord to subtract
     * @return a new UWord representing the difference
     */
    public UWord subtract(UWord other) {
        return new UWord((this.value - other.value) & 0xFFFF);
    }

    /**
     * Multiplies this UWord by another UWord.
     *
     * @param other the UWord multiplier
     * @return a new UWord representing the product
     */
    public UWord multiply(UWord other) {
        return new UWord((this.value * other.value) & 0xFFFF);
    }

    /**
     * Returns the low byte (least significant 8 bits) of this UWord.
     *
     * @return the low byte as a UByte
     */
    public UByte getLowByte() {
        return new UByte(value & 0xFF);
    }

    /**
     * Returns the high byte (most significant 8 bits) of this UWord.
     *
     * @return the high byte as a UByte
     */
    public UByte getHighByte() {
        return new UByte((value >> 8) & 0xFF);
    }

    /**
     * Returns a hexadecimal string representation of this UWord.
     *
     * @return a string in the format "0xXXXX"
     */
    @Override
    public String toString() {
        return String.format("0x%04X", value);
    }

    /**
     * Checks whether this UWord is equal to another object.
     *
     * @param obj the object to compare with
     * @return true if obj is a UWord with the same value, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UWord)) return false;
        UWord other = (UWord) obj;
        return this.value == other.value;
    }

    /**
     * Returns the hash code for this UWord.
     *
     * @return the hash code based on the value
     */
    @Override
    public int hashCode() {
        return value;
    }
}
