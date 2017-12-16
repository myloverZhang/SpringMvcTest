package ct.dc.pc.api.model.serialize;

import java.io.Serializable;

/**
 * Created by CTWLPC on 2017/9/15.
 */
public class ChannelTagSerInfo implements Serializable{
    private String name;
    private Integer status;
    private Integer id;
    private Integer type;

    public ChannelTagSerInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ChannelTagSerInfo{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", id=" + id +
                ", type=" + type +
                '}';
    }
}
