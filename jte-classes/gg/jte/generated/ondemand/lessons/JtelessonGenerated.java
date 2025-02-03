package gg.jte.generated.ondemand.lessons;
import com.example.dto.lessons.LessonPage;
@SuppressWarnings("unchecked")
public final class JtelessonGenerated {
	public static final String JTE_NAME = "lessons/lesson.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,1,16,16,16,18,18,18,21,21,21,23,23,25,25,28,28,28,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, LessonPage page) {
		jteOutput.writeContent("\r\n<!doctype html>\r\n<html lang=\"en\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\"\r\n          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\r\n    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n          integrity=\"sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x\" crossorigin=\"anonymous\">\r\n    <title>javalin-project-learn</title>\r\n</head>\r\n<body>\r\n    <div class=\"container text-center\">\r\n        ");
		if (page != null) {
			jteOutput.writeContent("\r\n            <div class=\"row mt-5\">\r\n                <h1>Lesson: ");
			jteOutput.setContext("h1", null);
			jteOutput.writeUserContent(page.getLesson().getNameLesson());
			jteOutput.writeContent("</h1>\r\n            </div>\r\n            <div class=\"row mt-2\">\r\n                <span><h3>description:</h3> ");
			jteOutput.setContext("span", null);
			jteOutput.writeUserContent(page.getLesson().getDescription());
			jteOutput.writeContent("</span>\r\n            </div>\r\n        ");
		} else {
			jteOutput.writeContent("\r\n            <h1>Not found lesson</h1>\r\n        ");
		}
		jteOutput.writeContent("\r\n    </div>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		LessonPage page = (LessonPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
