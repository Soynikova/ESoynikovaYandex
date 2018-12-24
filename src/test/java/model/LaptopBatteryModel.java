package model;

import java.util.Map;

public class LaptopBatteryModel {
    private String batteryTime;
    private String batterySize;
    private String batteryCellAmount;
    private String batteryType;
    private String batteryChargeTime;

    public LaptopBatteryModel(Map<String, String> model) {
        for(Map.Entry<String, String> entry: model.entrySet())
        switch (entry.getKey()) {

            case "Время работы от аккумулятора": {
                batteryTime = entry.getValue();
                break;
            }
            case "Емкость аккумулятора": {
                batterySize = entry.getValue();
                break;
            }
            case "Количество ячеек аккумулятора": {
                batteryCellAmount = entry.getValue();
                break;
            }
            case "Тип аккумулятора": {
                batteryType = entry.getValue();
                break;
            }
            case "Время зарядки аккумулятора": {
                batteryChargeTime = entry.getValue();
                break;
            }
        }
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

    public String getBatteryChargeTime() {
        return batteryChargeTime;
    }

    public void setBatteryChargeTime(String batteryChargeTime) {
        this.batteryChargeTime = batteryChargeTime;
    }
}
