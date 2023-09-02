import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Account> pulledAccount = new ArrayList<>();
        ArrayList<Account> accounts = new ArrayList<>();
        ArrayList<String> socials = new ArrayList<>();

        Account adminAccount = new Account("John", "", "Doe", "1111 First Street", "123456789", "admin", 99999);
        accounts.add(adminAccount);
        pulledAccount.add(adminAccount);

        //GUI Setup
        JFrame mainGUI = new JFrame("Unuphan Banking Inc.");

        JFrame signUpGUI = new JFrame("Sign Up Page");

        JFrame chooseGUI = new JFrame("Unuphan Banking Inc.");

        JFrame loginGUI = new JFrame("Unuphan Banking Inc.");

        JPanel layoutPanel = new JPanel(new BorderLayout());


        //JPanel setup (mainGUI)
        BorderLayout border = new BorderLayout();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(border);

        //JLabel setup (mainGUI)
        JLabel titleLabel = new JLabel("Hello, welcome to Unuphan Banking Inc.");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setSize(150, 300);

        //JButton setup (mainGUI)
        JButton startButton = new JButton("Get Started");
        JButton faqButton = new JButton("FAQs Page");
        JButton learnButton = new JButton("Learn More");

        //Adding all elements to the pane (mainGUI)
        JPanel mainDecPanel = new JPanel();
        mainDecPanel.add(faqButton);
        mainDecPanel.add(startButton);
        mainDecPanel.add(learnButton);

        mainDecPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        mainPanel.add(titleLabel, BorderLayout.PAGE_START);
        mainPanel.add(mainDecPanel, BorderLayout.CENTER);
        mainGUI.add(mainPanel);

        //Configuring GUI settings (mainGUI)
        mainGUI.setSize(500, 200);
        mainGUI.setLocationRelativeTo(null);
        mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainGUI.setVisible(true);


        //JTextField setup (signUpGUI)
        JTextField firstNameText = new JTextField(5);
        JTextField middleNameText = new JTextField(5);
        JTextField lastNameText = new JTextField(5);
        JTextField addressText = new JTextField(5);
        JTextField socialSecText = new JTextField(5);
        AbstractDocument secDoc = (AbstractDocument) socialSecText.getDocument();
        secDoc.setDocumentFilter(new stringFilter());

        JTextField passwordText = new JTextField(5);

        JTextField initialDepositText = new JTextField(5);
        AbstractDocument initDoc = (AbstractDocument) initialDepositText.getDocument();
        initDoc.setDocumentFilter(new stringFilter());

        //JPanel setup (signUpGUI)
        JPanel signUp = new JPanel();
        signUp.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel signUp2 = new JPanel();
        signUp2.setLayout(new BorderLayout());

        //JLabel setup (signUpGUI)

        JLabel firstName = new JLabel("*First Name : ");
        JLabel middleName = new JLabel("Middle Name : ");
        JLabel lastName = new JLabel("*Last Name : ");

        JLabel address = new JLabel("*Address : ");
        JLabel socialSec = new JLabel("*Social Security Number : ");
        JLabel password = new JLabel("*Password : ");
        JLabel initialDeposit = new JLabel("*Initial Deposit : ");

        JLabel errorMessage = new JLabel();
        errorMessage.setHorizontalAlignment(SwingConstants.CENTER);

        //JButton setup (signUpGUI)

        JButton submit = new JButton("Submit");
        JButton back = new JButton("Back");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        buttonPanel.add(back);
        buttonPanel.add(submit);

        //Configuring GUI settings (signUpGUI)

        signUpGUI.setSize(500, 200);
        signUpGUI.setLocationRelativeTo(null);
        signUpGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Adding all elements to GUI (signUpGUI)

        signUp.add(firstName);
        signUp.add(firstNameText);

        signUp.add(middleName);
        signUp.add(middleNameText);

        signUp.add(lastName);
        signUp.add(lastNameText);

        signUp.add(address);
        signUp.add(addressText);

        signUp.add(socialSec);
        signUp.add(socialSecText);

        // signUp.add(blankLabel);

        signUp.add(password);
        signUp.add(passwordText);

        signUp.add(initialDeposit);
        signUp.add(initialDepositText);

        layoutPanel.add(signUp, BorderLayout.CENTER);
        layoutPanel.add(errorMessage, BorderLayout.NORTH);
        layoutPanel.add(buttonPanel, BorderLayout.PAGE_END);

        signUpGUI.add(layoutPanel);


        // choosePageGUI Setup

        JButton loginButton = new JButton("Login");
        JButton signUpButton = new JButton("Sign up");

        JPanel chooseButton = new JPanel();
        chooseButton.setLayout(new FlowLayout());
        chooseButton.add(loginButton);
        chooseButton.add(signUpButton);

        JLabel pageTopper = new JLabel("Welcome to Unuphan Banking Inc.");
        pageTopper.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel choosePanel = new JPanel();
        choosePanel.setLayout(new BorderLayout());

        choosePanel.add(pageTopper, BorderLayout.PAGE_START);
        choosePanel.add(chooseButton, BorderLayout.CENTER);

        chooseGUI.add(choosePanel);
        chooseGUI.setSize(500, 200);
        chooseGUI.setLocationRelativeTo(null);
        chooseGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //loginGUI Set UP

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BorderLayout());

        JPanel loginDecPanel = new JPanel();
        loginDecPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        loginPanel.add(loginDecPanel, BorderLayout.CENTER);

        JTextField logLastText = new JTextField(5);
        JTextField logPassText = new JTextField(5);

        JLabel logLast = new JLabel("*Last Name : ");
        JLabel logPass = new JLabel("*Password : ");

        JPanel logButtons = new JPanel();
        logButtons.setLayout(new FlowLayout());
        JButton submitLog = new JButton("Log in");
        JButton backLog = new JButton("Back");


        JPanel logDecPanel2 = new JPanel();
        logDecPanel2.setLayout(new BorderLayout());
        logButtons.add(backLog);
        logButtons.add(submitLog);

        loginDecPanel.add(logLast);
        loginDecPanel.add(logLastText);

        loginDecPanel.add(logPass);
        loginDecPanel.add(logPassText);

        logDecPanel2.add(loginDecPanel, BorderLayout.CENTER);
        logDecPanel2.add(logButtons, BorderLayout.PAGE_END);

        loginGUI.add(logDecPanel2);

        loginGUI.setSize(500, 200);
        loginGUI.setLocationRelativeTo(null);
        loginGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Action Listeners (mainGUI)

        //Start button
        startButton.addActionListener(e -> {
            mainGUI.setVisible(false);
            chooseGUI.setVisible(true);
        });

        //FAQ button
        faqButton.addActionListener(e -> System.out.println("Opening FAQs.."));

        //Learn more button
        learnButton.addActionListener(e -> System.out.println("Opening Learn More.."));

        //Action Listeners (chooseGUI)
        signUpButton.addActionListener(e -> {
            chooseGUI.setVisible(false);
            signUpGUI.setVisible(true);
        });

            loginButton.addActionListener(e -> {
                chooseGUI.setVisible(false);
                loginGUI.setVisible(true);
            });

            //Action Listeners (signUpGUI)

            //Submit button
            submit.addActionListener(e -> {
                if (
                    (firstNameText.getText().equalsIgnoreCase("")) ||
                    (lastNameText.getText().equalsIgnoreCase("")) ||
                    (addressText.getText().equalsIgnoreCase("")) ||
                    (socialSecText.getText().equalsIgnoreCase(""))
                ) {
                    errorMessage.setText("A field is missing information!");
                } else {
                    String socialSecLength = socialSecText.getText();
                    String initialDep = initialDepositText.getText();
                    int intDep = Integer.parseInt(initialDep);
                    if (socialSecLength.length() == 9) {
                        if (intDep >= 500) {

                            var first = firstNameText.getText();
                            var middle = middleNameText.getText();
                            var last = lastNameText.getText();
                            var pass = passwordText.getText();
                            var add = addressText.getText();
                            var sec = socialSecText.getText();

                            if (socials.contains(sec)) {
                                errorMessage.setText("This social security number is already in use.");
                            } else {
                                socials.add(sec);
                                createAccount(first, middle, last, add, sec, pass, intDep, accounts);
                                System.out.println(accounts);
                            }
                        } else {
                            errorMessage.setText("Your initial deposit was too small!");
                        }
                    } else {
                        errorMessage.setText("Please enter a valid SSN.");
                    }
                }
            });

            //Back button
            back.addActionListener(e -> {
                signUpGUI.setVisible(false);
                mainGUI.setVisible(true);

                firstNameText.setText("");
                middleNameText.setText("");
                lastNameText.setText("");
                addressText.setText("");
                socialSecText.setText("");
                initialDepositText.setText("");
                passwordText.setText("");
            });

            //Action Listener (loginGUI)

            submitLog.addActionListener(e -> {

                pulledAccount.set(0, getAccount(logLastText.getText(), logPassText.getText(), accounts));

                loginGUI.setVisible(false);
                JFrame accountGUI = getAccountGUI(pulledAccount);
                accountGUI.setVisible(true);



            });

            backLog.addActionListener(e -> {
                loginGUI.setVisible(false);
                mainGUI.setVisible(true);
            });
    }

    private static JFrame getAccountGUI(ArrayList<Account> pulledAccount) {
        JFrame accountGUI = new JFrame();

        JLabel currentBalance = new JLabel("Current Balance : " + pulledAccount.get(0).currentBalance);

        currentBalance.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel accountPanel = new JPanel();
        accountPanel.setLayout(new BorderLayout());

        JPanel accountDecPanel = new JPanel();
        accountDecPanel.setLayout(new BorderLayout());

        JPanel accountPanelButtons = new JPanel();
        accountPanelButtons.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel amountPanel = new JPanel();
        amountPanel.setLayout(new FlowLayout());
        JTextField amountTextBox = new JTextField(5);

        amountPanel.add(amountTextBox);
        AbstractDocument amountDoc = (AbstractDocument) amountTextBox.getDocument();
        amountDoc.setDocumentFilter(new stringFilter());

        JButton deposit = new JButton("Deposit");

        deposit.addActionListener(e -> {

            int desiredAmount = Integer.parseInt(amountTextBox.getText());
            pulledAccount.get(0).currentBalance += desiredAmount;
            currentBalance.setText("Current Balance : " + pulledAccount.get(0).currentBalance);

        });

        JButton withdraw = new JButton("Withdraw");
        withdraw.addActionListener(e -> {
            int desiredAmount = Integer.parseInt(amountTextBox.getText());

            if (desiredAmount <= pulledAccount.get(0).currentBalance) {

                pulledAccount.get(0).currentBalance -= desiredAmount;
                currentBalance.setText("Current Balance : " + pulledAccount.get(0).currentBalance);

            } else {

                currentBalance.setText("Enter a valid balance. Current Balance : " + pulledAccount.get(0).currentBalance);

            }
        });

        accountPanelButtons.add(deposit);
        accountPanelButtons.add(withdraw);

        accountDecPanel.add(amountPanel, BorderLayout.CENTER);
        accountDecPanel.add(accountPanelButtons, BorderLayout.PAGE_END);

        accountPanel.add(currentBalance, BorderLayout.PAGE_START);
        accountPanel.add(accountDecPanel, BorderLayout.CENTER);

        accountGUI.add(accountPanel);

        accountGUI.setSize(500, 200);
        accountGUI.setLocationRelativeTo(null);
        accountGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return accountGUI;
    }

    //Class testing
        public static void createAccount(String firstName, String middleName, String lastName, String address, String socialSec, String password, int initialDep, ArrayList<Account> accounts) {
                Account newPerson = new Account(firstName, middleName, lastName, address, socialSec, password, initialDep);
                accounts.add(newPerson);
        }

        public static Account getAccount(String lastName, String password, ArrayList <Account> accounts){
            for (Account account : accounts) {

                System.out.println(account.lastName);
                System.out.println(account.password);

                if (account.lastName.equals(lastName) && account.password.equals(password)) {
                    System.out.println("Account Found!");
                    System.out.println(account.lastName + " " + account.password);
                    return account;
                }
            }
            System.out.println("Grabbing default account!");
            return accounts.get(0);
        }

}