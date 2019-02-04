package webDriver.Model;



public class Rim {

    private String rimMaker;
    private String rimModel;
    private int erd;


    public Rim(String rimMaker, String rimModel, int erd) {
        this.rimMaker = rimMaker;
        this.rimModel = rimModel;
        this.erd = erd;
    }

    public String getRimMaker() {
        return rimMaker;
    }

    public void setRimMaker(String rimMaker) {
        this.rimMaker = rimMaker;
    }

    public String getRimModel() {
        return rimModel;
    }

    public void setRimModel(String rimModel) {
        this.rimModel = rimModel;
    }

    public int getErd() {
        return erd;
    }

    public void setErd(int erd) {
        this.erd = erd;
    }

    @Override
    public String toString() {
        return "HUB [Maker:" + rimMaker + ", Model: " + rimModel + ", ERD: " + erd + "]";
    }
}

