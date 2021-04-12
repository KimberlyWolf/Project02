package Project02;

/**
 * Enums of what "classes" a member of a tribe/nation could be.
 * These include: Warrior, Wizard, and Healers.
 * This is also used to differentiate player characters from non-player characters.
 */
public enum PeopleType
{

    healer ("Healer"),
    wizard  ("wizard"),
    warrior ("warrior"),
    special("npc");

    private String description;

    PeopleType (String types)
    {
        description = types;
    }

    public String getDescription()
    {
        return description;
    }


}
