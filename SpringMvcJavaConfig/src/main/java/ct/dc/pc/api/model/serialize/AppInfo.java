package ct.dc.pc.api.model.serialize;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/17.
 */
public class AppInfo implements Serializable{
    private String gameCode;
    private Integer appId;
    private String appCode;
    private Integer platForm;
    private Integer gameId;
    private Integer type;
    private String appName;

    public AppInfo() {
    }

    public AppInfo(String gameCode, Integer appId, String appCode, Integer platForm, Integer gameId, Integer type,
                   String appName) {
        this.gameCode = gameCode;
        this.appId = appId;
        this.appCode = appCode;
        this.platForm = platForm;
        this.gameId = gameId;
        this.type = type;
        this.appName = appName;
    }

    public String getGameCode() {
        return gameCode;
    }

    public void setGameCode(String gameCode) {
        this.gameCode = gameCode;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Integer getPlatForm() {
        return platForm;
    }

    public void setPlatForm(Integer platForm) {
        this.platForm = platForm;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "gameCode='" + gameCode + '\'' +
                ", appId=" + appId +
                ", appCode='" + appCode + '\'' +
                ", platForm=" + platForm +
                ", gameId=" + gameId +
                ", type=" + type +
                ", appName='" + appName + '\'' +
                '}';
    }
}
