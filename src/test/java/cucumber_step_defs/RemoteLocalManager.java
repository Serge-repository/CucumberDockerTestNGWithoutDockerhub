package cucumber_step_defs;

public enum RemoteLocalManager {
    REMOTE("http://localhost:4444/wd/hub"),
    LOCAL(null);

    final String hostAddress;

    RemoteLocalManager(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public static RemoteLocalManager remoteLocalManager;

    public static RemoteLocalManager getRemoteLocalManager() {
        if (remoteLocalManager == null){
            remoteLocalManager = RemoteLocalManager.valueOf(System.getProperty("remoteLocal", "local").toUpperCase());
        }
        return remoteLocalManager;
    }
}
