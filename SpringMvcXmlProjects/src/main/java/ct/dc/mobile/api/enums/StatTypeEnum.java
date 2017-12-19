package ct.dc.mobile.api.enums;

/**
 * Created by B41-80 on 2017/1/5.
 */
public enum StatTypeEnum {
    DEFAULT(0),
    /**
     * 账号
     */
    ACCOUNT(1),
    /**
     * 设备
     */
    HARD(2);

    private final int value;

    StatTypeEnum(int value) {
        this.value = value;
    }

    public static StatTypeEnum valueOf(int num) {
        switch ( num ) {
            case 1:
                return ACCOUNT;
            case 2:
                return HARD;
            default:
                return DEFAULT;
        }
    }

    public int getValue() {
        return this.value;
    }
}
