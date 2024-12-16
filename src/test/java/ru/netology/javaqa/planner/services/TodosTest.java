package ru.netology.javaqa.planner.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {


    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void checkOneMatchesInSearch() {
        SimpleTask simpleTask = new SimpleTask(5, "Игрушечная машинка");

        String[] subtasks = {"Стиральная машинка", "Холодильник", "Вытяжка"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Машинка для стрижки",
                "Инструкция",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.search("Инструкция");

        Task[] expected = {meeting};
        Task[] actual = todos.search("Инструкция");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void checkNoMatchesInSearch() {
        SimpleTask simpleTask = new SimpleTask(5, "Игрушечная машинка");

        String[] subtasks = {"Стиральная машинка", "Холодильник", "Вытяжка"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Машинка для стрижки",
                "Инструкция",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.search("Курица");

        Task[] expected = {};
        Task[] actual = todos.search("Курица");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void checkTwoMatchesInSearch() {
        SimpleTask simpleTask = new SimpleTask(5, "Инструкция");

        String[] subtasks = {"Стиральная машинка", "Холодильник", "Вытяжка"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Машинка для стрижки",
                "Инструкция",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.search("Инструкция");

        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search("Инструкция");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void checkThreeInSearch() {
        SimpleTask simpleTask = new SimpleTask(5, "Инструкция");

        String[] subtasks = {"Стиральная машинка", "Инструкция", "Вытяжка"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Машинка для стрижки",
                "Инструкция",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.search("Инструкция");

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("Инструкция");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void checkAllInSearch() {
        SimpleTask simpleTask = new SimpleTask(5, "Инструкция");

        String[] subtasks = {"Стиральная машинка", "Инструкция", "Вытяжка"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Инструкция",
                "Написать",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.search("Инструкция");

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("Инструкция");
        Assertions.assertArrayEquals(expected, actual);
    }


}
