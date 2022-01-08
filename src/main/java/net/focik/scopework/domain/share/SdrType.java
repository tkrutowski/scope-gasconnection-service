package net.focik.scopework.domain.share;

public enum SdrType {
    SDR_11("SDR 11"),
    SDR_17_6("SDR 17,6");

    private String dbValue;

    SdrType(String dbValue) {
        this.dbValue = dbValue;
    }


    public String getDbValue() {
        return dbValue;
    }

    public void setDbValue(String dbValue) {
        this.dbValue = dbValue;
    }

    public static SdrType fromDbValue(String dbValue){
        switch (dbValue){
            case "SDR 11":
                return SdrType.SDR_11;
            case "SDR 17,6":
                return SdrType.SDR_17_6;

            default:
                throw new IllegalArgumentException("Value [" + dbValue
                        + "] not supported.");
        }
    }
}
