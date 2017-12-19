package ct.dc.mobile.api.model.serialize;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/19.
 */
public class ChannelJsonInfo implements Serializable{
    private Integer code;
    private String message;
    private ArrayList<ChannelInfo> data;
    private Boolean status;

    public ChannelJsonInfo() {
    }

    public ChannelJsonInfo(Integer code, String message, ArrayList<ChannelInfo> data, Boolean status) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<ChannelInfo> getData() {
        return data;
    }

    public void setData(ArrayList<ChannelInfo> data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ChannelJsonInfo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", status=" + status +
                '}';
    }
}
