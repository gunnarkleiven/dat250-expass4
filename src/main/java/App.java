import com.google.gson.Gson;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App {

    static TodoDAO todoDAO = null;

    public static void main(String[] args) {

        if (args.length > 0) {
            port(Integer.parseInt(args[0]));
        } else {
            port(8080);
        }

        todoDAO = new TodoDAO();

        after((req, res) -> {
            res.type("application/json");
        });

        get("/hello", (req, res) -> "Hello World!");

        get("/todos", (req, res) -> todoDAO.getAllTodos());

        put("/todos", (req,res) -> {

            Gson gson = new Gson();

            Todo todo  = gson.fromJson(req.body(), Todo.class);
            todoDAO.createTodo(todo);

            return todoDAO.getAllTodos();

        });

        put("/todos", (req, res) -> {
            Gson gson = new Gson();
            Todo todoWithUpdates =gson.fromJson(req.body(), Todo.class);
            todoDAO.updateTodo(todoWithUpdates);

            return todoDAO.getAllTodos();
        });

        delete("/todos", (req, res) -> {
            Gson gson = new Gson();

            Todo todo  = gson.fromJson(req.body(), Todo.class);

            todoDAO.deleteTodo(todo);
            return todoDAO.getAllTodos();
        });

    }

}
