package ct.dc.pc.api.model.serialize;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/17.
 */
public class ProvinceJsonInfo implements Serializable{
    private Boolean status;
    private String message;
    private ArrayList<ProvinceInfo> data;

    public ProvinceJsonInfo() {
    }

    public ProvinceJsonInfo(Boolean status, String message, ArrayList<ProvinceInfo> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<ProvinceInfo> getData() {
        return data;
    }

    public void setData(ArrayList<ProvinceInfo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ProvinceJsonInfo{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
