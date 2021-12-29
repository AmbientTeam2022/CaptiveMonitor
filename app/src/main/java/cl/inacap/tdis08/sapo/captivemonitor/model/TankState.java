package cl.inacap.tdis08.sapo.captivemonitor.model;

public class TankState {

    private int soilHumidity;
    private int soilTemperature;
    private int roomHumidity;
    private int roomTemperature;
    private int waterLevel;
    private int waterTemperature;

    public TankState() {
    }

    public TankState(int soilHumidity, int soilTemperature, int roomHumidity, int roomTemperature, int waterLevel, int waterTemperature) {
        this.soilHumidity = soilHumidity;
        this.soilTemperature = soilTemperature;
        this.roomHumidity = roomHumidity;
        this.roomTemperature = roomTemperature;
        this.waterLevel = waterLevel;
        this.waterTemperature = waterTemperature;
    }

    public int getSoilHumidity() {
        return soilHumidity;
    }

    public void setSoilHumidity(int soilHumidity) {
        this.soilHumidity = soilHumidity;
    }

    public int getSoilTemperature() {
        return soilTemperature;
    }

    public void setSoilTemperature(int soilTemperature) {
        this.soilTemperature = soilTemperature;
    }

    public int getRoomHumidity() {
        return roomHumidity;
    }

    public void setRoomHumidity(int roomHumidity) {
        this.roomHumidity = roomHumidity;
    }

    public int getRoomTemperature() {
        return roomTemperature;
    }

    public void setRoomTemperature(int roomTemperature) {
        this.roomTemperature = roomTemperature;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public int getWaterTemperature() {
        return waterTemperature;
    }

    public void setWaterTemperature(int waterTemperature) {
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
