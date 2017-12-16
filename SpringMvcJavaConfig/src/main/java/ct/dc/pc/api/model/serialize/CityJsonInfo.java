package ct.dc.pc.api.model.serialize;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/17.
 */
public class CityJsonInfo implements Serializable{
    private Boolean status;
    private ArrayList<CityInfo> data;
    private String message;
    private Integer code;
    public CityJsonInfo() {
    }

    public CityJsonInfo(Boolean status, ArrayList<CityInfo> data, String message,Integer code) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ArrayList<CityInfo> getData() {
        return data;
    }

    public void setData(ArrayList<CityInfo> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CityJsonInfo{" +
                "status=" + status +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
