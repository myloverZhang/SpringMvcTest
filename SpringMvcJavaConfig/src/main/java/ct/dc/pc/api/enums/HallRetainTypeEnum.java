package ct.dc.pc.api.enums;

/**
 * Created by B41-80 on 2017/4/6.
 */
public enum HallRetainTypeEnum {
    DEFAULT(0),
    /**
     * 本大厅
     */
    HALL(1),
    /**
     * pc平台
     */
    PC(2),
    /**
     * 移动平台
     */
    MOBILE(3),
    /**
     * 同城游app平台
     */
    TCYAPP(4),

    /**
     * 同城游全平台
     */
    TCY(5);

    private final int value;

    HallRetainTypeEnum(int value){
        this.value = value;
    }
    public static HallRetainTypeEnum valueOf(int num){
        switch (num){
            case 1:
                return HALL;
            case 2:
                return PC;
            case 3:
                return MOBILE;
            case 4:
                return TCYAPP;
            case 5:
                return TCY;
            default:
                return DEFAULT;
        }
    }
}
