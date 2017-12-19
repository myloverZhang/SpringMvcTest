package ct.dc.mobile.api.model.serialize;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/17.
 */
public class CityInfo implements Serializable{
    private String provinceCode;
    private String cityCode;
    private String cityName;

    public CityInfo(String provinceCode, String cityCode, String cityName) {
        this.provinceCode = provinceCode;
        this.cityCode = cityCode;
        this.cityName = cityName;
    }

    public CityInfo() {
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "CityInfo{" +
                "provinceCode='" + provinceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
