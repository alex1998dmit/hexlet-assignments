package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        var companies = getCompanies();
        String searchParam =request.getParameter("search");
        PrintWriter pw = response.getWriter();
        if (searchParam != null) {
            String foundCompanies = companies.stream()
                    .filter(com -> com.contains(searchParam))
                    .collect(Collectors.joining("\n"));
            if (foundCompanies.length() == 0) {
                pw.print("Companies not found");
            } else {
                pw.print(foundCompanies);
            }
            return;
        }
        String res = String.join("\n", companies);
        pw.print(res);
        // END
    }
}
