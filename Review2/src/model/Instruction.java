package model;

public class Instruction {
    private int id;
    private String instructionText;

    public Instruction() {}

    public Instruction(int id, String instructionText) {
        this.id = id;
        this.instructionText = instructionText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstructionText() {
        return instructionText;
    }

    public void setInstructionText(String instructionText) {
        this.instructionText = instructionText;
    }
}
