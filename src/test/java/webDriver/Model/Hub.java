package webDriver.Model;


public class Hub {


    private String hubMaker;
    private String hubModel;
    private int axleWidth;
    private int leftFlangeEnd;
    private int rightFlangeEnd;
    private int leftFlangeDiameter;
    private int rightFlangeDiameter;

    public Hub(){}

    public Hub(String hubMaker, String hubModel,
               int axleWidth, int leftFlangeEnd, int rightFlangeEnd,
               int leftFlangeDiameter, int rightFlangeDiameter) {
        this.hubMaker = hubMaker;
        this.hubModel = hubModel;
        this.axleWidth = axleWidth;
        this.leftFlangeEnd = leftFlangeEnd;
        this.rightFlangeEnd = rightFlangeEnd;
        this.leftFlangeDiameter = leftFlangeDiameter;
        this.rightFlangeDiameter = rightFlangeDiameter;
    }


    public String getHubMaker() {
        return hubMaker;
    }

    public void setHubMaker(String hubMaker) {
        this.hubMaker = hubMaker;
    }

    public String getHubModel() {
        return hubModel;
    }

    public void setHubModel(String hubModel) {
        this.hubModel = hubModel;
    }

    public int getAxleWidth() {
        return axleWidth;
    }

    public void setAxleWidth(int axleWidth) {
        this.axleWidth = axleWidth;
    }

    public int getLeftFlangeEnd() {
        return leftFlangeEnd;
    }

    public void setLeftFlangeEnd(int leftFlangeEnd) {
        this.leftFlangeEnd = leftFlangeEnd;
    }

    public int getRightFlangeEnd() {
        return rightFlangeEnd;
    }

    public void setRightFlangeEnd(int rightFlangeEnd) {
        this.rightFlangeEnd = rightFlangeEnd;
    }

    public int getLeftFlangeDiameter() {
        return leftFlangeDiameter;
    }

    public void setLeftFlangeDiameter(int leftFlangeDiameter) {
        this.leftFlangeDiameter = leftFlangeDiameter;
    }

    public int getRightFlangeDiameter() {
        return rightFlangeDiameter;
    }

    public void setRightFlangeDiameter(int rightFlangeDiameter) {
        this.rightFlangeDiameter = rightFlangeDiameter;
    }

    @Override
    public String toString() {
        return "Hub [Hub Maker: " + hubMaker +
                ", Hub Model: " + hubModel +
                ", Hub Axle Width: " + axleWidth +
                ", Hub Left Flange End: " + leftFlangeEnd +
                ", Hub Right Flange End: " + rightFlangeEnd +
                ", Hub Left Flange Diameter: " + leftFlangeDiameter +
                ", Hub Right Flange Diameter: " + rightFlangeDiameter +"]";
    }
}
