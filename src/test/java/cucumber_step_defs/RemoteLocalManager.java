package cucumber_step_defs;

public enum RemoteLocalManager {
    REMOTE("http://localhost:4444/wd/hub", "classpath:features"),
    LOCAL(null, "src/test/resources/features");

    final String hostAddress;
    final String featuresPath;

    RemoteLocalManager(String hostAddress, String featuresPath) {
        this.hostAddress = hostAddress;
        this.featuresPath = featuresPath;
    }

    public static RemoteLocalManager remoteLocalManager;

    public static RemoteLocalManager getRemoteLocalManager() {
        if (remoteLocalManager == null){
            remoteLocalManager = RemoteLocalManager.valueOf(System.getProperty("remoteLocal", "local").toUpperCase());
        }
        return remoteLocalManager;
    }
}
