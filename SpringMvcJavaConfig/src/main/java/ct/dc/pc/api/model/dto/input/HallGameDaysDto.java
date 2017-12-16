package ct.dc.pc.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/4/7.
 */
public class HallGameDaysDto implements Serializable{
    private Integer hallId;
    private Integer gameId;
    private Integer beginDate;
    private Integer endDate;

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Integer beginDate) {
        this.beginDate = beginDate;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "HallGameDaysDto{" +
                "hallId=" + hallId +
                ", gameId=" + gameId +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }
}
