package ru.netology.javaqa.planner.services;

public class Epic extends Task {


    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }


    @Override
    public boolean matches(String query) {
        String[] temp = new String[0];
        for (String subtask : subtasks) {
            if (subtask.contains(query)) {
                temp = new String[]{subtask};
                return true;
            }
        }
        return false;
    }


}
