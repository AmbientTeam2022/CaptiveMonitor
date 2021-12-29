package cl.inacap.tdis08.sapo.captivemonitor.model;

public class TankPreset {

    private Range soilHumidity;
    private Range soilTemperature;
    private Range roomHumidity;
    private Range roomTemperature;
    private Range waterLevel;
    private Range waterTemperature;

    public TankPreset() {
    }

    public TankPreset(int[][] ranges) {
        setSoilHumidity      (ranges[0][0], ranges[0][1]);
        setSoilTemperature   (ranges[1][0], ranges[1][1]);
        setRoomHumidity      (ranges[2][0], ranges[2][1]);
        setRoomTemperature   (ranges[3][0], ranges[3][1]);
        setWaterLevel        (ranges[4][0], ranges[4][1]);
        setWaterTemperature  (ranges[5][0], ranges[5][1]);
    }

    public Range getSoilHumidity() {
        return soilHumidity;
    }

    public Range getSoilTemperature() {
        return soilTemperature;
    }

    public Range getRoomHumidity() {
        return roomHumidity;
    }

    public Range getRoomTemperature() {
        return roomTemperature;
    }

    public Range getWaterLevel() {
        return waterLevel;
    }

    public Range getWaterTemperature() {
        return waterTemperature;
    }

    public void setSoilHumidity(int min, int max) {
        this.soilHumidity = new Range(min, max);
    }

    public void setSoilTemperature(int min, int max) {
        this.soilTemperature = new Range(min, max);;
    }

    public void setRoomHumidity(int min, int max) {
        this.roomHumidity = new Range(min, max);;
    }

    public void setRoomTemperature(int min, int max) {
        this.roomTemperature = new Range(min, max);;
    }

    public void setWaterLevel(int min, int max) {
        this.waterLevel = new Range(min, max);;
    }

    public void setWaterTemperature(int min, int max) {
        this.waterTemperature = new Range(min, max);;
    }

    public class Range {
        private int min;
        private int max;

        public Range(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }
    }

}
