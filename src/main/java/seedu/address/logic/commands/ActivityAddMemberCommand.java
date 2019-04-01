package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.activity.Activity;
import seedu.address.model.person.MatricNumber;
import seedu.address.model.person.Person;

/**
 * Selects an activity identified using it's displayed index from the address book.
 */
public class ActivityAddMemberCommand extends ActivityCommand {

    public static final String COMMAND_WORD = "activityAddMember";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Selects the activity identified by the index number used in the displayed activity list and adds"
            + "the Person object with given matriculation number into its attendance list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1" + " A1234567H";

    public static final String MESSAGE_ACTIVITY_ADD_MEMBER_SUCCESS = "Successfully added to selected Activity: %1$s";

    private final Index targetIndex;
    private final MatricNumber targetMatric;

    public ActivityAddMemberCommand(Index targetIndex, MatricNumber targetMatric) {
        this.targetIndex = targetIndex;
        this.targetMatric = targetMatric;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        requireNonNull(model);

        List<Activity> filteredActivityList = model.getFilteredActivityList();

        if (targetIndex.getZeroBased() >= filteredActivityList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_ACTIVITY_DISPLAYED_INDEX);
        }

        model.setSelectedActivity(filteredActivityList.get(targetIndex.getZeroBased()));
        Activity selectedActivity = model.getSelectedActivity();
        if (!model.hasMatricNumber(targetMatric)) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_MATRIC_NUMBER);
        }
        Person selectedPerson = model.getPersonWithMatricNumber(targetMatric);
        if (selectedActivity.hasPersonInAttendance(selectedPerson)) {
            throw new CommandException(Messages.MESSAGE_ACTIVITY_ALREADY_HAS_PERSON);
        } else {
            selectedActivity.addMemberToActivity(selectedPerson);
        }
        return new CommandResult(String.format(MESSAGE_ACTIVITY_ADD_MEMBER_SUCCESS, targetIndex.getOneBased()));

    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ActivityAddMemberCommand // instanceof handles nulls
                && targetIndex.equals(((ActivityAddMemberCommand) other).targetIndex)); // state check
    }
}
