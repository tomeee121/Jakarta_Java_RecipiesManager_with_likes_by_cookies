package RecipiesMS.JavaModels;

public class Log {
    private String ip;
    private String userAgent;
    private Integer recipeId;

    public Log(String ip, String userAgent, Integer recipeId) {
        this.ip = ip;
        this.userAgent = userAgent;
        this.recipeId = recipeId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }
}
