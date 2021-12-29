package cl.inacap.tdis08.sapo.captivemonitor.model;

public class TankState {

    private double soilHumidity;
    private double soilTemperature;
    private double roomHumidity;
    private double roomTemperature;
    private double waterLevel;
    private double waterTemperature;

    public TankState() {
    }

    public TankState(double soilHumidity, double soilTemperature, double roomHumidity, double roomTemperature, double waterLevel, double waterTemperature) {
        this.soilHumidity = soilHumidity;
        this.soilTemperature = soilTemperature;
        this.roomHumidity = roomHumidity;
        this.roomTemperature = roomTemperature;
        this.waterLevel = waterLevel;
        this.waterTemperature = waterTemperature;
    }

    public double getSoilHumidity() {
        return soilHumidity;
    }

    public void setSoilHumidity(double soilHumidity) {
        this.soilHumidity = soilHumidity;
    }

    public double getSoilTemperature() {
        return soilTemperature;
    }

    public void setSoilTemperature(double soilTemperature) {
        this.soilTemperature = soilTemperature;
    }

    public double getRoomHumidity() {
        return roomHumidity;
    }

    public void setRoomHumidity(double roomHumidity) {
        this.roomHumidity = roomHumidity;
    }

    public double getRoomTemperature() {
        return roomTemperature;
    }

    public void setRoomTemperature(double roomTemperature) {
        this.roomTemperature = roomTemperature;
    }

    public double getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(double waterLevel) {
        this.waterLevel = waterLevel;
    }

    public double getWaterTemperature() {
        return waterTemperature;
    }

    public void setWaterTemperature(double waterTemperature) {
        this.waterTemperature = waterTemperature;
    }

    @Override
    public String toString() {
        return "TankState{" +
                "soilHumidity=" + soilHumidity +
                ", soilTemperature=" + soilTemperature +
                ", roomHumidity=" + roomHumidity +
                ", roomTemperature=" + roomTemperature +
                ", waterLevel=" + waterLevel +
                ", waterTemperature=" + waterTemperature +
                '}';
    }
}
