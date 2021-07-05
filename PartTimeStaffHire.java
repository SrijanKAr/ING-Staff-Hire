public class PartTimeStaffHire extends StaffHire
{
  //declare private variable
  private int workingHour;
  private int wagesPerHour;
  private String staffName;
  private String joiningDate;
  private String qualification;
  private String appointedBy;
  private String shifts;
  private boolean joined;
  private boolean terminated;
  public PartTimeStaffHire(int vacancyNumber,String designation, String jobType, int workingHour, int wagesPerHour, String shifts){
    super(vacancyNumber,designation,jobType);
    // set workingHour,wagesPerHour,shifts to the instance variable using this keyword
    //set empty string to rest of the string variable and false to boolean variable.
     this.workingHour=workingHour;
     this.wagesPerHour=wagesPerHour;
     this.shifts=shifts;
     staffName="";
     joiningDate="";
     qualification="";
     appointedBy="";
     joined=false;
     terminated=false;
    }
    //accesor method for each attribute
    //getter method for all the variable of this class.
    // setter method for all the variable of this class
    public int getWorkingHour(){
      return this.workingHour;
    }
   public void setWorkingHour(int workingHour){
       this.workingHour= workingHour;
    }
    public int getWagesPerHour(){
      return this.wagesPerHour;
    }
     public void setWagesPerHour(int wagesPerHour){
       this.wagesPerHour= wagesPerHour;
    }
    public String getShifts(){
        return this.shifts;
    }
     public void setShifts(String newShifts){
         if(joined==true){
             shifts=newShifts;
            }else{
       this.shifts=shifts;
    }
    }
    public String getStaffName(){
     return staffName;
    }
     public void setStaffName(String staffName){
       this.staffName= staffName;
    }
    public String getJoiningDate(){
      return joiningDate;
    }
     public void setJoingDate(String joiningDate){
       this.joiningDate=joiningDate;
    }
    public String getQualification(){
      return qualification;
    }
     public void setQualification(String qualification){
       this.qualification=qualification;
    }
    public String getAppointedBy(){
      return appointedBy;
    }
     public void setAppointedBy(String appointedBy){
       this.appointedBy=appointedBy;
    }
    public boolean getJoined(){
      return joined;
    }
    public boolean getTerminated(){
      return terminated;
    }
    public void hirePartTimeStaff(String staffName, String joiningDate, String qualification, String appointedBy)
    {//check whether the staff us already hired or not.
        if(joined==true){
            System.out.println("Sorry,"+staffName+ "has already joined on"+this.getJoiningDate()+"."); 
        }else{
            //set the parameter values to corresponding varaiable
            //set joined variable to true
            //set terminated variable to false
            
            this.staffName=staffName;
            this.joiningDate=joiningDate;
            this.qualification=qualification;
            this.appointedBy=appointedBy;
            joined=true;
            terminated=false;
        }
    }
    public void terminateTheStaff(String staffName, String joiningDate, String qualification, String appointedBy)
    {//check the staff termination status
        if(terminated==true){
            System.out.println(staffName+"has already been terminated!");
        }else{
            //set the empty and zero variable 
            //set the terminated status true
            //set the joined status  false
            this.staffName="";
            this.joiningDate="";
            this.qualification="";
            this.appointedBy="";
            terminated=true;
            joined=false;
        }
    }
    //defined the same method that u declare in super class  
    public void display(){
        super.display();//calling the method from the StaffHire class
            if(joined==true)
        {
            System.out.println("------------------------------Hire Parttime Staff------------------------------------");
            System.out.println("The name of the new part time staff is"+' '+this.staffName);
            System.out.println("Total working hour of part time staff is "+this.workingHour+"hours.");
            System.out.println("WagesPerHour=Rs:"+this.wagesPerHour+".00");
            System.out.println("Shift of the parttime staff is:"+this.shifts);
            System.out.println("The joining date of part time Staff is from "+this.joiningDate+".");
            System.out.println("The qualification of part time Staff is "+this.qualification+".");
            System.out.println("The part time staff is appointed by "+this.appointedBy+".");
            System.out.println("Income per day=Rs:"+(this.wagesPerHour * this.workingHour)+".00");
            System.out.println("------------------------------------THANK YOU---------------------------------------");
        }
    }
}
    
            
     
   
 

