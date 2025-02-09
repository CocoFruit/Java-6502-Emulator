package cpu; // Ensure it's in the correct package

import java.util.HashMap;
import java.util.Map;

public enum Opcode {
    LDA_IM(0xA9), // Example opcode; add more as needed
    LDA_ZP(0xA5);

    private final byte code;

    private static final Map<Byte, Opcode> LOOKUP = new HashMap<>();

    // Static block to populate the lookup map
    static {
        for (Opcode op : Opcode.values()) {
            LOOKUP.put(op.code, op);
        }
    }

    Opcode(int code) {
        this.code = (byte) code;
    }

    public byte getCode() {
        return code;
    }

    public static Opcode fromByte(byte code) {
        return LOOKUP.get(code); // Returns null if the opcode is not found
    }
}
