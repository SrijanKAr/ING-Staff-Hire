/**
 * Write a description of class INGNepal here.
 *
 * @author (Srijan Karki)
 * @version (0.1)
 */
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class INGNepal
{
    JFrame frm;
    JPanel hirePanel,fullTimePanel,partTimePanel,terminatePanel;
    JLabel lblTitle1,lblVno,lblDesignation,lblJobType,lblTitle2,lblVno1,lblDesignation1,lblStaffName,lblQualification,lblSalary,lblDate,lblTime,lblHire,lblTitle3,lblVno2,lblDesignation2,lblStaffName1,lblQualification1,lblShift,lblDate1,lblWages,lblHire1,lblTitle4,lblVnoT;
    JTextField txtVno,txtDesignation,txtVno1,txtDesignation1,txtStaffName,txtQualification,txtSalary,txtDate,txtTime,txtHire,txtVno2,txtDesignation2,txtStaffName1,txtQualification1,txtDate1,txtWages,txtHire1,txtVnoT;
    JComboBox cmbJobType,cmbShift;
    JButton btnAddFullTime,btnFullTimestaff,btnPartTimestaff,btnAddPart,btnDisplayS,btnClear,btnAppoint,btnAdd,btnDisplay,btnClear1,btnBack,btnAppoint1,btnAdd1,btnTerminate,btnDisplay2,btnClear2,btnBack1,btnClear3,btnBack2,btnTerminateR,btnHome;
    Font f=new Font("Arial Rounded MT Bold",Font.BOLD,20);
    Font f1=new Font("Arial",Font.BOLD,15);
    Cursor cur=new Cursor(Cursor.HAND_CURSOR);
    ArrayList<StaffHire> staffList=new ArrayList<StaffHire>();
    public INGNepal(){
        frame();
        body();
        fullTimeStaff();
        partTimeStaff();
        terminate();
    }
    public static void main(String[] abc){
        new INGNepal().frm.setVisible(true);
    }
    public void frame(){
        //create the frame named INGNepal
        frm = new JFrame("INGNepal");
        frm.setSize(500,650);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setResizable(false);
        frm.setLayout(null);
    }
    //creating the hire staff section
    public void body(){
        hirePanel= new JPanel();
        hirePanel.setBounds(0,0,500,650);
        hirePanel.setLayout(null);
        hirePanel.setBackground(Color.LIGHT_GRAY);
        //hirePanel.setVisible(false);
        frm.getContentPane().add(hirePanel);
        //Staff hire section
        lblTitle1=new JLabel("INGNepal STAFF HIRE SYSTEM");
        lblTitle1.setBounds(75,10,400,30);
        lblTitle1.setFont(f);
        lblTitle1.setForeground(Color.BLUE);
        hirePanel.add(lblTitle1);
               
        lblVno=new JLabel("Vacancy Number:");
        lblVno.setBounds(80,60,160,30);
        lblVno.setFont(f1);
        hirePanel.add(lblVno);
        
        txtVno=new JTextField();
        txtVno.setBounds(240,60,150,25);
        hirePanel.add(txtVno);
        
        lblDesignation=new JLabel("Designation:");
        lblDesignation.setBounds(80,100,160,30);
        lblDesignation.setFont(f1);
        hirePanel.add(lblDesignation);
        
        txtDesignation=new JTextField();
        txtDesignation.setBounds(240,100,150,25);
        hirePanel.add(txtDesignation);
        
        lblJobType=new JLabel("Job Type:");
        lblJobType.setBounds(80,140,160,30);
        lblJobType.setFont(f1);
        hirePanel.add(lblJobType);
        
        String jobType[]={"Full Time","PartTime"};
        cmbJobType=new JComboBox(jobType);
        cmbJobType.setBounds(240,140,150,25);
        cmbJobType.setFont(f1);
        cmbJobType.addActionListener(new ActionListener()//performing the event handling for job type
        {
            public void actionPerformed(ActionEvent e){
                String jobType=(cmbJobType.getSelectedItem()).toString();
                if(jobType.equals("PartTime")){             
               lblSalary.setVisible(false);
               txtSalary.setVisible(false);
               lblWages.setVisible(true);
               txtWages.setVisible(true);
               lblShift.setVisible(true);
               cmbShift.setVisible(true);
            }else{
               lblSalary.setVisible(true);
               txtSalary.setVisible(true);
               lblWages.setVisible(false);
               txtWages.setVisible(false);
               lblShift.setVisible(false);
               cmbShift.setVisible(false);
            }
            }
        });
        hirePanel.add(cmbJobType);
        
        lblTime=new JLabel("Working Hour:");
        lblTime.setBounds(80,180,160,30);
        lblTime.setFont(f1);
        hirePanel.add(lblTime);
        
        txtTime=new JTextField();
        txtTime.setBounds(240,180,150,25);
        hirePanel.add(txtTime);
        
        lblSalary=new JLabel("Salary:");
        lblSalary.setBounds(80,220,160,30);
        lblSalary.setFont(f1);
        hirePanel.add(lblSalary);
        
        txtSalary=new JTextField();
        txtSalary.setBounds(240,220,150,25);
        hirePanel.add(txtSalary);
        
        lblWages=new JLabel("Wages Per Hour:");
        lblWages.setBounds(80,220,160,30);
        lblWages.setFont(f1);
        lblWages.setVisible(false);
        hirePanel.add(lblWages);
        
        txtWages=new JTextField();
        txtWages.setBounds(240,220,150,25);
        txtWages.setVisible(false);
        hirePanel.add(txtWages);
        
        lblShift=new JLabel("Shift:");
        lblShift.setBounds(80,260,160,30);
        lblShift.setFont(f1);
        lblShift.setVisible(false);
        hirePanel.add(lblShift);
        
        String shift[]={"Day","Nigth"};
        cmbShift=new JComboBox(shift);
        cmbShift.setBounds(240,260,100,30);
        cmbShift.setFont(f1);
        cmbShift.setVisible(false);
        cmbShift.setCursor(cur);
        hirePanel.add(cmbShift);
        
        btnAddFullTime=new JButton("Add Full Time Staff");
        btnAddFullTime.setBounds(60,360,180,30);
        btnAddFullTime.setFont(f1);
        btnAddFullTime.setCursor(cur);
        btnAddFullTime.addActionListener(new ActionListener()//performing the event handling for add full time staff button
        {
            public void actionPerformed(ActionEvent e){
                int vacancyNumber=0,  workingHours=0;
                float salary=0;
                String jobType="", desgination="";
                try{
                     vacancyNumber=Integer.parseInt(txtVno.getText());
                     desgination=txtDesignation.getText();
                     jobType=(cmbJobType.getSelectedItem()).toString();
                     salary=Float.parseFloat(txtSalary.getText());
                     workingHours=Integer.parseInt(txtTime.getText());
            
                     boolean isDuplicateVno=false;
                     for(StaffHire var:staffList){
                        if(var.getVacancyNumber()==vacancyNumber){
                            isDuplicateVno=true;
                            break;
                        }
                    }
                    if(isDuplicateVno==false){
                       FullTimeStaffHire obj=new FullTimeStaffHire(vacancyNumber, desgination,jobType,salary,workingHours);
                        staffList.add(obj);
                        int appoint=JOptionPane.showConfirmDialog(frm,"The vacancy number: "+txtVno.getText()+" is added,Do you want to appoint???");
                        if(appoint==0){
                        hirePanel.setVisible(false);
                        fullTimePanel.setVisible(true);
                       }
                       else if(appoint==1){
                        hirePanel.setVisible(true);
                        fullTimePanel.setVisible(false);
                        }
                    }else{
                        JOptionPane.showMessageDialog(frm,"Input Vacancy no is already in the list. "+staffList.size());
                    }
                }catch(Exception exp){
                    JOptionPane.showMessageDialog(frm,"Input is invalid. "); 
                }
            } 
        });
        hirePanel.add(btnAddFullTime);
        
        btnAddPart=new JButton("Add Part Time Staff");
        btnAddPart.setBounds(260,360,180,30);
        btnAddPart.setFont(f1);
        btnAddPart.setCursor(cur);
        btnAddPart.addActionListener(new ActionListener()//performing the event handling for add part time staff button
        {            
            public void actionPerformed(ActionEvent e){
                int vacancyNumber=0,  workingHours=0, wagesPerHour=0;
                String jobType="", desgination="",shifts="";
                try{
                     vacancyNumber=Integer.parseInt(txtVno.getText());
                     desgination=txtDesignation.getText();
                     jobType=(cmbJobType.getSelectedItem()).toString();
                     workingHours=Integer.parseInt(txtTime.getText());
                     wagesPerHour=Integer.parseInt(txtWages.getText());
                     shifts=(cmbShift.getSelectedItem()).toString();
                     boolean isDuplicateVno=false;
                     for(StaffHire var:staffList){
                        if(var.getVacancyNumber()==vacancyNumber){
                            isDuplicateVno=true;
                            break;
                        }
                    }
                    if(isDuplicateVno==false){
                        PartTimeStaffHire obj=new PartTimeStaffHire(vacancyNumber, desgination,jobType,workingHours,wagesPerHour,shifts);
                        staffList.add(obj);
                        int appoint=JOptionPane.showConfirmDialog(frm,"The vacancy number: "+txtVno.getText()+" is added,Do you want to appoint???");
                        if(appoint==0){
                        hirePanel.setVisible(false);
                        partTimePanel.setVisible(true);
                       }
                       else if(appoint==1){
                        hirePanel.setVisible(true);
                        partTimePanel.setVisible(false); 
                        }
                    }else{
                        JOptionPane.showMessageDialog(frm,"Input Vacancy no is already in the list. "+staffList.size());;
                    }
                }catch(Exception exp){
                    JOptionPane.showMessageDialog(frm,"Input is invalid. "); 
                }
            }
        });
        hirePanel.add(btnAddPart);
        
        btnFullTimestaff=new JButton("Full Time Staff");
        btnFullTimestaff.setBounds(60,450,180,30);
        btnFullTimestaff.setFont(f1);
        btnFullTimestaff.setCursor(cur);
        btnFullTimestaff.addActionListener(new ActionListener()//performing the event handling for full time button to linked with full time panel
        {
            public void actionPerformed(ActionEvent e){
                hirePanel.setVisible(false);
                fullTimePanel.setVisible(true);
            }
            
        });
        hirePanel.add(btnFullTimestaff);
        
        btnPartTimestaff=new JButton("Part Time Staff");
        btnPartTimestaff.setBounds(260,450,180,30);
        btnPartTimestaff.setFont(f1);
        btnPartTimestaff.setCursor(cur);
        btnPartTimestaff.addActionListener(new ActionListener()//performing the event handling for part time staff button to linked part time panel
        {
            public void actionPerformed(ActionEvent e){
                hirePanel.setVisible(false);
                partTimePanel.setVisible(true);
            }
            
        });
        hirePanel.add(btnPartTimestaff);
        
        btnDisplayS=new JButton("Display");
        btnDisplayS.setBounds(140,410,100,25);
        btnDisplayS.setFont(f1);
        btnDisplayS.setCursor(cur);
        btnDisplayS.addActionListener(new ActionListener()//performing the event handling for display button to display the value
        {
            public void actionPerformed(ActionEvent e){
                for(StaffHire obj:staffList){
                    if(obj instanceof StaffHire){// to test whether the object is an instance of the specific class
                        ((StaffHire)obj).display();
                         System.out.println("Total working hour="+txtTime.getText());
                         String jobType=(cmbJobType.getSelectedItem()).toString();
                      if(jobType.equals("PartTime")){ 
                          System.out.println("Wages per day="+txtWages.getText());
                          System.out.println("Shifts="+cmbShift.getSelectedItem().toString());
                      }
                      else{
                          System.out.println("Salary="+txtSalary.getText());
                        }
                    }
                }
           }
        });
        hirePanel.add(btnDisplayS);
        
        btnClear=new JButton("Clear");
        btnClear.setBounds(260,410,100,30);
        btnClear.setFont(f1);
        btnClear.setCursor(cur);
        btnClear.addActionListener(new ActionListener()//performing the event handling for clear button to clear the value
        {
            public void actionPerformed(ActionEvent e){
                txtVno.setText("");
                txtDesignation.setText("");
                txtWages.setText("");
                txtSalary.setText("");
                txtTime.setText("");
                
                cmbJobType.setSelectedIndex(0);
                cmbShift.setSelectedIndex(0);
            }
        });
        hirePanel.add(btnClear);
    }
    public void fullTimeStaff(){
        fullTimePanel=new JPanel();
        fullTimePanel.setBounds(0,0,500,650);
        fullTimePanel.setLayout(null);
        fullTimePanel.setVisible(false);
        fullTimePanel.setBackground(Color.LIGHT_GRAY);
        frm.getContentPane().add(fullTimePanel);
        //Hire Full Time Staff section
        lblTitle2=new JLabel("FULL TIME STAFF HIRE");
        lblTitle2.setBounds(100,10,320,30);
        lblTitle2.setFont(f);
        lblTitle2.setForeground(Color.BLUE);
        fullTimePanel.add(lblTitle2);
        
        lblVno1=new JLabel("Vacancy Number:");
        lblVno1.setBounds(80,60,160,30);
        lblVno1.setFont(f1);
        fullTimePanel.add(lblVno1);
        
        txtVno1=new JTextField();
        txtVno1.setBounds(240,60,150,25);
        fullTimePanel.add(txtVno1);
        
        lblDesignation1=new JLabel("Designation:");
        lblDesignation1.setBounds(80,100,160,30);
        lblDesignation1.setFont(f1);
        fullTimePanel.add(lblDesignation1);
        
        txtDesignation1=new JTextField();
        txtDesignation1.setBounds(240,100,150,25);
        fullTimePanel.add(txtDesignation1);
        
        lblStaffName=new JLabel("Staff Name:");
        lblStaffName.setBounds(80,140,160,30);
        lblStaffName.setFont(f1);
        fullTimePanel.add(lblStaffName);
        
        txtStaffName=new JTextField();
        txtStaffName.setBounds(240,140,150,25);
        fullTimePanel.add(txtStaffName);
        
        lblQualification=new JLabel("Qualification:");
        lblQualification.setBounds(80,180,160,30);
        lblQualification.setFont(f1);
        fullTimePanel.add(lblQualification);
        
        txtQualification=new JTextField();
        txtQualification.setBounds(240,180,150,25);
        fullTimePanel.add(txtQualification);
        
        lblDate=new JLabel("Joining Date:");
        lblDate.setBounds(80,220,160,30);
        lblDate.setFont(f1);
        fullTimePanel.add(lblDate);
        
        txtDate=new JTextField();
        txtDate.setBounds(240,220,150,25);
        fullTimePanel.add(txtDate);
        
        lblHire=new JLabel("Appointed by:");
        lblHire.setBounds(80,260,160,30);
        lblHire.setFont(f1);
        fullTimePanel.add(lblHire);
        
        txtHire=new JTextField();
        txtHire.setBounds(240,260,150,25);
        fullTimePanel.add(txtHire);
        
        btnAppoint=new JButton("Appoint");
        btnAppoint.setBounds(40,400,100,25);
        btnAppoint.setFont(f1);
        btnAppoint.setCursor(cur);
        btnAppoint.addActionListener(new ActionListener()//performing the event handling for appoint button to appoint the staff
        {
            public void actionPerformed(ActionEvent e){
                int vacancyNumber=0;
                float salary=0;
                int workingHours=0;
                String staffName="";
                String joiningDate="";
                String qualification="";
                String appointedBy="";
                String designation="";
                try{
                 vacancyNumber=Integer.parseInt(txtVno1.getText());
                 staffName=txtStaffName.getText();
                 joiningDate=txtDate.getText();
                 qualification=txtQualification.getText();
                 appointedBy=txtHire.getText();
                 boolean vacancyFound=false;
                 for(StaffHire obj:staffList){
                    if(obj.getVacancyNumber()==vacancyNumber){
                        vacancyFound=true;
                        if(obj instanceof FullTimeStaffHire){// to test whether the object is an instance of the specific class
                            FullTimeStaffHire ab=(FullTimeStaffHire)obj;
                            if(ab.getJoined()==true){
                                JOptionPane.showMessageDialog(frm,"Staff has already hired");
                                System.out.println(txtStaffName.getText()+" has been hired");
                            }
                            else{
                                ab.hireFullTimeStaff(staffName,joiningDate,qualification,appointedBy);
                                JOptionPane.showMessageDialog(frm,"Staff has been appointed.");
                                break;
                            }
                        }else{
                            JOptionPane.showMessageDialog(frm,"Not for fulltime staff Hire");
                            break;
                         }
                     }
                 }
                 if(!vacancyFound){
                    JOptionPane.showMessageDialog(frm,"INVALID VACANCY NUMBER");
                    
                 } 
                }
                catch(Exception exp){
                     JOptionPane.showMessageDialog(frm,"INVALID!!!Please fill the form...");
                }
            }
        });
        fullTimePanel.add(btnAppoint);

        btnDisplay=new JButton("Display");
        btnDisplay.setBounds(320,400,100,25);
        btnDisplay.setFont(f1);
        btnDisplay.setCursor(cur);
        btnDisplay.addActionListener(new ActionListener()//performing the event handling for display button to display the value
        {
            public void actionPerformed(ActionEvent e){
                for(StaffHire obj:staffList){
                    if(obj instanceof FullTimeStaffHire){// to test whether the object is an instance of the specific class
                        ((FullTimeStaffHire)obj).display();
                    }
                }
           }
        });
        fullTimePanel.add(btnDisplay);
        
        btnClear1=new JButton("Clear");
        btnClear1.setBounds(180,400,100,25);
        btnClear1.setFont(f1);
        btnClear1.setCursor(cur);
        btnClear1.addActionListener(new ActionListener()//performing the event handling for clear button to clear the value
        {
            public void actionPerformed(ActionEvent e){
                txtVno1.setText("");
                txtDesignation1.setText("");
                txtStaffName.setText("");
                txtQualification.setText("");
                txtDate.setText("");
                txtHire.setText("");
            }
        });
        fullTimePanel.add(btnClear1);
        
        btnBack=new JButton("Back");
        btnBack.setBounds(180,450,100,25);
        btnBack.setFont(f1);
        btnBack.setCursor(cur);
        btnBack.addActionListener(new ActionListener()//performing the event handling for back button to go back to the hire panel
        {
            public void actionPerformed(ActionEvent e){
                hirePanel.setVisible(true);
                fullTimePanel.setVisible(false);
            }
           });
        fullTimePanel.add(btnBack);
    }
    public void partTimeStaff(){
        partTimePanel=new JPanel();
        partTimePanel.setBounds(0,0,500,650);
        partTimePanel.setLayout(null);
        partTimePanel.setVisible(false);
        partTimePanel.setBackground(Color.LIGHT_GRAY);
        frm.getContentPane().add(partTimePanel);
        //HIRE PART TIME SECTION
        lblTitle3=new JLabel("PART TIME STAFF HIRE");
        lblTitle3.setBounds(100,10,320,30);
        lblTitle3.setFont(f);
        lblTitle3.setForeground(Color.BLUE);
        partTimePanel.add(lblTitle3);
        
        lblVno2=new JLabel("Vacancy Number:");
        lblVno2.setBounds(80,60,160,30);
        lblVno2.setFont(f1);
        partTimePanel.add(lblVno2);
        
        txtVno2=new JTextField();
        txtVno2.setBounds(240,60,150,25);
        partTimePanel.add(txtVno2);
        
        lblDesignation2=new JLabel("Designation:");
        lblDesignation2.setBounds(80,100,160,30);
        lblDesignation2.setFont(f1);
        partTimePanel.add(lblDesignation2);
        
        txtDesignation2=new JTextField();
        txtDesignation2.setBounds(240,100,150,25);
        partTimePanel.add(txtDesignation2);
        
        lblStaffName1=new JLabel("Staff Name:");
        lblStaffName1.setBounds(80,140,160,30);
        lblStaffName1.setFont(f1);
        partTimePanel.add(lblStaffName1);
        
        txtStaffName1=new JTextField();
        txtStaffName1.setBounds(240,140,150,25);
        partTimePanel.add(txtStaffName1);
        
        lblQualification1=new JLabel("Qualification:");
        lblQualification1.setBounds(80,180,160,30);
        lblQualification1.setFont(f1);
        partTimePanel.add(lblQualification1);
        
        txtQualification1=new JTextField();
        txtQualification1.setBounds(240,180,150,25);
        partTimePanel.add(txtQualification1);
        
        lblDate1=new JLabel("Joining Date:");
        lblDate1.setBounds(80,220,160,30);
        lblDate1.setFont(f1);
        partTimePanel.add(lblDate1);
        
        txtDate1=new JTextField();
        txtDate1.setBounds(240,220,150,25);
        partTimePanel.add(txtDate1);
        
        lblHire1=new JLabel("Appointed by:");
        lblHire1.setBounds(80,260,160,30);
        lblHire1.setFont(f1);
        partTimePanel.add(lblHire1);
        
        txtHire1=new JTextField();
        txtHire1.setBounds(240,260,150,25);
        partTimePanel.add(txtHire1);
        
        btnAppoint1=new JButton("Appoint");
        btnAppoint1.setBounds(40,400,100,25);
        btnAppoint1.setFont(f1);
        btnAppoint1.setCursor(cur);
        btnAppoint1.addActionListener(new ActionListener()//performing the event handling for appoint button to appoint the staff
        {
            public void actionPerformed(ActionEvent e){
                int vacancyNumber=0;
                int workingHour=0;
                int wagesPerHour=0;
                String staffName="";
                String joiningDate="";
                String qualification="";
                String shifts="";
                String appointedBy="";
                String designation="";
                try{
                 vacancyNumber=Integer.parseInt(txtVno2.getText());
                 staffName=txtStaffName1.getText();
                 joiningDate=txtDate1.getText();
                 qualification=txtQualification1.getText();
                 appointedBy=txtHire1.getText();
                 
                 boolean vacancyFound=false;
                 for(StaffHire obj:staffList){
                    if(obj.getVacancyNumber()==vacancyNumber){
                        vacancyFound=true;
                        if(obj instanceof PartTimeStaffHire){// to test whether the object is an instance of the specific class
                            PartTimeStaffHire h=(PartTimeStaffHire)obj;
                            if(h.getJoined()==true){
                                JOptionPane.showMessageDialog(frm,"Staff has already hired");
                                 System.out.println(txtStaffName1.getText()+" has been hired");
                            }
                            else{
                                h.hirePartTimeStaff(staffName,joiningDate,qualification,appointedBy);
                                JOptionPane.showMessageDialog(frm,"Staff has been appointed.");
                                break;
                            }
                        }else{
                            JOptionPane.showMessageDialog(frm,"not for part t staff Hire");
                            break;
                         }
                     }
                 }
                 if(!vacancyFound){
                    JOptionPane.showMessageDialog(frm,"INVALID VACANCY NUMBER");
                    
                 } 
                }
                catch(Exception exp){
                     JOptionPane.showMessageDialog(frm,"INVALID!!!Please fill the form...");
                }
            }
        });
        partTimePanel.add(btnAppoint1);
        
        
        btnTerminate=new JButton("Terminate");
        btnTerminate.setBounds(320,400,120,25);
        btnTerminate.setFont(f1);
        btnTerminate.setCursor(cur);
        btnTerminate.addActionListener(new ActionListener()//performing the event handling for terminate button to go the terminate panel
        {
            public void actionPerformed(ActionEvent e){
                terminatePanel.setVisible(true);
                partTimePanel.setVisible(false);
            }
           });
        partTimePanel.add(btnTerminate);
        
        btnDisplay2=new JButton("Display");
        btnDisplay2.setBounds(180,400,100,25);
        btnDisplay2.setFont(f1);
        btnDisplay2.addActionListener(new ActionListener()//performing the event handling for display button to display the value
        {
            public void actionPerformed(ActionEvent e){
                for(StaffHire obj: staffList){
                    if(obj instanceof PartTimeStaffHire){// to test whether the object is an instance of the specific class
                        ((PartTimeStaffHire)obj).display();
                    }
                }
           }
        });
        btnDisplay2.setCursor(cur);
        
        partTimePanel.add(btnDisplay2);
        
        btnClear2=new JButton("Clear");
        btnClear2.setBounds(190,450,100,25);
        btnClear2.setFont(f1);
        btnClear2.setCursor(cur);
        btnClear2.addActionListener(new ActionListener()//performing the event handling for clear button to clear the value
        {
            public void actionPerformed(ActionEvent e){
                txtVno2.setText("");
                txtDesignation2.setText("");
                txtStaffName1.setText("");
                txtQualification1.setText("");
                txtDate1.setText("");
                txtHire1.setText("");
            }
        });
        partTimePanel.add(btnClear2);
        
        btnBack1=new JButton("Back");
        btnBack1.setBounds(340,450,100,25);
        btnBack1.setFont(f1);
        btnBack1.setCursor(cur);
        btnBack1.addActionListener(new ActionListener()//performing the event handling for back button to go back to the previous panel
        {
            public void actionPerformed(ActionEvent e){
                hirePanel.setVisible(true);
                partTimePanel.setVisible(false);
            }
           });
        partTimePanel.add(btnBack1);
    }
    public void terminate(){
        terminatePanel=new JPanel();
        terminatePanel.setBounds(0,0,500,650);
        terminatePanel.setLayout(null);
        terminatePanel.setVisible(false);
        terminatePanel.setBackground(Color.LIGHT_GRAY);
        frm.getContentPane().add(terminatePanel);
        //termination section
        lblTitle4=new JLabel("TERMINATION SECTION");
        lblTitle4.setBounds(150,10,320,30);
        lblTitle4.setFont(f);
        lblTitle4.setForeground(Color.BLUE);
        terminatePanel.add(lblTitle4);
        
        lblVnoT=new JLabel("Vacancy Number:");
        lblVnoT.setBounds(80,60,160,30);
        lblVnoT.setFont(f1);
        terminatePanel.add(lblVnoT);
        
        txtVnoT=new JTextField();
        txtVnoT.setBounds(240,60,150,25);
        terminatePanel.add(txtVnoT);
        
        btnTerminateR=new JButton("Terminate");
        btnTerminateR.setBounds(190,120,120,25);
        btnTerminateR.setFont(f1);
        btnTerminateR.setCursor(cur);
        btnTerminateR.addActionListener(new ActionListener()//performing the event handling for terminate button to terminate the vacancy number
        {
            public void actionPerformed(ActionEvent e){
                int vacancyNumber=0;
                String staffName="";
                String joiningDate="";
                String qualification="";
                String appointedBy="";
                try{
                    vacancyNumber=Integer.parseInt(txtVnoT.getText());
                    staffName=txtStaffName1.getText();
                    joiningDate=txtDate1.getText();
                    qualification=txtQualification1.getText();
                    appointedBy=txtHire1.getText();
                    boolean  vacancyFound=false;
                 for(StaffHire obj:staffList){
                    if(obj.getVacancyNumber()==vacancyNumber){
                        vacancyFound=true;
                        if(obj instanceof PartTimeStaffHire){// to test whether the object is an instance of the specific class
                            PartTimeStaffHire h=(PartTimeStaffHire)obj;
                            if(h.getJoined()==true && h.getTerminated()==false){
                                h.terminateTheStaff(staffName,joiningDate,qualification,appointedBy);
                                JOptionPane.showMessageDialog(frm,"Staff has  been terminated.");
                                System.out.println("Vacancy number:"+txtVnoT.getText()+" has been terminated");
                            }
                            else{
                                JOptionPane.showMessageDialog(frm,"Staff has already been terminated.");
                                break;
                            }
                        }else{
                            JOptionPane.showMessageDialog(frm,"Input Vacancy Number is not for Part time staff...");
                            break;
                         }
                     }
                 }
                 if(!vacancyFound){
                    JOptionPane.showMessageDialog(frm,"INVALID VACANCY NUMBER");
                    
                 } 
                }
                catch(Exception exp){
                     JOptionPane.showMessageDialog(frm,"INVALID!!!Please fill the form...");
                }
                }
            
           });
        terminatePanel.add(btnTerminateR);
        
        btnClear3=new JButton("Clear");
        btnClear3.setBounds(190,180,120,25);
        btnClear3.setFont(f1);
        btnClear3.setCursor(cur);
        btnClear3.addActionListener(new ActionListener()//performing the event handling for clear button to clear the value
        {
            public void actionPerformed(ActionEvent e){
                txtVnoT.setText("");
                
            }
        });
        terminatePanel.add(btnClear3);
        
        
        btnBack2=new JButton("Back");
        btnBack2.setBounds(190,240,120,25);
        btnBack2.setFont(f1);
        btnBack2.setCursor(cur);
        btnBack2.addActionListener(new ActionListener()//performing the event handling for back button to go back to  the previous panel
        {
            public void actionPerformed(ActionEvent e){
                partTimePanel.setVisible(true);
                terminatePanel.setVisible(false);
            }
           });
        terminatePanel.add(btnBack2);
        
        btnHome=new JButton("Home");
        btnHome.setBounds(190,300,120,25);
        btnHome.setFont(f1);
        btnHome.setCursor(cur);
        btnHome.addActionListener(new ActionListener()//performing the event handling for home button to go back to the hire panel
        {
            public void actionPerformed(ActionEvent e){
                hirePanel.setVisible(true);
                terminatePanel.setVisible(false);
            }
           });
        terminatePanel.add(btnHome);
    }
}