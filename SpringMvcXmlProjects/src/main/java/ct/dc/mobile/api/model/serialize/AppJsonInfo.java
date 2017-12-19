package ct.dc.mobile.api.model.serialize;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/17.
 */
public class AppJsonInfo implements Serializable{
    private Boolean status;
    private String message;
    private ArrayList<AppInfo> data;


    public AppJsonInfo() {

    }

    public AppJsonInfo(Boolean status, String message, ArrayList<AppInfo> data) {
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

    public ArrayList<AppInfo> getData() {
        return data;
    }

    public void setData(ArrayList<AppInfo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AppJsonInfo{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
