package seedu.address.model.person;

import java.util.function.Predicate;

/**
 * Tests that a {@code Person}'s {@code YearOfStudy} matches any of the keywords given.
 */

public class YearOfStudyContainsKeywordsPredicate implements Predicate<Person> {
    private final String keywords;

    public YearOfStudyContainsKeywordsPredicate(String keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        return keywords.equalsIgnoreCase(person.getYearOfStudy().value);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof YearOfStudyContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((YearOfStudyContainsKeywordsPredicate) other).keywords)); // state check
    }

}
