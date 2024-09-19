import java.util.Scanner;
import java.util.ArrayList;

public class Student_grade_tracker
{
    Scanner scanobj = new Scanner(System.in);

    //ARRARYLIST OF NAME AND GRADES
    ArrayList<String> name = new ArrayList<String>();
    ArrayList<Integer> grade = new ArrayList<Integer>();

    //MAIN METHOD
    public static void main(String args[])
    {
        Student_grade_tracker classobj = new Student_grade_tracker();   //different obj from out side because static function can only access static so we have to create obj inside main method
        classobj.welcome();

    }

    //WELCOME METHOD
    public void welcome()
    {
        System.out.println("\n* * * WELCOME TO THE STUDENT GRADE TRACKER MENU * * *\n");
        System.out.println("Choose any option by corresponding number :");
        System.out.println("1. Add Students Grade");
        System.out.println("2. Find Average Grade");
        System.out.println("3. Find Highest Grade");
        System.out.println("4. Find Lowest Grade");
        System.out.println("5. View Student Grades");

        int option = scanobj.nextInt();
        scanobj.nextLine();

        optiondefiner(option);
    }

    //METHOD FOR SELECTING OPTION
    public void optiondefiner(int opt)
    {
        switch(opt)
        {
            case 1 :
                System.out.println("You choose to ADD STUDENT GRADES :");
                addgrade();//add method
                break;

            case 2 :
                System.out.println("you choose to FIND AVERAGE GRADE :");
                avggrade();
                break;

            case 3 :
                System.out.println("you choose to FIND HIGHEST GRADE :");
                highest();
                break;

            case 4 :
                System.out.println("you choose to FIND LOWEST GRADE :");
                lowest();
                break;

            case 5 :
                System.out.println("you choose to VIEW STUDENTS GRADE :");
                viewgrades();
                break;

            default :
                System.out.println("Give a valid number amoung options !!!");
                welcome();
                break;
        }
    }

    //METHOD FOR ADDING STUDENTS GRADE
    public void addgrade()
    {
        System.out.println("READY TO ENTER GRADE ? (YES or NO)");
        String input = scanobj.nextLine();


        while(input.equalsIgnoreCase("YES"))        // input == "yes" it could not compare strings insteed it compare references so we have to use equalsignorecase();
        {
            System.out.print("Enter student name :");
            String stuname = scanobj.nextLine();
            name.add(stuname);                      //we cant use list.set() to a list which is not initialized yet so we have to choose add()

            System.out.print("Enter his/her grade : ");
            int stugrade =scanobj.nextInt();
            grade.add(stugrade);

            scanobj.nextLine();  // Consume the newline "enter" left after nextInt()

            System.out.println(".\nstudent grade successfully added !!!\n.");

            System.out.println("want to add more ? (YES or NO) ");
            input = scanobj.nextLine();

        }

        welcome();
    }


    //METHOD FOR FIND AVG GRADE
    public void avggrade()
    {
       int size = name.size();

       if(size == 0)
       {
           System.out.print(".\n!!! NO student grades added !!!\n.");
           System.out.println("Would you like to add grade? (YES or NO)");
           String input = scanobj.nextLine();

           if(input.equalsIgnoreCase("YES"))
           {
               addgrade();
           }
           else
           {
               welcome();
           }

       }

       else
       {
           int total=0;
           for(int score : grade)
           {
               total += score;
           }

           int avg_score =total/size;
           System.out.println(".\nAverage Student score is : "+avg_score+"\n.");
       }

       welcome();
    }

    // METHOD FOR HIGHEST SCORE
    public void highest()
    {
        int size = name.size();

        if(size == 0)
        {
            System.out.print(".\n!!! NO student grades added !!!\n.");
            System.out.println("Would you like to add grade? (YES or NO)");
            String input = scanobj.nextLine();

            if(input.equalsIgnoreCase("YES"))
            {
                addgrade();
            }
            else
            {
                welcome();
            }
        }

        else
        {
            ArrayList<Integer> sort_grade = new ArrayList<Integer>();
            ArrayList<String> sort_name = new ArrayList<String>();

            sort_grade = grade;
            sort_name = name;

            for (int i = 0; i < sort_grade.size(); i++) {
                for (int j = 0; j < sort_grade.size(); j++) {
                    if (sort_grade.get(i) > sort_grade.get(j)) {
                        int temp;
                        String temp_name;

                        temp = sort_grade.get(i);
                        temp_name = sort_name.get(i);

                        sort_grade.set(i, sort_grade.get(j));
                        sort_name.set(i, sort_name.get(j));

                        sort_grade.set(j, temp);
                        sort_name.set(j, temp_name);
                    }
                }
            }

            int highest_num = sort_grade.get(0);
            String highest_name = sort_name.get(0);
            System.out.println(".\nThe highest Grade is : " + highest_name + " : " + highest_num+"\n.");
        }

        welcome();
    }

    //METHOD FOR LOWEST SCORE
    public void lowest()
    {
        int size = name.size();

        if(size == 0)
        {
            System.out.print(".\n!!! NO student grades added !!!\n.");
            System.out.println("Would you like to add grade? (YES or NO)");
            String input = scanobj.nextLine();

            if(input.equalsIgnoreCase("YES"))
            {
                addgrade();
            }
            else
            {
                welcome();
            }
        }

        else
        {
            ArrayList<Integer> sort_grade = new ArrayList<Integer>();
            ArrayList<String> sort_name = new ArrayList<String>();

            sort_grade = grade;
            sort_name = name;

            for (int i = 0; i < sort_grade.size(); i++) {
                for (int j = 0; j < sort_grade.size(); j++) {
                    if (sort_grade.get(i) > sort_grade.get(j)) {
                        int temp;
                        String temp_name;

                        temp = sort_grade.get(i);
                        temp_name = sort_name.get(i);

                        sort_grade.set(i, sort_grade.get(j));
                        sort_name.set(i, sort_name.get(j));

                        sort_grade.set(j, temp);
                        sort_name.set(j, temp_name);
                    }
                }
            }

            int lowest_num = sort_grade.get(size-1);
            String lowest_name = sort_name.get(size-1);
            System.out.println(".\nThe Lowest Grade is : " + lowest_name + " : " + lowest_num+"\n.");
        }

        welcome();
    }

    // method for view grades
    public void viewgrades()
    {
        int size = name.size();

        if(size == 0)
        {
            System.out.print(".\n!!! NO student grades added !!!\n.");
            System.out.println("Would you like to add grade? (YES or NO)");
            String input = scanobj.nextLine();

            if(input.equalsIgnoreCase("YES"))
            {
                addgrade();
            }
            else
            {
                welcome();
            }
        }

        else
        {
            for( int i=0; i<size ;i++)
            {
                System.out.println("name : "+name.get(i)+" |"+" grade : "+grade.get(i));
            }
        }

        welcome();
    }

}
