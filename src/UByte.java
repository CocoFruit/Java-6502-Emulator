/**
 * Represents an unsigned 8-bit value (0 to 255).
 */
public class UByte {
    private int value;

    /**
     * Constructs a new UByte with the specified value.
     * The value is masked to ensure it is within 0 to 255.
     *
     * @param value the initial value
     */
    public UByte(int value) {
        this.value = value & 0xFF;
    }

    /**
     * Returns the integer value of this UByte.
     *
     * @return the value in the range 0 to 255
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of this UByte.
     * The value is masked to ensure it is within 0 to 255.
     *
     * @param value the new value
     */
    public void setValue(int value) {
        this.value = value & 0xFF;
    }

    /**
     * Adds another UByte to this one.
     *
     * @param other the UByte to add
     * @return a new UByte representing the sum (modulo 256)
     */
    public UByte add(UByte other) {
        return new UByte((this.value + other.value) & 0xFF);
    }

    /**
     * Subtracts another UByte from this one.
     *
     * @param other the UByte to subtract
     * @return a new UByte representing the difference (modulo 256)
     */
    public UByte subtract(UByte other) {
        return new UByte((this.value - other.value) & 0xFF);
    }

    /**
     * Performs a bitwise AND with another UByte.
     *
     * @param other the UByte to AND with
     * @return a new UByte representing the result
     */
    public UByte and(UByte other) {
        return new UByte(this.value & other.value);
    }

    /**
     * Performs a bitwise OR with another UByte.
     *
     * @param other the UByte to OR with
     * @return a new UByte representing the result
     */
    public UByte or(UByte other) {
        return new UByte(this.value | other.value);
    }

    /**
     * Performs a bitwise XOR with another UByte.
     *
     * @param other the UByte to XOR with
     * @return a new UByte representing the result
     */
    public UByte xor(UByte other) {
        return new UByte(this.value ^ other.value);
    }

    /**
     * Returns the bitwise NOT of this UByte.
     *
     * @return a new UByte representing the complement
     */
    public UByte not() {
        return new UByte(~this.value & 0xFF);
    }

    /**
     * Shifts this UByte one bit to the left.
     *
     * @return a new UByte representing the result of the shift
     */
    public UByte shiftLeft() {
        return new UByte((this.value << 1) & 0xFF);
    }

    /**
     * Shifts this UByte one bit to the right.
     *
     * @return a new UByte representing the result of the shift
     */
    public UByte shiftRight() {
        return new UByte((this.value >> 1) & 0xFF);
    }

    /**
     * Determines whether this UByte is equal to another object.
     * Two UByte objects are considered equal if they represent the same value.
     *
     * @param obj the object to compare with
     * @return true if the other object is a UByte with the same value, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UByte)) return false;
        UByte other = (UByte) obj;
        return this.value == other.value;
    }

    /**
     * Returns a hash code for this UByte.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return value;
    }

    /**
     * Returns a string representation of this UByte in hexadecimal format.
     *
     * @return a string formatted as "0xXX" (e.g., "0x2A")
     */
    @Override
    public String toString() {
        return String.format("0x%02X", value);
    }
}
