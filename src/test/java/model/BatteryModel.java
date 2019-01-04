package model;

public class BatteryModel {
    private String batteryTime;
    private String batterySize;
    private String batteryCellAmount;
    private String batteryType;

    public BatteryModel(String batteryTime, String batterySize, String batteryCellAmount, String batteryType) {
        this.batteryTime = batteryTime;
        this.batterySize = batterySize;
        this.batteryCellAmount = batteryCellAmount;
        this.batteryType = batteryType;
    }

    public String getBatteryTime() {
        return batteryTime;
    }

    public void setBatteryTime(String batteryTime) {
        this.batteryTime = batteryTime;
    }

    public String getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(String batterySize) {
        this.batterySize = batterySize;
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
