package Attest_Speciality;

class Animal {
    private String name;
    private String command;
    private String dateOfBirth;

    public Animal(String name, String command, String dateOfBirth) {
        this.name = name;
        this.command = command;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getCommand() {
        return command;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", command='" + command + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
    
}