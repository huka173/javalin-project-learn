@import com.example.dto.lessons.LessonsPage
@param LessonsPage page

@template.index(
    content = @`
        <h1 class="text-center p-5">Lessons</h1>
        <table class="table mb-5">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th>Name lesson</th>
                <th>Description</th>
            </tr>
            </thead>
            <tbody>
            @for(var elem : page.getArrLessons())
                <tr>
                    <th scope="row"><a href="/lessons/${elem.getId()}">${elem.getId()}</a></th>
                    <td>${elem.getNameLesson()}</td>
                    <td>${elem.getDescription()}</td>
                </tr>
            @endfor
            </tbody>
        </table>
    `
)