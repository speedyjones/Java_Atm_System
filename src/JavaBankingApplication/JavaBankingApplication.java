package JavaBankingApplication;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaBankingApplication {

    static final Logger logs = Logger.getLogger(String.valueOf(JavaBankingApplication.class));
    String msg = "Please Collect Your ";
    String notesMsg = " Notes ";

    long amtTotal = 0;
    long total = 0;
    long qty = 0;

    int oneHundredQty = 10;
    int twoHundredQty = 10;
    int fiveHundredQty = 10;

    int amtCount = 0;

    public static void main(String[] args) throws InterruptedException {


        logs.info("Welcome to ABC Bank....");
        logs.info("Please Insert Your Card & Proceed With Your Transaction !!!");

        Scanner cardDetect = new Scanner(System.in);
        int cardDetectValue = cardDetect.nextInt();

        logs.info("--------------------------------------------");

        if (cardDetectValue == 1) {
            logs.info("Please Wait .......");
            Thread.sleep(1000);
            JavaBankingApplication jba = new JavaBankingApplication();
            jba.pinValidate();


        } else {
            logs.info("Wrong Input !!!");
        }

    }

    public int pinValidate() throws InterruptedException {


        logs.info("Please Enter Your PIN !!!!");
        logs.info("PIN : ");
        Scanner pinVal = new Scanner(System.in);
        int pinReceived = pinVal.nextInt();
        String pinLength = Integer.toString(pinReceived);


        if (pinLength.length() == 4) {
            logs.info("Please Wait .......");
            Thread.sleep(1000);
            amount();
        } else {
            logs.info("Invalidate Pin, Please Validate Again !!!!");

        }

        return pinReceived;
    }

    public void amount() {


        logs.fine("Enter The Amount, When You're Ready !!!!");
        logs.info("Amount : ");
        Scanner amountInput = new Scanner(System.in);
        long amtInput = amountInput.nextInt();

        calAmount(amtInput);

    }

    public void calAmount(long amtInput) {


        if (amtInput < 100) {
            logs.warning("Please Enter Amount Above 100 !!!!");

        } else {
            while (amtInput > 99) {
                if (amtInput < 200) {
                    amtCount = 100;
                    total = amtInput / amtCount;
                    amtTotal = amtInput - (total * amtCount);
                } else if (amtInput < 500) {
                    amtCount = 200;
                    total = amtInput / amtCount;
                    amtTotal = amtInput - (total * amtCount);

                } else if (amtInput < 2000) {
                    amtCount = 500;
                    total = amtInput / amtCount;
                    amtTotal = amtInput - (total * amtCount);

                } else {
                    amtCount = 2000;
                    total = amtInput / amtCount;

                    amtTotal = amtInput - (total * amtCount);
                }
                String finalMsg = msg + total + notesMsg + amtCount + "'s";
                logs.log(Level.INFO, finalMsg);

                amtInput = amtTotal;

            }

        }


    }


}
