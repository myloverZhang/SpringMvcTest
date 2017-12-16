package ct.dc.pc.api.model.serialize;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/19.
 */
public class ChannelInfo implements Serializable{
    private ArrayList<Integer> tags;
    private Integer status;
    private Integer payId;
    private Integer gameId;
    private Integer os;
    private String gameName;
    private String channName;
    private Long channId;

    public ChannelInfo() {
    }

    public ArrayList<Integer> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Integer> tags) {
        this.tags = tags;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getOs() {
        return os;
    }

    public void setOs(Integer os) {
        this.os = os;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getChannName() {
        return channName;
    }

    public void setChannName(String channName) {
        this.channName = channName;
    }

    public Long getChannId() {
        return channId;
    }

    public void setChannId(Long channId) {
        this.channId = channId;
    }


}
