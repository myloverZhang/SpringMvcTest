package ct.dc.mobile.api.model.domain.app;

/**
 * Created by B41-80 on 2017/1/9.
 */
public class AppRegByMonthDo {
    private int month;
    private int users;
    private int hards;

    public AppRegByMonthDo(int month, int users, int hards) {
        this.month = month;
        this.users = users;
        this.hards = hards;
    }

    public AppRegByMonthDo() {
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public int getHards() {
        return hards;
    }

    public void setHards(int hards) {
        this.hards = hards;
    }
}
