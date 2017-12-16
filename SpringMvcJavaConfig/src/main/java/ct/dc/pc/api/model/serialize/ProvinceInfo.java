package ct.dc.pc.api.model.serialize;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/17.
 */
public class ProvinceInfo implements Serializable{
    private String provinceCode;
    private String provinceName;

    public ProvinceInfo() {
    }

    public ProvinceInfo(String provinceCode, String provinceName) {
        this.provinceCode = provinceCode;
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        return "ProvinceInfo{" +
                "provinceCode='" + provinceCode + '\'' +
                ", provinceName='" + provinceName + '\'' +
                '}';
    }
}
