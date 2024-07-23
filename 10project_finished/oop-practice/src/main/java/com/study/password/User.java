package com.study.password;


public class User  {
    private  String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void initPassword(PasswordGenerator passwordGenerator){
        //RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        String randomPassword = passwordGenerator.generatePassword();

        if( randomPassword.length() >= 8 && randomPassword.length()<=12){
            this.password=randomPassword;
        }

    }

}
