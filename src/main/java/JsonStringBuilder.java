public class JsonStringBuilder {
    public String getJsonLine(String description, String status, String createdAt, String updatedAt) {
        return getStringWithComma("description", description) +
                getStringWithComma("status", status) +
                getStringWithComma("createdAt", createdAt) +
                getStringWithoutComma("updatedAt", updatedAt);
    }

    public String getStringWithComma(String key, String value) {
        return "\"" + key + "\"" + ":" + " " + "\"" + value + "\"" + ", ";
    }

    public String getStringWithoutComma(String key, String value) {
        return "\"" + key + "\"" + ":" + " " + "\"" + value + "\"";
    }

    public String[] deJsonify(String string) {
        string = string.replace("{", "")
                .replace("},", "")
                .replace("}", "")
                .replace("\"", "")
                .replace(": ", ", ");
        return string.split(", ");
    }
}
