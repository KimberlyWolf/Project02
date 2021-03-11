package Project02;


public enum PeopleType
{
    healer ("Healer"),
    wizard  ("wizard"),
    warrior ("warrior");

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
