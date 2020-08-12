package com.example.voiceforu;

public class Commands {
    //Main Activity Commands
    public static final String mailModule = "mail";
    public static final String TIME = "time";

    //Gmail Module Commands
    //search base commands
    public static final String MAIL_FETCH_MAILS = "show inbox";
    public static final String MAIL_FEtCH_LABELS = "get labels";
    public static final String MAIL_SEARCH_SUBJECT = "search subject";
    public static final String MAIL_SEARCH_LABELS = "search labels";
    public static final String MAIL_NEXT = "next";
    public static final String MAIL_CONFIRM = "do you want to change any field?";

    public static final String DATE = "date";

    //compose based commands
    public static final String MAIL_COMPOSE_MAIL = "compose mail";
    public static final String helpModule = "help";

    //Support commands
    public static final String MAIL_SEND = "send";
    public static final String MAIL_SUBJECT = "subject";
    public static final String MAIL_TO = "send to";
    public static final String MAIL_BODY = "body";

    public static String[] filterCommands(String commandToFilter) {
        String words[] = commandToFilter.split(" ");
        return switchCommands(words);

    }


    public static String[] switchCommands(String[] commandToSwitch) {
        String[] a = new String[4];
        String as = "";
        if (commandToSwitch[0].equals(Commands.helpModule)) {
            a[0] = commandToSwitch[0];
        } else if (commandToSwitch.length == 1) {
            a[0] = "";
        } else {
            switch (commandToSwitch[0] + " " + commandToSwitch[1]) {
                case MAIL_SEARCH_SUBJECT:
                    a[0] = commandToSwitch[0] + " " + commandToSwitch[1];
                    if (commandToSwitch[2] != null) {
                        a[1] = commandToSwitch[2];
                    }
                    break;
                case MAIL_FETCH_MAILS:
                    a[0] = commandToSwitch[0] + " " + commandToSwitch[1];
                    try {
                        a[1] = commandToSwitch[2];
                    } catch (IndexOutOfBoundsException e) {
                        a[1] = "";
                    }
                    break;

                default:
                    for (String ab : commandToSwitch)
                        as = as + ab + " ";
                    a[0] = as.trim();


            }
        }
        return a;
    }

}
