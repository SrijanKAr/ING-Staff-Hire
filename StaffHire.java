/**
 * Write a description of class StaffHire here.
 * This application is used to hire the staff in an organization.
 * @author Srijan Karki
 * @version 0.1
 */
 public class StaffHire
 {
     //declare private variable
  private int vacancyNumber;
  private String designation;
  private String jobType;
  public StaffHire (int vacancyNumber,String designation,String jobType){
      //set vacancyNumber, designation and jobType to the instance variable using this keyboard 
      this.vacancyNumber=vacancyNumber;
      this.designation=designation;
      this.jobType=jobType;
  }
  //accesor method for each attribute
  //getter method for all the variable of this class.
  // setter method for all the variable of this class
    public int getVacancyNumber(){
    return vacancyNumber;
  }
  public void setVacancyNumber(int vacancyNumber){
      this.vacancyNumber=vacancyNumber;
    }
       public String getDesignation(){
    return designation;
  }
  public void setDesignation(String designation){
      this.designation=designation;
    }
       public String getJobType(){
    return jobType;
  }
  public void setJobType(String jobTyoe){
      this.jobType=jobType;
    }
  public void display(){//define the methods to display the details of vacancy
      System.out.println("================================================");
      System.out.println("Vacancy Number="+getVacancyNumber());
      System.out.println("Designation="+getDesignation());
      System.out.println("Job Type="+ getJobType());
      System.out.println("================================================");
    }
}
