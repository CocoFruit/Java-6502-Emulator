public class ProcessorStatus {
    private byte flags = 0b01111111;
    private final String flag_order = "0CZIDBVN";

    private void n_flip(int n) {
        this.flags = (byte) (this.flags ^ (1 << n));
    }

    private int get_index(char flag_c) throws IllegalArgumentException {
        int i = this.flag_order.indexOf(flag_c);
        if (i == -1) {
            throw new IllegalArgumentException("Invalid flag: " + flag_c);
        }
        return i;
    }

    public void flag_flip(char flag_c) {
        int i = get_index(flag_c);
        this.n_flip(i);
    }

    public void flag_set(char flag_c, boolean set) throws IllegalArgumentException {
        int i = get_index(flag_c);
        
        if (set) {
            this.flags = (byte) (this.flags | (1 << i)); // Set the i-th bit to 1
        } else {
            this.flags = (byte) (this.flags & ~(1 << i)); // Set the i-th bit to 0
        }
    }

    public void set_flags(char[] flags, boolean set) {
        for (char flag : flags) {
            flag_set(flag, set);
        }
    }
}
