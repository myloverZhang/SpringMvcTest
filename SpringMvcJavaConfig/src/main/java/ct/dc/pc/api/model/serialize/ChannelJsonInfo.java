package ct.dc.pc.api.model.serialize;

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

    public ChannelJsonInfo(ArrayList<ChannelInfo> data) {

        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public ArrayList<ChannelInfo> getData() {
        return data;
    }

    public void setData(ArrayList<ChannelInfo> data) {
        this.data = data;
    }


}
