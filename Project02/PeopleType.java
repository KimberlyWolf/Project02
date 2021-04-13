package Project02;

/**
 * Enums of what "classes" a member of a tribe/nation could be.
 * These include: Warrior, Wizard, Healers, and NPCs.
 * This is also used to differentiate player characters from non-player characters.
 */
public enum PeopleType
{

    healer ("Healer"),
    wizard  ("wizard"),
    warrior ("warrior"),
    special("npc");

    /**
     * The description of a given class.
     */
    private String description;

    /**
     * Sets the description of a person to a given enum value.
     * @param types The enum healer, wizard, warrior, or npc.
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
