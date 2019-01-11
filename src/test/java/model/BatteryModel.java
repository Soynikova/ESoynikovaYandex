package model;

public class BatteryModel {
    private String batteryTime;

    private String batteryCellAmount;
    private String batteryType;

    public BatteryModel(String batteryTime, String batteryCellAmount, String batteryType) {
        this.batteryTime = batteryTime;
        this.batteryCellAmount = batteryCellAmount;
        this.batteryType = batteryType;
    }

    public String getBatteryTime() {
        return batteryTime;
    }

    public void setBatteryTime(String batteryTime) {
        this.batteryTime = batteryTime;
    }



    public String getBatteryCellAmount() {
        return batteryCellAmount;
    }

    public void setBatteryCellAmount(String batteryCellAmount) {
        this.batteryCellAmount = batteryCellAmount;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }
}
