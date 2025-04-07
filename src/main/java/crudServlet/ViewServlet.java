package crudServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<button><a href='index.html' style='text-decoration: none; color: inherit;'>Cadastrar novo funcionário</a></button>");
        out.println("<h1 style='text-align:center'>Lista de Funcionários</h1>");

        List<Emp> list = Banco.getAllEmployees();

        out.print("<table border='1' width='100%'>");
        out.print("<tr><th>Id</th><th>Nome</th><th>Senha</th><th>Email</th><th>País</th><th>Editar</th><th>Deletar</th></tr>");
        for (Emp e : list) {
            out.print("<tr>"
                    + "<td>" + e.getId() + "</td>"
                    + "<td>" + e.getName() + "</td>"
                    + "<td>" + e.getPassword() + "</td>"
                    + "<td>" + e.getEmail() + "</td>"
                    + "<td>" + e.getCountry() + "</td>"
                    + "<td><a href='EditServlet?id=" + e.getId() + "' style='text-decoration: none'>Editar</a></td>"
                    + "<td><a href='DeleteServlet?id=" + e.getId() + "' style='text-decoration: none'>Deletar</a></td>"
                    + "</tr>");
        }
        out.print("</table>");

        out.close();
    }
}
