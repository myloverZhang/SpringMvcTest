package ct.dc.pc.api.model.domain.channel;

/**
 * Created by CTWLPC on 2017/7/6.
 */
public class BriefSumDO {
    private Long channel;
    private Integer type;
    private Long reg;
    private Long login;

    public BriefSumDO() {
        channel = 0L;
        reg = 0L;
        login = 0L;
    }

    public BriefSumDO(Long channel, Integer type, Long reg, Long login) {
        this.channel = channel;
        this.type = type;
        this.reg = reg;
        this.login = login;
    }

    public Long getChannel() {
        return channel;
    }

    public void setChannel(Long channel) {
        this.channel = channel;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getReg() {
        return reg;
    }

    public void setReg(Long reg) {
        this.reg = reg;
    }

    public Long getLogin() {
        return login;
    }

    public void setLogin(Long login) {
        this.login = login;
    }
}
