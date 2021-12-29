package cl.inacap.tdis08.sapo.captivemonitor.model;

public class TankParams {

    private Range soilHumidity;
    private Range soilTemperature;
    private Range roomHumidity;
    private Range roomTemperature;
    private Range waterLevel;
    private Range waterTemperature;

    public TankParams() {
    }

    public TankParams(TankPreset preset) {
        soilHumidity     = preset.getSoilHumidity();
        soilTemperature  = preset.getSoilTemperature();
        roomHumidity     = preset.getRoomHumidity();
        roomTemperature  = preset.getRoomTemperature();
        waterLevel       = preset.getWaterLevel();
        waterTemperature = preset.getWaterTemperature();
    }

    public Range getSoilHumidity() {
        return soilHumidity;
    }

    public void setSoilHumidity(Range soilHumidity) {
        this.soilHumidity = soilHumidity;
    }

    public Range getSoilTemperature() {
        return soilTemperature;
    }

    public void setSoilTemperature(Range soilTemperature) {
        this.soilTemperature = soilTemperature;
    }

    public Range getRoomHumidity() {
        return roomHumidity;
    }

    public void setRoomHumidity(Range roomHumidity) {
        this.roomHumidity = roomHumidity;
    }

    public Range getRoomTemperature() {
        return roomTemperature;
    }

    public void setRoomTemperature(Range roomTemperature) {
        this.roomTemperature = roomTemperature;
    }

    public Range getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(Range waterLevel) {
        this.waterLevel = waterLevel;
    }

    public Range getWaterTemperature() {
        return waterTemperature;
    }

    public void setWaterTemperature(Range waterTemperature) {
        this.waterTemperature = waterTemperature;
    }
}
