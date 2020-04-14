package salarycompetition;
import java.text.DecimalFormat;
import java.util.Scanner;
public class SalaryCompetition {

    static SimpleEmployee emp = new SimpleEmployee();
    static SimpleEmployee emp2 = new SimpleEmployee();
    
    public static void main(String[] args) {
        
        emp2.setName("Chiken");
        emp2.setWeeklyGross(123434.234);
        emp2.setClassification('F');

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Name: ");
        emp.setName(sc.nextLine());
        
        System.out.print("Enter Weekly Gross: ");
        emp.setWeeklyGross(sc.nextDouble());
        
        
        double netWeek = netWeekly(emp.getWeeklyGross());
        System.out.println("\n\n*****Snow Enterprice*****");
        
        DecimalFormat df = new DecimalFormat("#0.00"); //predefined Method
        System.out.println("Employee Name:      "+ emp.getName());
        System.out.println("Gross Salary:       "+ df.format(emp.getWeeklyGross()));
        System.out.println("Bonus:              "+ df.format(emp.getBonusRate()));
        System.out.println("Net Weekly Salary:  "+ df.format(netWeek));
        System.out.println("Classification:     "+emp.getClassification());
   
        System.out.println("\n__________________________________");
        System.out.println("Employee Name:      "+ emp2.getName());
        System.out.println("Gross Salary:       "+ df.format(emp2.getWeeklyGross()));
        System.out.println("Classification:     "+emp2.getClassification());
        
         System.out.println("\n__________________________________");
        System.out.println("Employee Name:      "+ emp.getName());
        System.out.println("Gross Salary:       "+ df.format(emp.getWeeklyGross()));
        System.out.println("Classification:     "+emp.getClassification());
        
        
    }
    //chain method
    static double netWeekly(double GrossWeekly){
        double bonus = emp.WeeklyGross * emp.BonusRate;
        emp.BonusRate = bonus;
        double NetWeek = bonus + emp.FixedSalary;
        emp.setClassification(classif(NetWeek));
        return NetWeek;
    }
    //another method 
    static char classif(double NetWeek){
        char classif[] = {'A','B','C','D','E','F'};
        int value[] = {1500, 2000, 2500, 3000, 3500, 4000, 1000000};
        
        char classification = 'x';
        for(int i = 1; i <= value.length; i++){
            if(NetWeek >= value[i-1] && NetWeek < value[i]){
                classification = classif[i-1];
            }
        }
        return classification;
    }
    
}

