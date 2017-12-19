package ct.dc.mobile.api.model.domain.report;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/17.
 */
public class ReportAreaRegDo implements Serializable{
    private Integer date;
    private String province;
    private String provinceName;
    private String city;
    private String cityName;
    private Integer users;
    private Integer hards;

    public ReportAreaRegDo() {
    }

    public ReportAreaRegDo(Integer date, String province, String provinceName, String city, String cityName, Integer users, Integer hards) {
        this.date = date;
        this.province = province;
        this.provinceName = provinceName;
        this.city = city;
        this.cityName = cityName;
        this.users = users;
        this.hards = hards;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getUsers() {
        return users;
    }

    public void setUsers(Integer users) {
        this.users = users;
    }

    public Integer getHards() {
        return hards;
    }

    public void setHards(Integer hards) {
        this.hards = hards;
    }

    @Override
    public String toString() {
        return "ReportAreaRegDo{" +
                "date=" + date +
                ", province='" + province + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", city='" + city + '\'' +
                ", cityName='" + cityName + '\'' +
                ", users=" + users +
                ", hards=" + hards +
                '}';
    }
}
