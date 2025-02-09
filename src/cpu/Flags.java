package cpu;
/**
 * Represents the processor status register with individual flag bits.
 * Each bit is associated with a flag, as defined by FLAG_ORDER.
 * For example, if FLAG_ORDER is "CZIDBVN0", then:
 * - Bit 0 represents the 'C' (carry) flag,
 * - Bit 1 represents the 'Z' (zero) flag,
 * - Bit 2 represents the 'I' (interrupt disable) flag,
 * - Bit 3 represents the 'D' (decimal) flag,
 * - Bit 4 represents the 'B' (break) flag,
 * - Bit 5 represents the 'V' (overflow) flag,
 * - Bit 6 represents the 'N' (negative) flag,
 * - Bit 7 is unused (or could be used as needed).
 */
public class Flags {
    private byte flags = 0b01111111;
    private static final String FLAG_ORDER = "CZIDBVN0";

    /**
     * Toggles (flips) the bit at the specified index.
     *
     * @param index the bit index to toggle
     */
    private void toggleBit(int index) {
        flags ^= (1 << index);
    }

    /**
     * Returns the index of the specified flag character in FLAG_ORDER.
     *
     * @param flagChar the flag character to look up
     * @return the index of the flag
     * @throws IllegalArgumentException if the flag character is invalid
     */
    private int getIndex(char flagChar) {
        int index = FLAG_ORDER.indexOf(flagChar);
        if (index == -1) {
            throw new IllegalArgumentException("Invalid flag: " + flagChar);
        }
        return index;
    }

    /**
     * Toggles the specified flag.
     *
     * @param flagChar the flag character to toggle
     */
    public void toggleFlag(char flagChar) {
        int index = getIndex(flagChar);
        toggleBit(index);
    }

    /**
     * Sets or clears the specified flag.
     *
     * @param flagChar the flag character
     * @param set      true to set the flag, false to clear it
     */
    public void setFlag(char flagChar, boolean set) {
        int index = getIndex(flagChar);
        if (set) {
            flags |= (1 << index);
        } else {
            flags &= ~(1 << index);
        }
    }

    /**
     * Sets or clears multiple flags.
     *
     * @param flagsArr an array of flag characters
     * @param set      true to set the flags, false to clear them
     */
    public void setFlags(char[] flagsArr, boolean set) {
        for (char flag : flagsArr) {
            setFlag(flag, set);
        }
    }

    /**
     * Prints a formatted view of the processor status.
     * The first line shows the flag order header,
     * and the second line shows the corresponding bit values.
     */
    public void prettyPrint() {
        System.out.println(FLAG_ORDER);
        System.out.println(this);
    }

    /**
     * Returns a string representing the flag bits.
     * Bits are printed in the order defined by FLAG_ORDER (from bit 0 to bit 7).
     *
     * @return a string of 8 characters ('1' or '0')
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            sb.append((flags & (1 << i)) != 0 ? '1' : '0');
        }
        return sb.toString();
    }
}
