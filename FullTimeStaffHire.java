
public class FullTimeStaffHire extends StaffHire
{
    private float salary;
    private int workingHours;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;
    public FullTimeStaffHire(int vacancyNumber,String designation,String jobType,float salary,int workingHours){
        super(vacancyNumber,designation,jobType);
        this.salary=salary;
        this.workingHours=workingHours;
        this.staffName="";
        this.joiningDate="";
        this.qualification="";
        this.appointedBy="";
        this.joined=false;
    }
    public float getSalary(){
        return salary;
    }
    public int getWorkingHours(){
        return workingHours;
    }   
    public String getStaffName(){
       return staffName;    
    }
    public String getQualification(){
        return qualification;
    }
    public String getJoiningDate(){
        return joiningDate;
    }
    public String getAppointedBy(){
        return appointedBy;
    }
    public boolean getJoined(){
        return this.joined;
     }
    public void setsalary(float salary){
        if (joined==true){
            System.out.println("Hello ! you have already been appointed. Your salary is unchangeable. "+getSalary());
        }
        else{
            this.salary=salary;
        }
    }
    public void setworkingHours(int workingHours){
        this.workingHours=workingHours;
    }
    public void hireFullTimeStaff(String staffName,String joiningDate, String qualification,String appointedBy){
        if (joined==true){
            System.out.println("Hello ! you have already been appointed.");
        }
        else{
            this.staffName=staffName;
            this.joiningDate=joiningDate;
            this.qualification=qualification;
            this.appointedBy=appointedBy;
            joined=true;
        }
    }
    public void display(){
        super.display();
        if (joined==true){
           System.out.println("---------------------------Full TimeStaff Hire---------------------------");
           System.out.println("The salary of fulltime staff is Rs."+this.salary );
           System.out.println("Total workinghour="+this.workingHours +"hours");
           System.out.println("The name of the new staff is "+staffName);
           System.out.println("The Joiningdate of new staff is from "+joiningDate);
           System.out.println("The Qualification is "+qualification);
           System.out.println("He/She is Appointed by "+appointedBy);
           System.out.println("--------------------------------Thank you-------------------------------");
        }
    }
}