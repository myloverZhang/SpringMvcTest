package ct.dc.pc.api.model.serialize;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/7.
 */
public class GameJsonInfo implements Serializable{
    private Boolean status;
    private ArrayList<GameInfo> data;
    private String message;
    private Integer code;

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setData(ArrayList<GameInfo> data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getStatus() {
        return status;
    }

    public ArrayList<GameInfo> getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "GameJsonInfo{" +
                "status=" + status +
                ", data=" + data +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
