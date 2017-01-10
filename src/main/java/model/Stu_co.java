package model;


public class Stu_co {
    private int stu_coid;
    private int stuid;
    private int coid;
    private double mark_co;

    public Stu_co() {
    }

    public double getMark_co() {
        return mark_co;
    }

    public void setMark_co(double mark_co) {
        this.mark_co = mark_co;
    }

    public int getCoid() {

        return coid;
    }

    public void setCoid(int coid) {
        this.coid = coid;
    }

    public int getStuid() {

        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public int getStu_coid() {

        return stu_coid;
    }

    public void setStu_coid(int stu_coid) {
        this.stu_coid = stu_coid;
    }
}
