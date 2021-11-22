package model;

public class Security {
    private String name;
    private String id;

    public Security() {
    }

    public Security(String name) {
        this.name = name;
    }

    public Security(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
