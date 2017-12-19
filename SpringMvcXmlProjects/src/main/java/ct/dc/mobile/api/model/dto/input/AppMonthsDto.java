package ct.dc.mobile.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/9.
 */
public class AppMonthsDto implements Serializable{
    private Long appId;//应用id
    private Integer beginMonth;//开始月份
    private Integer endMonth;//结束月份

    public AppMonthsDto() {
    }

    public AppMonthsDto(Long appId, Integer beginMonth, Integer endMonth) {
        this.appId = appId;
        this.beginMonth = beginMonth;
        this.endMonth = endMonth;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Integer getBeginMonth() {
        return beginMonth;
    }

    public void setBeginMonth(Integer beginMonth) {
        this.beginMonth = beginMonth;
    }

    public Integer getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(Integer endMonth) {
        this.endMonth = endMonth;
    }

    @Override
    public String toString() {
        return "AppMonthsDto{" +
                "appId=" + appId +
                ", beginMonth=" + beginMonth +
                ", endMonth=" + endMonth +
                '}';
    }
}
