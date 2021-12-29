package cl.inacap.tdis08.sapo.captivemonitor.model;

public class Tank {

    private String uuid;
    private String name;
    private int iconId;
    private String actionCache;
    private TankState state;
    private TankParams params;

    public Tank() {
    }

    public Tank(String uuid, String name, int iconId) {
        this.uuid = uuid;
        this.name = name;
        this.iconId = iconId;
    }

    public Tank(String uuid, String name, int iconId, String actionCache, TankState state) {
        this.uuid = uuid;
        this.name = name;
        this.iconId = iconId;
        this.actionCache = actionCache;
        this.state = state;
    }

    public Tank(String uuid, String name, int iconId, TankParams params) {
        this.uuid = uuid;
        this.name = name;
        this.iconId = iconId;
        this.params = params;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getActionCache() {
        return actionCache;
    }

    public void setActionCache(String actionCache) {
        this.actionCache = actionCache;
    }

    public TankState getState() {
        return state;
    }

    public void setState(TankState state) {
        this.state = state;
    }

    public TankParams getParams() {
        return params;
    }

    public void setParams(TankParams params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "Tank{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", iconId='" + iconId + '\'' +
                ", actionCache='" + actionCache + '\'' +
                ", state=" + state +
                '}';
    }
}
