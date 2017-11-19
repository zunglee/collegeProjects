/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

/**
 *
 * @author rajendra
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class emp extends JFrame implements ActionListener, TextListener {

    String name;
    String designation;
    String address;
    String age;
    String gender;
    String dob;
    String email;
    String work;
    float currentRating;
    String userid;
    String target;
    String internship;
    String highschool;
    String college;
    String curr;
    String projectparticipation;
    JButton viewProfileBtn, viewOtherBtn, updateProfileBtn, rateBtn, logoutBtn;
    JPanel mPanel, mainPanel, yourPanel, otherPanel, updatePanel, ratePanel, btnPanel;
    CardLayout cl;
    CardLayout cm;
    Connection conn;
    //Rating r;
    jobrating jr;
    socialrating sr;
   // otherrating or;
    //viewOther panel
    JComboBox employee_lists;
    //RatePanel
    JTextField jobf, accuracyf, overtimef, skillsf;
    //SocialPanel
    JTextField interactionf, teamworkf, communicationf;
    //OtherPanel
    JTextArea seminarsf, projectsf, remarksf;
    JScrollPane scrollingResult;
    JTextField namef, idf, designationf, genderf, dateOfBirthf, agef, emailIdf,currf,highschoolf,collegef,intershipf,workf,projectf;

   emp() {
        setVisible(true);
        setSize(600, 500);
        setResizable(false);
        setTitle(global.id);
        mPanel = new JPanel();
        cm = new CardLayout();
        mPanel.setLayout(cm);
        addControls();

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

      //  r = new Rating();
        jr = new jobrating();
        sr = new socialrating();
       // or = new OtherRating();

        //Rate Panel
        jobf = new JTextField(5);
        accuracyf = new JTextField(5);
        overtimef = new JTextField(5);
        skillsf = new JTextField(5);

        //SocialPanel
        interactionf = new JTextField(5);
        teamworkf = new JTextField(5);
        communicationf = new JTextField(5);

        //other panel
        Dimension d = new Dimension(5, 10);

        seminarsf = new JTextArea("", 4, 10);
        scrollingResult = new JScrollPane(seminarsf);

        seminarsf.setMaximumSize(d);
        projectsf = new JTextArea(4, 10);
        remarksf = new JTextArea(4, 10);


    }

    private void addControls() {

        btnPanel = new JPanel();
//             
        viewProfileBtn = new JButton("View Your Profile");
        viewOtherBtn = new JButton("View Others Profile");
        updateProfileBtn = new JButton("Update Profile");
        rateBtn = new JButton("Rate");
        logoutBtn = new JButton("Logout");

        viewProfileBtn.addActionListener(this);
        viewOtherBtn.addActionListener(this);
        updateProfileBtn.addActionListener(this);
        rateBtn.addActionListener(this);
        logoutBtn.addActionListener(this);

        viewProfileBtn.setActionCommand("ViewMyProfile");
        viewOtherBtn.setActionCommand("ViewOthersProfile");
        updateProfileBtn.setActionCommand("UpdateProfile");
        rateBtn.setActionCommand("Rate");
        logoutBtn.setActionCommand("Logout");

        btnPanel.add(viewProfileBtn);
        btnPanel.add(viewOtherBtn);
        btnPanel.add(updateProfileBtn);
        btnPanel.add(rateBtn);
        btnPanel.add(logoutBtn);


        Container contentPane = getContentPane();
        contentPane.add(BorderLayout.NORTH, btnPanel);

        cl = new CardLayout();
        mainPanel = new JPanel();
        mainPanel.setLayout(cl);

        yourPanel = new JPanel();

        otherPanel = new JPanel();
        updatePanel = new JPanel();
        ratePanel = new JPanel();
        ratePanel.setLayout(new BorderLayout());
        //yourPanel.setBackground(Color.red);
        viewMyProfile();
        displaYourPanel(yourPanel, name);

        //otherPanel.setBackground(Color.cyan );
        //updatePanel.setBackground(Color.GREEN);
        UpdateProfile();
        updateYourPanel();

        //   ViewOthersProfile();
        viewPanel();
        displaYourPanel(otherPanel, name);
        

        mainPanel.add("ViewMyProfile", yourPanel);
        mainPanel.add("ViewOthersProfile", otherPanel);
        mainPanel.add("UpdateProfile", updatePanel);
        mainPanel.add("Rate", ratePanel);

        contentPane.add(mainPanel);


    }

    public void actionPerformed(ActionEvent ae) {


        CardLayout c2 = (CardLayout) (mPanel.getLayout());
        CardLayout c = (CardLayout) (mainPanel.getLayout());


        String command = ae.getActionCommand();
        if (command.equals("ViewMyProfile")) {
            c.show(mainPanel, "ViewMyProfile");
        } else if (command.equals("ViewOthersProfile")) {
            c.show(mainPanel, "ViewOthersProfile");
            System.out.println("Other Pressed");
        } else if (command.equals("UpdateProfile")) {
            c.show(mainPanel, "UpdateProfile");
        } else if (command.equals("Update")) {
            updateInformation();
            System.out.println(" Database Updated");
        } else if (command.equals("Rate")) {
            System.out.println(" Rate button Pressed");
            c.show(mainPanel, "Rate");
            displayRatePanel();
        } else if (command.equals("JobFields")) {
            c2.show(mPanel, "JobFields");
            System.out.println("Job pressed");
            System.out.println("inside jobs per day " + jr.jobsperday);
            //System.out.println("inside jobs per day " + Float.parseFloat(jobf.getText()));

        } else if (command.equals("SocialFields")) {
            System.out.println("Social pressed");
            c2.show(mPanel, "SocialFields");
            System.out.println("inside jobs per day " + 23);
        } else if (command.equals("OtherFields")) {
            System.out.println("Other pressed");
            c2.show(mPanel, "OtherFields");

        } else if (command.equals("SubmitJob")) {
            //c2.show(mPanel,"SocialFields");

            System.out.println("SubmitPressed");

            jr.jobsperday = Float.parseFloat(jobf.getText());
            jr.accuracy = Float.parseFloat(accuracyf.getText());
            jr.overtime = Float.parseFloat(overtimef.getText());
            jr.problemSolvingSkills = Float.parseFloat(skillsf.getText());
           // r.jobrating = jr.calculatejobrating();
          //  System.out.println("job Rating is " + r.jobRating);

        } else if (command.equals("SubmitSocial")) {
            // c2.show(mPanel,"OtherFields");
            System.out.println("Social Submitted");
            sr.interaction = Float.parseFloat(interactionf.getText());
            sr.communiactionSkills = Float.parseFloat(communicationf.getText());
            sr.teamwork = Float.parseFloat(teamworkf.getText());

         //   r.socialRating = sr.calculateSocialRating();
          //  System.out.println("Social Rating ..." + r.socialRating);
        } else if (command.equals("SubmitOthers")) {

//            System.out.println("Your Rating Is ......." + r.calculateRating());
            System.out.println("otherSubmitted");
            updateDatabase();
         //   r.updateEmployeeDatabase();
        } else if (command.equals("GO")) {
            System.out.println("inside Go button");
            viewOtherProfile((String) employee_lists.getSelectedItem());
            //displaYourPanel(otherPanel,);
        } else if (command.equals("Logout")){
                System.exit(0);
        }
        //c.show(mainPanel,(String)ae.getActionCommand());

    }

    public void editPanel(String na, String id, String desig, String addr, String gend, String dobirth, String emailid,String cur) {
        namef.setText(na);
        idf.setText(id);
        designationf.setText(desig);
        genderf.setText(desig);
        emailIdf.setText(emailid);
        dateOfBirthf.setText(dobirth);
        currf.setText(cur);

    }

    public void updateDatabase() {
        connectDatabase();
        try {
            Statement st = conn.createStatement();
            String semi = seminarsf.getText();
            String pro = projectsf.getText();
            String rem = remarksf.getText();

        //    int d = st.executeUpdate("update  otherfields set seminar_name ='"+semi+"',project_name='"+pro+"',remarks='"+rem+"' where employee_id = '"+Global.id+"' " );

            st.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Inside update Database");
        }
    }

    public void textValueChanged(TextEvent te) {
        jr.jobsperday = Float.parseFloat(jobf.getText());
        System.out.println("ssss." + jr.jobsperday);
    }

    public void connectDatabase() {


        Timestamp created = new Timestamp(System.currentTimeMillis());
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "raminder");
            System.out.println("Connection in Employee class");
            //Statement stmt = conn.createStatement();
            /*ResultSet rset = stmt.executeQuery("select password from login where username ='"+us+"' ");
            rset.next();

            rset.close();
             *
             */
            //stmt.close();
            //conn.close();
            System.out.println("Your JDBC installation is correct.");

        } catch (ClassNotFoundException e) {
            System.err.println("init(): ClassNotFoundException: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("init(): SQLException: " + e.getMessage());
        }

    }

    public void viewMyProfile() {
        System.out.println("Raminder");
        connectDatabase();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select * from employee where employee_id='" + global.id + "' ");
            rset.next();
            global.id = rset.getString(1);

            name = rset.getString(2);

            designation = rset.getString(3);

            address = rset.getString(4);
            age = rset.getString(5);
            gender = rset.getString(6);
            dob = rset.getString(7);
            email = rset.getString(8);
            curr=rset.getString(9);
            /*----------YOUR PANEL---------*/
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("init(): SQLException: " + e.getMessage());
        }


    }

    public JComponent displaYourPanel(JComponent panel, String n) {

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel firstrow = new JPanel();
        JLabel namel = new JLabel("       NAME             ");
        namef = new JTextField(15);

        namef.setText(n);
        namef.setEditable(false);

        firstrow.setSize(50, 50);
        firstrow.add(namel);
        firstrow.add(namef);

        panel.add(firstrow);

        JPanel secondrow = new JPanel();
        JLabel idl = new JLabel("EmployeeId           ");
        idf = new JTextField(15);
        secondrow.setSize(20, 20);

        idf.setText(global.id);
        idf.setEditable(false);
        secondrow.add(idl);
        secondrow.add(idf);
        panel.add(secondrow);

        JPanel thirdrow = new JPanel();
        JLabel designationl = new JLabel("   Desigantion       ");
        designationf = new JTextField(15);
        designationf.setText(designation);
        designationf.setEditable(false);
        thirdrow.add(designationl);
        thirdrow.add(designationf);

        panel.add(thirdrow);



        JPanel fourthrow = new JPanel();
        JLabel agel = new JLabel("           Age         ");
        agef = new JTextField(15);
        agef.setText(age + " ");
        agef.setEditable(false);
        fourthrow.add(agel);
        fourthrow.add(agef);
        panel.add(fourthrow);


        JPanel fifthhrow = new JPanel();
        JLabel genderl = new JLabel("       Gender        ");
        genderf = new JTextField(15);
        genderf.setText(gender);
        genderf.setEditable(false);
        fifthhrow.add(genderl);
        fifthhrow.add(genderf);
        panel.add(fifthhrow);


        JPanel sixthhrow = new JPanel();
        JLabel dateOfBirthl = new JLabel("Date OF Birth     ");
        dateOfBirthf = new JTextField(15);
        dateOfBirthf.setText(dob);
        dateOfBirthf.setEditable(false);
        sixthhrow.add(dateOfBirthl);
        sixthhrow.add(dateOfBirthf);
        panel.add(sixthhrow);

        JPanel seventhhrow = new JPanel();
        JLabel emailIdl = new JLabel("  Email ID       ");
        emailIdf = new JTextField(15);
        emailIdf.setText(email);
        emailIdf.setEditable(false);
        seventhhrow.add(emailIdl);
        seventhhrow.add(emailIdf);
        panel.add(seventhhrow);

        JPanel eighthrow = new JPanel();
        JLabel currg = new JLabel("  Current Rating       ");
        currf = new JTextField(15);
        currf.setText(curr);
        currf.setEditable(false);
        eighthrow.add(currg);
        eighthrow.add(currf);
        panel.add(eighthrow);


        System.out.println(name + ".............");
        System.out.println(address);
        System.out.println(designation);
        System.out.println(age);
        return panel;
    }

    public void UpdateProfile() {
        System.out.println("Raminder");
        connectDatabase();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select * from employee where employee_id='" + global.id + "' ");
            rset.next();
            global.id = rset.getString(1);

            name = rset.getString(2);

            designation = rset.getString(3);

            address = rset.getString(4);
            age = rset.getString(5);
            gender = rset.getString(6);
            dob = rset.getString(7);
            email = rset.getString(8);
            internship =  rset.getString(11) ;
            highschool =  rset.getString(12) ;
            projectparticipation = rset.getString(13) ;
            college =  rset.getString(14) ;
            work =  rset.getString(15) ;


            /*----------YOUR PANEL---------*/
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("init(): SQLException: " + e.getMessage());
        }
    }

    public void updateYourPanel() {

        updatePanel.setLayout(new BoxLayout(updatePanel, BoxLayout.Y_AXIS));

        JPanel firstrow = new JPanel();
        JLabel namel = new JLabel("       NAME             ");
        JTextField namef = new JTextField(15);
        namef.setEditable(false);
        namef.setText(name);
        firstrow.add(namel);
        firstrow.add(namef);

        updatePanel.add(firstrow);

        JPanel secondrow = new JPanel();
        JLabel idl = new JLabel("EmployeeId           ");
        JTextField idf = new JTextField(15);
        idf.setEditable(false);
        idf.setText(global.id);
        secondrow.add(idl);
        secondrow.add(idf);
        updatePanel.add(secondrow);

        JPanel thirdrow = new JPanel();
        JLabel designationl = new JLabel("   Desigantion       ");
        JTextField designationf = new JTextField(15);
        designationf.setText(designation);
        designationf.setEditable(false);
        thirdrow.add(designationl);
        thirdrow.add(designationf);

        updatePanel.add(thirdrow);

        JPanel fourthrow = new JPanel();
        JLabel agel = new JLabel("           Age         ");
        JTextField agef = new JTextField(15);
        agef.setText(age + "");
        fourthrow.add(agel);
        fourthrow.add(agef);
        updatePanel.add(fourthrow);


        JPanel fifthhrow = new JPanel();
        JLabel genderl = new JLabel("       Gender        ");
        JTextField genderf = new JTextField(15);
        genderf.setText(gender);
        fifthhrow.add(genderl);
        fifthhrow.add(genderf);
        updatePanel.add(fifthhrow);


        JPanel sixthhrow = new JPanel();
        JLabel dateOfBirthl = new JLabel("Date OF Birth     ");
        JTextField dateOfBirthf = new JTextField(15);
        dateOfBirthf.setText(dob);
        sixthhrow.add(dateOfBirthl);
        sixthhrow.add(dateOfBirthf);
        updatePanel.add(sixthhrow);

        //Saturday
        JPanel addressrow = new JPanel();
        JLabel addressl = new JLabel("Address         ");
        JTextField addressf = new JTextField(20);
        addressf.setText(address);
        addressrow.add(addressl);
        addressrow.add(addressf);
        updatePanel.add(addressrow);

        JPanel highschoolrow = new JPanel();
        JLabel highschooll = new JLabel("High School         ");
        highschoolf = new JTextField(20);
        addressf.setText(highschool);
        highschoolrow.add(highschooll);
        highschoolrow.add(highschoolf);
        updatePanel.add(highschoolrow);

        JPanel collegerow = new JPanel();
        JLabel collegerowl = new JLabel("College         ");
         collegef = new JTextField(20);
        addressf.setText(college);
        collegerow.add(collegerowl);
        collegerow.add(collegef);
        updatePanel.add(collegerow);

        JPanel projectrow = new JPanel();
        JLabel projectrowl = new JLabel("Project Participation         ");
         projectf = new JTextField(20);
        addressf.setText(projectparticipation);
        projectrow.add(projectrowl);
        projectrow.add(projectf);
        updatePanel.add(projectrow);

        JPanel intership = new JPanel();
        JLabel intershipl = new JLabel("Intership         ");
        intershipf = new JTextField(20);
        addressf.setText(internship);
        intership.add(intershipl);
        intership.add(intershipf);
        updatePanel.add(intership);

        JPanel experience = new JPanel();
        JLabel experiencel = new JLabel("Work    Experience     ");
         workf = new JTextField(20);
        addressf.setText(work);
        experience.add(experiencel);
        experience.add(workf);
        updatePanel.add(experience);


        JPanel seventhhrow = new JPanel();
        JLabel emailIdl = new JLabel("  Email ID       ");
        JTextField emailIdf = new JTextField(15);
        emailIdf.setText(email);
        seventhhrow.add(emailIdl);
        seventhhrow.add(emailIdf);
        updatePanel.add(seventhhrow);

        JPanel eigthrow = new JPanel();
        JButton btnSave = new JButton("Update");
        btnSave.setActionCommand("Update");
        btnSave.addActionListener(this);
        eigthrow.add(btnSave);
        updatePanel.add(eigthrow);

        System.out.println(name);
        System.out.println(address);
        System.out.println(designation);
        System.out.println(age);

    }

    public void updateInformation()
    {
        connectDatabase();
        try {
        Statement st = conn.createStatement();
        String temp = agef.getText();
        //float a = Float.parseFloat(temp);
          //  System.out.println(temp);
            //int s1 = st.executeUpdate("update employee set age = '"+temp+"' where employee_id ='"+Global.id+"' ");
            temp  = genderf.getText();
            System.out.println(temp);
            int s2 = st.executeUpdate("update employee set gender = '"+temp+"' where employee_id ='"+global.id+"' ");
            temp = dateOfBirthf.getText();
            System.out.println(temp);
            int s3 = st.executeUpdate("update employee set date_of_birth = '"+temp+"' where employee_id ='"+global.id+"' ");
            temp  = emailIdf.getText();
            System.out.println(temp);
             int s4 = st.executeUpdate("update employee set email_id = '"+temp+"' where employee_id ='"+global.id+"' ");
             temp = highschoolf.getText();
             System.out.println(temp);
             int s5 = st.executeUpdate("update employee set highschool = '"+temp+"' where employee_id ='"+global.id+"' ");
             temp = collegef.getText();
             System.out.println(temp);
             int s6 = st.executeUpdate("update employee set college = '"+temp+"' where employee_id ='"+global.id+"' ");
             temp =projectf.getText();
             System.out.println(temp);
             int s7 = st.executeUpdate("update employee set project_participation = '"+temp+"' where employee_id ='"+global.id+"' ");
             temp = workf.getText();
             System.out.println(temp);
             int s8 = st.executeUpdate("update employee set workexperience = '"+temp+"' where employee_id ='"+global.id+"' ");
             temp = intershipf.getText();
             int s9 = st.executeUpdate("update employee set internship = '"+temp+"' where employee_id ='"+global.id+"' ");
             st.close();
             conn.close();

        } catch (SQLException e) {
            System.out.println("updateInformation......");
        }

    }
    public void displayRatePanel() {                                                   //jobf,jobl
        JPanel buttonPanel, jobPanel, socialPanel, oPanel;//frow,
        JButton jobBtn, socialBtn, otherBtn;

        buttonPanel = new JPanel();

        //           mPanel = new JPanel();
        //         cm = new CardLayout();
        //       mPanel.setLayout(cm);

        jobPanel = new JPanel();
        socialPanel = new JPanel();
        oPanel = new JPanel();

        jobPanel.setLayout(new BoxLayout(jobPanel, BoxLayout.Y_AXIS));
        socialPanel.setLayout(new BoxLayout(socialPanel, BoxLayout.Y_AXIS));
        oPanel.setLayout(new BoxLayout(oPanel, BoxLayout.Y_AXIS));

        jobPanel.setBackground(Color.red);
        socialPanel.setBackground(Color.cyan);
        oPanel.setBackground(Color.blue);

        jobBtn = new JButton("JobFields");
        jobBtn.setActionCommand("JobFields");
        socialBtn = new JButton("SocialFields");
        socialBtn.setActionCommand("SocialFields");
        otherBtn = new JButton("OtherFields");
        otherBtn.setActionCommand("OtherFields");

        jobBtn.addActionListener(this);
        socialBtn.addActionListener(this);
        otherBtn.addActionListener(this);

        buttonPanel.add(jobBtn);
        buttonPanel.add(socialBtn);
        buttonPanel.add(otherBtn);

        ratePanel.add(BorderLayout.NORTH, buttonPanel);
        ratePanel.add(BorderLayout.CENTER, mPanel);
        mPanel.add("JobFields", jobPanel);
        mPanel.add("SocialFields", socialPanel);
        mPanel.add("OtherFields", oPanel);
        ratePanel.validate();




        //JOb Card
        JPanel frow = new JPanel();
        JLabel jobl = new JLabel("      Job Performance  ");

        frow.add(jobl);
        frow.add(jobf);
        jobPanel.add(frow);

        JPanel srow = new JPanel();
        JLabel accuracyl = new JLabel("     Accuracy  ");

        srow.add(accuracyl);
        srow.add(accuracyf);
        jobPanel.add(srow);

        JPanel trow = new JPanel();
        JLabel overtimel = new JLabel("      Job Performance  ");

        trow.add(overtimel);
        trow.add(overtimef);
        jobPanel.add(trow);


        JPanel forow = new JPanel();
        JLabel skillsl = new JLabel("      Job Performance  ");

        forow.add(skillsl);
        forow.add(skillsf);
        jobPanel.add(forow);

        JPanel p = new JPanel();
        JButton jobRatingBtn = new JButton("Submit");
        jobRatingBtn.setActionCommand("SubmitJob");
        jobRatingBtn.addActionListener(this);
        p.add(jobRatingBtn);
        jobPanel.add(p);

        //Social Card
        //socialPanel.setLayout(new BoxLayout(socialPanel,BoxLayout.Y_AXIS));
        JPanel sfrow = new JPanel();
        JLabel interactionl = new JLabel("   Interaction  ");

        sfrow.add(interactionl);
        sfrow.add(interactionf);
        socialPanel.add(sfrow);

        JPanel ssrow = new JPanel();
        JLabel teamworkl = new JLabel("  Teamwork  ");

        ssrow.add(teamworkl);
        ssrow.add(teamworkf);
        socialPanel.add(ssrow);

        JPanel strow = new JPanel();
        JLabel commskillsl = new JLabel("  Communication Skills ");

        strow.add(commskillsl);
        strow.add(communicationf);
        socialPanel.add(strow);

        JPanel sp = new JPanel();
        JButton sbtn = new JButton("Submit");
        sbtn.setActionCommand("SubmitSocial");
        sbtn.addActionListener(this);
        sp.add(sbtn);
        socialPanel.add(sp);

        //Other Fields
        JPanel row1 = new JPanel();
        JLabel seminarsl = new JLabel("  Seminars ");

        row1.add(seminarsl);
        row1.add(seminarsf);
        oPanel.add(row1);

        JPanel row2 = new JPanel();
        JLabel projectsl = new JLabel("  Projects ");

        row2.add(projectsl);
        row2.add(projectsf);
        oPanel.add(row2);


        JPanel row3 = new JPanel();
        JLabel remarksl = new JLabel("  Remarks ");

        row3.add(remarksl);
        row3.add(remarksf);
        oPanel.add(row3);

        JPanel row4 = new JPanel();
        JButton obtn = new JButton("Submit");
        obtn.setActionCommand("SubmitOthers");
        obtn.addActionListener(this);
        row4.add(obtn);
        oPanel.add(row4);


    }

    public void viewPanel() {


        otherPanel.setLayout(new BoxLayout(otherPanel, BoxLayout.Y_AXIS));

        int c = 0;
        String[] employees = new String[10];

        System.out.println("Raminder");
        connectDatabase();
        try {
            //while ( c <= 5 ) {
            Statement stmt = conn.createStatement();
            //ResultSet rset = stmt.executeQuery("select * from employee where employee_id='"+Global.id+"' ");
            ResultSet rset = stmt.executeQuery("select * from employee where employee_id='eidorg01'");//+ (c+1) +"' ");
            rset.next();
            employees[0] = rset.getString(2);
            ResultSet rset1 = stmt.executeQuery("select * from employee where employee_id='eidorg02' ");
            rset1.next();
            employees[1] = rset1.getString(2);
            ResultSet rset3 = stmt.executeQuery("select * from employee where employee_id='eidorg03'");//+ (c+1) +"' ");
            rset3.next();
            employees[2] = rset3.getString(2);
            ResultSet rset4 = stmt.executeQuery("select * from employee where employee_id='eidorg04'");//+ (c+1) +"' ");
            rset4.next();
            employees[3] = rset4.getString(2);
            ResultSet rset5 = stmt.executeQuery("select * from employee where employee_id='eidorg05'");//+ (c+1) +"' ");
            rset5.next();
            employees[4] = rset5.getString(2);
            //c++;
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("init(): SQLException: " + e.getMessage());
        }
        // String[] employees = { "emp1", "emp2", "emp3", "emp4", "emp5" };


        employee_lists = new JComboBox(employees);
        employee_lists.setBackground(Color.white);
        employee_lists.addActionListener(this);

        JPanel firstrow = new JPanel();
        firstrow.add(employee_lists);
        JButton go = new JButton("View");
        go.addActionListener(this);
        go.setActionCommand("GO");
        firstrow.add(go);
        otherPanel.add(firstrow);

    }

    public void viewOtherProfile(String emp) {
        JPanel othersPanel = new JPanel();
        othersPanel.setLayout(new BoxLayout(othersPanel, BoxLayout.Y_AXIS));

        connectDatabase();
        try {
            Statement st1 = conn.createStatement();
            ResultSet rs1 = st1.executeQuery("select * from employee where employee_name = '" + emp + "'");
            rs1.next();
            name = rs1.getString(2);
            String identity = rs1.getString(1);

            address = rs1.getString(4);
            age = rs1.getString(5);
            gender = rs1.getString(6);
            dob = rs1.getString(7);
            email = rs1.getString(8);
            curr=rs1.getString(9);
            editPanel(name, identity, designation, address, gender, dob, email,curr);
        } catch (SQLException e) {
            System.out.println("Inside View Other Profile");
        }

    }
}

