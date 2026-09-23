package model;

public class Manager {


    private  int mid;

    private  String mName;

    public Manager(int mid, String mName) {
        this.mid = mid;
        this.mName = mName;
    }

    public Manager() {
    }


    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getmName() {
        return mName;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mid=" + mid +
                ", mName='" + mName + '\'' +
                '}';
    }


    public void setmName(String mName) {
        this.mName = mName;
    }
}
