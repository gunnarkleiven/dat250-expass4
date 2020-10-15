import com.google.gson.Gson;

public class Todo {
    private Long id;
    private String summary;
    private String description;

    // TODO automatically generate id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Todo [summary=" + summary + ", description=" + description
                + "]";
    }

    String toJson () {

        Gson gson = new Gson();

        String jsonInString = gson.toJson(this);

        return jsonInString;
    }

}