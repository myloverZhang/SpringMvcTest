package ct.dc.mobile.api.model.dto.output;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/5.
 */
public class ResultDto implements Serializable{
    private Boolean status;
    private Object data;
    private String message;

    public ResultDto() {
    }

    public ResultDto(Boolean status, Object data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
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
        return "ResultDto{" +
                "status=" + status +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
