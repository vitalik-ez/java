package laba;

public class CramerController {
    private Cramer model;
    private CramerView view;

    public CramerController(Cramer model, CramerView view) {
        this.model = model;
        this.view = view;
    }

    public double[] getCramerResult() {
        return model.getResult();
    }

    public void setCramerColumn(double[] column) {
        model.setColumn(column);
    }

    public double[] calcCramerMatrix() {
        double[] result = model.calcMatrix();
        return result;
    }

    public void updateView() {
        view.printCramerDetails(model.getMatrix(), model.getColumn(), model.getResult());
    }
}
