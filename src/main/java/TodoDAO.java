import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object class for the todos, to manage the CRUD operations
 */
public class TodoDAO {

    List<Todo> todos;

    public TodoDAO() {
        todos = new ArrayList<Todo>();
    }

    // Create (POST)
    public void createTodo(String summary, String description) {
        Todo todo = new Todo();
        int id = todos.size();
        todo.setId((long) id);
        todo.setSummary(summary);
        todo.setDescription(description);
        todos.add(id, todo);
    }

    // I think only this gets used
    public void createTodo(Todo todo) {
        int id = todos.size();
        todo.setId((long) id);
        todos.add(id, todo);
    }


    // Update (PUT)
    public void updateTodo(Todo todo) {
        todos.add(todo.getId().intValue(), todo);
        deleteTodo(todo);
    }

    // Delete (DELETE)
    // The delete body needs to include the id field
    public void deleteTodo(Todo todo) {
        todos.remove(todo.getId().intValue()-1);
    }

    public void deleteTodo(int id) {
        todos.remove(id);
    }

    // Read (GET)
    // Return all todos as json
    public List<String> getAllTodos() {
        List<String> list = new ArrayList();
        for (Todo t : todos) {
            list.add(t.toJson());
        }

        return list;
    }


}
