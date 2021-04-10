package Project02;


/**
 * This class enums of the "classes" a member of a tribe/nation
 *        could be. These include: Warrior, Wizard, and Healers.
 */
public enum PeopleType
{
    healer ("Healer"),
    wizard  ("Wizard"),
    warrior ("Warrior");

    /**
     * The description of a given class.
     */
    private String description;

    /**
     * Sets the description of a person to a given enum value.
     * @param types The enum healer, wizard, or warrior.
     */
    PeopleType (String types)
    {
        description = types;
    }


    /**
     * @return The description of a person.
     */
    public String getDescription()
    {
        return description;
    }
}
