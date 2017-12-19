package ct.dc.mobile.api.model.dto.output;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/17.
 */
public class ReportResultsDto implements Serializable{
    private Boolean status;
    private Object data;

    public ReportResultsDto() {
    }

    public ReportResultsDto(Boolean status, Object data) {
        this.status = status;
        this.data = data;
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

    @Override
    public String toString() {
        return "ReportResultsDto{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
