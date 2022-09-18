package assets;

public class Participant {
    private String name;
    private String phone;
    private String gender;
    private String address;
    private int day;
    private String month;
    private int year;
    private int point = 0;

    public Participant(String name, String phone, String gender, String address, int day, String month, int year) {
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        this.address = this.address.replaceAll("\n", " - ");
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getPoint() {
        return point;
    }

    public void increasePoint(){
        this.point++;
    }

    public String getBirthDate(){
        return day + " " + month + " " + year;
    }
}
