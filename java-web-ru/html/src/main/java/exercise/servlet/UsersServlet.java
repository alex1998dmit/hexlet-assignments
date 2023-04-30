package exercise.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import exercise.User;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List<User> getUsers() throws IOException {
        // BEGIN
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        List<User> users = objectMapper.readValue(new File("src/main/resources/users.json"), new TypeReference<List<User>>(){});
        return users;
        // END
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {

        // BEGIN
        List<User> users = getUsers();
        PrintWriter pw = response.getWriter();
        StringBuilder body = new StringBuilder();
        body.append("""
                <!DOCTYPE html>
                <html lang=\"ru\">
                    <head>
                        <meta charset=\"UTF-8\">
                        <title>Example application | Users</title>
                        <link rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">
                    </head>
                    <body>
                """);
        body.append("<table>");
        for (User user : users) {
            body.append("<tr>" +
                        "<td>" + user.id + "</td>" +
                        "<td>" + "<a href=\"/users/" + user.id + "\">" +  user.firstName + " " + user.lastName + "</a></td>" +
                        "<td>" + user.email + "</td>" +
                    "<tr>");
        }
        body.append("</table>");
        body.append("""
                    </body>
                </html>
                """);
        pw.println(body);
        // END
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        PrintWriter pw = response.getWriter();
        for (User user : getUsers()) {
            if (user.id.equals(id)) {
                StringBuilder body = new StringBuilder();
                body.append("""
                    <!DOCTYPE html>
                    <html lang=\"ru\">
                        <head>
                            <meta charset=\"UTF-8\">
                            <title>Example application | Users</title>
                            <link rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">
                        </head>
                        <body>
                    """);
                body.append("<table>");
                body.append("<tr>" +
                        "<td>" + user.id + "</td>" +
                        "<td>" +  user.firstName + " " + user.lastName + "</td>" +
                        "<td>" + user.email + "</td>" +
                        "<tr>");
                body.append("</table>");
                body.append("""
                    </body>
                </html>
                """);
                pw.println(body);
                return ;
            }
        }
        response.sendError(404);
        // END
    }
}
