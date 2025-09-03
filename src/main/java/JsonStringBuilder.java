public class JsonStringBuilder {
    public String getStringWithComma(String key, String value) {
        return "\"" + key + "\"" + ":" + " " + "\"" + value + "\"" + ",";
    }

    public String getStringWithoutComma(String key, String value) {
        return "\"" + key + "\"" + ":" + " " + "\"" + value + "\"";
    }
}
