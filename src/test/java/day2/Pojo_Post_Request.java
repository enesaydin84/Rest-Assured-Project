package day2;

public class Pojo_Post_Request {
    String name;
    String location;
    String phone;

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    String courses[];
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String[] getCourses() {
        return courses;
    }



}
