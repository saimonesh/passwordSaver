package com.example.passwordsaver2;

public class DATA {
    public DATA(String name, String userName, String password, String description) {
        Name = name;
        UserName = userName;
        Password = password;
        Description = description;
    }
    String Name;
    String UserName;

    public String getName() {
        return Name;
    }

    public String getUserName() {
        return UserName;
    }

    public String getDescription() {
        return Description;
    }
    public boolean isPasswordEmpty()
    {
        if(Password==null || Password.length()==0)
        {
            return true;
        }
        return false;
    }

    String Password;
    String Description;
    String ID;

}
