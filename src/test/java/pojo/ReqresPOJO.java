package pojo;

public class ReqresPOJO {

    private String name;
    private String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public ReqresPOJO(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public ReqresPOJO() {
    }

    @Override
    public String toString() {
        return "ReqresPOJO{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

}
