public class ProcessorStatus {
    private byte flags = 0b01111111;
    private final String flag_order = "CZIDBVN0";

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

    public void set_flag(char flag_c, boolean set) throws IllegalArgumentException {
        int i = get_index(flag_c);
        
        if (set) {
            this.flags = (byte) (this.flags | (1 << i)); // Set the i-th bit to 1
        } else {
            this.flags = (byte) (this.flags & ~(1 << i)); // Set the i-th bit to 0
        }
    }

    public void set_flags(char[] flags, boolean set) {
        for (char flag : flags) {
            set_flag(flag, set);
        }
    }

    public void prettyPrint() {
        System.out.println("CZIDBVN0");
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append((this.flags & (1 << i)) == 0 ? '0' : '1');
        }
        return sb.toString();
    }
}
