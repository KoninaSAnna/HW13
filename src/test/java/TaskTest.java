import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {
    @Test
    public void testSimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskNoMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Перезвонить");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicMatches() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Молоко");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicNoMatches() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Малако");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingMatchesTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("версии");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingMatchesProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Приложение");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingNoMatches() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("вторник");
        Assertions.assertFalse(actual);
    }
}