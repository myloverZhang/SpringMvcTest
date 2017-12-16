package ct.dc.pc.api.model.serialize;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/4/7.
 */
public class GameInfo implements Serializable{
    private Integer clazz;
    private Integer id;
    private String name;
    private String code;

    public Integer getClazz() {
        return clazz;
    }

    public void setClazz(Integer clazz) {
        this.clazz = clazz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "GameInfo{" +
                "clazz=" + clazz +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
