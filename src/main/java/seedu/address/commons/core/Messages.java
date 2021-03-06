package seedu.address.commons.core;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command!";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The member index provided is invalid.";
    public static final String MESSAGE_INVALID_PERSON_MATRIC_NUMBER = "The matric number is not found in the member "
            + "list!";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d member(s) listed!";

    public static final String MESSAGE_INVALID_PERSON_IN_ACTIVITY = "The person is not in the activity "
            + "attendance list!";
    public static final String MESSAGE_INVALID_ACTIVITY_DISPLAYED_INDEX = "The activity index provided is invalid";
    public static final String MESSAGE_INVALID_COMMAND_MODE = "Invalid command mode! Allowed Mode : %1$s\n"
            + "Change mode by using 'mode' command\n%2$s";
    public static final String MESSAGE_ACTIVITIES_LISTED_OVERVIEW = "%1$d activities listed!";
    public static final String MESSAGE_ACTIVITY_ALREADY_HAS_PERSON = "This member is already in the attendance list!";
}
