package ct.dc.mobile.api.model.domain.report;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/17.
 */
public class ReportGameLoginDo implements Serializable{
    private int date;
    private long app;
    private String appName;
    private int times;
    private int users1D1;
    private int users3D1;
    private int users7D1;
    private int users14D1;
    private int users30D1;
    private int hards1D1;
    private int hards3D1;
    private int hards7D1;
    private int hards14D1;
    private int hards30D1;

    public ReportGameLoginDo() {
    }

    public ReportGameLoginDo(int date, long app, String appName, int times, int users1D1, int users3D1, int users7D1, int users14D1, int users30D1, int hards1D1, int hards3D1, int hards7D1, int hards14D1, int hards30D1) {
        this.date = date;
        this.app = app;
        this.appName = appName;
        this.times = times;
        this.users1D1 = users1D1;
        this.users3D1 = users3D1;
        this.users7D1 = users7D1;
        this.users14D1 = users14D1;
        this.users30D1 = users30D1;
        this.hards1D1 = hards1D1;
        this.hards3D1 = hards3D1;
        this.hards7D1 = hards7D1;
        this.hards14D1 = hards14D1;
        this.hards30D1 = hards30D1;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public long getApp() {
        return app;
    }

    public void setApp(long app) {
        this.app = app;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getUsers1D1() {
        return users1D1;
    }

    public void setUsers1D1(int users1D1) {
        this.users1D1 = users1D1;
    }

    public int getUsers3D1() {
        return users3D1;
    }

    public void setUsers3D1(int users3D1) {
        this.users3D1 = users3D1;
    }

    public int getUsers7D1() {
        return users7D1;
    }

    public void setUsers7D1(int users7D1) {
        this.users7D1 = users7D1;
    }

    public int getUsers14D1() {
        return users14D1;
    }

    public void setUsers14D1(int users14D1) {
        this.users14D1 = users14D1;
    }

    public int getUsers30D1() {
        return users30D1;
    }

    public void setUsers30D1(int users30D1) {
        this.users30D1 = users30D1;
    }

    public int getHards1D1() {
        return hards1D1;
    }

    public void setHards1D1(int hards1D1) {
        this.hards1D1 = hards1D1;
    }

    public int getHards3D1() {
        return hards3D1;
    }

    public void setHards3D1(int hards3D1) {
        this.hards3D1 = hards3D1;
    }

    public int getHards7D1() {
        return hards7D1;
    }

    public void setHards7D1(int hards7D1) {
        this.hards7D1 = hards7D1;
    }

    public int getHards14D1() {
        return hards14D1;
    }

    public void setHards14D1(int hards14D1) {
        this.hards14D1 = hards14D1;
    }

    public int getHards30D1() {
        return hards30D1;
    }

    public void setHards30D1(int hards30D1) {
        this.hards30D1 = hards30D1;
    }
}
