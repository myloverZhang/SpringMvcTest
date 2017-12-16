package ct.dc.pc.api.model.serialize;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/9/15.
 */
public class ChannelTagJsonInfo implements Serializable{
    private String message;
    private ArrayList<ChannelTagSerInfo> data;
    private Boolean status;
    private Integer code;

    public ChannelTagJsonInfo() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<ChannelTagSerInfo> getData() {
        return data;
    }

    public void setData(ArrayList<ChannelTagSerInfo> data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ChannelTagJsonInfo{" +
                "message='" + message + '\'' +
                ", data=" + data +
                ", status=" + status +
                ", code=" + code +
                '}';
    }
}
