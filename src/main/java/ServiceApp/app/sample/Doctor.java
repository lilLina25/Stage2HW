package ServiceApp.app.sample;

public class Doctor {
    private int id;
    private String name;
    private int clinic_id;
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getClinic_id(){
        return clinic_id;
    }
    public void getClinic_id(int id){
        this.clinic_id = id;
    }
    public Doctor(int id, String name, int clinic_id){
        this.id = id;
        this.name = name;
        this.clinic_id = clinic_id;
    }
}
