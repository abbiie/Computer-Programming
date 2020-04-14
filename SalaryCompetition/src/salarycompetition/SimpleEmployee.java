package salarycompetition;

public class SimpleEmployee {

    String name;
    char Classification;
    double FixedSalary;
    double BonusRate;
    double WeeklyGross;
    
    SimpleEmployee(){
    this.BonusRate = 0.085;
    this.FixedSalary = 1500;
    }
        public void setName(String empname){ 
            this.name = empname;
        }
        public void setWeeklyGross(double weeklysales){
            this.WeeklyGross = weeklysales;
        }
        public void setClassification(char classify){
            this.Classification = classify;
        }
        public String getName(){
            return this.name;    
        }
        public double getWeeklyGross(){
            return this.WeeklyGross;    
        }
        public double getFixedSalary(){
                
            return this.FixedSalary ;    
        }
        public char getClassification(){
            return this.Classification;    
        }
        public double getBonusRate(){
            return this.BonusRate;    
        }        
                

                
                
                
    } 
    
  
    
