package gg.jte.generated.ondemand.lessons;
import com.example.dto.lessons.LessonsPage;
@SuppressWarnings("unchecked")
public final class JtelessonsGenerated {
	public static final String JTE_NAME = "lessons/lessons.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,1,19,19,19,23,23,33,33,35,35,35,35,35,35,35,36,36,36,37,37,37,39,39,42,42,45,45,45,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, LessonsPage page) {
		jteOutput.writeContent("\r\n<!doctype html>\r\n<html lang=\"en\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\"\r\n          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\r\n    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n          integrity=\"sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x\" crossorigin=\"anonymous\">\r\n    <title>javalin-project-learn</title>\r\n</head>\r\n<body>\r\n<div class=\"container\">\r\n    <div class=\"row text-center mt-5\">\r\n        <h1>Lessons</h1>\r\n    </div>\r\n    ");
		if (page.getArrLessons().isEmpty()) {
			jteOutput.writeContent("\r\n        <div class=\"row text-center\">\r\n            <h2>lessons empty</h2>\r\n        </div>\r\n    ");
		} else {
			jteOutput.writeContent("\r\n        <table class=\"table\">\r\n            <thead>\r\n                <tr>\r\n                    <th scope=\"col\">Id</th>\r\n                    <th>Name lesson</th>\r\n                    <th>Description</th>\r\n                </tr>\r\n            </thead>\r\n            <tbody>\r\n            ");
			for (var lesson : page.getArrLessons()) {
				jteOutput.writeContent("\r\n                <tr>\r\n                    <th scope=\"row\"><a href=\"/lessons/");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(lesson.getId());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\">");
				jteOutput.setContext("a", null);
				jteOutput.writeUserContent(lesson.getId());
				jteOutput.writeContent("</a></th>\r\n                    <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(lesson.getNameLesson());
				jteOutput.writeContent("</td>\r\n                    <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(lesson.getDescription());
				jteOutput.writeContent("</td>\r\n                </tr>\r\n            ");
			}
			jteOutput.writeContent("\r\n            </tbody>\r\n        </table>\r\n    ");
		}
		jteOutput.writeContent("\r\n</div>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		LessonsPage page = (LessonsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
