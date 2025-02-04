@import com.example.dto.lessons.LessonPage
@param LessonPage page

@template.index(
    content = @`
        <h1 class="text-center p-5">Lesson: ${page.getLesson().getId()}</h1>
        <span class="text-center">Name lesson: ${page.getLesson().getNameLesson()}</span>
        <span class="text-center">Description: ${page.getLesson().getDescription()}</span>
    `
)